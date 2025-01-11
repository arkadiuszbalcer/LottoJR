package http.numbergenerator;

import org.springframework.web.client.RestTemplate;
import pl.lotto.domain.numbergenerator.RandomNumberGenerable;
import pl.lotto.infrastracute.numbergenerator.http.RandomGeneratorClientConfig;

public class RandomNumberGeneratorRestTemplateIntegrationTestConfig extends RandomGeneratorClientConfig {
    public RandomNumberGenerable remoteNumberGeneratorClient(int port, int connectionTimeout, int readTimeout){
        RestTemplate restTemplate = restTemplate(connectionTimeout,readTimeout,restTemplateResponseErrorHandler());
        return remoteNumberGeneratorClient(restTemplate, "http//localhost", port);
    }

}
