public class Bron {
    public String title;
    public String session;
    public int seat;

    public Bron(String title, String session, int seat) {
        this.title = title;
        this.session = session;
        this.seat = seat;
    }
    
    public String getTitle() {
        return title;
    }

    public String getSession() {
        return session;
    }

    public int getSeat() {
        return seat;
    }
}
