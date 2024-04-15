package org.ici.backend.request.matrix;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class GenerateMatrixRequestBody {
    private int numChanges;
    private int size;
    private String randomAlgorithm;
}
