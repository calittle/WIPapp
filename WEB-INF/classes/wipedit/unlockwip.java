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
/*     */ public class unlockwip extends HttpServlet
/*     */ {
/*  24 */   private String className = getClass().getSimpleName();
/*  25 */   private Controller ws = null;
/*     */   
/*     */   public void init(ServletConfig config) throws ServletException {
/*  28 */     super.init(config);
/*  29 */     this.ws = new Controller(config);
/*     */   }
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  35 */     response.setContentType("text/html");
/*  36 */     PrintWriter out = response.getWriter();
/*     */     
/*  38 */     String uniqueId = request.getParameter("uniqueid");
/*     */     
/*  40 */     if ((uniqueId.equalsIgnoreCase("")) || (uniqueId.equalsIgnoreCase("null")))
/*     */     {
/*  42 */       out.println("<h4>UNIQUE ID IS MISSING</h4>");
/*  43 */       out.close();
/*  44 */       this.ws.logMessage("ERROR", this.className, "UNIQUE ID not provided in request.");
/*  45 */       return;
/*     */     }
/*     */     
/*     */ 
/*  49 */     String entityId = this.ws.getDocPrepGroupId();
/*  50 */     Subject subject = Subject.getSubject(AccessController.getContext());
/*     */     
/*  52 */     StringBuffer groups = new StringBuffer();
/*  53 */     String user = null;
/*  54 */     String gname = null;
/*  55 */     boolean first = true;
/*     */     
/*  57 */     if ((subject != null) && (subject.getPrincipals() != null)) {
/*  58 */       for (Principal p : subject.getPrincipals()) {
/*  59 */         if ((p instanceof WLSGroup)) {
/*  60 */           if (first) {
/*  61 */             first = false;
/*     */           } else {
/*  63 */             groups.append(", ");
/*     */           }
/*  65 */           gname = p.getName();
/*  66 */           groups.append(gname);
/*  67 */           if (gname.equalsIgnoreCase(this.ws.getDocPrepGroupName())) {
/*  68 */             entityId = this.ws.getDocPrepGroupId();
/*  69 */           } else if (gname.equalsIgnoreCase(this.ws.getDocVetGroupName()))
/*  70 */             entityId = this.ws.getDocVetGroupId();
/*  71 */         } else if ((p instanceof WLSUser)) {
/*  72 */           user = p.getName();
/*     */         }
/*     */       }
/*     */     }
/*     */     try {
/*  77 */       CompositionServicePortClient cli = null;
/*  78 */       cli = new CompositionServicePortClient();
/*     */       
/*  80 */       DoCallIDSResponse res = null;
/*  81 */       Results results = null;
/*     */       
/*  83 */       res = cli.unlockWIPentry(this.ws.getIdsConfig(), uniqueId, entityId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsRequestUpdateWip());
/*  84 */       results = res.getResults();
/*     */       
/*  86 */       if (results.getResult() != 0) {
/*  87 */         Errors errors = results.getErrors();
/*  88 */         out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/*  89 */         for (Error e : errors.getError()) {
/*  90 */           out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */           
/*     */ 
/*     */ 
/*  94 */           this.ws.logMessage("ERROR", this.className, "Category <" + e.getCategory() + "> Code <" + e.getCode() + "> Severity <" + e.getSeverity() + "> Description <" + e.getDescription() + "> Diagnoses follow.");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 100 */           for (Diagnosis d : e.getDiagnosis()) {
/* 101 */             out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */             
/*     */ 
/* 104 */             this.ws.logMessage("ERROR", this.className, "Diagnosis -- Cause <" + d.getCause() + "> Remedy <" + d.getRemedy() + ">");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 109 */         out.println("</table>");
/* 110 */         out.close();
/* 111 */         return;
/*     */       }
/*     */       
/* 114 */       this.ws.logMessage("DEBUG", this.className, "Transaction unlocked.     UNIQUE_ID <" + uniqueId + ">");
/*     */ 
/*     */     }
/*     */     catch (Throwable t)
/*     */     {
/*     */ 
/* 120 */       this.ws.logMessage("ERROR", this.className, t.getMessage());
/* 121 */       t.printStackTrace();
/*     */     }
/*     */     
/*     */ 
/* 125 */     out.close();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/* 133 */     doGet(request, response);
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2-27-2017-2/WEB-INF/classes/!/wipedit/unlockwip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */