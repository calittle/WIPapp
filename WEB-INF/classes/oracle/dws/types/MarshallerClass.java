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
/*    */ @XmlType(name="MarshallerClass")
/*    */ @XmlEnum
/*    */ public enum MarshallerClass
/*    */ {
/* 28 */   COM_DOCUCORP_MESSAGING_DATA_MARSHALLER_SERIALIZATION_DSI_MESSAGE_MARSHALLER("com.docucorp.messaging.data.marshaller.SerializationDSIMessageMarshaller"), 
/*    */   
/* 30 */   COM_DOCUCORP_MESSAGING_DATA_MARSHALLER_SOAPMIMEDSI_MESSAGE_MARSHALLER("com.docucorp.messaging.data.marshaller.SOAPMIMEDSIMessageMarshaller");
/*    */   
/*    */   private final String value;
/*    */   
/*    */   private MarshallerClass(String v) {
/* 35 */     this.value = v;
/*    */   }
/*    */   
/*    */   public String value() {
/* 39 */     return this.value;
/*    */   }
/*    */   
/*    */   public static MarshallerClass fromValue(String v) {
/* 43 */     for (MarshallerClass c : ) {
/* 44 */       if (c.value.equals(v)) {
/* 45 */         return c;
/*    */       }
/*    */     }
/* 48 */     throw new IllegalArgumentException(v);
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/MarshallerClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */