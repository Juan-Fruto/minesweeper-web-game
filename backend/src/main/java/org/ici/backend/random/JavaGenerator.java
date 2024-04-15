package org.ici.backend.random;

import java.util.Random;

public class JavaGenerator implements IRandomNumberMatrix {
    private Random random;
    public JavaGenerator(){
        this.random = new Random();
    }

    @Override
    public int generate(int maxValue) {
        return random.nextInt(maxValue + 1);
    }
}
