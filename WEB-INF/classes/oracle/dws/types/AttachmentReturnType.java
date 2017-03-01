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
/*    */ @XmlType(name="AttachmentReturnType", namespace="oracle/documaker/schema/common")
/*    */ @XmlEnum
/*    */ public enum AttachmentReturnType
/*    */ {
/* 28 */   URI("URI"), 
/* 29 */   BINARY("Binary");
/*    */   
/*    */   private final String value;
/*    */   
/*    */   private AttachmentReturnType(String v) {
/* 34 */     this.value = v;
/*    */   }
/*    */   
/*    */   public String value() {
/* 38 */     return this.value;
/*    */   }
/*    */   
/*    */   public static AttachmentReturnType fromValue(String v) {
/* 42 */     for (AttachmentReturnType c : ) {
/* 43 */       if (c.value.equals(v)) {
/* 44 */         return c;
/*    */       }
/*    */     }
/* 47 */     throw new IllegalArgumentException(v);
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/AttachmentReturnType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */