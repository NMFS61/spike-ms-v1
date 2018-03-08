package nmfs.ms.config;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"nmfs.ms"})
public class AppConfig {
//    @Bean
//    public DefaultCamelContext defaultCamelContext() throws Exception {
//        DefaultCamelContext context = camel().context();
//        context.addComponent("ibmmq", ibmMqJmsComponent());
//        return context;
//    }
    @Bean
    public CamelContext camelContext()
    {
        CamelContext ctx = new DefaultCamelContext();
        try {
            //ctx.addRoutes(routeBuilder);
            //ctx.addRoutes(routeBuilder2);
            // ctx.addRoutes(routeBuilder3);
           // ctx.start();

         }
         catch (Exception ex) {
                            System.out.println(this.getClass().toString()+ex.getMessage());
            }
            return ctx;
    }
}
