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
/*     */   public DoCallIDSResponse unlockWIPentry(String config, String uniqueId, String newGroupId, String idsUser, String idsPass, String idsRequestUpdateWip) throws CompositionFault
/*     */   {
/*  28 */     compositionService = new CompositionService();
/*  29 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/*     */ 
/*  32 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/*  33 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/*  35 */     DSIMSG dsimsg = new DSIMSG();
/*  36 */     dwsRequest.setDSIMSG(dsimsg);
/*  37 */     MSGVARS msgvars = new MSGVARS();
/*  38 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/*  40 */     List<ROWSET> rsList = msgvars.getROWSET();
/*  41 */     ROWSET rowset = null;
/*  42 */     ROW row = null;
/*  43 */     List<ROW> rowList = null;
/*  44 */     List<VAR> varList = null;
/*  45 */     String value = null;
/*     */     
/*  47 */     varList = msgvars.getVAR();
/*  48 */     varList.add(bvar("USERID", idsUser));
/*  49 */     varList.add(bvar("PASSWORD", idsPass));
/*     */     
/*  51 */     varList.add(bvar("REQTYPE", idsRequestUpdateWip));
/*  52 */     varList.add(bvar("CONFIG", config));
/*  53 */     varList.add(bvar("DPRSTANDARDINDEX", "Y"));
/*  54 */     varList.add(bvar("SETBLANKFIELDS", "YES"));
/*  55 */     varList.add(bvar("GOCHANGE", "YES"));
/*     */     
/*  57 */     rowset = new ROWSET();
/*  58 */     rsList.add(rowset);
/*  59 */     rowset.setNAME("WIPS");
/*  60 */     rowList = rowset.getROW();
/*     */     
/*  62 */     row = new ROW();
/*  63 */     varList = row.getVAR();
/*  64 */     varList.add(bvar("UNIQUE_ID", uniqueId));
/*  65 */     rowList.add(row);
/*     */     
/*  67 */     rowset = new ROWSET();
/*  68 */     rsList.add(rowset);
/*  69 */     rowset.setNAME("NEWWIP");
/*  70 */     rowList = rowset.getROW();
/*     */     
/*  72 */     row = new ROW();
/*  73 */     varList = row.getVAR();
/*  74 */     varList.add(bvar("CURRGROUP", newGroupId));
/*  75 */     varList.add(bvar("CURRUSER", ""));
/*  76 */     varList.add(bvar("STATUSCODE", "W"));
/*  77 */     varList.add(bvar("INUSE", ""));
/*  78 */     varList.add(bvar("TRNDOLOG", "2"));
/*  79 */     rowList.add(row);
/*     */     
/*  81 */     DoCallIDSResponse response = null;
/*     */     
/*  83 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/*  84 */     return response;
/*     */   }
/*     */   
/*     */   public DoCallIDSResponse submitRBC(String config, String uniqueId, String newGroupId, String idsUser, String idsPass, String idsRequestUpdateWip) throws CompositionFault
/*     */   {
/*  89 */     compositionService = new CompositionService();
/*  90 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/*     */ 
/*  93 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/*  94 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/*  96 */     DSIMSG dsimsg = new DSIMSG();
/*  97 */     dwsRequest.setDSIMSG(dsimsg);
/*  98 */     MSGVARS msgvars = new MSGVARS();
/*  99 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/* 101 */     List<ROWSET> rsList = msgvars.getROWSET();
/* 102 */     ROWSET rowset = null;
/* 103 */     ROW row = null;
/* 104 */     List<ROW> rowList = null;
/* 105 */     List<VAR> varList = null;
/* 106 */     String value = null;
/*     */     
/* 108 */     varList = msgvars.getVAR();
/* 109 */     varList.add(bvar("USERID", idsUser));
/* 110 */     varList.add(bvar("PASSWORD", idsPass));
/*     */     
/* 112 */     varList.add(bvar("REQTYPE", idsRequestUpdateWip));
/* 113 */     varList.add(bvar("CONFIG", config));
/* 114 */     varList.add(bvar("DPRSTANDARDINDEX", "Y"));
/* 115 */     varList.add(bvar("SETBLANKFIELDS", "YES"));
/* 116 */     varList.add(bvar("GOCHANGE", "YES"));
/*     */     
/* 118 */     rowset = new ROWSET();
/* 119 */     rsList.add(rowset);
/* 120 */     rowset.setNAME("WIPS");
/* 121 */     rowList = rowset.getROW();
/*     */     
/* 123 */     row = new ROW();
/* 124 */     varList = row.getVAR();
/* 125 */     varList.add(bvar("UNIQUE_ID", uniqueId));
/* 126 */     rowList.add(row);
/*     */     
/* 128 */     rowset = new ROWSET();
/* 129 */     rsList.add(rowset);
/* 130 */     rowset.setNAME("NEWWIP");
/* 131 */     rowList = rowset.getROW();
/*     */     
/* 133 */     row = new ROW();
/* 134 */     varList = row.getVAR();
/* 135 */     varList.add(bvar("CURRGROUP", newGroupId));
/* 136 */     varList.add(bvar("CURRUSER", ""));
/* 137 */     varList.add(bvar("STATUSCODE", "W"));
/* 138 */     varList.add(bvar("INUSE", ""));
/* 139 */     varList.add(bvar("TRNDOLOG", "2"));
/* 140 */     varList.add(bvar("ROUTEDESC", "Processed by SubmitRBC"));
/* 141 */     rowList.add(row);
/*     */     
/*     */ 
/* 144 */     DoCallIDSResponse response = null;
/*     */     
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
/* 207 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/* 208 */     return response;
/*     */   }
/*     */   
/*     */   public DoCallIDSResponse getResource(String config, String effectiveDate, String entityId, String resourceName, String resourceType, String idsUser, String idsPass, String idsReqGetResource) throws CompositionFault
/*     */   {
/* 213 */     compositionService = new CompositionService();
/* 214 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/*     */ 
/* 217 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/* 218 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/* 220 */     DSIMSG dsimsg = new DSIMSG();
/* 221 */     dwsRequest.setDSIMSG(dsimsg);
/* 222 */     MSGVARS msgvars = new MSGVARS();
/* 223 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/* 225 */     List<ROWSET> rsList = msgvars.getROWSET();
/* 226 */     ROWSET rowset = null;
/* 227 */     ROW row = null;
/* 228 */     List<ROW> rowList = null;
/* 229 */     List<VAR> varList = null;
/* 230 */     String value = null;
/* 231 */     varList = msgvars.getVAR();
/* 232 */     varList.add(bvar("USERID", idsUser));
/* 233 */     varList.add(bvar("PASSWORD", idsPass));
/* 234 */     varList.add(bvar("REQTYPE", idsReqGetResource));
/* 235 */     varList.add(bvar("CONFIG", config));
/* 236 */     varList.add(bvar("DPRSTANDARDINDEX", "Y"));
/* 237 */     varList.add(bvar("EFFECTIVEDATE", effectiveDate));
/* 238 */     varList.add(bvar("entityId", entityId));
/* 239 */     varList.add(bvar("RESOURCENAME", resourceName));
/* 240 */     varList.add(bvar("RESOURCETYPE", resourceType));
/*     */     
/* 242 */     DoCallIDSResponse response = null;
/*     */     
/* 244 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/* 245 */     return response;
/*     */   }
/*     */   
/*     */   public DoCallIDSResponse getWIPentry(String config, String uniqueId, String idsUser, String idsPass, String idsPrintType, String urlPrefix, String idsReqGetWip, String idsReqSave, String servletGetResource, String servletSave, String servletRefresh, String httpUser, String httpUserPass) throws CompositionFault {
/* 249 */     compositionService = new CompositionService();
/* 250 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/*     */ 
/* 253 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/* 254 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/* 256 */     DSIMSG dsimsg = new DSIMSG();
/* 257 */     dwsRequest.setDSIMSG(dsimsg);
/* 258 */     MSGVARS msgvars = new MSGVARS();
/* 259 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/* 261 */     List<ROWSET> rsList = msgvars.getROWSET();
/* 262 */     ROWSET rowset = null;
/* 263 */     ROW row = null;
/* 264 */     List<ROW> rowList = null;
/* 265 */     List<VAR> varList = null;
/* 266 */     String value = null;
/* 267 */     varList = msgvars.getVAR();
/* 268 */     varList.add(bvar("USERID", idsUser));
/* 269 */     varList.add(bvar("PASSWORD", idsPass));
/* 270 */     varList.add(bvar("PRTTYPE", idsPrintType));
/*     */     
/* 272 */     varList.add(bvar("PUTURL", urlPrefix));
/* 273 */     varList.add(bvar("HTTPUSERID", httpUser));
/* 274 */     varList.add(bvar("HTTPPASSWORD", httpUserPass));
/*     */     
/* 276 */     varList.add(bvar("SAVE_REQTYPE", idsReqSave));
/* 277 */     varList.add(bvar("REQTYPE", idsReqGetWip));
/*     */     
/* 279 */     varList.add(bvar("SCRIPT", servletSave));
/* 280 */     varList.add(bvar("REFRESHSCRIPT", servletRefresh));
/* 281 */     varList.add(bvar("GETSCRIPT", servletGetResource));
/*     */     
/* 283 */     varList.add(bvar("CONFIG", config));
/* 284 */     varList.add(bvar("UNIQUE_ID", uniqueId));
/*     */     
/* 286 */     DoCallIDSResponse response = null;
/*     */     
/* 288 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/* 289 */     return response;
/*     */   }
/*     */   
/*     */   public DoCallIDSResponse saveWIPEntry(Attachment attachment, String idsReqType, String config, String uniqueId, String currentUser, String idsUser, String idsPass, String idsPrintType) throws CompositionFault {
/* 293 */     compositionService = new CompositionService();
/* 294 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/* 296 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/* 297 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/* 299 */     DSIMSG dsimsg = new DSIMSG();
/* 300 */     dwsRequest.setDSIMSG(dsimsg);
/*     */     
/* 302 */     MSGVARS msgvars = new MSGVARS();
/* 303 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/* 305 */     List<Attachment> attachments = dsimsg.getAttachment();
/* 306 */     attachments.add(attachment);
/*     */     
/* 308 */     List<ROWSET> rsList = msgvars.getROWSET();
/* 309 */     ROWSET rowset = null;
/* 310 */     ROW row = null;
/* 311 */     List<ROW> rowList = null;
/* 312 */     List<VAR> varList = null;
/* 313 */     String value = null;
/* 314 */     varList = msgvars.getVAR();
/*     */     
/* 316 */     varList.add(bvar("REQTYPE", idsReqType));
/* 317 */     varList.add(bvar("USERID", idsUser));
/* 318 */     varList.add(bvar("PASSWORD", idsPass));
/* 319 */     varList.add(bvar("PRTTYPE", idsPrintType));
/* 320 */     varList.add(bvar("DPWRECNUM", uniqueId));
/* 321 */     varList.add(bvar("CONFIG", config));
/* 322 */     varList.add(bvar("CURRUSER", currentUser));
/* 323 */     DoCallIDSResponse response = null;
/*     */     
/* 325 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/* 326 */     return response;
/*     */   }
/*     */   
/*     */   public DoCallIDSResponse printWIPEntry(String config, String uniqueId, String idsUser, String idsPass, String idsPrintType, String idsRequestProof) throws CompositionFault {
/* 330 */     compositionService = new CompositionService();
/* 331 */     CompositionServicePortType compositionServicePortType = compositionService.getCompositionServicePort();
/*     */     
/*     */ 
/* 334 */     DoCallIDSRequest dwsRequest = new DoCallIDSRequest();
/* 335 */     dwsRequest.setSchemaVersion("1.0");
/*     */     
/* 337 */     DSIMSG dsimsg = new DSIMSG();
/* 338 */     dwsRequest.setDSIMSG(dsimsg);
/* 339 */     MSGVARS msgvars = new MSGVARS();
/* 340 */     dsimsg.setMSGVARS(msgvars);
/*     */     
/* 342 */     List<ROWSET> rsList = msgvars.getROWSET();
/* 343 */     ROWSET rowset = null;
/* 344 */     ROW row = null;
/* 345 */     List<ROW> rowList = null;
/* 346 */     List<VAR> varList = null;
/* 347 */     String value = null;
/* 348 */     varList = msgvars.getVAR();
/* 349 */     varList.add(bvar("USERID", idsUser));
/* 350 */     varList.add(bvar("PASSWORD", idsPass));
/* 351 */     varList.add(bvar("PRTTYPE", idsPrintType));
/* 352 */     varList.add(bvar("REQTYPE", idsRequestProof));
/* 353 */     varList.add(bvar("CONFIG", config));
/* 354 */     varList.add(bvar("UNIQUE_ID", uniqueId));
/*     */     
/* 356 */     DoCallIDSResponse response = null;
/*     */     
/* 358 */     response = compositionServicePortType.doCallIDS(dwsRequest);
/* 359 */     return response;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2017-2-23-1/WEB-INF/classes/!/oracle/dws/CompositionServicePortClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */