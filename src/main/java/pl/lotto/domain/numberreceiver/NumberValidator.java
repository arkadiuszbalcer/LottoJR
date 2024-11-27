package pl.lotto.domain.numberreceiver;

import java.util.Set;

class NumberValidator {
    private  static final int MAX_NUMBERS_FROM_USER = 6;
    private static final int MINIMAL_NUMBERS_FROM_USER = 1;
    private static final int MAXIMAL_NUMBERS_FROM_USER = 99;

    boolean areAllNumberInRange(Set<Integer> numbersFromUser) {
        return numbersFromUser.stream()
                .filter(number -> number >= MINIMAL_NUMBERS_FROM_USER)
                .filter(number -> number <= MAXIMAL_NUMBERS_FROM_USER)
                .count() == MAX_NUMBERS_FROM_USER;
    }
}

