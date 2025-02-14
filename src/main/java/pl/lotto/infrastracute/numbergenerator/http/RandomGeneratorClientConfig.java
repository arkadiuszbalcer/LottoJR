package pl.lotto.infrastracute.numbergenerator.http;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.lotto.domain.numbergenerator.RandomNumberGenerable;

@Configuration
public class RandomGeneratorClientConfig {

    @Bean
    public RestTemplateErrorHandle restTemplateResponseErrorHandler() {
        return new RestTemplateErrorHandle();
    }

    @Bean
    public RestTemplate restTemplate(@Value("${lotto.number-generator.http.client.config.connectionTimeout:1000}") long connectionTimeout,
                                     @Value("${lotto.number-generator.http.client.config.readTimeout:1000}") long readTimeout,
                                     RestTemplateErrorHandle restTemplateErrorHandle) {
        return new RestTemplateBuilder()
                .errorHandler(restTemplateErrorHandle)
                .setConnectTimeout(Duration.ofMillis(5000))
                .setReadTimeout(Duration.ofMillis(5000))
                .build();
    }

    @Bean
    public RandomNumberGenerable remoteNumberGeneratorClient(RestTemplate restTemplate,
                                                             @Value("${lotto.number-generator.http.client.config.uri}") String uri,
                                                             @Value("${lotto.number-generator.http.client.config.port}") int port) {
        return new RandomNumberGeneratorRestTemplate(restTemplate, uri, port);
    }
}