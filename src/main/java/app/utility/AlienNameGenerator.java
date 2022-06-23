package app.utility;

import java.util.Random;

/**
 * This class is responsible for generating alien race names.
 */
public class AlienNameGenerator {
    private static final String[] syllables =
            {"Cla", "At", "Oisc", "At", "Iy", "Fri", "Un", "Is", "Groi", "Go", "Grai", "Ig", "Ih", "Klo", "Ul", "Ru",
                    "Sce", "Tee", "Aaf", "Xu", "Ob", "Ib", "Va", "As", "Le", "Gli", "Aiw", "Hoa", "Ox", "Mu", "Keu",
                    "Flo", "Si", "Zoe", "Ic", "Frou", "Dreo", "Za", "Ost", "Ut", "Nib", "Ba"};

    /**
     * This static method creates alien race names from a variety of hardcoded syllables,
        which can be separated by a regex or merged.
     * @param seed the seed used when creating an instance of Random class.
     * @return name - the generated String of the name.
     */
    public static String generate(int seed) {
        Random random = new Random(seed);
        StringBuilder name = new StringBuilder();

        int range = 2 + random.nextInt(5);
        int i = 0;
        // loop iterations range from 2 to 6
        while (i < range) {
            // syllables are chosen from the 1st to 30th index of the array
            int randomIndex = random.nextInt(42);
            if (i == 0) {
                name = new StringBuilder(syllables[randomIndex]);
            } else {
                // choosing separator between syllables
                String separator;
                int randomCase = random.nextInt(5);
                switch (randomCase) {
                    case 1:
                        separator = " ";
                        break;
                    case 2:
                        separator = "-";
                        break;
                    case 3:
                        separator = "'";
                        break;
                    case 4:
                    default:
                        separator = "";
                        break;
                }
                if (separator.equals("")) {
                    name.append(separator).append(syllables[randomIndex].toLowerCase());
                } else {
                    name.append(separator).append(syllables[randomIndex]);
                }
            }
            i++;
        }
        return name.toString();
    }
}