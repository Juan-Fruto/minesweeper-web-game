package org.ici.backend.random;

import java.util.List;
import java.util.Random;

public class LinearfeedbackShiftRegister implements IRandomNumberMatrix {

    private int state;
    private static final int TAP_POSITION = 4;
    private static final int MAX_BITS = 16;

    public LinearfeedbackShiftRegister() {
        Random random = new Random();
        state = random.nextInt((int) Math.pow(2, MAX_BITS));
    }

    @Override
    public int generate(int maxValue) {
        state = ((state >> 1) ^ (-(state & 1) & (1 << (TAP_POSITION - 1))));

        return Math.abs(state) % (maxValue + 1);
    }
}
