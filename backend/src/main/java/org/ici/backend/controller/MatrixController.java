package org.ici.backend.controller;

import org.ici.backend.request.matrix.GenerateMatrixRequestBody;
import org.ici.backend.service.MatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MatrixController {

    @Autowired
    private MatrixService matrixService;

    @PostMapping("/generate")
    int[][] generateNewMatrix(@RequestBody GenerateMatrixRequestBody body) {
        return matrixService.generateNewMatrix(
                body.getRandomAlgorithm(),
                body.getSize(),
                body.getNumChanges()
        );
    }

}
