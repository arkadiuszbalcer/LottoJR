package pl.lotto.domain.numbergenerator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
@Repository
@Component
public interface WinningNumbersRepository {

    Optional<WinningNumbers>findNumbersByDate(LocalDateTime date);
    boolean existsByDate(LocalDateTime nextDrawdate);
    WinningNumbers save(WinningNumbers winningNumbers);
}
