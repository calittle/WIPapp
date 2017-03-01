/*    */ package oracle.dws.types;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
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
/*    */ @XmlType(name="", propOrder={"msgvars", "attachment"})
/*    */ @XmlRootElement(name="DSIMSG")
/*    */ public class DSIMSG
/*    */ {
/*    */   @XmlElement(name="MSGVARS", required=true)
/*    */   protected MSGVARS msgvars;
/*    */   @XmlElement(name="Attachment", namespace="oracle/documaker/schema/common")
/*    */   protected List<Attachment> attachment;
/*    */   
/*    */   public MSGVARS getMSGVARS()
/*    */   {
/* 55 */     return this.msgvars;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setMSGVARS(MSGVARS value)
/*    */   {
/* 67 */     this.msgvars = value;
/*    */   }
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
/*    */   public List<Attachment> getAttachment()
/*    */   {
/* 93 */     if (this.attachment == null) {
/* 94 */       this.attachment = new ArrayList();
/*    */     }
/* 96 */     return this.attachment;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/DSIMSG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */