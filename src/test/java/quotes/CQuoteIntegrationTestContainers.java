package quotes;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = CQuoteIntegrationTestContainers.Initializer.class)
@EnableConfigurationProperties
public class CQuoteIntegrationTestContainers extends CQuoteIntegrationTest {
    @ClassRule
    public static GenericContainer cassandra =
            new GenericContainer("cassandra:3")
                    .withExposedPorts(9042);

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "cassandra.host=" + cassandra.getContainerIpAddress(),
                    "cassandra.port=" + cassandra.getMappedPort(9042))
                    .applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}
