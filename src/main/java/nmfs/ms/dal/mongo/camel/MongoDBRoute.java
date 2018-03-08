package nmfs.ms.dal.mongo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
public class MongoDBRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:mongoSearchOne").to("mongodb:myDb?database=flights&collection=tickets&operation=findOneByQuery");
        from("direct:mongofindAll")
                .to("mongodb:myDb?database=flights&collection=tickets&operation=findAll");


    }
}