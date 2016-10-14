package entities;

public class Sport {
    private String sport;

    public Sport(String sport) {
        super();
        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Sport [sport=" + sport + "]";
    }

}
