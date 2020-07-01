import java.io.IOException;
import java.util.Arrays;

public class Functions {

    public static void stableSort(String[][] table, int column) {
        String[] temp = null;
        int rows = table.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < (rows - i); j++) {
                if (table[j - 1][column].compareTo(table[j][column]) > 0) {
                    temp = table[j - 1];
                    table[j - 1] = table[j];
                    table[j] = temp;
                }
            }
        }
    }

    public static void printTable(String[][] table) {
        System.out.println("Array:");
        for (int i = 0; i < table.length; i++) {
            System.out.println(Arrays.toString(table[i]));
        }
    }

    public static String ratingEvaluation(String[][] table) {
        double percentage;
        int likes = 0;
        int dislikes = 0;

        for (int i = 0; i < table.length; i++) {
            String temp = "";
            temp = table[i][2];

            if (temp.equals("like")) {
                likes = likes + 1;
            }
            if (temp.equals("dislike")) {
                dislikes = dislikes + 1;
            }
        }

        double d1 = likes;
        double d2 = table.length;

        percentage = ((d1 / d2)) ;
        percentage = percentage*100;
        String result = "";
        result = (percentage + " %").toString();

        return result;
    }

    public static String tagsEvaluation(String[][] table) {
        // like { "užitečné", "aktuální", "jasné", "stručné", "objevné"}
        // dislike { "nepřehledné", "moc dlouhé", "příliš stručné", "nesrozumitelné",
        // "irelevantní", "zastaralé" };

        String result = "";
        String part1 = "Kategorie s počtem tagů ";
        String part2 = "(like - ";
        String part3 = "dislike - ";

        int like1 = 0, like2 = 0, like3 = 0, like4 = 0, like5 = 0;
        int dislike1 = 0, dislike2 = 0, dislike3 = 0, dislike4 = 0, dislike5 = 0, dislike6 = 0;

        for (int i = 0; i < table.length; i++) {
            String temp = "";
            temp = table[i][3];

            // likes
            if (temp.equals("užitečné")) {
                like1++;
            }
            if (temp.equals("aktuální")) {
                like2++;
            }
            if (temp.equals("jasné")) {
                like3++;
            }
            if (temp.equals("stručné")) {
                like4++;
            }
            if (temp.equals("objevné")) {
                like5++;
            }

            // dislikes
            if (temp.equals("nepřehledné")) {
                dislike1++;
            }
            if (temp.equals("moc dlouhé")) {
                dislike2++;
            }
            if (temp.equals("příliš stručné")) {
                dislike3++;
            }
            if (temp.equals("nesrozumitelné")) {
                dislike4++;
            }
            if (temp.equals("irelevantní")) {
                dislike5++;
            }
            if (temp.equals("zastaralé")) {
                dislike6++;
            }
        }

        if (like1 > 0) {
            part2 += "užitečné " + like1 + "x, ";
        }
        if (like2 > 0) {
            part2 += "aktuální " + like2 + "x, ";
        }
        if (like3 > 0) {
            part2 += "jasné " + like3 + "x, ";
        }
        if (like4 > 0) {
            part2 += "stručné " + like4 + "x, ";
        }
        if (like5 > 0) {
            part2 += "objevné " + like5 + "x, ";
        }

        if (dislike1 > 0) {
            part2 += "nepřehledné " + dislike1 + "x, ";
        }

        if (dislike2 > 0) {
            part3 += "moc dlouhé " + dislike2 + "x, ";
        }
        if (dislike3 > 0) {
            part3 += "příliš stručné " + dislike3 + "x, ";
        }
        if (dislike4 > 0) {
            part3 += "nesrozumitelné " + dislike4 + "x, ";
        }
        if (dislike5 > 0) {
            part3 += "irelevantní " + dislike5 + "x, ";
        }
        if (dislike6 > 0) {
            part3 += "zastaralé " + dislike6 + "x";
        }
        result = part1 + part2 + part3 +")";
        return result;

    }

    public static void main(String[] args) {
        String[][] names = new String[6][4];

        // initialize array values
        names[0][0] = "page001";
        names[0][1] = "Marketa Blazkova";
        names[0][2] = "like";
        names[0][3] = "užitečné";

        names[1][0] = "page002";
        names[1][1] = "Petr Novak";
        names[1][2] = "dislike";
        names[1][3] = "moc dlouhé";

        names[2][0] = "page003";
        names[2][1] = "Blanka Dankova";
        names[2][2] = "like";
        names[2][3] = "objevné";

        names[3][0] = "page001";
        names[3][1] = "Petr Novak";
        names[3][2] = "like";
        names[3][3] = "objevné";

        names[4][0] = "page003";
        names[4][1] = "Marketa Blazkova";
        names[4][2] = "dislike";
        names[4][3] = "nesrozumitelné";

        names[5][0] = "page002";
        names[5][1] = "Marketa Blazkova";
        names[5][2] = "dislike";
        names[5][3] = "příliš stručné";

        printTable(names);
        stableSort(names, 0);
        printTable(names);
        System.out.println(ratingEvaluation(names));
        System.out.println(tagsEvaluation(names));
    }
}
