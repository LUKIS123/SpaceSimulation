import java.util.Random;

public class AlienNameGenerator {
    private static final Random random = new Random();
    private static final String[] syllables =
            {"Cla", "At", "Oisc", "At", "Iy", "Fri", "Un", "Is", "Groi", "Go", "Grai", "Ig", "Ih", "Klo", "Ul", "Ru",
                    "Sce", "Tee", "Aaf", "Xu", "Ob", "Ib", "Va", "As", "Le", "Gli", "Aiw", "Hoa", "Ox", "Mu", "Keu",
                    "Flo", "Si", "Zoe", "Ic", "Frou", "Dreo", "Za", "Ost", "Ut"};

    public static String generate() {
        StringBuilder name = new StringBuilder();
        int range = 2 + random.nextInt(5);
        int i = 0;
        //loop iterations range from 2 to 6
        while (i < range) {
            //syllables are chosen from the 1st to 30th index of the array
            int randomIndex = random.nextInt(40);
            if (i == 0) {
                name = new StringBuilder(syllables[randomIndex]);
            } else {
                //choosing regex between syllables
                String regex = "";
                int randomCase = random.nextInt(4);
                switch (randomCase) {
                    case 1:
                        regex = " ";
                        break;
                    case 2:
                        regex = "-";
                        break;
                    case 3:
                        regex = "'";
                        break;
                    default:
                }
                name.append(regex).append(syllables[randomIndex]);
            }
            i++;
        }
        return name.toString();
    }
}