package lotto.model;

import lotto.constants.Constants;
import lotto.constants.Message;

public class Validator {
    public void validateCost(String cost, Integer lottoPrice) {
        if (notNumeric(cost)) {
            throw new IllegalArgumentException();
        }
        if (notThousands(cost, lottoPrice)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean notThousands(String cost, Integer lottoPrice) {
        return (Integer.parseInt(cost) % lottoPrice != 0);
    }

    public void validateAnswer(String number, Integer start, Integer end) {
        if (notNumeric(number)) {
            throw new IllegalArgumentException();
        }
        if (outOfRange(number, start, end)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateBonus(String number, Integer start, Integer end) {
        if (notNumeric(number)) {
            throw new IllegalArgumentException();
        }
        if (outOfRange(number, start, end)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean notNumeric(String number) {
        return !number.matches(Message.REGULAR_NUMBER);
    }

    private boolean outOfRange(String number, Integer start, Integer end) {
        Integer num = Integer.parseInt(number);

        return (num < start || end < num);
    }
}
