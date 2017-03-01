/*    */ package oracle.dws.types;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlSeeAlso;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="AttachmentBase", namespace="oracle/documaker/schema/common", propOrder={"name", "content"})
/*    */ @XmlSeeAlso({Attachment.class})
/*    */ public abstract class AttachmentBase
/*    */ {
/*    */   @XmlElement(name="Name")
/*    */   protected String name;
/*    */   @XmlElement(name="Content", required=true)
/*    */   protected Content content;
/*    */   
/*    */   public String getName()
/*    */   {
/* 55 */     return this.name;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setName(String value)
/*    */   {
/* 67 */     this.name = value;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Content getContent()
/*    */   {
/* 79 */     return this.content;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setContent(Content value)
/*    */   {
/* 91 */     this.content = value;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/AttachmentBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */