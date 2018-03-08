package nmfs.ms;

import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan({"nmfs.ms","nmfs.ms.rest","nmfs.ms.config"})
@ComponentScan("nmfs.ms")

public class MicroservicesApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MicroservicesApplication.class, args);
        ApplicationContext context = SpringApplication.run(MicroservicesApplication.class, args);
        //context.getBean(DefaultCamelContext.class);

        try {Thread.sleep(300 * 60000); // minutes
        }catch (Exception ex) {}
	}

//    @Bean
//    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory,
//                                       MongoMappingContext context) {
//
//        MappingMongoConverter converter =
//                new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
//
//        return mongoTemplate;
//
//    }
}


