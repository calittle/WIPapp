/*     */ package wipedit;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.security.AccessController;
/*     */ import java.security.Principal;
/*     */ import javax.security.auth.Subject;
/*     */ import javax.servlet.ServletConfig;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import oracle.dws.CompositionServicePortClient;
/*     */ import oracle.dws.types.Diagnosis;
/*     */ import oracle.dws.types.DoCallIDSResponse;
/*     */ import oracle.dws.types.Error;
/*     */ import oracle.dws.types.Errors;
/*     */ import oracle.dws.types.Results;
/*     */ import weblogic.security.spi.WLSGroup;
/*     */ import weblogic.security.spi.WLSUser;
/*     */ 
/*     */ 
/*     */ public class unlockwip
/*     */   extends HttpServlet
/*     */ {
/*  26 */   private String className = getClass().getSimpleName();
/*  27 */   private Controller ws = null;
/*     */   
/*     */   public void init(ServletConfig config) throws ServletException {
/*  30 */     super.init(config);
/*  31 */     this.ws = new Controller(config);
/*     */   }
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  37 */     response.setContentType("text/html");
/*  38 */     PrintWriter out = response.getWriter();
/*     */     
/*  40 */     String uniqueId = request.getParameter("uniqueid");
/*     */     
/*  42 */     if ((uniqueId.equalsIgnoreCase("")) || (uniqueId.equalsIgnoreCase("null")))
/*     */     {
/*  44 */       out.println("<h4>UNIQUE ID IS MISSING</h4>");
/*  45 */       out.close();
/*  46 */       this.ws.logMessage("ERROR", this.className, "UNIQUE ID not provided in request.");
/*  47 */       return;
/*     */     }
/*     */     
/*     */ 
/*  51 */     String entityId = this.ws.getDocPrepGroupId();
/*  52 */     Subject subject = Subject.getSubject(AccessController.getContext());
/*     */     
/*  54 */     StringBuffer groups = new StringBuffer();
/*  55 */     String user = null;
/*  56 */     String gname = null;
/*  57 */     boolean first = true;
/*     */     
/*  59 */     if ((subject != null) && (subject.getPrincipals() != null)) {
/*  60 */       for (Principal p : subject.getPrincipals()) {
/*  61 */         if ((p instanceof WLSGroup)) {
/*  62 */           if (first) {
/*  63 */             first = false;
/*     */           } else {
/*  65 */             groups.append(", ");
/*     */           }
/*  67 */           gname = p.getName();
/*  68 */           groups.append(gname);
/*  69 */           if (gname.equalsIgnoreCase(this.ws.getDocPrepGroupName())) {
/*  70 */             entityId = this.ws.getDocPrepGroupId();
/*  71 */           } else if (gname.equalsIgnoreCase(this.ws.getDocVetGroupName()))
/*  72 */             entityId = this.ws.getDocVetGroupId();
/*  73 */         } else if ((p instanceof WLSUser)) {
/*  74 */           user = p.getName();
/*     */         }
/*     */       }
/*     */     }
/*     */     try {
/*  79 */       CompositionServicePortClient cli = null;
/*  80 */       cli = new CompositionServicePortClient();
/*     */       
/*  82 */       DoCallIDSResponse res = null;
/*  83 */       Results results = null;
/*     */       
/*  85 */       res = cli.unlockWIPentry(this.ws.getIdsConfig(), uniqueId, entityId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsRequestUpdateWip());
/*  86 */       results = res.getResults();
/*     */       
/*  88 */       if (results.getResult() != 0) {
/*  89 */         Errors errors = results.getErrors();
/*  90 */         out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/*  91 */         for (Error e : errors.getError()) {
/*  92 */           out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */           
/*     */ 
/*     */ 
/*  96 */           this.ws.logMessage("ERROR", this.className, "Category <" + e.getCategory() + "> Code <" + e.getCode() + "> Severity <" + e.getSeverity() + "> Description <" + e.getDescription() + "> Diagnoses follow.");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 102 */           for (Diagnosis d : e.getDiagnosis()) {
/* 103 */             out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */             
/*     */ 
/* 106 */             this.ws.logMessage("ERROR", this.className, "Diagnosis -- Cause <" + d.getCause() + "> Remedy <" + d.getRemedy() + ">");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 111 */         out.println("</table>");
/* 112 */         out.close();
/* 113 */         return;
/*     */       }
/*     */       
/* 116 */       this.ws.logMessage("DEBUG", this.className, "Transaction unlocked.     UNIQUE_ID <" + uniqueId + ">");
/*     */ 
/*     */     }
/*     */     catch (Throwable t)
/*     */     {
/*     */ 
/* 122 */       this.ws.logMessage("ERROR", this.className, t.getMessage());
/* 123 */       t.printStackTrace();
/*     */     }
/*     */     
/*     */ 
/* 127 */     out.close();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/* 135 */     doGet(request, response);
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/wipedit/unlockwip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */