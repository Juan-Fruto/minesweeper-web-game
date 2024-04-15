package org.ici.backend.random;

public class LinearCongruentialGenerator implements IRandomNumberMatrix {

    private long seed;
    private final long a = 1664525;
    private final long c = 1013904223;
    private final long m = (long) Math.pow(2, 32);

    public LinearCongruentialGenerator() {
        this.seed = System.currentTimeMillis();
    }

    public int generate(int maxValue) {
        seed = (a * seed + c) % m;
        return (int) (seed % (maxValue + 1));
    }
}
