/*     */ package wipedit;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.activation.DataHandler;
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
/*     */ import org.apache.commons.fileupload.servlet.ServletFileUpload;
/*     */ 
/*     */ public class getresource extends HttpServlet
/*     */ {
/*     */   private String saveServlet;
/*     */   private String getResourceServlet;
/*     */   private String refreshServlet;
/*     */   private String idsConfig;
/*     */   private String idsgetWipPrintType;
/*     */   private String hostUrlPrefix;
/*     */   private String idsRequestSave;
/*     */   private String idsRequestGetWip;
/*     */   private String idsRequestUpdateWip;
/*     */   private String idsRequestGetResource;
/*     */   private String idsRequestUID;
/*     */   private String idsRequestPWD;
/*     */   private static final int LOG_DEBUG = 0;
/*     */   private static final int LOG_WARN = 1;
/*     */   private static final int LOG_ERROR = 2;
/*  45 */   private int logLevel = 2;
/*     */   
/*     */   private void logMessage(String logType, String message)
/*     */   {
/*  49 */     int curLevel = 2;
/*  50 */     if (logType.equalsIgnoreCase("DEBUG")) {
/*  51 */       curLevel = 0;
/*  52 */     } else if (logType.equalsIgnoreCase("WARN")) {
/*  53 */       curLevel = 1;
/*     */     } else {
/*  55 */       curLevel = 2;
/*     */     }
/*  57 */     if (curLevel >= this.logLevel) {
/*  58 */       System.out.println(String.format("<%s> <%s> <wipedit> <getresource> %s", new Object[] { new SimpleDateFormat("MMM d, yyyy HH:mm:ss").format(new Date()), logType, message }));
/*     */     }
/*     */   }
/*     */   
/*     */   private void setLogLevel(String level)
/*     */   {
/*  64 */     if (level == null) {
/*  65 */       this.logLevel = 2;
/*  66 */       logMessage("WARN", "Setting <logLevel> missing from web.xml, using default <ERROR>");
/*     */ 
/*     */     }
/*  69 */     else if (level.equalsIgnoreCase("ERROR")) {
/*  70 */       this.logLevel = 2;
/*  71 */     } else if (level.equalsIgnoreCase("DEBUG")) {
/*  72 */       this.logLevel = 0;
/*  73 */     } else if (level.equalsIgnoreCase("WARN")) {
/*  74 */       this.logLevel = 1;
/*     */     } else {
/*  76 */       this.logLevel = 2;
/*     */     }
/*  78 */     logMessage("DEBUG", "Log Level = <" + this.logLevel + "> <0=DEBUG,1=WARN,2=ERROR>");
/*     */   }
/*     */   
/*     */   private void check(String s, String n) throws Exception {
/*  82 */     if (((s == null ? 1 : 0) | (s.length() < 1 ? 1 : 0)) != 0) {
/*  83 */       logMessage("ERROR", "Setting '" + n + "' was not configured in web.xml and has no default.");
/*     */       
/*  85 */       throw new Exception("Setting '" + n + "' was not configured in web.xml and has no default.");
/*     */     }
/*     */     
/*  88 */     logMessage("DEBUG", "<INIT> Setting <" + n + "> = <" + s + ">");
/*     */   }
/*     */   
/*     */   public void init(ServletConfig config) throws ServletException {
/*  92 */     super.init(config);
/*     */     try {
/*  94 */       ServletContext ctx = config.getServletContext();
/*     */       
/*  96 */       this.saveServlet = ctx.getInitParameter("saveServlet");
/*  97 */       check(this.saveServlet, "saveServlet");
/*     */       
/*  99 */       this.idsConfig = ctx.getInitParameter("idsConfig");
/* 100 */       check(this.idsConfig, "idsConfig");
/*     */       
/* 102 */       setLogLevel(ctx.getInitParameter("logLevel"));
/*     */       
/* 104 */       this.getResourceServlet = ctx.getInitParameter("getResourceServlet");
/* 105 */       check(this.getResourceServlet, "getResourceServlet");
/*     */       
/* 107 */       this.idsConfig = ctx.getInitParameter("idsConfig");
/* 108 */       check(this.idsConfig, "idsConfig");
/*     */       
/* 110 */       this.idsgetWipPrintType = ctx.getInitParameter("idsgetWipPrintType");
/* 111 */       check(this.idsgetWipPrintType, "idsgetWipPrintType");
/*     */       
/* 113 */       this.hostUrlPrefix = ctx.getInitParameter("hostUrlPrefix");
/* 114 */       check(this.hostUrlPrefix, "hostUrlPrefix");
/*     */       
/* 116 */       this.idsRequestSave = ctx.getInitParameter("idsRequestSave");
/* 117 */       check(this.idsRequestSave, "idsRequestSave");
/*     */       
/* 119 */       this.idsRequestGetWip = ctx.getInitParameter("idsRequestGetWip");
/* 120 */       check(this.idsRequestGetWip, "idsRequestGetWip");
/*     */       
/* 122 */       this.idsRequestUpdateWip = ctx.getInitParameter("idsRequestUpdateWip");
/* 123 */       check(this.idsRequestUpdateWip, "idsRequestUpdateWip");
/*     */       
/* 125 */       this.idsRequestGetResource = ctx.getInitParameter("idsRequestGetResource");
/*     */       
/* 127 */       check(this.idsRequestGetResource, "idsRequestGetResource");
/*     */       
/* 129 */       this.idsRequestUID = ctx.getInitParameter("idsRequestUID");
/* 130 */       check(this.idsRequestUID, "idsRequestUID");
/*     */       
/* 132 */       this.idsRequestPWD = ctx.getInitParameter("idsRequestPWD");
/* 133 */       check(this.idsRequestPWD, "idsRequestPWD");
/*     */       
/* 135 */       this.refreshServlet = ctx.getInitParameter("refreshServlet");
/* 136 */       check(this.refreshServlet, "refreshServlet");
/*     */     }
/*     */     catch (Throwable t) {
/* 139 */       logMessage("ERROR", t.getMessage());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/* 149 */     doPost(request, response);
/*     */   }
/*     */   
/*     */ 
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/* 156 */     String resourceName = "";
/* 157 */     String requestType = "";
/* 158 */     String config = "";
/* 159 */     String resourceType = "";
/* 160 */     String resourceExtension = "";
/* 161 */     String effectiveDate = "";
/* 162 */     Boolean okToSend = Boolean.valueOf(false);
/*     */     try
/*     */     {
/* 165 */       List<FileItem> items = new ServletFileUpload(new org.apache.commons.fileupload.disk.DiskFileItemFactory()).parseRequest(request);
/*     */       
/* 167 */       for (FileItem item : items) {
/* 168 */         if (item.isFormField())
/*     */         {
/*     */ 
/* 171 */           String fieldName = item.getFieldName();
/* 172 */           String fieldValue = item.getString();
/*     */           
/* 174 */           logMessage("DEBUG", fieldName + "=" + fieldValue);
/*     */           
/* 176 */           if (fieldName.equalsIgnoreCase("resourcename")) {
/* 177 */             resourceName = fieldValue;
/* 178 */             okToSend = Boolean.valueOf(true);
/*     */           }
/*     */           
/* 181 */           if (fieldName.equalsIgnoreCase("requesttype")) {
/* 182 */             requestType = fieldValue;
/* 183 */             okToSend = Boolean.valueOf(true);
/*     */           }
/*     */           
/* 186 */           if (fieldName.equalsIgnoreCase("config")) {
/* 187 */             config = fieldValue;
/* 188 */             okToSend = Boolean.valueOf(true);
/*     */           }
/*     */           
/* 191 */           if (fieldName.equalsIgnoreCase("resourcetype")) {
/* 192 */             resourceType = fieldValue;
/* 193 */             okToSend = Boolean.valueOf(true);
/*     */           }
/*     */           
/* 196 */           if (fieldName.equalsIgnoreCase("resourceext")) {
/* 197 */             resourceExtension = fieldValue;
/* 198 */             okToSend = Boolean.valueOf(true);
/*     */           }
/*     */           
/* 201 */           if (fieldName.equalsIgnoreCase("effectivedate")) {
/* 202 */             effectiveDate = fieldValue;
/* 203 */             okToSend = Boolean.valueOf(true);
/*     */           }
/*     */         }
/*     */       }
/* 207 */       if (okToSend.booleanValue()) {
/* 208 */         CompositionServicePortClient cli = new CompositionServicePortClient();
/*     */         
/* 210 */         DoCallIDSResponse res = cli.getResource(config, effectiveDate, "2", resourceName, resourceType, this.idsRequestUID, this.idsRequestPWD, this.idsRequestGetResource);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 215 */         Results results = res.getResults();
/*     */         
/* 217 */         if (results.getResult() != 0) {
/* 218 */           response.setContentType("text/html");
/* 219 */           PrintWriter out = response.getWriter();
/* 220 */           out.println("There was a problem processing the request. <h1>Diagnostics:</h1>");
/* 221 */           Errors errors = results.getErrors();
/* 222 */           out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/* 223 */           for (Error e : errors.getError()) {
/* 224 */             out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 229 */             for (Diagnosis d : e.getDiagnosis()) {
/* 230 */               out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 235 */           out.println("</table>");
/* 236 */           out.close();
/* 237 */           return;
/*     */         }
/*     */         
/* 240 */         OutputStream os = response.getOutputStream();
/*     */         
/* 242 */         List<Attachment> attachList = res.getDSIMSG().getAttachment();
/*     */         
/* 244 */         if (attachList.size() < 1) {
/* 245 */           throw new Exception("No attachments available in response.");
/*     */         }
/* 247 */         Attachment att = (Attachment)attachList.get(attachList.size() - 1);
/*     */         
/* 249 */         Content c = att.getContent();
/* 250 */         DataHandler d = c.getBinary();
/* 251 */         InputStream is = d.getInputStream();
/*     */         
/* 253 */         response.addHeader("content-disposition", "attachment; filename=" + att.getFileName());
/*     */         
/*     */ 
/* 256 */         response.addHeader("content-transfer-encoding", "base64");
/* 257 */         response.addHeader("content-id", "DOCUMENTSTREAM");
/* 258 */         response.setContentType("application/ids");
/*     */         
/* 260 */         byte[] buf = new byte['Ϩ'];
/*     */         
/* 262 */         for (int chunk = is.read(buf); chunk != -1; chunk = is.read(buf)) {
/* 263 */           os.write(buf, 0, chunk);
/*     */         }
/* 265 */         response.setHeader("Content-Length", Integer.toString(chunk));
/*     */         
/* 267 */         os.flush();
/* 268 */         os.close();
/* 269 */         return;
/*     */       }
/*     */     } catch (Throwable t) {
/* 272 */       logMessage("ERROR", t.getMessage());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/wipedit/getresource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */