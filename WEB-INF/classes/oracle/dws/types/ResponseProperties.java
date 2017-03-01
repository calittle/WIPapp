/*    */ package oracle.dws.types;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="ResponseProperties", propOrder={"responseAttachment"})
/*    */ public class ResponseProperties
/*    */ {
/*    */   @XmlElement(name="ResponseAttachment")
/*    */   protected List<ResponseAttachment> responseAttachment;
/*    */   
/*    */   public List<ResponseAttachment> getResponseAttachment()
/*    */   {
/* 63 */     if (this.responseAttachment == null) {
/* 64 */       this.responseAttachment = new ArrayList();
/*    */     }
/* 66 */     return this.responseAttachment;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/ResponseProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */