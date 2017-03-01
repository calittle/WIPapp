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
/*  40 */   private int logLevel = 2;
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
/*  51 */       ServletContext ctx = config.getServletContext();
/*     */       
/*  53 */       check(ctx.getInitParameter("wipEditVersion"), "Web Application: WipEdit Version ");
/*  54 */       this.pegaEndpoint = ctx.getInitParameter("pegaEndpoint");
/*  55 */       check(this.pegaEndpoint, "pegaEndpoint");
/*     */       
/*  57 */       logMessage("DEBUG", this.className, "Version 1.0");
/*     */       
/*  59 */       this.saveServlet = ctx.getInitParameter("saveServlet");
/*  60 */       check(this.saveServlet, "saveServlet");
/*     */       
/*  62 */       this.idsConfig = ctx.getInitParameter("idsConfig");
/*  63 */       check(this.idsConfig, "idsConfig");
/*     */       
/*  65 */       setLogLevel(ctx.getInitParameter("logLevel"));
/*     */       
/*  67 */       this.getResourceServlet = ctx.getInitParameter("getResourceServlet");
/*  68 */       check(this.getResourceServlet, "getResourceServlet");
/*     */       
/*  70 */       this.idsConfig = ctx.getInitParameter("idsConfig");
/*  71 */       check(this.idsConfig, "idsConfig");
/*     */       
/*  73 */       this.idsgetWipPrintType = ctx.getInitParameter("idsgetWipPrintType");
/*  74 */       check(this.idsgetWipPrintType, "idsgetWipPrintType");
/*     */       
/*  76 */       this.hostUrlPrefix = ctx.getInitParameter("hostUrlPrefix");
/*  77 */       check(this.hostUrlPrefix, "hostUrlPrefix");
/*     */       
/*  79 */       this.idsRequestSave = ctx.getInitParameter("idsRequestSave");
/*  80 */       check(this.idsRequestSave, "idsRequestSave");
/*     */       
/*  82 */       this.idsRequestGetWip = ctx.getInitParameter("idsRequestGetWip");
/*  83 */       check(this.idsRequestGetWip, "idsRequestGetWip");
/*     */       
/*  85 */       this.idsRequestUpdateWip = ctx.getInitParameter("idsRequestUpdateWip");
/*  86 */       check(this.idsRequestUpdateWip, "idsRequestUpdateWip");
/*     */       
/*  88 */       this.idsRequestGetResource = ctx.getInitParameter("idsRequestGetResource");
/*     */       
/*  90 */       check(this.idsRequestGetResource, "idsRequestGetResource");
/*     */       
/*  92 */       this.idsRequestUID = ctx.getInitParameter("idsRequestUID");
/*  93 */       check(this.idsRequestUID, "idsRequestUID");
/*     */       
/*  95 */       this.idsRequestPWD = ctx.getInitParameter("idsRequestPWD");
/*  96 */       check(this.idsRequestPWD, "idsRequestPWD");
/*     */       
/*  98 */       this.refreshServlet = ctx.getInitParameter("refreshServlet");
/*  99 */       check(this.refreshServlet, "refreshServlet");
/*     */       
/* 101 */       this.docPrepGroupId = ctx.getInitParameter("docPrepGroupId");
/* 102 */       check(this.docPrepGroupId, "docPrepGroupId");
/*     */       
/* 104 */       this.docVetGroupId = ctx.getInitParameter("docVetGroupId");
/* 105 */       check(this.docVetGroupId, "docVetGroupId");
/*     */       
/* 107 */       this.docPrepGroupName = ctx.getInitParameter("docPrepGroupName");
/* 108 */       check(this.docPrepGroupName, "docPrepGroupName");
/*     */       
/* 110 */       this.docVetGroupName = ctx.getInitParameter("docVetGroupName");
/* 111 */       check(this.docVetGroupName, "docVetGroupName");
/*     */       
/* 113 */       this.httpUser = ctx.getInitParameter("httpUser");
/* 114 */       check(this.httpUser, "httpUser");
/*     */       
/* 116 */       this.httpUserPass = ctx.getInitParameter("httpUserPass");
/* 117 */       check("*", "httpUserPass");
/*     */     }
/*     */     catch (Throwable t) {
/* 120 */       logMessage("ERROR", this.className, t.getMessage());
/*     */     }
/*     */   }
/*     */   
/*     */   public void logMessage(String logType, String className, String message)
/*     */   {
/* 126 */     int curLevel = 2;
/* 127 */     if (logType.equalsIgnoreCase("DEBUG")) {
/* 128 */       curLevel = 0;
/* 129 */     } else if (logType.equalsIgnoreCase("WARN")) {
/* 130 */       curLevel = 1;
/*     */     } else {
/* 132 */       curLevel = 2;
/*     */     }
/* 134 */     if (curLevel >= this.logLevel) {
/* 135 */       System.out.println(String.format("<%s> <%s> <wipedit> <%s> %s", new Object[] { new SimpleDateFormat("MMM d, yyyy HH:mm:ss").format(new Date()), logType, className, message }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void setLogLevel(String level)
/*     */   {
/* 142 */     if (level == null) {
/* 143 */       this.logLevel = 2;
/* 144 */       logMessage("WARN", this.className, "Setting <logLevel> missing from web.xml, using default <ERROR>");
/*     */ 
/*     */     }
/* 147 */     else if (level.equalsIgnoreCase("ERROR")) {
/* 148 */       this.logLevel = 2;
/* 149 */     } else if (level.equalsIgnoreCase("DEBUG")) {
/* 150 */       this.logLevel = 0;
/* 151 */     } else if (level.equalsIgnoreCase("WARN")) {
/* 152 */       this.logLevel = 1;
/*     */     } else {
/* 154 */       this.logLevel = 2;
/*     */     }
/* 156 */     logMessage("DEBUG", this.className, "Log Level = <" + this.logLevel + "> <0=DEBUG,1=WARN,2=ERROR>");
/*     */   }
/*     */   
/*     */   private void check(String s, String n) throws Exception
/*     */   {
/* 161 */     if (((s == null ? 1 : 0) | (s.length() < 1 ? 1 : 0)) != 0) {
/* 162 */       logMessage("ERROR", this.className, "Setting '" + n + "' was not configured in web.xml and has no default.");
/*     */       
/* 164 */       throw new Exception("Setting '" + n + "' was not configured in web.xml and has no default.");
/*     */     }
/*     */     
/* 167 */     logMessage("DEBUG", this.className, "<INIT> Setting <" + n + "> = <" + s + ">");
/*     */   }
/*     */   
/*     */   public String userName(Subject subject)
/*     */   {
/* 172 */     if ((subject != null) && (subject.getPrincipals() != null)) {
/* 173 */       for (Principal p : subject.getPrincipals()) {
/* 174 */         if ((p instanceof WLSUser)) {
/* 175 */           return p.getName();
/*     */         }
/*     */       }
/*     */     }
/* 179 */     return "";
/*     */   }
/*     */   
/* 182 */   public String userGroups(Subject subject) { StringBuilder sb = new StringBuilder();
/* 183 */     Boolean first = Boolean.valueOf(true);
/* 184 */     if ((subject != null) && (subject.getPrincipals() != null)) {
/* 185 */       for (Principal p : subject.getPrincipals()) {
/* 186 */         if ((p instanceof WLSGroup)) {
/* 187 */           if (first.booleanValue()) {
/* 188 */             sb.append(p.getName());
/* 189 */             first = Boolean.valueOf(false);
/*     */           }
/*     */           else {
/* 192 */             sb.append("," + p.getName());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 197 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public Boolean isUserDocVet(Subject subject) {
/* 201 */     if ((subject != null) && (subject.getPrincipals() != null)) {
/* 202 */       for (Principal p : subject.getPrincipals()) {
/* 203 */         if (((p instanceof WLSGroup)) && 
/* 204 */           (p.getName().equalsIgnoreCase(this.docVetGroupName))) {
/* 205 */           return Boolean.valueOf(true);
/*     */         }
/*     */       }
/*     */     }
/* 209 */     return Boolean.valueOf(false);
/*     */   }
/*     */   
/* 212 */   public Boolean isUserDocPrep(Subject subject) { if ((subject != null) && (subject.getPrincipals() != null)) {
/* 213 */       for (Principal p : subject.getPrincipals()) {
/* 214 */         if (((p instanceof WLSGroup)) && 
/* 215 */           (p.getName().equalsIgnoreCase(this.docPrepGroupName))) {
/* 216 */           return Boolean.valueOf(true);
/*     */         }
/*     */       }
/*     */     }
/* 220 */     return Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public final synchronized int getLogLevel() {
/* 224 */     return this.logLevel;
/*     */   }
/*     */   
/*     */   public final synchronized void setLogLevel(int s) {
/* 228 */     this.logLevel = s;
/*     */   }
/*     */   
/*     */   public final synchronized String getSaveServlet() {
/* 232 */     return this.saveServlet;
/*     */   }
/*     */   
/*     */   public final synchronized void setSaveServlet(String s) {
/* 236 */     this.saveServlet = s;
/*     */   }
/*     */   
/*     */   public final synchronized void setGetResourceServlet(String getResourceServlet) {
/* 240 */     this.getResourceServlet = getResourceServlet;
/*     */   }
/*     */   
/*     */   public final synchronized String getGetResourceServlet() {
/* 244 */     return this.getResourceServlet;
/*     */   }
/*     */   
/*     */   public final synchronized void setRefreshServlet(String refreshServlet) {
/* 248 */     this.refreshServlet = refreshServlet;
/*     */   }
/*     */   
/*     */   public final synchronized String getRefreshServlet() {
/* 252 */     return this.refreshServlet;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsConfig(String idsConfig) {
/* 256 */     this.idsConfig = idsConfig;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsConfig() {
/* 260 */     return this.idsConfig;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsgetWipPrintType(String idsgetWipPrintType) {
/* 264 */     this.idsgetWipPrintType = idsgetWipPrintType;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsgetWipPrintType() {
/* 268 */     return this.idsgetWipPrintType;
/*     */   }
/*     */   
/*     */   public final synchronized void setHostUrlPrefix(String hostUrlPrefix) {
/* 272 */     this.hostUrlPrefix = hostUrlPrefix;
/*     */   }
/*     */   
/*     */   public final synchronized String getHostUrlPrefix() {
/* 276 */     return this.hostUrlPrefix;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestSave(String idsRequestSave) {
/* 280 */     this.idsRequestSave = idsRequestSave;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestSave() {
/* 284 */     return this.idsRequestSave;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestGetWip(String idsRequestGetWip) {
/* 288 */     this.idsRequestGetWip = idsRequestGetWip;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestGetWip() {
/* 292 */     return this.idsRequestGetWip;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestUpdateWip(String idsRequestUpdateWip) {
/* 296 */     this.idsRequestUpdateWip = idsRequestUpdateWip;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestUpdateWip() {
/* 300 */     return this.idsRequestUpdateWip;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestGetResource(String idsRequestGetResource) {
/* 304 */     this.idsRequestGetResource = idsRequestGetResource;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestGetResource() {
/* 308 */     return this.idsRequestGetResource;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestUID(String idsRequestUID) {
/* 312 */     this.idsRequestUID = idsRequestUID;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestUID() {
/* 316 */     return this.idsRequestUID;
/*     */   }
/*     */   
/*     */   public final synchronized void setIdsRequestPWD(String idsRequestPWD) {
/* 320 */     this.idsRequestPWD = idsRequestPWD;
/*     */   }
/*     */   
/*     */   public final synchronized String getIdsRequestPWD() {
/* 324 */     return this.idsRequestPWD;
/*     */   }
/*     */   
/*     */   public final synchronized void setDocPrepGroupId(String docPrepGroupId) {
/* 328 */     this.docPrepGroupId = docPrepGroupId;
/*     */   }
/*     */   
/*     */   public final synchronized String getDocPrepGroupId() {
/* 332 */     return this.docPrepGroupId;
/*     */   }
/*     */   
/*     */   public final synchronized void setDocVetGroupId(String docVetGroupId) {
/* 336 */     this.docVetGroupId = docVetGroupId;
/*     */   }
/*     */   
/*     */   public final synchronized String getDocVetGroupId() {
/* 340 */     return this.docVetGroupId;
/*     */   }
/*     */   
/*     */   public final synchronized void setDocPrepGroupName(String docPrepGroupName) {
/* 344 */     this.docPrepGroupName = docPrepGroupName;
/*     */   }
/*     */   
/*     */   public final synchronized String getDocPrepGroupName() {
/* 348 */     return this.docPrepGroupName;
/*     */   }
/*     */   
/*     */   public final synchronized void setDocVetGroupName(String docVetGroupName) {
/* 352 */     this.docVetGroupName = docVetGroupName;
/*     */   }
/*     */   
/*     */   public final synchronized String getDocVetGroupName() {
/* 356 */     return this.docVetGroupName;
/*     */   }
/*     */   
/* 359 */   public final synchronized String getHttpUser() { return this.httpUser; }
/*     */   
/*     */   public final synchronized String getHttpUserPass() {
/* 362 */     return this.httpUserPass;
/*     */   }
/*     */   
/* 365 */   public final synchronized void setHttpUser(String httpUser) { this.httpUser = httpUser; }
/*     */   
/*     */   public final synchronized void setHttpUserPass(String httpUserPass) {
/* 368 */     this.httpUserPass = httpUserPass;
/*     */   }
/*     */   
/*     */   public static final synchronized int getLOG_DEBUG()
/*     */   {
/* 373 */     return 0;
/*     */   }
/*     */   
/*     */   public static final synchronized int getLOG_WARN() {
/* 377 */     return 1;
/*     */   }
/*     */   
/*     */   public static final synchronized int getLOG_ERROR() {
/* 381 */     return 2;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/wipedit/Controller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */