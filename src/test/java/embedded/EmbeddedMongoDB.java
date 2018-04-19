package embedded;

import com.mongodb.Mongo;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

import java.io.IOException;

import static config.TestConfig.MONGO_PORT;

public class EmbeddedMongoDB {

    private MongodExecutable mongodExe;
    private Mongo mongo;
    private int mongoPort;

    // Default constructor , default port from config
    public EmbeddedMongoDB() throws IOException {
        this.mongoPort = MONGO_PORT;
        this.bootstrapMongo();
    }
    // in case multiple instance or different port is required
    public EmbeddedMongoDB(final int mongoPort) throws IOException {
        this.mongoPort = mongoPort;
        this.bootstrapMongo();
    }


    private void bootstrapMongo() throws IOException {
        MongodStarter runtime = MongodStarter.getDefaultInstance();
        IMongodConfig mongodConfig = new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(mongoPort, Network.localhostIsIPv6()))
                .build();

        mongodExe = runtime.prepare(mongodConfig);
        mongodExe.start();
    }
}



