package pl.lotto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import pl.lotto.domain.AdjustableClock;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

@Configuration
@Profile("Integration")
public class IntegrationConfiguration {
    @Bean
    @Primary
    AdjustableClock clock(){
        return AdjustableClock.ofLocalDateAndLocalTime(LocalDate.of(2022, 11, 16), LocalTime.of(10, 0), ZoneId.systemDefault());
    }
}
