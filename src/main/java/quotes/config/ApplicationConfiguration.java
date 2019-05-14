package quotes.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Value("${cassandra.host}")
    private String host;

    @Value("${cassandra.port}")
    private int port;

    @Bean
    public Session createSession() {
        return createSession(host, port);
    }

    public static Session createSession(String ip, int port) {
        Cluster cluster;

        cluster = Cluster.builder()
                .addContactPoint(ip)
                .withPort(port)
                .build();

        Session session = cluster.connect();

        session.execute("CREATE KEYSPACE IF NOT EXISTS quote_keyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 }");
        session.execute("USE quote_keyspace;");
        session.execute("DROP TABLE IF EXISTS quotes");
        session.execute("CREATE TABLE quotes(id UUID PRIMARY KEY, text text, author text);");

        return session;
    }
}