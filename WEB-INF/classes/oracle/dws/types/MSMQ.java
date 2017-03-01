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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"queuefactoryClass", "marshallerClass", "msmqServerName", "msmqInputqueueName", "msmqOutputqueueName", "msmqTimeout", "msmqExpiry", "msmqProperty"})
/*     */ @XmlRootElement(name="MSMQ")
/*     */ public class MSMQ
/*     */ {
/*     */   @XmlElement(name="queuefactory.class", required=true)
/*     */   protected String queuefactoryClass;
/*     */   @XmlElement(name="marshaller.class", required=true)
/*     */   protected MarshallerClass marshallerClass;
/*     */   @XmlElement(name="msmq.server.name", defaultValue="localhost")
/*     */   protected String msmqServerName;
/*     */   @XmlElement(name="msmq.inputqueue.name", required=true, defaultValue="DIRECT=OS:localhost\\PRIVATE$\\RESULTQ")
/*     */   protected String msmqInputqueueName;
/*     */   @XmlElement(name="msmq.outputqueue.name", required=true, defaultValue="DIRECT=OS:localhost\\PRIVATE$\\REQUESTQ")
/*     */   protected String msmqOutputqueueName;
/*     */   @XmlElement(name="msmq.timeout", defaultValue="30000")
/*     */   protected String msmqTimeout;
/*     */   @XmlElement(name="msmq.expiry", defaultValue="1800000")
/*     */   protected String msmqExpiry;
/*     */   @XmlElement(name="msmq.Property")
/*     */   protected List<Property> msmqProperty;
/*     */   
/*     */   public String getQueuefactoryClass()
/*     */   {
/*  79 */     return this.queuefactoryClass;
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
/*  91 */     this.queuefactoryClass = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MarshallerClass getMarshallerClass()
/*     */   {
/* 103 */     return this.marshallerClass;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMarshallerClass(MarshallerClass value)
/*     */   {
/* 115 */     this.marshallerClass = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsmqServerName()
/*     */   {
/* 127 */     return this.msmqServerName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsmqServerName(String value)
/*     */   {
/* 139 */     this.msmqServerName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsmqInputqueueName()
/*     */   {
/* 151 */     return this.msmqInputqueueName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsmqInputqueueName(String value)
/*     */   {
/* 163 */     this.msmqInputqueueName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsmqOutputqueueName()
/*     */   {
/* 175 */     return this.msmqOutputqueueName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsmqOutputqueueName(String value)
/*     */   {
/* 187 */     this.msmqOutputqueueName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsmqTimeout()
/*     */   {
/* 199 */     return this.msmqTimeout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsmqTimeout(String value)
/*     */   {
/* 211 */     this.msmqTimeout = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMsmqExpiry()
/*     */   {
/* 223 */     return this.msmqExpiry;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMsmqExpiry(String value)
/*     */   {
/* 235 */     this.msmqExpiry = value;
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
/*     */   public List<Property> getMsmqProperty()
/*     */   {
/* 261 */     if (this.msmqProperty == null) {
/* 262 */       this.msmqProperty = new ArrayList();
/*     */     }
/* 264 */     return this.msmqProperty;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/MSMQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */