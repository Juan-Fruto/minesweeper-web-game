package org.ici.backend.service;

import org.ici.backend.random.*;
import org.springframework.stereotype.Service;

@Service
public class MatrixService {

    public int[][] generateNewMatrix(String randomAlgorithm,int size, int numOfChanges) {
        IRandomNumberMatrix generator;
        int[][] finalMatrix = new int[size][size];
        int changes = 0;

        switch (randomAlgorithm) {
            case "blum blum":
                generator = new BlumBlumShubGenerator();
            case "mix max":
                generator = new MixMax();
            case "linear congruential":
                generator = new LinearCongruentialGenerator();
            case "linear feedback shift":
                generator = new LinearfeedbackShiftRegister();
            case "wichmann hill":
                generator = new WichmannHillGenerator();
            default:
                generator = new JavaGenerator();
        }

       while(changes < numOfChanges){
           int columnIndex = generator.generate(size -1);
           int rowIndex = generator.generate(size -1);

           if(finalMatrix[rowIndex][columnIndex] != 1) {
               finalMatrix[rowIndex][columnIndex] = 1;
               changes++;
           }

       }

        return finalMatrix;
    }

}
