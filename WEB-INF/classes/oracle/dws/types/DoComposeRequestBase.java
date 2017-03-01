/*     */ package oracle.dws.types;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlSeeAlso;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="doComposeRequestBase", propOrder={"timeoutMillis", "userId", "password", "properties"})
/*     */ @XmlSeeAlso({DoCallIDSRequest.class})
/*     */ public abstract class DoComposeRequestBase
/*     */ {
/*     */   @XmlElement(defaultValue="30000")
/*     */   protected Integer timeoutMillis;
/*     */   @XmlElement(name="UserId", namespace="oracle/documaker/schema/common")
/*     */   protected String userId;
/*     */   @XmlElement(name="Password", namespace="oracle/documaker/schema/common")
/*     */   protected String password;
/*     */   @XmlElement(name="Properties")
/*     */   protected Properties properties;
/*     */   @XmlAttribute(required=true)
/*     */   protected String schemaVersion;
/*     */   
/*     */   public Integer getTimeoutMillis()
/*     */   {
/*  67 */     return this.timeoutMillis;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTimeoutMillis(Integer value)
/*     */   {
/*  79 */     this.timeoutMillis = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUserId()
/*     */   {
/*  91 */     return this.userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUserId(String value)
/*     */   {
/* 103 */     this.userId = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPassword()
/*     */   {
/* 115 */     return this.password;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPassword(String value)
/*     */   {
/* 127 */     this.password = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Properties getProperties()
/*     */   {
/* 139 */     return this.properties;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setProperties(Properties value)
/*     */   {
/* 151 */     this.properties = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSchemaVersion()
/*     */   {
/* 163 */     return this.schemaVersion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSchemaVersion(String value)
/*     */   {
/* 175 */     this.schemaVersion = value;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/DoComposeRequestBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */