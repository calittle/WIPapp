/*     */ package oracle.dws;
/*     */ 
/*     */ import java.util.List;
/*     */ import oracle.dws.types.Attachment;
/*     */ import oracle.dws.types.DSIMSG;
/*     */ import oracle.dws.types.DoCallIDSRequest;
/*     */ import oracle.dws.types.DoCallIDSResponse;
/*     */ import oracle.dws.types.MSGVARS;
/*     */ import oracle.dws.types.ROW;
/*     */ import oracle.dws.types.ROWSET;
/*     */ import oracle.dws.types.VAR;
/*     */ 
/*     */ public class CompositionServicePortClient
/*     */ {
/*     */   @javax.xml.ws.WebServiceRef
/*     */   private static CompositionService compositionService;
/*     */   
/*     */   protected VAR bvar(String var, String val)
/*     */   {
/*  20 */     VAR variable = new VAR();
/*  21 */     variable.setNAME(var);
/*  22 */     variable.setValue(val);
/*  23 */     return variable;
/*     */   }
/*     */   
/*  26 */   public DoCallIDSResponse unlockWIPentry(String config, String uniqueId, String newGroupId, String idsUser, String idsPass, String idsRequestUpdateWip) throws CompositionFault { compositionService = new CompositionService();
/*  27 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/*     */ 
/*  30 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/*  31 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/*  33 */     DSIMSG dsimsg = new DSIMSG();
/*  34 */     dwsRequest.setDSIMSG(dsimsg);
/*  35 */     MSGVARS msgvars = new MSGVARS();
/*  36 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/*  38 */     List<ROWSET> rsList = msgvars.getROWSET();
/*  39 */     ROWSET rowset = null;
/*  40 */     ROW row = null;
/*  41 */     List<ROW> rowList = null;
/*  42 */     List<VAR> varList = null;
/*  43 */     String value = null;
/*     */     
/*  45 */     varList = msgvars.getVAR();
/*  46 */     varList.add(bvar("USERID", idsUser));
/*  47 */     varList.add(bvar("PASSWORD", idsPass));
/*     */     
/*  49 */     varList.add(bvar("REQTYPE", idsRequestUpdateWip));
/*  50 */     varList.add(bvar("CONFIG", config));
/*  51 */     varList.add(bvar("DPRSTANDARDINDEX", "Y"));
/*  52 */     varList.add(bvar("SETBLANKFIELDS", "YES"));
/*  53 */     varList.add(bvar("GOCHANGE", "YES"));
/*     */     
/*  55 */     rowset = new ROWSET();
/*  56 */     rsList.add(rowset);
/*  57 */     rowset.setNAME("WIPS");
/*  58 */     rowList = rowset.getROW();
/*     */     
/*  60 */     row = new ROW();
/*  61 */     varList = row.getVAR();
/*  62 */     varList.add(bvar("UNIQUE_ID", uniqueId));
/*  63 */     rowList.add(row);
/*     */     
/*  65 */     rowset = new ROWSET();
/*  66 */     rsList.add(rowset);
/*  67 */     rowset.setNAME("NEWWIP");
/*  68 */     rowList = rowset.getROW();
/*     */     
/*  70 */     row = new ROW();
/*  71 */     varList = row.getVAR();
/*  72 */     varList.add(bvar("CURRGROUP", newGroupId));
/*  73 */     varList.add(bvar("CURRUSER", ""));
/*  74 */     varList.add(bvar("STATUSCODE", "W"));
/*  75 */     varList.add(bvar("INUSE", ""));
/*  76 */     varList.add(bvar("TRNDOLOG", "2"));
/*  77 */     rowList.add(row);
/*     */     
/*  79 */     DoCallIDSResponse response = null;
/*     */     
/*  81 */     compositionServicePortType.doCallIDS(dwsRequest);
/*  82 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/*  83 */     return response;
/*     */   }
/*     */   
/*     */   public DoCallIDSResponse submitRBC(String config, String uniqueId, String newGroupId, String idsUser, String idsPass, String idsRequestUpdateWip) throws CompositionFault
/*     */   {
/*  88 */     compositionService = new CompositionService();
/*  89 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/*     */ 
/*  92 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/*  93 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/*  95 */     DSIMSG dsimsg = new DSIMSG();
/*  96 */     dwsRequest.setDSIMSG(dsimsg);
/*  97 */     MSGVARS msgvars = new MSGVARS();
/*  98 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/* 100 */     List<ROWSET> rsList = msgvars.getROWSET();
/* 101 */     ROWSET rowset = null;
/* 102 */     ROW row = null;
/* 103 */     List<ROW> rowList = null;
/* 104 */     List<VAR> varList = null;
/* 105 */     String value = null;
/*     */     
/* 107 */     varList = msgvars.getVAR();
/* 108 */     varList.add(bvar("USERID", idsUser));
/* 109 */     varList.add(bvar("PASSWORD", idsPass));
/*     */     
/* 111 */     varList.add(bvar("REQTYPE", idsRequestUpdateWip));
/* 112 */     varList.add(bvar("CONFIG", config));
/* 113 */     varList.add(bvar("DPRSTANDARDINDEX", "Y"));
/* 114 */     varList.add(bvar("SETBLANKFIELDS", "YES"));
/* 115 */     varList.add(bvar("GOCHANGE", "YES"));
/*     */     
/* 117 */     rowset = new ROWSET();
/* 118 */     rsList.add(rowset);
/* 119 */     rowset.setNAME("WIPS");
/* 120 */     rowList = rowset.getROW();
/*     */     
/* 122 */     row = new ROW();
/* 123 */     varList = row.getVAR();
/* 124 */     varList.add(bvar("UNIQUE_ID", uniqueId));
/* 125 */     rowList.add(row);
/*     */     
/* 127 */     rowset = new ROWSET();
/* 128 */     rsList.add(rowset);
/* 129 */     rowset.setNAME("NEWWIP");
/* 130 */     rowList = rowset.getROW();
/*     */     
/* 132 */     row = new ROW();
/* 133 */     varList = row.getVAR();
/* 134 */     varList.add(bvar("CURRGROUP", newGroupId));
/* 135 */     varList.add(bvar("CURRUSER", ""));
/* 136 */     varList.add(bvar("STATUSCODE", "W"));
/* 137 */     varList.add(bvar("INUSE", ""));
/* 138 */     varList.add(bvar("TRNDOLOG", "2"));
/* 139 */     varList.add(bvar("ROUTEDESC", "Processed by SubmitRBC"));
/* 140 */     rowList.add(row);
/*     */     
/*     */ 
/* 143 */     DoCallIDSResponse response = null;
/*     */     
/* 145 */     compositionServicePortType.doCallIDS(dwsRequest);
/* 146 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/* 147 */     return response;
/*     */   }
/*     */   
/*     */   public DoCallIDSResponse lockWIPentry(String config, String uniqueId, String groupId, String idsUser, String idsPass, String idsRequestUpdateWip, String userId) throws CompositionFault
/*     */   {
/* 152 */     compositionService = new CompositionService();
/* 153 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/*     */ 
/* 156 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/* 157 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/* 159 */     DSIMSG dsimsg = new DSIMSG();
/* 160 */     dwsRequest.setDSIMSG(dsimsg);
/* 161 */     MSGVARS msgvars = new MSGVARS();
/* 162 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/* 164 */     List<ROWSET> rsList = msgvars.getROWSET();
/* 165 */     ROWSET rowset = null;
/* 166 */     ROW row = null;
/* 167 */     List<ROW> rowList = null;
/* 168 */     List<VAR> varList = null;
/* 169 */     String value = null;
/*     */     
/* 171 */     varList = msgvars.getVAR();
/* 172 */     varList.add(bvar("USERID", idsUser));
/* 173 */     varList.add(bvar("PASSWORD", idsPass));
/*     */     
/* 175 */     varList.add(bvar("REQTYPE", idsRequestUpdateWip));
/* 176 */     varList.add(bvar("CONFIG", config));
/* 177 */     varList.add(bvar("DPRSTANDARDINDEX", "Y"));
/* 178 */     varList.add(bvar("SETBLANKFIELDS", "YES"));
/* 179 */     varList.add(bvar("GOCHANGE", "YES"));
/*     */     
/* 181 */     rowset = new ROWSET();
/* 182 */     rsList.add(rowset);
/* 183 */     rowset.setNAME("WIPS");
/* 184 */     rowList = rowset.getROW();
/*     */     
/* 186 */     row = new ROW();
/* 187 */     varList = row.getVAR();
/* 188 */     varList.add(bvar("UNIQUE_ID", uniqueId));
/* 189 */     rowList.add(row);
/*     */     
/* 191 */     rowset = new ROWSET();
/* 192 */     rsList.add(rowset);
/* 193 */     rowset.setNAME("NEWWIP");
/* 194 */     rowList = rowset.getROW();
/*     */     
/* 196 */     row = new ROW();
/* 197 */     varList = row.getVAR();
/* 198 */     varList.add(bvar("CURRGROUP", groupId));
/* 199 */     varList.add(bvar("CURRUSER", userId));
/* 200 */     varList.add(bvar("STATUSCODE", "W"));
/* 201 */     varList.add(bvar("INUSE", "Y"));
/* 202 */     varList.add(bvar("TRNDOLOG", "2"));
/* 203 */     rowList.add(row);
/*     */     
/* 205 */     DoCallIDSResponse response = null;
/*     */     
/* 207 */     compositionServicePortType.doCallIDS(dwsRequest);
/* 208 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/* 209 */     return response;
/*     */   }
/*     */   
/*     */   public DoCallIDSResponse getResource(String config, String effectiveDate, String entityId, String resourceName, String resourceType, String idsUser, String idsPass, String idsReqGetResource) throws CompositionFault
/*     */   {
/* 214 */     compositionService = new CompositionService();
/* 215 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/*     */ 
/* 218 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/* 219 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/* 221 */     DSIMSG dsimsg = new DSIMSG();
/* 222 */     dwsRequest.setDSIMSG(dsimsg);
/* 223 */     MSGVARS msgvars = new MSGVARS();
/* 224 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/* 226 */     List<ROWSET> rsList = msgvars.getROWSET();
/* 227 */     ROWSET rowset = null;
/* 228 */     ROW row = null;
/* 229 */     List<ROW> rowList = null;
/* 230 */     List<VAR> varList = null;
/* 231 */     String value = null;
/* 232 */     varList = msgvars.getVAR();
/* 233 */     varList.add(bvar("USERID", idsUser));
/* 234 */     varList.add(bvar("PASSWORD", idsPass));
/* 235 */     varList.add(bvar("REQTYPE", idsReqGetResource));
/* 236 */     varList.add(bvar("CONFIG", config));
/* 237 */     varList.add(bvar("DPRSTANDARDINDEX", "Y"));
/* 238 */     varList.add(bvar("EFFECTIVEDATE", effectiveDate));
/* 239 */     varList.add(bvar("entityId", entityId));
/* 240 */     varList.add(bvar("RESOURCENAME", resourceName));
/* 241 */     varList.add(bvar("RESOURCETYPE", resourceType));
/*     */     
/* 243 */     DoCallIDSResponse response = null;
/*     */     
/* 245 */     compositionServicePortType.doCallIDS(dwsRequest);
/* 246 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/* 247 */     return response;
/*     */   }
/*     */   
/*     */   public DoCallIDSResponse getWIPentry(String config, String uniqueId, String idsUser, String idsPass, String idsPrintType, String urlPrefix, String idsReqGetWip, String idsReqSave, String servletGetResource, String servletSave, String servletRefresh, String httpUser, String httpUserPass) throws CompositionFault {
/* 251 */     compositionService = new CompositionService();
/* 252 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/*     */ 
/* 255 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/* 256 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/* 258 */     DSIMSG dsimsg = new DSIMSG();
/* 259 */     dwsRequest.setDSIMSG(dsimsg);
/* 260 */     MSGVARS msgvars = new MSGVARS();
/* 261 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/* 263 */     List<ROWSET> rsList = msgvars.getROWSET();
/* 264 */     ROWSET rowset = null;
/* 265 */     ROW row = null;
/* 266 */     List<ROW> rowList = null;
/* 267 */     List<VAR> varList = null;
/* 268 */     String value = null;
/* 269 */     varList = msgvars.getVAR();
/* 270 */     varList.add(bvar("USERID", idsUser));
/* 271 */     varList.add(bvar("PASSWORD", idsPass));
/* 272 */     varList.add(bvar("PRTTYPE", idsPrintType));
/*     */     
/* 274 */     varList.add(bvar("PUTURL", urlPrefix));
/* 275 */     varList.add(bvar("HTTPUSERID", httpUser));
/* 276 */     varList.add(bvar("HTTPPASSWORD", httpUserPass));
/*     */     
/* 278 */     varList.add(bvar("SAVE_REQTYPE", idsReqSave));
/* 279 */     varList.add(bvar("REQTYPE", idsReqGetWip));
/*     */     
/* 281 */     varList.add(bvar("SCRIPT", servletSave));
/* 282 */     varList.add(bvar("REFRESHSCRIPT", servletRefresh));
/* 283 */     varList.add(bvar("GETSCRIPT", servletGetResource));
/*     */     
/* 285 */     varList.add(bvar("CONFIG", config));
/* 286 */     varList.add(bvar("UNIQUE_ID", uniqueId));
/*     */     
/* 288 */     DoCallIDSResponse response = null;
/*     */     
/* 290 */     compositionServicePortType.doCallIDS(dwsRequest);
/* 291 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/* 292 */     return response;
/*     */   }
/*     */   
/*     */   public DoCallIDSResponse saveWIPEntry(Attachment attachment, String idsReqType, String config, String uniqueId, String currentUser, String idsUser, String idsPass, String idsPrintType) throws CompositionFault {
/* 296 */     compositionService = new CompositionService();
/* 297 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/* 299 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/* 300 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/* 302 */     DSIMSG dsimsg = new DSIMSG();
/* 303 */     dwsRequest.setDSIMSG(dsimsg);
/*     */     
/* 305 */     MSGVARS msgvars = new MSGVARS();
/* 306 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/* 308 */     List<Attachment> attachments = dsimsg.getAttachment();
/* 309 */     attachments.add(attachment);
/*     */     
/* 311 */     List<ROWSET> rsList = msgvars.getROWSET();
/* 312 */     ROWSET rowset = null;
/* 313 */     ROW row = null;
/* 314 */     List<ROW> rowList = null;
/* 315 */     List<VAR> varList = null;
/* 316 */     String value = null;
/* 317 */     varList = msgvars.getVAR();
/*     */     
/* 319 */     varList.add(bvar("REQTYPE", idsReqType));
/* 320 */     varList.add(bvar("USERID", idsUser));
/* 321 */     varList.add(bvar("PASSWORD", idsPass));
/* 322 */     varList.add(bvar("PRTTYPE", idsPrintType));
/* 323 */     varList.add(bvar("DPWRECNUM", uniqueId));
/* 324 */     varList.add(bvar("CONFIG", config));
/* 325 */     varList.add(bvar("CURRUSER", currentUser));
/* 326 */     DoCallIDSResponse response = null;
/*     */     
/* 328 */     compositionServicePortType.doCallIDS(dwsRequest);
/* 329 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/* 330 */     return response;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/CompositionServicePortClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */