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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"queuefactoryClass", "marshallerClass", "jmsInitialContextFactory", "jmsProviderURL", "jmsSecurityPrincipal", "jmsSecurityCredentials", "jmsQcfName", "jmsInputqueueConnectstring", "jmsOutputqueueConnectstring", "jmsEnvProperty"})
/*     */ @XmlRootElement(name="JMS")
/*     */ public class JMS
/*     */ {
/*     */   @XmlElement(name="queuefactory.class", required=true)
/*     */   protected String queuefactoryClass;
/*     */   @XmlElement(name="marshaller.class", required=true)
/*     */   protected MarshallerClass marshallerClass;
/*     */   @XmlElement(name="jms.initial.context.factory", required=true, defaultValue="weblogic.jndi.WLInitialContextFactory")
/*     */   protected String jmsInitialContextFactory;
/*     */   @XmlElement(name="jms.provider.URL", required=true, defaultValue="t3://localhost:7001")
/*     */   protected String jmsProviderURL;
/*     */   @XmlElement(name="jms.security.principal", defaultValue="")
/*     */   protected String jmsSecurityPrincipal;
/*     */   @XmlElement(name="jms.security.credentials", defaultValue="")
/*     */   protected String jmsSecurityCredentials;
/*     */   @XmlElement(name="jms.qcf.name", required=true, defaultValue="qcf")
/*     */   protected String jmsQcfName;
/*     */   @XmlElement(name="jms.inputqueue.connectstring", required=true, defaultValue="resultq")
/*     */   protected String jmsInputqueueConnectstring;
/*     */   @XmlElement(name="jms.outputqueue.connectstring", required=true, defaultValue="requestq")
/*     */   protected String jmsOutputqueueConnectstring;
/*     */   @XmlElement(name="jms.env.Property")
/*     */   protected List<Property> jmsEnvProperty;
/*     */   
/*     */   public String getQueuefactoryClass()
/*     */   {
/*  87 */     return this.queuefactoryClass;
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
/*  99 */     this.queuefactoryClass = value;
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
/* 111 */     return this.marshallerClass;
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
/* 123 */     this.marshallerClass = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getJmsInitialContextFactory()
/*     */   {
/* 135 */     return this.jmsInitialContextFactory;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJmsInitialContextFactory(String value)
/*     */   {
/* 147 */     this.jmsInitialContextFactory = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getJmsProviderURL()
/*     */   {
/* 159 */     return this.jmsProviderURL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJmsProviderURL(String value)
/*     */   {
/* 171 */     this.jmsProviderURL = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getJmsSecurityPrincipal()
/*     */   {
/* 183 */     return this.jmsSecurityPrincipal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJmsSecurityPrincipal(String value)
/*     */   {
/* 195 */     this.jmsSecurityPrincipal = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getJmsSecurityCredentials()
/*     */   {
/* 207 */     return this.jmsSecurityCredentials;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJmsSecurityCredentials(String value)
/*     */   {
/* 219 */     this.jmsSecurityCredentials = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getJmsQcfName()
/*     */   {
/* 231 */     return this.jmsQcfName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJmsQcfName(String value)
/*     */   {
/* 243 */     this.jmsQcfName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getJmsInputqueueConnectstring()
/*     */   {
/* 255 */     return this.jmsInputqueueConnectstring;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJmsInputqueueConnectstring(String value)
/*     */   {
/* 267 */     this.jmsInputqueueConnectstring = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getJmsOutputqueueConnectstring()
/*     */   {
/* 279 */     return this.jmsOutputqueueConnectstring;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setJmsOutputqueueConnectstring(String value)
/*     */   {
/* 291 */     this.jmsOutputqueueConnectstring = value;
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
/*     */   public List<Property> getJmsEnvProperty()
/*     */   {
/* 317 */     if (this.jmsEnvProperty == null) {
/* 318 */       this.jmsEnvProperty = new ArrayList();
/*     */     }
/* 320 */     return this.jmsEnvProperty;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/JMS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */