package com.hand.hcf.app.gof;

import com.hand.hcf.app.gof.config.BaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(BaseProperties.class)
public class GofApplication {

    public static void main(String[] args) {
        SpringApplication.run(GofApplication.class, args);
    }

}
