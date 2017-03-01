/*     */ package wipedit;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.security.AccessController;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import javax.activation.DataHandler;
/*     */ import javax.security.auth.Subject;
/*     */ import javax.servlet.ServletConfig;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import oracle.dws.CompositionServicePortClient;
/*     */ import oracle.dws.types.Attachment;
/*     */ import oracle.dws.types.Content;
/*     */ import oracle.dws.types.DSIMSG;
/*     */ import oracle.dws.types.Diagnosis;
/*     */ import oracle.dws.types.DoCallIDSResponse;
/*     */ import oracle.dws.types.Error;
/*     */ import oracle.dws.types.Errors;
/*     */ import oracle.dws.types.Results;
/*     */ 
/*     */ public class getwip
/*     */   extends HttpServlet
/*     */ {
/*  30 */   private String className = getClass().getSimpleName();
/*  31 */   private Controller ws = null;
/*     */   
/*     */   public void init(ServletConfig config) throws ServletException {
/*  34 */     super.init(config);
/*  35 */     this.ws = new Controller(config);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws IOException, ServletException
/*     */   {
/*  41 */     doGet(request, response);
/*     */   }
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  47 */     String uniqueId = "";
/*  48 */     String entityId = this.ws.getDocPrepGroupId();
/*  49 */     Subject s = Subject.getSubject(AccessController.getContext());
/*     */     
/*  51 */     this.ws.logMessage("DEBUG", this.className, String.format("User <%s> DOC_PREP <%s>, DOC_VET <%s>, Groups <%s>.", new Object[] { this.ws.userName(s), this.ws.isUserDocPrep(s), this.ws.isUserDocVet(s), this.ws.userGroups(s) }));
/*     */     
/*     */ 
/*     */ 
/*  55 */     Enumeration attrs = request.getAttributeNames();
/*  56 */     String attrName = "";
/*  57 */     while (attrs.hasMoreElements()) {
/*  58 */       attrName = (String)attrs.nextElement();
/*  59 */       this.ws.logMessage("DEBUG", this.className, " Request Attribute: <" + attrName + ">=<" + request.getAttribute(attrName) + ">");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  64 */     attrs = request.getParameterNames();
/*  65 */     attrName = "";
/*  66 */     while (attrs.hasMoreElements()) {
/*  67 */       attrName = (String)attrs.nextElement();
/*  68 */       this.ws.logMessage("DEBUG", this.className, " Request Parameter: <" + attrName + ">=<" + request.getParameter(attrName) + ">");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  73 */     attrs = request.getHeaderNames();
/*  74 */     attrName = "";
/*  75 */     while (attrs.hasMoreElements()) {
/*  76 */       attrName = (String)attrs.nextElement();
/*  77 */       this.ws.logMessage("DEBUG", this.className, " Header Item: <" + attrName + ">=<" + request.getHeader(attrName) + ">");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/*  86 */       uniqueId = request.getParameter("uniqueid");
/*     */       
/*  88 */       if (uniqueId.equalsIgnoreCase("")) {
/*  89 */         response.setContentType("text/html");
/*  90 */         PrintWriter out = response.getWriter();
/*  91 */         out.println("<h4>UNIQUE ID IS MISSING</h4>");
/*  92 */         out.close();
/*  93 */         this.ws.logMessage("ERROR", this.className, "UNIQUE ID not provided in request.");
/*  94 */         return;
/*     */       }
/*  96 */       CompositionServicePortClient cli = null;
/*  97 */       cli = new CompositionServicePortClient();
/*     */       
/*  99 */       DoCallIDSResponse res = null;
/* 100 */       Results results = null;
/*     */       
/* 102 */       res = cli.lockWIPentry(this.ws.getIdsConfig(), uniqueId, entityId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsRequestUpdateWip(), this.ws.userName(s));
/*     */       
/*     */ 
/* 105 */       results = res.getResults();
/*     */       
/* 107 */       if (results.getResult() != 0) {
/* 108 */         response.setContentType("text/html");
/* 109 */         PrintWriter out = response.getWriter();
/* 110 */         Errors errors = results.getErrors();
/* 111 */         out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/* 112 */         for (Error e : errors.getError()) {
/* 113 */           out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */           
/*     */ 
/*     */ 
/* 117 */           this.ws.logMessage("ERROR", this.className, "Category <" + e.getCategory() + "> Code <" + e.getCode() + "> Severity <" + e.getSeverity() + "> Description <" + e.getDescription() + "> Diagnoses follow.");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */           for (Diagnosis d : e.getDiagnosis()) {
/* 124 */             out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */             
/*     */ 
/* 127 */             this.ws.logMessage("ERROR", this.className, "Diagnosis -- Cause <" + d.getCause() + "> Remedy <" + d.getRemedy() + ">");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 132 */         out.println("</table>");
/*     */       }
/* 134 */       this.ws.logMessage("DEBUG", this.className, "Transaction locked.     UNIQUE_ID <" + uniqueId + ">, CURRGROUP <" + entityId + ">");
/* 135 */       this.ws.logMessage("DEBUG", this.className, "Getting WIP Data.       UNIQUE_ID <" + uniqueId + ">");
/* 136 */       this.ws.logMessage("DEBUG", this.className, String.format("IDS Request[<IdsConfig=%s>, <UniqueId=%s>, <IdsRequestUID=%s>, <IdsRequestPwd=%s>, <IdsWipPrtType=%s>, <HostUrlPrefix=%s>, <IdsReqGetWip=%s>, <IdsReqSave=%s>, <GetResSrv=%s>, <SaveSrv=%s>, <RefreshSrv=%s>, <HTTPUser=%s>, <HTTPPass=%s>]", new Object[] { this.ws.getIdsConfig(), uniqueId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsgetWipPrintType(), this.ws.getHostUrlPrefix(), this.ws.getIdsRequestGetWip(), this.ws.getIdsRequestSave(), this.ws.getGetResourceServlet(), this.ws.getSaveServlet(), this.ws.getRefreshServlet(), this.ws.getHttpUser(), "*" }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */       res = cli.getWIPentry(this.ws.getIdsConfig(), uniqueId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsgetWipPrintType(), this.ws.getHostUrlPrefix(), this.ws.getIdsRequestGetWip(), this.ws.getIdsRequestSave(), this.ws.getGetResourceServlet(), this.ws.getSaveServlet(), this.ws.getRefreshServlet(), this.ws.getHttpUser(), this.ws.getHttpUserPass());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 148 */       results = res.getResults();
/*     */       
/* 150 */       if (results.getResult() != 0) {
/* 151 */         this.ws.logMessage("ERROR", this.className, "Unable to get WIP Data UNIQUE_ID <" + uniqueId + ">");
/*     */         
/*     */ 
/* 154 */         response.setContentType("text/html");
/* 155 */         PrintWriter out = response.getWriter();
/* 156 */         Errors errors = results.getErrors();
/* 157 */         out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/* 158 */         for (Error e : errors.getError()) {
/* 159 */           out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */           
/*     */ 
/*     */ 
/* 163 */           this.ws.logMessage("ERROR", this.className, "Category <" + e.getCategory() + "> Code <" + e.getCode() + "> Severity <" + e.getSeverity() + "> Description <" + e.getDescription() + "> Diagnoses follow.");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 169 */           for (Diagnosis d : e.getDiagnosis()) {
/* 170 */             out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */             
/*     */ 
/* 173 */             this.ws.logMessage("ERROR", this.className, "Diagnosis -- Cause <" + d.getCause() + "> Remedy <" + d.getRemedy() + ">");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 178 */         out.println("</table>");
/* 179 */         out.close();
/* 180 */         return;
/*     */       }
/*     */       
/* 183 */       OutputStream os = response.getOutputStream();
/*     */       
/* 185 */       List<Attachment> attachList = res.getDSIMSG().getAttachment();
/*     */       
/* 187 */       if (attachList.size() < 1) {
/* 188 */         throw new Exception("No attachments available in response.");
/*     */       }
/* 190 */       Attachment att = (Attachment)attachList.get(attachList.size() - 1);
/*     */       
/* 192 */       Content c = att.getContent();
/* 193 */       DataHandler d = c.getBinary();
/* 194 */       InputStream is = d.getInputStream();
/*     */       
/* 196 */       response.addHeader("content-disposition", "inline; filename=" + att.getFileName());
/*     */       
/* 198 */       response.setContentType("application/x-dpwfile");
/*     */       
/* 200 */       byte[] buf = new byte['Ϩ'];
/*     */       
/* 202 */       for (int chunk = is.read(buf); chunk != -1; chunk = is.read(buf)) {
/* 203 */         os.write(buf, 0, chunk);
/*     */       }
/* 205 */       response.setHeader("Content-Length", Integer.toString(chunk));
/*     */       
/* 207 */       os.flush();
/* 208 */       os.close();
/* 209 */       return;
/*     */     }
/*     */     catch (Throwable t) {
/* 212 */       this.ws.logMessage("ERROR", this.className, t.getMessage());
/* 213 */       t.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/wipedit/getwip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */