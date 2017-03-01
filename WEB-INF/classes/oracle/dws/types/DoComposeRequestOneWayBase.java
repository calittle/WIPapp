/*    */ package oracle.dws.types;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlAttribute;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="doComposeRequestOneWayBase", propOrder={"properties"})
/*    */ @XmlSeeAlso({DoCallIDSOneWayRequest.class})
/*    */ public abstract class DoComposeRequestOneWayBase
/*    */ {
/*    */   @XmlElement(name="Properties")
/*    */   protected Properties properties;
/*    */   @XmlAttribute(required=true)
/*    */   protected String schemaVersion;
/*    */   
/*    */   public Properties getProperties()
/*    */   {
/* 55 */     return this.properties;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setProperties(Properties value)
/*    */   {
/* 67 */     this.properties = value;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String getSchemaVersion()
/*    */   {
/* 79 */     return this.schemaVersion;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setSchemaVersion(String value)
/*    */   {
/* 91 */     this.schemaVersion = value;
/*    */   }
/*    */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/DoComposeRequestOneWayBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */