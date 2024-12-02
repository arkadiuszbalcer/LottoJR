package pl.lotto.domain.numbergenerator;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.Builder;
@Builder
public record WinningNumbers(String id,
                             Set<Integer> winningNumbers,
                             LocalDateTime date) {

}
