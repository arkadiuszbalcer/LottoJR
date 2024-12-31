package pl.lotto.infrastracute.numbergenerator.scheduler;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lotto.domain.numbergenerator.WinningNumbersGeneratorFacade;
import pl.lotto.domain.numbergenerator.dto.WinningNumbersDto;

@Component
@AllArgsConstructor
@Log4j2
public class WinningNumberScheduler {
    private final WinningNumbersGeneratorFacade winningNumbersGeneratorFacade;
    @Scheduled(cron = "${lotto.number-generator.lotteryRunOccurence}")

    public void generateWinningNumbers(){
     WinningNumbersDto winningNumbersDto = winningNumbersGeneratorFacade.generateWinningNumbers();
        log.info(winningNumbersDto.getWinningNumbers());
        log.info(winningNumbersDto.getDate());

    }
}
