/*     */ package oracle.dws.types;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="ResponseAttachment", namespace="oracle/documaker/schema/common", propOrder={"name", "returnType", "uri"})
/*     */ public class ResponseAttachment
/*     */ {
/*     */   @XmlElement(name="Name", required=true)
/*     */   protected String name;
/*     */   @XmlElement(name="ReturnType", required=true)
/*     */   protected AttachmentReturnType returnType;
/*     */   @XmlElement(name="URI", defaultValue="file:///temp/outputfile")
/*     */   protected String uri;
/*     */   
/*     */   public String getName()
/*     */   {
/*  55 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String value)
/*     */   {
/*  67 */     this.name = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AttachmentReturnType getReturnType()
/*     */   {
/*  79 */     return this.returnType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReturnType(AttachmentReturnType value)
/*     */   {
/*  91 */     this.returnType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getURI()
/*     */   {
/* 103 */     return this.uri;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setURI(String value)
/*     */   {
/* 115 */     this.uri = value;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/ResponseAttachment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */