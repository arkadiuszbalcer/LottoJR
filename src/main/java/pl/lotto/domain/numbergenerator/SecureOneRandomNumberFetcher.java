package pl.lotto.domain.numbergenerator;



import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;
@Component
public class SecureOneRandomNumberFetcher implements OneRandomNumberFetcher{

    @Override
    public OneRandomNumberResponseDto retrieveOneRandomNumber(int lowerBand, int upperBand) {
        Random random = new SecureRandom();
        return OneRandomNumberResponseDto.builder()
                .number(random.nextInt((upperBand-lowerBand)+1))
                .build();
    }
}
