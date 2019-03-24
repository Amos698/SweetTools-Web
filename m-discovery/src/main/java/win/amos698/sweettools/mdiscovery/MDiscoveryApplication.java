package win.amos698.sweettools.mdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MDiscoveryApplication.class, args);
    }

}
