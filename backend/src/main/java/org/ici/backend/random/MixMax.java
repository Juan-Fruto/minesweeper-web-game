package org.ici.backend.random;

public class MixMax implements IRandomNumberMatrix {
    private long state;

    public MixMax() {
        this.state = System.currentTimeMillis();
    }

    @Override
    public int generate(int maxValue) {
        state ^= (state << 13);
        state ^= (state >>> 17);
        state ^= (state << 5);

        int randomNumber = (int) (Math.abs(state) % (long) (maxValue + 1));

        return randomNumber;
    }
}
