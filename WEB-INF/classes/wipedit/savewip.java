/*     */ package wipedit;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import javax.activation.DataHandler;
/*     */ import javax.activation.DataSource;
/*     */ import javax.activation.FileDataSource;
/*     */ import javax.servlet.ServletConfig;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import oracle.dws.CompositionServicePortClient;
/*     */ import oracle.dws.types.Attachment;
/*     */ import oracle.dws.types.Content;
/*     */ import oracle.dws.types.Diagnosis;
/*     */ import oracle.dws.types.DoCallIDSResponse;
/*     */ import oracle.dws.types.Error;
/*     */ import oracle.dws.types.Errors;
/*     */ import oracle.dws.types.Results;
/*     */ import org.apache.commons.fileupload.FileItem;
/*     */ import org.apache.commons.fileupload.disk.DiskFileItemFactory;
/*     */ import org.apache.commons.fileupload.servlet.ServletFileUpload;
/*     */ 
/*     */ public class savewip
/*     */   extends HttpServlet
/*     */ {
/*  31 */   private String className = getClass().getSimpleName();
/*  32 */   private Controller ws = null;
/*     */   private static final String UPLOAD_DIRECTORY = "upload";
/*     */   private static final int MEMORY_THRESHOLD = 52428800;
/*     */   private static final int MAX_FILE_SIZE = 52428800;
/*     */   private static final int MAX_REQUEST_SIZE = 52428800;
/*     */   private static final String SERVLET_VERSION = "1.0";
/*     */   
/*     */   public void init(ServletConfig config)
/*     */     throws ServletException
/*     */   {
/*  42 */     super.init(config);
/*  43 */     this.ws = new Controller(config);
/*     */   }
/*     */   
/*     */ 
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws IOException, ServletException
/*     */   {
/*  50 */     doGet(request, response);
/*     */   }
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  56 */     String currentUser = "2";
/*  57 */     String uniqueId = null;
/*     */     
/*  59 */     DiskFileItemFactory factory = new DiskFileItemFactory();
/*  60 */     factory.setSizeThreshold(52428800);
/*     */     
/*  62 */     ServletContext servletContext = getServletConfig().getServletContext();
/*  63 */     File repository = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
/*  64 */     factory.setRepository(repository);
/*     */     
/*  66 */     ServletFileUpload upload = new ServletFileUpload(factory);
/*  67 */     upload.setFileSizeMax(52428800L);
/*  68 */     upload.setSizeMax(52428800L);
/*     */     
/*  70 */     this.ws.logMessage("DEBUG", this.className, "Processing save request Servlet Version 1.0");
/*     */     try
/*     */     {
/*  73 */       this.ws.logMessage("DEBUG", this.className, "Parse request from POST...");
/*  74 */       List<FileItem> items = upload.parseRequest(request);
/*     */       
/*     */ 
/*  77 */       Attachment attach = new Attachment();
/*     */       
/*  79 */       for (FileItem item : items) {
/*  80 */         this.ws.logMessage("DEBUG", this.className, "... Request Item parsed; form/non-form content parsing follows.");
/*  81 */         if (item.isFormField()) {
/*  82 */           String fieldName = item.getFieldName();
/*  83 */           String fieldValue = item.getString();
/*  84 */           this.ws.logMessage("DEBUG", this.className, fieldName + "=" + fieldValue);
/*     */           
/*     */ 
/*  87 */           if (fieldName.equalsIgnoreCase("DPWRECNUM")) {
/*  88 */             uniqueId = fieldValue;
/*     */           }
/*     */         }
/*     */         else {
/*  92 */           File f = new File(repository, item.getName());
/*  93 */           String fileName = f.getName();
/*  94 */           item.write(f);
/*     */           
/*  96 */           this.ws.logMessage("DEBUG", this.className, String.format("Attachment <Name=%s> <ContentType=%s>", new Object[] { fileName, item.getContentType() }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 101 */           DataSource fds = new FileDataSource(f);
/* 102 */           DataHandler handler = new DataHandler(fds);
/* 103 */           Content c = new Content();
/* 104 */           c.setBinary(handler);
/*     */           
/* 106 */           attach.setFileName("XMLIMPORT");
/* 107 */           attach.setName("XMLIMPORT");
/* 108 */           attach.setContent(c);
/*     */         }
/*     */       }
/*     */       
/* 112 */       this.ws.logMessage("DEBUG", this.className, "...Completed POST parsing. Calling DWS...");
/*     */       
/* 114 */       CompositionServicePortClient cli = new CompositionServicePortClient();
/*     */       
/*     */ 
/* 117 */       DoCallIDSResponse res = cli.saveWIPEntry(attach, this.ws.getIdsRequestSave(), this.ws.getIdsConfig(), uniqueId, currentUser, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsgetWipPrintType());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */       this.ws.logMessage("DEBUG", this.className, "...DWS call complete. Parsing results.");
/*     */       
/* 125 */       Results results = res.getResults();
/*     */       
/* 127 */       if (results.getResult() != 0) {
/* 128 */         this.ws.logMessage("DEBUG", this.className, "...DWS call complete. Parsing results.");
/*     */         
/* 130 */         response.setContentType("text/html");
/* 131 */         PrintWriter out = response.getWriter();
/* 132 */         out.println("There was a problem processing the request. <h1>Diagnostics:</h1>");
/* 133 */         Errors errors = results.getErrors();
/* 134 */         out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/* 135 */         this.ws.logMessage("ERROR", this.className, "DWS Save Error:");
/* 136 */         for (Error e : errors.getError())
/*     */         {
/* 138 */           this.ws.logMessage("ERROR", this.className, String.format("<Category=%s> <Severity=%s> <Desc=%s>", new Object[] { e.getCategory(), e.getSeverity(), e.getDescription() }));
/*     */           
/* 140 */           out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 145 */           for (Diagnosis d : e.getDiagnosis()) {
/* 146 */             out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 151 */         out.println("</table>");
/* 152 */         out.close();
/* 153 */         return;
/*     */       }
/* 155 */       this.ws.logMessage("DEBUG", this.className, "DWS call completed successfully.");
/* 156 */       PrintWriter out = response.getWriter();
/* 157 */       out.println("Document saved.");
/* 158 */       out.flush();
/* 159 */       out.close();
/* 160 */       return;
/*     */     }
/*     */     catch (Throwable t) {
/* 163 */       this.ws.logMessage("ERROR", this.className, t.getMessage());
/* 164 */       t.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp-2017-2-27-3/WEB-INF/classes/!/wipedit/savewip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */