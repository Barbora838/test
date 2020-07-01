import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile {
    private String path;
    private boolean append_to_file = false;

    public WriteFile(String file_path) {
        path = file_path;
    }

    public WriteFile(String file_path, boolean append_value) {
        path = file_path;
        append_to_file = append_value;
    }

    public void writeToFile(String textLine) throws IOException {
        FileWriter write = new FileWriter(path, append_to_file);
        PrintWriter print_line = new PrintWriter(write);

        print_line.printf("%s" + "%n", textLine);

        print_line.close();

    }

    public static void main(String[] args) {
        File p1 = new File();
        p1.setTag("užitečné");
        p1.setLike("like");
        p1.setUserID("Marketa Blazkova");
        p1.setDocumentID("page001");
        System.out.println(p1.getEvaluation());

        File p2 = new File();
        p2.setTag("moc dlouhé");
        p2.setLike("dislike");
        p2.setUserID("Petr Novak");
        p2.setDocumentID("page002");
        System.out.println(p2.getEvaluation());

        File p3 = new File();
        p3.setTag("objevné");
        p3.setLike("like");
        p3.setUserID("Blanka Dankova");
        p3.setDocumentID("page003");
        System.out.println(p3.getEvaluation());

        File p4 = new File();
        p4.setTag("objevné");
        p4.setLike("like");
        p4.setUserID("Petr Novak");
        p4.setDocumentID("page001");
        System.out.println(p4.getEvaluation());

        File list[] = new File[4];
        list[0] = p1;
        list[1] = p2;
        list[2] = p3;
        list[3] = p4;


        String file_name = "/Users/barbora/Desktop/test/test.txt";
        // Write to a file
        try {
            for (int i = 0; i < list.length; i++) {
                WriteFile data = new WriteFile(file_name, true);
                data.writeToFile(list[i].getEvaluation());
            }
        } catch (IOException e) {
            System.out.println("Text File Written To");
        }
    }
}
