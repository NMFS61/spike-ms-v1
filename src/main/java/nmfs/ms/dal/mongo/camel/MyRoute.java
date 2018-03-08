package nmfs.ms.dal.mongo.camel;
 
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
 
@Component
public class MyRoute extends RouteBuilder {
 
    @Override
    public void configure() throws Exception {
        //from("timer:foo").to("log:bar");
        from("file:/Users/borauzun/Documents/Test/camel/In?noop=true").to("file:/Users/borauzun/Documents/Test/camel/Out?fileName=Out.txt");
    }
}