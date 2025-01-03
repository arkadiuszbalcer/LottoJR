package pl.lotto.domain.numbergenerator;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import pl.lotto.domain.numberreceiver.NumberReceiverFacade;

import java.time.LocalDateTime;
import java.util.Optional;


@Configuration
public class NumberGeneratorConfiguration {

    @Bean
    WinningNumbersGeneratorFacade winningNumbersGeneratorFacade( WinningNumbersRepository winningNumbersRepository, NumberReceiverFacade numberReceiverFacade,RandomNumberGenerable randomNumberGenerator, WinningNumbersGeneratorFacadeConfigurationProperties properties) {
        WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

        return new WinningNumbersGeneratorFacade(randomNumberGenerator, winningNumberValidator, winningNumbersRepository,numberReceiverFacade, properties);
    }


    WinningNumbersGeneratorFacade createForTest( WinningNumbersRepository winningNumbersRepository, NumberReceiverFacade numberReceiverFacade,RandomNumberGenerable randomNumberGenerator) {
    WinningNumbersGeneratorFacadeConfigurationProperties properties = WinningNumbersGeneratorFacadeConfigurationProperties.builder()
            .upperBand(99)
            .lowerBand(1)
            .count(6)
            .build();
    return winningNumbersGeneratorFacade( winningNumbersRepository,numberReceiverFacade,randomNumberGenerator, properties);
    }

}