package pl.lotto.domain.numbergenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Component
public class WiningNumberRepositoryImplementation  implements  WinningNumbersRepository{



    @Override
    public Optional<WinningNumbers> findNumbersByDate(LocalDateTime date) {
        return Optional.empty();
    }

    @Override
    public boolean existsByDate(LocalDateTime nextDrawdate) {
        return false;
    }

    @Override
    public WinningNumbers save(WinningNumbers winningNumbers) {
        return null;
    }
}

