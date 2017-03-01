/*    */ package oracle.dws.types;
/*    */ 
/*    */ import javax.activation.DataHandler;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlMimeType;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="Content", namespace="oracle/documaker/schema/common", propOrder={"uri", "binary"})
/*    */ public class Content
/*    */ {
/*    */   @XmlElement(name="URI", defaultValue="file:///temp/test.pdf")
/*    */   protected String uri;
/*    */   @XmlElement(name="Binary")
/*    */   @XmlMimeType("application/octet-stream")
/*    */   protected DataHandler binary;
/*    */   
/*    */   public String getURI()
/*    */   {
/* 54 */     return this.uri;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setURI(String value)
/*    */   {
/* 66 */     this.uri = value;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public DataHandler getBinary()
/*    */   {
/* 78 */     return this.binary;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setBinary(DataHandler value)
/*    */   {
/* 90 */     this.binary = value;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/Content.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */