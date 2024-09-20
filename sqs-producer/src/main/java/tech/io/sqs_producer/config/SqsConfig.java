package tech.io.sqs_producer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.SqsAsyncClientBuilder;

import java.net.URI;
import java.util.Objects;

@Configuration
public class SqsConfig {

    @Value("${stage.name}")
    private String env;

    @Value("${infra.localstack.url}")
    private String localStackUrl;

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        SqsAsyncClientBuilder builder = SqsAsyncClient.builder();

        if (Objects.equals(env, "dev")) {
            builder.endpointOverride(URI.create(localStackUrl));
        }

        return builder.build();
    }
}
