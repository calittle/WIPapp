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
/*     */ public class submitwip extends HttpServlet
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
/*  43 */       this.ws.logMessage("ERROR", this.className, "UNIQUE ID not provided in request.");
/*     */     }
/*     */     else {
/*  46 */       String entityId = this.ws.getDocPrepGroupId();
/*  47 */       Subject subject = Subject.getSubject(AccessController.getContext());
/*     */       
/*  49 */       StringBuffer groups = new StringBuffer();
/*  50 */       String user = null;
/*  51 */       String gname = null;
/*  52 */       boolean first = true;
/*     */       
/*  54 */       if ((subject != null) && (subject.getPrincipals() != null)) {
/*  55 */         for (Principal p : subject.getPrincipals()) {
/*  56 */           if ((p instanceof WLSGroup)) {
/*  57 */             if (first) {
/*  58 */               first = false;
/*     */             } else {
/*  60 */               groups.append(", ");
/*     */             }
/*  62 */             gname = p.getName();
/*  63 */             groups.append(gname);
/*  64 */             if (gname.equalsIgnoreCase(this.ws.getDocPrepGroupName())) {
/*  65 */               entityId = this.ws.getDocPrepGroupId();
/*  66 */             } else if (gname.equalsIgnoreCase(this.ws.getDocVetGroupName()))
/*  67 */               entityId = this.ws.getDocVetGroupId();
/*  68 */           } else if ((p instanceof WLSUser)) {
/*  69 */             user = p.getName();
/*     */           }
/*     */         }
/*     */       }
/*     */       try {
/*  74 */         CompositionServicePortClient cli = null;
/*  75 */         cli = new CompositionServicePortClient();
/*     */         
/*  77 */         DoCallIDSResponse res = null;
/*  78 */         Results results = null;
/*     */         
/*  80 */         res = cli.submitRBC(this.ws.getIdsConfig(), uniqueId, entityId, this.ws.getIdsRequestUID(), this.ws.getIdsRequestPWD(), this.ws.getIdsRequestUpdateWip());
/*     */         
/*  82 */         results = res.getResults();
/*     */         
/*  84 */         if (results.getResult() != 0) {
/*  85 */           Errors errors = results.getErrors();
/*  86 */           out.println("<table><tr><td>Category</td><td>Code</td><td>Severity</td><td>Description</td></tr>");
/*  87 */           for (Error e : errors.getError()) {
/*  88 */             out.println("<tr><td>" + e.getCategory() + "</td><td>" + e.getCode() + "</td><td>" + e.getSeverity() + "</td><td>" + e.getDescription() + "</td></tr>");
/*     */             
/*     */ 
/*     */ 
/*  92 */             this.ws.logMessage("ERROR", this.className, "Category <" + e.getCategory() + "> Code <" + e.getCode() + "> Severity <" + e.getSeverity() + "> Description <" + e.getDescription() + "> Diagnoses follow.");
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  98 */             for (Diagnosis d : e.getDiagnosis()) {
/*  99 */               out.println("<tr><td colspan='2'>" + d.getCause() + "</td><td colspan='2'>" + d.getRemedy() + "</td></tr>");
/*     */               
/*     */ 
/* 102 */               this.ws.logMessage("ERROR", this.className, "Diagnosis -- Cause <" + d.getCause() + "> Remedy <" + d.getRemedy() + ">");
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 107 */           out.println("</table>");
/*     */           
/* 109 */           return;
/*     */         }
/*     */         
/* 112 */         this.ws.logMessage("DEBUG", this.className, "Transaction submitted.     UNIQUE_ID <" + uniqueId + ">");
/*     */         
/*     */ 
/* 115 */         out.println("<h4>Transaction submitted.</h4>");
/*     */       }
/*     */       catch (Throwable t)
/*     */       {
/* 119 */         this.ws.logMessage("ERROR", this.className, t.getMessage());
/* 120 */         t.printStackTrace();
/*     */       }
/*     */     }
/*     */     
/* 124 */     out.println("You may <a href='#' onclick='parent.window.close();'>close</a> this window.");
/* 125 */     out.close();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void doPut(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/* 133 */     doGet(request, response);
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/wipedit/submitwip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */