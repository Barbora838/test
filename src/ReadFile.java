import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile {

    private String path;

    public ReadFile(String file_path) {
        path = file_path;
    }

    // returns number of lines in my document
    public int counter(String file_path) throws IOException {
        FileReader fr = new FileReader(file_path);
        BufferedReader textReader = new BufferedReader(fr);

        String line;
        int count = 0;
        while ((line = textReader.readLine()) != null) {
            if (!line.isEmpty()) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public String[] OpenFile() throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = counter(path);
        String[] textData = new String[numberOfLines];

        int i;

        for (i = 0; i < numberOfLines; i++) {
            textData[i] = textReader.readLine();
        }

        textReader.close();
        return textData;
    }

    int readLines() throws IOException {
        FileReader file_to_read = new FileReader(path);
        BufferedReader bf = new BufferedReader(file_to_read);

        String aLine;
        int numberOfLines = 0;

        while ((aLine = bf.readLine()) != null) {
            numberOfLines++;
        }

        bf.close();
        return numberOfLines;
    }

    //read the document and set up the variable and also creates the 2D array and returns
    public static String[][] read(String file) {
        File Contract = new File();
        final String[][] items;

        try {
            ReadFile file2 = new ReadFile(file);
            String[] aryLines = file2.OpenFile();
            items = new String[aryLines.length][4];

            for (int i = 0; i < aryLines.length; i++) {
                String[] part = aryLines[i].split(",");

                // setting the instance variables of the objects
                Contract.setDocumentID(part[0]);
                Contract.setUserID(part[1]);
                Contract.setLike(part[2]);
                Contract.setTag(part[3]);

                // setting the 2-D array
                items[i][0] = Contract.getDocID();
                items[i][1] = Contract.getUserID();
                items[i][2] = Contract.getRating();
                items[i][3] = Contract.getTag();

                for (int j = 0; j < 4; j++) {
                    System.out.print((items[i][j]).toString() + " ");
                }
                System.out.println();
            }
            return items;

        } catch (IOException e) {
            System.out.println("Cannot do!");

        }
        return null;
    }

    public static void main(String[] args) {
        File Contract = new File();
        String file_name = "/Users/barbora/Desktop/test/test.txt";

        String [][] list =read(file_name);

        Functions.stableSort(list, 0);
        Functions.printTable(list);

        System.out.println(Functions.ratingEvaluation(list));
        System.out.println(Functions.tagsEvaluation(list));

    }
}
