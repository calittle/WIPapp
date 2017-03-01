/*     */ package oracle.dws.types;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
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
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"queuefactoryClass", "marshallerClass", "httpUrl", "httpReusePorts", "httpPutmessageTries", "httpProperty"})
/*     */ @XmlRootElement(name="HTTP")
/*     */ public class HTTP
/*     */ {
/*     */   @XmlElement(name="queuefactory.class", required=true)
/*     */   protected String queuefactoryClass;
/*     */   @XmlElement(name="marshaller.class", required=true)
/*     */   protected String marshallerClass;
/*     */   @XmlElement(name="http.url", required=true, defaultValue="http://localhost:49152")
/*     */   protected String httpUrl;
/*     */   @XmlElement(name="http.reuse.ports", defaultValue="true")
/*     */   protected String httpReusePorts;
/*     */   @XmlElement(name="http.putmessage.tries", defaultValue="3")
/*     */   protected String httpPutmessageTries;
/*     */   @XmlElement(name="http.Property")
/*     */   protected List<Property> httpProperty;
/*     */   
/*     */   public String getQueuefactoryClass()
/*     */   {
/*  71 */     return this.queuefactoryClass;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setQueuefactoryClass(String value)
/*     */   {
/*  83 */     this.queuefactoryClass = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMarshallerClass()
/*     */   {
/*  95 */     return this.marshallerClass;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMarshallerClass(String value)
/*     */   {
/* 107 */     this.marshallerClass = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getHttpUrl()
/*     */   {
/* 119 */     return this.httpUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHttpUrl(String value)
/*     */   {
/* 131 */     this.httpUrl = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getHttpReusePorts()
/*     */   {
/* 143 */     return this.httpReusePorts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHttpReusePorts(String value)
/*     */   {
/* 155 */     this.httpReusePorts = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getHttpPutmessageTries()
/*     */   {
/* 167 */     return this.httpPutmessageTries;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHttpPutmessageTries(String value)
/*     */   {
/* 179 */     this.httpPutmessageTries = value;
/*     */   }
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
/*     */   public List<Property> getHttpProperty()
/*     */   {
/* 205 */     if (this.httpProperty == null) {
/* 206 */       this.httpProperty = new ArrayList();
/*     */     }
/* 208 */     return this.httpProperty;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/HTTP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */