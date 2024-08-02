package pl.servicealerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ServiceAlertsApi {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAlertsApi.class, args);

        System.out.println("--------api run complete ----  -------------- [               ] http://localhost:8888/ui  ");
    }

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
}
