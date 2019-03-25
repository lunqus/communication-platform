package com.protocols.communicationplatform.config;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import sun.plugin2.message.Message;

import javax.servlet.ServletRegistration;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);

    return new ServletRegistrationBean(servlet, "/soapWS/*");
    }

    @Bean
    public XsdSchema customerSchema() {
        return new SimpleXsdSchema(new ClassPathResource("users.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema customerSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(customerSchema);
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("UserServicePort");
        definition.setTargetNamespace("http://protocols.com/communication-platforms");

        return definition;
    }
}
