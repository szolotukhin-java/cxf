package ua.in.sz.learn.cxfone;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.in.sz.learn.cxfone.ws.Hello;

import javax.xml.ws.BindingProvider;

/**
 * https://github.com/code-not-found/jaxws-cxf/blob/master/jaxws-cxf-server-basic-authentication-server/src/test/java/com/codenotfound/soap/http/cxf/HelloWorldClientImplMock.java
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CxfOneApplicationTests {

    @Test
    public void contextLoads() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(Hello.class);
        jaxWsProxyFactoryBean.setAddress("http://localhost:8080/services/Hello");

        Hello helloWorldClientProxy = (Hello) jaxWsProxyFactoryBean.create();

//        BindingProvider bindingProvider = (BindingProvider) helloWorldClientProxy;
//        bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "userName");
//        bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "password");

        String greeting = helloWorldClientProxy.sayHello("person");
        log.info("Response: {}", greeting);
    }
}

