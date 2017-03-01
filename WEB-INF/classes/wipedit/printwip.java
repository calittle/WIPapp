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
/*     */ public class printwip extends javax.servlet.http.HttpServlet
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
/*  97 */       this.ws.logMessage("DEBUG", this.className, "Proof print.          UNIQUE_ID <" + uniqueId + ">");
/*  98 */       this.ws.logMessage("DEBUG", this.className, String.format("IDS Request[<IdsConfig=%s>, <UniqueId=%s>, <IdsRequestUID=%s>, <IdsRequestPwd=%s>, <IdsProofPrintType=%s>, <IdsRequestProof=%s>]", new Object[] { this.ws.getIdsConfig(), uniqueId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsProofPrintType(), this.ws.getIdsRequestProof() }));
/*     */       
/*     */ 
/* 101 */       res = cli.printWIPEntry(this.ws.getIdsConfig(), uniqueId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsProofPrintType(), this.ws.getIdsRequestProof());
/*     */       
/* 103 */       results = res.getResults();
/*     */       
/* 105 */       if (results.getResult() != 0) {
/* 106 */         this.ws.logMessage("ERROR", this.className, "Unable to PROOF PRINT UNIQUE_ID <" + uniqueId + ">");
/*     */         
/*     */ 
/* 109 */         response.setContentType("text/html");
/* 110 */         PrintWriter out = response.getWriter();
/* 111 */         Errors errors = results.getErrors();
/* 112 */         out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/* 113 */         for (Error e : errors.getError()) {
/* 114 */           out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */           
/*     */ 
/*     */ 
/* 118 */           this.ws.logMessage("ERROR", this.className, "Category <" + e.getCategory() + "> Code <" + e.getCode() + "> Severity <" + e.getSeverity() + "> Description <" + e.getDescription() + "> Diagnoses follow.");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 124 */           for (Diagnosis d : e.getDiagnosis()) {
/* 125 */             out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */             
/*     */ 
/* 128 */             this.ws.logMessage("ERROR", this.className, "Diagnosis -- Cause <" + d.getCause() + "> Remedy <" + d.getRemedy() + ">");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 133 */         out.println("</table>");
/* 134 */         out.close();
/* 135 */         return;
/*     */       }
/*     */       
/* 138 */       OutputStream os = response.getOutputStream();
/*     */       
/* 140 */       List<Attachment> attachList = res.getDSIMSG().getAttachment();
/*     */       
/* 142 */       if (attachList.size() < 1) {
/* 143 */         throw new Exception("No attachments available in response.");
/*     */       }
/* 145 */       Attachment att = (Attachment)attachList.get(attachList.size() - 1);
/*     */       
/* 147 */       Content c = att.getContent();
/* 148 */       DataHandler d = c.getBinary();
/* 149 */       InputStream is = d.getInputStream();
/*     */       
/* 151 */       response.addHeader("content-disposition", "inline; filename=" + att.getFileName());
/*     */       
/* 153 */       response.setContentType("application/pdf");
/*     */       
/* 155 */       byte[] buf = new byte['Ϩ'];
/*     */       
/* 157 */       for (int chunk = is.read(buf); chunk != -1; chunk = is.read(buf)) {
/* 158 */         os.write(buf, 0, chunk);
/*     */       }
/* 160 */       response.setHeader("Content-Length", Integer.toString(chunk));
/*     */       
/* 162 */       os.flush();
/* 163 */       os.close();
/* 164 */       return;
/*     */     }
/*     */     catch (Throwable t) {
/* 167 */       this.ws.logMessage("ERROR", this.className, t.getMessage());
/* 168 */       t.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2017-2-23-1/WEB-INF/classes/!/wipedit/printwip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */