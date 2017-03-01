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
/*     */   
/*     */   private static final String UPLOAD_DIRECTORY = "upload";
/*     */   private static final int MEMORY_THRESHOLD = 52428800;
/*     */   private static final int MAX_FILE_SIZE = 52428800;
/*     */   private static final int MAX_REQUEST_SIZE = 52428800;
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
/*     */     try
/*     */     {
/*  71 */       List<FileItem> items = upload.parseRequest(request);
/*     */       
/*     */ 
/*  74 */       Attachment attach = new Attachment();
/*     */       
/*  76 */       for (FileItem item : items) {
/*  77 */         if (item.isFormField()) {
/*  78 */           String fieldName = item.getFieldName();
/*  79 */           String fieldValue = item.getString();
/*  80 */           this.ws.logMessage("DEBUG", this.className, fieldName + "=" + fieldValue);
/*     */           
/*     */ 
/*  83 */           if (fieldName.equalsIgnoreCase("DPWRECNUM")) {
/*  84 */             uniqueId = fieldValue;
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*  89 */           File f = new File(repository, item.getName());
/*  90 */           String fileName = f.getName();
/*  91 */           item.write(f);
/*     */           
/*  93 */           this.ws.logMessage("DEBUG", this.className, String.format("Attachment <Name=%s> <ContentType=%s>", new Object[] { fileName, item.getContentType() }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  98 */           DataSource fds = new FileDataSource(f);
/*  99 */           DataHandler handler = new DataHandler(fds);
/* 100 */           Content c = new Content();
/* 101 */           c.setBinary(handler);
/*     */           
/* 103 */           attach.setFileName("XMLIMPORT");
/* 104 */           attach.setName("XMLIMPORT");
/* 105 */           attach.setContent(c);
/*     */         }
/*     */       }
/*     */       
/* 109 */       CompositionServicePortClient cli = new CompositionServicePortClient();
/*     */       
/*     */ 
/* 112 */       DoCallIDSResponse res = cli.saveWIPEntry(attach, this.ws.getIdsRequestSave(), this.ws.getIdsConfig(), uniqueId, currentUser, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsgetWipPrintType());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 118 */       Results results = res.getResults();
/*     */       
/* 120 */       if (results.getResult() != 0) {
/* 121 */         response.setContentType("text/html");
/* 122 */         PrintWriter out = response.getWriter();
/* 123 */         out.println("There was a problem processing the request. <h1>Diagnostics:</h1>");
/* 124 */         Errors errors = results.getErrors();
/* 125 */         out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/* 126 */         for (Error e : errors.getError()) {
/* 127 */           out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 132 */           for (Diagnosis d : e.getDiagnosis()) {
/* 133 */             out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 138 */         out.println("</table>");
/* 139 */         out.close();
/* 140 */         return;
/*     */       }
/* 142 */       PrintWriter out = response.getWriter();
/* 143 */       out.println("Document saved.");
/* 144 */       out.flush();
/* 145 */       out.close();
/* 146 */       return;
/*     */     }
/*     */     catch (Throwable t) {
/* 149 */       this.ws.logMessage("ERROR", this.className, t.getMessage());
/* 150 */       t.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/wipedit/savewip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */