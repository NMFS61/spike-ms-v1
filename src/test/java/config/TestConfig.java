package config;

import java.util.stream.Stream;

public class TestConfig {
    // *** Embedded Mongo
    public static int MONGO_PORT=9091;


    // *** Embedded Kafka Config
    public static int KAFKA_PORT=9091;
    public enum Topic {
        INITIATE_PAYMENT_REQUEST("nmfs.request.in"),
        PAYMENT_AUTHORISE_REQUEST("nmfs.request.out"),
        PAYMENT_AUTHORISED_RESPONSE("nmfs.response.in"),
        PAYMENT_BOOKING_REQUEST("nmfs.response.out");

                private final String endPoint;
                public String endPoint() {
                    return endPoint;
                }
                Topic(final String endPoint) {
                    this.endPoint = endPoint;
                }

                public static String[] getTopicNames() {
                       return Stream.of(Topic.values()).map(Topic::endPoint).toArray(String[]::new);
                }
        }


    }
