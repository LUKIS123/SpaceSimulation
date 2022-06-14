package app.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlienNameGeneratorTest {

    @Test
    void generate() {
        // Arrange
        int seed = 123;
        int howManyNames = 10;
        String[] generatedNames = new String[howManyNames];
        String[] correctGeneratedNames = {"Obob-Ut-Le", "Obob-Ut-Le", "Obob-Ut-Le", "Obob-Ut-Le", "Obob-Ut-Le", "Obob-Ut-Le", "Obob-Ut-Le", "Obob-Ut-Le", "Obob-Ut-Le", "Obob-Ut-Le"};
        // Act
        fillArray(generatedNames, howManyNames, seed);
        // Assert
        for (int i = 0; i < howManyNames; i++) {
            assertEquals(correctGeneratedNames[i], generatedNames[i]);
        }
    }

    private void fillArray(String[] s, int iterations, int seed) {
        for (int i = 0; i < iterations; i++) {
            s[i] = AlienNameGenerator.generate(seed);
        }
    }
}