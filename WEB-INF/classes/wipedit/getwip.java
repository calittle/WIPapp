/*     */ package wipedit;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import javax.activation.DataHandler;
/*     */ import javax.security.auth.Subject;
/*     */ import javax.servlet.ServletConfig;
/*     */ import javax.servlet.ServletException;
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
/*     */ 
/*     */ public class getwip extends javax.servlet.http.HttpServlet
/*     */ {
/*  25 */   private String className = getClass().getSimpleName();
/*  26 */   private Controller ws = null;
/*     */   
/*     */   public void init(ServletConfig config) throws ServletException {
/*  29 */     super.init(config);
/*  30 */     this.ws = new Controller(config);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws java.io.IOException, ServletException
/*     */   {
/*  36 */     doGet(request, response);
/*     */   }
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, java.io.IOException
/*     */   {
/*  42 */     String uniqueId = "";
/*  43 */     String entityId = this.ws.getDocPrepGroupId();
/*  44 */     Subject s = Subject.getSubject(java.security.AccessController.getContext());
/*     */     
/*  46 */     this.ws.logMessage("DEBUG", this.className, String.format("User <%s> DOC_PREP <%s>, DOC_VET <%s>, Groups <%s>.", new Object[] { this.ws.userName(s), this.ws.isUserDocPrep(s), this.ws.isUserDocVet(s), this.ws.userGroups(s) }));
/*     */     
/*     */ 
/*     */ 
/*  50 */     Enumeration attrs = request.getAttributeNames();
/*  51 */     String attrName = "";
/*  52 */     while (attrs.hasMoreElements()) {
/*  53 */       attrName = (String)attrs.nextElement();
/*  54 */       this.ws.logMessage("DEBUG", this.className, " Request Attribute: <" + attrName + ">=<" + request.getAttribute(attrName) + ">");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  59 */     attrs = request.getParameterNames();
/*  60 */     attrName = "";
/*  61 */     while (attrs.hasMoreElements()) {
/*  62 */       attrName = (String)attrs.nextElement();
/*  63 */       this.ws.logMessage("DEBUG", this.className, " Request Parameter: <" + attrName + ">=<" + request.getParameter(attrName) + ">");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  68 */     attrs = request.getHeaderNames();
/*  69 */     attrName = "";
/*  70 */     while (attrs.hasMoreElements()) {
/*  71 */       attrName = (String)attrs.nextElement();
/*  72 */       this.ws.logMessage("DEBUG", this.className, " Header Item: <" + attrName + ">=<" + request.getHeader(attrName) + ">");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/*  81 */       uniqueId = request.getParameter("uniqueid");
/*     */       
/*  83 */       if (uniqueId.equalsIgnoreCase("")) {
/*  84 */         response.setContentType("text/html");
/*  85 */         PrintWriter out = response.getWriter();
/*  86 */         out.println("<h4>UNIQUE ID IS MISSING</h4>");
/*  87 */         out.close();
/*  88 */         this.ws.logMessage("ERROR", this.className, "UNIQUE ID not provided in request.");
/*  89 */         return;
/*     */       }
/*  91 */       CompositionServicePortClient cli = null;
/*  92 */       cli = new CompositionServicePortClient();
/*     */       
/*  94 */       DoCallIDSResponse res = null;
/*  95 */       Results results = null;
/*     */       
/*  97 */       res = cli.lockWIPentry(this.ws.getIdsConfig(), uniqueId, entityId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsRequestUpdateWip(), this.ws.userName(s));
/*     */       
/*     */ 
/* 100 */       results = res.getResults();
/*     */       
/* 102 */       if (results.getResult() != 0) {
/* 103 */         response.setContentType("text/html");
/* 104 */         PrintWriter out = response.getWriter();
/* 105 */         Errors errors = results.getErrors();
/* 106 */         out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/* 107 */         for (Error e : errors.getError()) {
/* 108 */           out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */           
/*     */ 
/*     */ 
/* 112 */           this.ws.logMessage("ERROR", this.className, "Category <" + e.getCategory() + "> Code <" + e.getCode() + "> Severity <" + e.getSeverity() + "> Description <" + e.getDescription() + "> Diagnoses follow.");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 118 */           for (Diagnosis d : e.getDiagnosis()) {
/* 119 */             out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */             
/*     */ 
/* 122 */             this.ws.logMessage("ERROR", this.className, "Diagnosis -- Cause <" + d.getCause() + "> Remedy <" + d.getRemedy() + ">");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 127 */         out.println("</table>");
/*     */       }
/* 129 */       this.ws.logMessage("DEBUG", this.className, "Transaction locked.     UNIQUE_ID <" + uniqueId + ">, CURRGROUP <" + entityId + ">");
/* 130 */       this.ws.logMessage("DEBUG", this.className, "Getting WIP Data.       UNIQUE_ID <" + uniqueId + ">");
/* 131 */       this.ws.logMessage("DEBUG", this.className, String.format("IDS Request[<IdsConfig=%s>, <UniqueId=%s>, <IdsRequestUID=%s>, <IdsRequestPwd=%s>, <IdsWipPrtType=%s>, <HostUrlPrefix=%s>, <IdsReqGetWip=%s>, <IdsReqSave=%s>, <GetResSrv=%s>, <SaveSrv=%s>, <RefreshSrv=%s>, <HTTPUser=%s>, <HTTPPass=%s>]", new Object[] { this.ws.getIdsConfig(), uniqueId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsgetWipPrintType(), this.ws.getHostUrlPrefix(), this.ws.getIdsRequestGetWip(), this.ws.getIdsRequestSave(), this.ws.getGetResourceServlet(), this.ws.getSaveServlet(), this.ws.getRefreshServlet(), this.ws.getHttpUser(), "*" }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 137 */       res = cli.getWIPentry(this.ws.getIdsConfig(), uniqueId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsgetWipPrintType(), this.ws.getHostUrlPrefix(), this.ws.getIdsRequestGetWip(), this.ws.getIdsRequestSave(), this.ws.getGetResourceServlet(), this.ws.getSaveServlet(), this.ws.getRefreshServlet(), this.ws.getHttpUser(), this.ws.getHttpUserPass());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */       results = res.getResults();
/*     */       
/* 145 */       if (results.getResult() != 0) {
/* 146 */         this.ws.logMessage("ERROR", this.className, "Unable to get WIP Data UNIQUE_ID <" + uniqueId + ">");
/*     */         
/*     */ 
/* 149 */         response.setContentType("text/html");
/* 150 */         PrintWriter out = response.getWriter();
/* 151 */         Errors errors = results.getErrors();
/* 152 */         out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/* 153 */         for (Error e : errors.getError()) {
/* 154 */           out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */           
/*     */ 
/*     */ 
/* 158 */           this.ws.logMessage("ERROR", this.className, "Category <" + e.getCategory() + "> Code <" + e.getCode() + "> Severity <" + e.getSeverity() + "> Description <" + e.getDescription() + "> Diagnoses follow.");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */           for (Diagnosis d : e.getDiagnosis()) {
/* 165 */             out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */             
/*     */ 
/* 168 */             this.ws.logMessage("ERROR", this.className, "Diagnosis -- Cause <" + d.getCause() + "> Remedy <" + d.getRemedy() + ">");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 173 */         out.println("</table>");
/* 174 */         out.close();
/* 175 */         return;
/*     */       }
/*     */       
/* 178 */       OutputStream os = response.getOutputStream();
/*     */       
/* 180 */       List<Attachment> attachList = res.getDSIMSG().getAttachment();
/*     */       
/* 182 */       if (attachList.size() < 1) {
/* 183 */         throw new Exception("No attachments available in response.");
/*     */       }
/* 185 */       Attachment att = (Attachment)attachList.get(attachList.size() - 1);
/*     */       
/* 187 */       Content c = att.getContent();
/* 188 */       DataHandler d = c.getBinary();
/* 189 */       InputStream is = d.getInputStream();
/*     */       
/* 191 */       response.addHeader("content-disposition", "inline; filename=" + att.getFileName());
/*     */       
/* 193 */       response.setContentType("application/x-dpwfile");
/*     */       
/* 195 */       byte[] buf = new byte['Ϩ'];
/*     */       
/* 197 */       for (int chunk = is.read(buf); chunk != -1; chunk = is.read(buf)) {
/* 198 */         os.write(buf, 0, chunk);
/*     */       }
/* 200 */       response.setHeader("Content-Length", Integer.toString(chunk));
/*     */       
/* 202 */       os.flush();
/* 203 */       os.close();
/* 204 */       return;
/*     */     }
/*     */     catch (Throwable t) {
/* 207 */       this.ws.logMessage("ERROR", this.className, t.getMessage());
/* 208 */       t.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2-27-2017-2/WEB-INF/classes/!/wipedit/getwip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */