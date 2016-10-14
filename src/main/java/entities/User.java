package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String nick;

    private String email;

    private List<String> sports;

    public User(String nick, String email) {
        this.nick = nick;
        this.email = email;
        this.sports = new ArrayList<String>();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addSport(String sport) {
        this.sports.add(sport);
    }

    public List<String> getSports() {
        return sports;
    }

    public void setSports(List<String> sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "User [nick=" + nick + ", email=" + email + ", deportes=" + sports + "]";
    }
}
