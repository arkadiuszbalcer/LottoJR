package pl.lotto.domain.numbergenerator;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerator implements RandomNumberGenerable {
    private final int LOWER_BAND = 1;
    private final int UPPER_BAND = 99;

    private final int RANDOM_NUMBER_BAND = (UPPER_BAND - LOWER_BAND) + 1;

    public Set<Integer> generateSixRandomNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();
        while (isAmountOfNumberLowerThanSix(winningNumbers)){
        int randomNumber = generateRandom();
        winningNumbers.add(randomNumber);
    }
    return  winningNumbers;
}

    private boolean isAmountOfNumberLowerThanSix(Set<Integer> winningNumbers){
return winningNumbers.size() <6;
    }

    private int generateRandom(){
        Random random = new SecureRandom();
        return random.nextInt(RANDOM_NUMBER_BAND) + 1;

    }
}
