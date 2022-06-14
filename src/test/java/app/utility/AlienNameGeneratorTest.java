package app.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienNameGeneratorTest {

    @Test
    void generate() {
        // Arrange
        int seed = 123;
        int howManyNames = 10;
        String[] generatedNames1 = new String[howManyNames];
        String[] generatedNames2 = new String[howManyNames];
        // Act
        fillArray(generatedNames1, howManyNames, seed);
        fillArray(generatedNames2, howManyNames, seed);
        // Assert
        for (int i = 0; i < howManyNames; i++) {
            assertEquals(generatedNames1[i], generatedNames2[i]);
        }
    }

    private void fillArray(String[] s, int iterations, int seed) {
        for (int i = 0; i < iterations; i++) {
            s[i] = AlienNameGenerator.generate(seed);
        }
    }
}