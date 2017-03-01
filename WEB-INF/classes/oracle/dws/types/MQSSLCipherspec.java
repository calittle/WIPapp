/*    */ package oracle.dws.types;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlEnumValue;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlType(name="MQSSLCipherspec")
/*    */ @XmlEnum
/*    */ public enum MQSSLCipherspec
/*    */ {
/* 36 */   DES_SHA_EXPORT("DES_SHA_EXPORT"), 
/* 37 */   DES_SHA_EXPORT_1024("DES_SHA_EXPORT1024"), 
/*    */   
/* 39 */   NULL_MD_5("NULL_MD5"), 
/*    */   
/* 41 */   NULL_SHA("NULL_SHA"), 
/* 42 */   RC_2_MD_5_EXPORT("RC2_MD5_EXPORT"), 
/*    */   
/* 44 */   RC_4_56_SHA_EXPORT_1024("RC4_56_SHA_EXPORT1024"), 
/*    */   
/* 46 */   RC_4_MD_5_US("RC4_MD5_US"), 
/*    */   
/* 48 */   RC_4_MD_5_EXPORT("RC4_MD5_EXPORT"), 
/*    */   
/* 50 */   RC_4_SHA_US("RC4_SHA_US"), 
/*    */   
/* 52 */   TRIPLE_DES_SHA_US("TRIPLE_DES_SHA_US");
/*    */   
/*    */   private final String value;
/*    */   
/* 56 */   private MQSSLCipherspec(String v) { this.value = v; }
/*    */   
/*    */   public String value()
/*    */   {
/* 60 */     return this.value;
/*    */   }
/*    */   
/*    */   public static MQSSLCipherspec fromValue(String v) {
/* 64 */     for (MQSSLCipherspec c : ) {
/* 65 */       if (c.value.equals(v)) {
/* 66 */         return c;
/*    */       }
/*    */     }
/* 69 */     throw new IllegalArgumentException(v);
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/MQSSLCipherspec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */