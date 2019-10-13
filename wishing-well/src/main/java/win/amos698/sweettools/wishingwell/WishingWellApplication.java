package win.amos698.sweettools.wishingwell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaAuditing
public class WishingWellApplication {

    public static void main(String[] args) {
        SpringApplication.run(WishingWellApplication.class, args);
    }

}
