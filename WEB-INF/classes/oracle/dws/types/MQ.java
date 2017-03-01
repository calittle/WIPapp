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
/*     */ @XmlType(name="", propOrder={"queuefactoryClass", "marshallerClass", "mqQueueManager", "mqTcpipHost", "mqTcpipPort", "mqInputqueueName", "mqOutputqueueName", "mqQueueChannel", "mqOutputqueueExpiry", "mqseriesExceptionLogging", "mqseriesTracing", "mqseriesTracingLog", "mqCcdtUrl", "mqSslCipherspec", "mqSslPeername", "mqSslSocketFactoryClass", "mqSslProtocol", "mqSslKeystore", "mqSslKeystoreType", "mqSslKeystoreManagerType", "mqSslKeystorePwd", "mqSslTruststore", "mqSslTruststoreType", "mqSslTruststoreManagerType", "mqSslTruststorePwd", "mqSslDebug", "mqProperty"})
/*     */ @XmlRootElement(name="MQ")
/*     */ public class MQ
/*     */ {
/*     */   @XmlElement(name="queuefactory.class", required=true)
/*     */   protected String queuefactoryClass;
/*     */   @XmlElement(name="marshaller.class", required=true)
/*     */   protected MarshallerClass marshallerClass;
/*     */   @XmlElement(name="mq.queue.manager", required=true, defaultValue="queue_manager")
/*     */   protected String mqQueueManager;
/*     */   @XmlElement(name="mq.tcpip.host", defaultValue="127.0.0.1")
/*     */   protected String mqTcpipHost;
/*     */   @XmlElement(name="mq.tcpip.port", defaultValue="1414")
/*     */   protected String mqTcpipPort;
/*     */   @XmlElement(name="mq.inputqueue.name", required=true, defaultValue="RESULTQ")
/*     */   protected String mqInputqueueName;
/*     */   @XmlElement(name="mq.outputqueue.name", required=true, defaultValue="REQUESTQ")
/*     */   protected String mqOutputqueueName;
/*     */   @XmlElement(name="mq.queue.channel", defaultValue="SYSTEM.DEF.SVRCONN")
/*     */   protected String mqQueueChannel;
/*     */   @XmlElement(name="mq.outputqueue.expiry", defaultValue="")
/*     */   protected String mqOutputqueueExpiry;
/*     */   @XmlElement(name="mqseries.exception.logging", defaultValue="N")
/*     */   protected String mqseriesExceptionLogging;
/*     */   @XmlElement(name="mqseries.tracing", defaultValue="1")
/*     */   protected Integer mqseriesTracing;
/*     */   @XmlElement(name="mqseries.tracing.log", defaultValue="mqseries.log")
/*     */   protected String mqseriesTracingLog;
/*     */   @XmlElement(name="mq.ccdt.url", defaultValue="file:///c:/mq/ccdt/AMQCLCHL.TAB")
/*     */   protected String mqCcdtUrl;
/*     */   @XmlElement(name="mq.ssl.cipherspec")
/*     */   protected MQSSLCipherspec mqSslCipherspec;
/*     */   @XmlElement(name="mq.ssl.peername")
/*     */   protected String mqSslPeername;
/*     */   @XmlElement(name="mq.ssl.socketFactory.class", defaultValue="com.docucorp.messaging.mqseries.DSIMQSSLSocketFactory")
/*     */   protected String mqSslSocketFactoryClass;
/*     */   @XmlElement(name="mq.ssl.protocol", defaultValue="SSLv3")
/*     */   protected String mqSslProtocol;
/*     */   @XmlElement(name="mq.ssl.keystore")
/*     */   protected String mqSslKeystore;
/*     */   @XmlElement(name="mq.ssl.keystore.type", defaultValue="JKS")
/*     */   protected String mqSslKeystoreType;
/*     */   @XmlElement(name="mq.ssl.keystore.manager.type", defaultValue="SunX509")
/*     */   protected String mqSslKeystoreManagerType;
/*     */   @XmlElement(name="mq.ssl.keystore.pwd")
/*     */   protected String mqSslKeystorePwd;
/*     */   @XmlElement(name="mq.ssl.truststore")
/*     */   protected String mqSslTruststore;
/*     */   @XmlElement(name="mq.ssl.truststore.type", defaultValue="JKS")
/*     */   protected String mqSslTruststoreType;
/*     */   @XmlElement(name="mq.ssl.truststore.manager.type", defaultValue="SunX509")
/*     */   protected String mqSslTruststoreManagerType;
/*     */   @XmlElement(name="mq.ssl.truststore.pwd")
/*     */   protected String mqSslTruststorePwd;
/*     */   @XmlElement(name="mq.ssl.debug", defaultValue="true")
/*     */   protected String mqSslDebug;
/*     */   @XmlElement(name="mq.Property")
/*     */   protected List<Property> mqProperty;
/*     */   
/*     */   public String getQueuefactoryClass()
/*     */   {
/* 155 */     return this.queuefactoryClass;
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
/* 167 */     this.queuefactoryClass = value;
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
/* 179 */     return this.marshallerClass;
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
/* 191 */     this.marshallerClass = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqQueueManager()
/*     */   {
/* 203 */     return this.mqQueueManager;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqQueueManager(String value)
/*     */   {
/* 215 */     this.mqQueueManager = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqTcpipHost()
/*     */   {
/* 227 */     return this.mqTcpipHost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqTcpipHost(String value)
/*     */   {
/* 239 */     this.mqTcpipHost = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqTcpipPort()
/*     */   {
/* 251 */     return this.mqTcpipPort;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqTcpipPort(String value)
/*     */   {
/* 263 */     this.mqTcpipPort = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqInputqueueName()
/*     */   {
/* 275 */     return this.mqInputqueueName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqInputqueueName(String value)
/*     */   {
/* 287 */     this.mqInputqueueName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqOutputqueueName()
/*     */   {
/* 299 */     return this.mqOutputqueueName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqOutputqueueName(String value)
/*     */   {
/* 311 */     this.mqOutputqueueName = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqQueueChannel()
/*     */   {
/* 323 */     return this.mqQueueChannel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqQueueChannel(String value)
/*     */   {
/* 335 */     this.mqQueueChannel = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqOutputqueueExpiry()
/*     */   {
/* 347 */     return this.mqOutputqueueExpiry;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqOutputqueueExpiry(String value)
/*     */   {
/* 359 */     this.mqOutputqueueExpiry = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqseriesExceptionLogging()
/*     */   {
/* 371 */     return this.mqseriesExceptionLogging;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqseriesExceptionLogging(String value)
/*     */   {
/* 383 */     this.mqseriesExceptionLogging = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getMqseriesTracing()
/*     */   {
/* 395 */     return this.mqseriesTracing;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqseriesTracing(Integer value)
/*     */   {
/* 407 */     this.mqseriesTracing = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqseriesTracingLog()
/*     */   {
/* 419 */     return this.mqseriesTracingLog;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqseriesTracingLog(String value)
/*     */   {
/* 431 */     this.mqseriesTracingLog = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqCcdtUrl()
/*     */   {
/* 443 */     return this.mqCcdtUrl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqCcdtUrl(String value)
/*     */   {
/* 455 */     this.mqCcdtUrl = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MQSSLCipherspec getMqSslCipherspec()
/*     */   {
/* 467 */     return this.mqSslCipherspec;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslCipherspec(MQSSLCipherspec value)
/*     */   {
/* 479 */     this.mqSslCipherspec = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslPeername()
/*     */   {
/* 491 */     return this.mqSslPeername;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslPeername(String value)
/*     */   {
/* 503 */     this.mqSslPeername = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslSocketFactoryClass()
/*     */   {
/* 515 */     return this.mqSslSocketFactoryClass;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslSocketFactoryClass(String value)
/*     */   {
/* 527 */     this.mqSslSocketFactoryClass = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslProtocol()
/*     */   {
/* 539 */     return this.mqSslProtocol;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslProtocol(String value)
/*     */   {
/* 551 */     this.mqSslProtocol = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslKeystore()
/*     */   {
/* 563 */     return this.mqSslKeystore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslKeystore(String value)
/*     */   {
/* 575 */     this.mqSslKeystore = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslKeystoreType()
/*     */   {
/* 587 */     return this.mqSslKeystoreType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslKeystoreType(String value)
/*     */   {
/* 599 */     this.mqSslKeystoreType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslKeystoreManagerType()
/*     */   {
/* 611 */     return this.mqSslKeystoreManagerType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslKeystoreManagerType(String value)
/*     */   {
/* 623 */     this.mqSslKeystoreManagerType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslKeystorePwd()
/*     */   {
/* 635 */     return this.mqSslKeystorePwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslKeystorePwd(String value)
/*     */   {
/* 647 */     this.mqSslKeystorePwd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslTruststore()
/*     */   {
/* 659 */     return this.mqSslTruststore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslTruststore(String value)
/*     */   {
/* 671 */     this.mqSslTruststore = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslTruststoreType()
/*     */   {
/* 683 */     return this.mqSslTruststoreType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslTruststoreType(String value)
/*     */   {
/* 695 */     this.mqSslTruststoreType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslTruststoreManagerType()
/*     */   {
/* 707 */     return this.mqSslTruststoreManagerType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslTruststoreManagerType(String value)
/*     */   {
/* 719 */     this.mqSslTruststoreManagerType = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslTruststorePwd()
/*     */   {
/* 731 */     return this.mqSslTruststorePwd;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslTruststorePwd(String value)
/*     */   {
/* 743 */     this.mqSslTruststorePwd = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMqSslDebug()
/*     */   {
/* 755 */     return this.mqSslDebug;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMqSslDebug(String value)
/*     */   {
/* 767 */     this.mqSslDebug = value;
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
/*     */   public List<Property> getMqProperty()
/*     */   {
/* 793 */     if (this.mqProperty == null) {
/* 794 */       this.mqProperty = new ArrayList();
/*     */     }
/* 796 */     return this.mqProperty;
/*     */   }
/*     */ }


/* Location:              /Volumes/Data/Users/calittle/Downloads/wipapp/wipapp_2016-12-23-1/WEB-INF/classes/!/oracle/dws/types/MQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */