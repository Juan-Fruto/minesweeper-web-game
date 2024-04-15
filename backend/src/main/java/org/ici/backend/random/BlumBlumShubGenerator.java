package org.ici.backend.random;

import java.math.BigInteger;
import java.security.SecureRandom;

public class BlumBlumShubGenerator implements IRandomNumberMatrix {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger currentState;

    public BlumBlumShubGenerator() {
        generatePrimes();
        generateSeed();
    }

    private void generatePrimes() {
        SecureRandom random = new SecureRandom();
        int bitLength = 512;

        p = BigInteger.probablePrime(bitLength, random);
        q = BigInteger.probablePrime(bitLength, random);
        n = p.multiply(q);
    }

    private void generateSeed() {
        SecureRandom random = new SecureRandom();
        currentState = new BigInteger(n.bitLength(), random).mod(n);
    }

    @Override
    public int generate(int maxValue) {
        BigInteger upperBoundBigInt = BigInteger.valueOf(maxValue);
        currentState = currentState.modPow(BigInteger.TWO, n);
        BigInteger scaledNumber = currentState.mod(upperBoundBigInt);
        return scaledNumber.intValue();
    }
}
