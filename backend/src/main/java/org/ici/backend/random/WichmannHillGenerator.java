package org.ici.backend.random;

import java.util.Calendar;

public class WichmannHillGenerator implements IRandomNumberMatrix {
    private int seed1, seed2, seed3;

    public WichmannHillGenerator() {
        // Obtener una semilla inicial basada en la hora actual
        Calendar now = Calendar.getInstance();
        seed1 = now.get(Calendar.SECOND) + 1;
        seed2 = now.get(Calendar.MINUTE) + 1;
        seed3 = now.get(Calendar.HOUR_OF_DAY) + 1;


        if (seed1 == 0) seed1 = 1;
        if (seed2 == 0) seed2 = 1;
        if (seed3 == 0) seed3 = 1;
    }

    @Override
    public int generate(int maxValue) {
        seed1 = (171 * seed1) % 30269;
        seed2 = (172 * seed2) % 30307;
        seed3 = (170 * seed3) % 30323;

        double result = (double) seed1 / 30269 + (double) seed2 / 30307 + (double) seed3 / 30323;
        result = result - (int) result;
        return (int) (result * maxValue);
    }
}
