/*     */ package wipedit;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.security.Principal;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.security.auth.Subject;
/*     */ import javax.servlet.ServletConfig;
/*     */ import javax.servlet.ServletContext;
/*     */ import weblogic.security.spi.WLSGroup;
/*     */ import weblogic.security.spi.WLSUser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Controller
/*     */ {
/*  18 */   private String className = getClass().getSimpleName();
/*     */   
/*     */   private String saveServlet;
/*     */   
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
/*     */   private String docPrepGroupId;
/*     */   private String docVetGroupId;
/*     */   private String docPrepGroupName;
/*     */   private String docVetGroupName;
/*     */   private String httpUser;
/*     */   private String httpUserPass;
/*     */   private String pegaEndpoint;
/*     */   private String idsProofPrintType;
/*     */   private String idsRequestProof;
/*  42 */   private int logLevel = 2;
/*     */   
/*     */   private static final int LOG_DEBUG = 0;
/*     */   private static final int LOG_WARN = 1;
/*     */   private static final int LOG_ERROR = 2;
/*     */   private static final String CONTROLLER_VERSION = "1.0";
/*     */   
/*     */   public Controller(ServletConfig config)
/*     */   {
/*     */     try
/*     */     {
/*  53 */       ServletContext ctx = config.getServletContext();
/*     */       
/*  55 */       check(ctx.getInitParameter("wipEditVersion"), "Web Application: WipEdit Version ");
/*  56 */       this.pegaEndpoint = ctx.getInitParameter("pegaEndpoint");
/*  57 */       check(this.pegaEndpoint, "pegaEndpoint");
/*     */       
/*  59 */       logMessage("DEBUG", this.className, "Version 1.0");
/*     */       
/*  61 */       this.saveServlet = ctx.getInitParameter("saveServlet");
/*  62 */       check(this.saveServlet, "saveServlet");
/*     */       
/*  64 */       this.idsConfig = ctx.getInitParameter("idsConfig");
/*  65 */       check(this.idsConfig, "idsConfig");
/*     */       
/*  67 */       setLogLevel(ctx.getInitParameter("logLevel"));
/*     */       
/*  69 */       this.getResourceServlet = ctx.getInitParameter("getResourceServlet");
/*  70 */       check(this.getResourceServlet, "getResourceServlet");
/*     */       
/*  72 */       this.idsConfig = ctx.getInitParameter("idsConfig");
/*  73 */       check(this.idsConfig, "idsConfig");
/*     */       
/*     */ 
/*  76 */       this.idsgetWipPrintType = ctx.getInitParameter("idsgetWipPrintType");
/*  77 */       check(this.idsgetWipPrintType, "idsgetWipPrintType");
/*     */       
/*  79 */       this.hostUrlPrefix = ctx.getInitParameter("hostUrlPrefix");
/*  80 */       check(this.hostUrlPrefix, "hostUrlPrefix");
/*     */       
/*  82 */       this.idsRequestSave = ctx.getInitParameter("idsRequestSave");
/*  83 */       check(this.idsRequestSave, "idsRequestSave");
/*     */       
/*  85 */       this.idsRequestGetWip = ctx.getInitParameter("idsRequestGetWip");
/*  86 */       check(this.idsRequestGetWip, "idsRequestGetWip");
/*     */       
/*  88 */       this.idsRequestUpdateWip = ctx.getInitParameter("idsRequestUpdateWip");
/*  89 */       check(this.idsRequestUpdateWip, "idsRequestUpdateWip");
/*     */       
/*  91 */       this.idsRequestGetResource = ctx.getInitParameter("idsRequestGetResource");
/*     */       
/*  93 */       check(this.idsRequestGetResource, "idsRequestGetResource");
/*     */       
/*  95 */       this.idsRequestUID = ctx.getInitParameter("idsRequestUID");
/*  96 */       check(this.idsRequestUID, "idsRequestUID");
/*     */       
/*  98 */       this.idsRequestPWD = ctx.getInitParameter("idsRequestPWD");
/*  99 */       check(this.idsRequestPWD, "idsRequestPWD");
/*     */       
/* 101 */       this.refreshServlet = ctx.getInitParameter("refreshServlet");
/* 102 */       check(this.refreshServlet, "refreshServlet");
/*     */       
/* 104 */       this.docPrepGroupId = ctx.getInitParameter("docPrepGroupId");
/* 105 */       check(this.docPrepGroupId, "docPrepGroupId");
/*     */       
/* 107 */       this.docVetGroupId = ctx.getInitParameter("docVetGroupId");
/* 108 */       check(this.docVetGroupId, "docVetGroupId");
/*     */       
/* 110 */       this.docPrepGroupName = ctx.getInitParameter("docPrepGroupName");
/* 111 */       check(this.docPrepGroupName, "docPrepGroupName");
/*     */       
/* 113 */       this.docVetGroupName = ctx.getInitParameter("docVetGroupName");
/* 114 */       check(this.docVetGroupName, "docVetGroupName");
/*     */       
/* 116 */       this.httpUser = ctx.getInitParameter("httpUser");
/* 117 */       check(this.httpUser, "httpUser");
/*     */       
/* 119 */       this.httpUserPass = ctx.getInitParameter("httpUserPass");
/* 120 */       check("*", "httpUserPass");
/*     */       
/* 122 */       this.idsRequestProof = ctx.getInitParameter("idsRequestProof");
/* 123 */       check(this.idsRequestProof, "idsRequestProof");
/*     */       
/* 125 */       this.idsProofPrintType = ctx.getInitParameter("idsProofPrintType");
/* 126 */       check(this.idsProofPrintType, "idsProofPrintType");
/*     */     }
/*     */     catch (Throwable t)
/*     */     {
/* 130 */       logMessage("ERROR", this.className, t.getMessage());
/*     */     }
/*     */   }
/*     */   
/*     */   public void logMessage(String logType, String className, String message)
/*     */   {
/* 136 */     int curLevel = 2;
/* 137 */     if (logType.equalsIgnoreCase("DEBUG")) {
/* 138 */       curLevel = 0;
/* 139 */     } else if (logType.equalsIgnoreCase("WARN")) {
/* 140 */       curLevel = 1;
/*     */     } else {
/* 142 */       curLevel = 2;
/*     */     }
/* 144 */     if (curLevel >= this.logLevel) {
/* 145 */       System.out.println(String.format("<%s> <%s> <wipedit> <%s> %s", new Object[] { new SimpleDateFormat("MMM d, yyyy HH:mm:ss").format(new Date()), logType, className, message }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void setLogLevel(String level)
/*     */   {
/* 152 */     if (level == null) {
/* 153 */       this.logLevel = 2;
/* 154 */       logMessage("WARN", this.className, "Setting <logLevel> missing from web.xml, using default <ERROR>");
/*     */ 
/*     */     }
/* 157 */     else if (level.equalsIgnoreCase("ERROR")) {
/* 158 */       this.logLevel = 2;
/* 159 */     } else if (level.equalsIgnoreCase("DEBUG")) {
/* 160 */       this.logLevel = 0;
/* 161 */     } else if (level.equalsIgnoreCase("WARN")) {
/* 162 */       this.logLevel = 1;
/*     */     } else {
/* 164 */       this.logLevel = 2;
/*     */     }
/* 166 */     logMessage("DEBUG", this.className, "Log Level = <" + this.logLevel + "> <0=DEBUG,1=WARN,2=ERROR>");
/*     */   }
/*     */   
/*     */   private void check(String s, String n) throws Exception
/*     */   {
/* 171 */     if (((s == null ? 1 : 0) | (s.length() < 1 ? 1 : 0)) != 0) {
/* 172 */       logMessage("ERROR", this.className, "Setting '" + n + "' was not configured in web.xml and has no default.");
/*     */       
/* 174 */       throw new Exception("Setting '" + n + "' was not configured in web.xml and has no default.");
/*     */     }
/*     */     
/* 177 */     logMessage("DEBUG", this.className, "<INIT> Setting <" + n + "> = <" + s + ">");
/*     */   }
/*     */   
/*     */   public String userName(Subject subject)
/*     */   {
/* 182 */     if ((subject != null) && (subject.getPrincipals() != null)) {
/* 183 */       for (Principal p : subject.getPrincipals()) {
/* 184 */         if ((p instanceof WLSUser)) {
/* 185 */           return p.getName();
/*     */         }
/*     */       }
/*     */     }
/* 189 */     return "";
/*     */   }
/*     */   
/* 192 */   public String userGroups(Subject subject) { StringBuilder sb = new StringBuilder();
/* 193 */     Boolean first = Boolean.valueOf(true);
/* 194 */     if ((subject != null) && (subject.getPrincipals() != null)) {
/* 195 */       for (Principal p : subject.getPrincipals()) {
/* 196 */         if ((p instanceof WLSGroup)) {
/* 197 */           if (first.booleanValue()) {
/* 198 */             sb.append(p.getName());
/* 199 */             first = Boolean.valueOf(false);
/*     */           }
/*     */           else {
/* 202 */             sb.append("," + p.getName());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 207 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public Boolean isUserDocVet(Subject subject) {
/* 211 */     if ((subject != null) && (subject.getPrincipals() != null)) {
/* 212 */       for (Principal p : subject.getPrincipals()) {
/* 213 */         if (((p instanceof WLSGroup)) && 
/* 214 */           (p.getName().equalsIgnoreCase(this.docVetGroupName))) {
/* 215 */           return Boolean.valueOf(true);
/*     */         }
/*     */       }
/*     */     }
/* 219 */     return Boolean.valueOf(false);
/*     */   }
/*     */   
/* 222 */   public Boolean isUserDocPrep(Subject subject) { if ((subject != null) && (subject.getPrincipals() != null)) {
/* 223 */       for (Principal p : subject.getPrincipals()) {
/* 224 */         if (((p instanceof WLSGroup)) && 
/* 225 */           (p.getName().equalsIgnoreCase(this.docPrepGroupName))) {
/* 226 */           return Boolean.valueOf(true);
/*     */         }
/*     */       }
/*     */     }
/* 230 */     return Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public final synchronized int getLogLevel() {
/* 234 */     return this.logLevel;
/*     */   }
/*     */   
/*     */   public final synchronized void setLogLevel(int s) {
/* 238 */     this.logLevel = s;
/*     */   }
/*     */   
/*     */   public final synchronized String getSaveServlet() {
/* 242 */     return this.saveServlet;
/*     */   }
/*     */   
/*     */   public final synchronized void setSaveServlet(String s) {
/* 246 */     this.saveServlet = s;
/*     */   }
/*     */   
/*     */   public final synchronized void setGetResourceServlet(String getResourceServlet) {
/* 250 */     this.getResourceServlet = getResourceServlet;
/*     */   }
/*     */   
/*     */   public final synchronized String getGetResourceServlet() {
/* 254 */     return this.getResourceServlet;
/*     */   }
/*     */   
/*     */   public final synchronized void setRefreshServlet(String refreshServlet) {
/* 258 */     this.refreshServlet = refreshServlet;
/*     */   }
/*     */   
/*     */   public final synchronized String getRefreshServlet() {
/* 262 */     return this.refreshServlet;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsConfig(String idsConfig) {
/* 266 */     this.idsConfig = idsConfig;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsConfig() {
/* 270 */     return this.idsConfig;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsgetWipPrintType(String idsgetWipPrintType) {
/* 274 */     this.idsgetWipPrintType = idsgetWipPrintType;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsProofPrintType(String idsProofPrintType) {
/* 278 */     this.idsProofPrintType = idsProofPrintType;
/*     */   }
/*     */   
/* 281 */   public final synchronized String getIdsProofPrintType() { return this.idsProofPrintType; }
/*     */   
/*     */ 
/*     */   public final synchronized String getIdsgetWipPrintType()
/*     */   {
/* 286 */     return this.idsgetWipPrintType;
/*     */   }
/*     */   
/*     */   public final synchronized void setHostUrlPrefix(String hostUrlPrefix) {
/* 290 */     this.hostUrlPrefix = hostUrlPrefix;
/*     */   }
/*     */   
/*     */   public final synchronized String getHostUrlPrefix() {
/* 294 */     return this.hostUrlPrefix;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestSave(String idsRequestSave) {
/* 298 */     this.idsRequestSave = idsRequestSave;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestSave() {
/* 302 */     return this.idsRequestSave;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestGetWip(String idsRequestGetWip) {
/* 306 */     this.idsRequestGetWip = idsRequestGetWip;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestGetWip() {
/* 310 */     return this.idsRequestGetWip;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestProof(String idsRequestProof)
/*     */   {
/* 315 */     this.idsRequestProof = idsRequestProof;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestProof() {
/* 319 */     return this.idsRequestProof;
/*     */   }
/*     */   
/*     */ 
/*     */   public final synchronized void setIdsRequestUpdateWip(String idsRequestUpdateWip)
/*     */   {
/* 325 */     this.idsRequestUpdateWip = idsRequestUpdateWip;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestUpdateWip() {
/* 329 */     return this.idsRequestUpdateWip;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestGetResource(String idsRequestGetResource) {
/* 333 */     this.idsRequestGetResource = idsRequestGetResource;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestGetResource() {
/* 337 */     return this.idsRequestGetResource;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestUID(String idsRequestUID) {
/* 341 */     this.idsRequestUID = idsRequestUID;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestUID() {
/* 345 */     return this.idsRequestUID;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestPWD(String idsRequestPWD) {
/* 349 */     this.idsRequestPWD = idsRequestPWD;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestPWD() {
/* 353 */     return this.idsRequestPWD;
/*     */   }
/*     */   
/*     */   public final synchronized void setDocPrepGroupId(String docPrepGroupId) {
/* 357 */     this.docPrepGroupId = docPrepGroupId;
/*     */   }
/*     */   
/*     */   public final synchronized String getDocPrepGroupId() {
/* 361 */     return this.docPrepGroupId;
/*     */   }
/*     */   
/*     */   public final synchronized void setDocVetGroupId(String docVetGroupId) {
/* 365 */     this.docVetGroupId = docVetGroupId;
/*     */   }
/*     */   
/*     */   public final synchronized String getDocVetGroupId() {
/* 369 */     return this.docVetGroupId;
/*     */   }
/*     */   
/*     */   public final synchronized void setDocPrepGroupName(String docPrepGroupName) {
/* 373 */     this.docPrepGroupName = docPrepGroupName;
/*     */   }
/*     */   
/*     */   public final synchronized String getDocPrepGroupName() {
/* 377 */     return this.docPrepGroupName;
/*     */   }
/*     */   
/*     */   public final synchronized void setDocVetGroupName(String docVetGroupName) {
/* 381 */     this.docVetGroupName = docVetGroupName;
/*     */   }
/*     */   
/*     */   public final synchronized String getDocVetGroupName() {
/* 385 */     return this.docVetGroupName;
/*     */   }
/*     */   
/* 388 */   public final synchronized String getHttpUser() { return this.httpUser; }
/*     */   
/*     */   public final synchronized String getHttpUserPass() {
/* 391 */     return this.httpUserPass;
/*     */   }
/*     */   
/* 394 */   public final synchronized void setHttpUser(String httpUser) { this.httpUser = httpUser; }
/*     */   
/*     */   public final synchronized void setHttpUserPass(String httpUserPass) {
/* 397 */     this.httpUserPass = httpUserPass;
/*     */   }
/*     */   
/*     */   public static final synchronized int getLOG_DEBUG()
/*     */   {
/* 402 */     return 0;
/*     */   }
/*     */   
/*     */   public static final synchronized int getLOG_WARN() {
/* 406 */     return 1;
/*     */   }
/*     */   
/*     */   public static final synchronized int getLOG_ERROR() {
/* 410 */     return 2;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2017-2-23-1/WEB-INF/classes/!/wipedit/Controller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */