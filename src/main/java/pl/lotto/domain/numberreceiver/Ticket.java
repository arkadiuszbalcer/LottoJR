package pl.lotto.domain.numberreceiver;

import java.time.LocalDateTime;
import java.util.Set;

record Ticket(String ticketId, java.time.LocalDateTime drawDate, Set<Integer> numbersFromUser) {
}
