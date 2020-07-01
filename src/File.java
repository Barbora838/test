import java.io.IOException;
import java.util.Arrays;

//One object of class File represent one page and its rating
public class File {

    private String documentID;
    private String userID;
    private String rating;
    private String tag = "";

    // { "užitečné", "aktuální", "jasné", "stručné", "objevné",
    // "nepřehledné", "moc dlouhé", "příliš stručné", "nesrozumitelné",
    // "irelevantní", "zastaralé" };

    public static void getEvalutation(String documentID) {

    }

    // -------SETTERS--------

    public void setDocumentID(String ID) {
        this.documentID = ID;
    }

    public void setUserID(String ID) {
        this.userID = ID;
    }

    public String setLike(String stage) {
        if (stage.equals("like")) {
            this.rating = stage;
        } else {
            this.rating = "dislike";
        }
        return this.rating;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    // -----GETTERS-------

    public String getEvaluation() {
        String result = (this.documentID + "," + this.userID + "," + this.rating + "," + this.tag).toString();
        return result;
    }

    public String getDocID() {
        return this.documentID;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getRating() {
        return this.rating;
    }

    public String getTag() {
        return this.tag;
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
        p2.setLike("like");
        p2.setUserID("Petr Novak");
        p2.setDocumentID("page002");
        System.out.println(p2.getEvaluation());

        File list[] = new File[2];
        list[0] = p1;
        list[1] = p2;
    }
}
