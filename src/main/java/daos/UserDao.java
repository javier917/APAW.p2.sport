package daos;

import java.util.List;

import entities.User;

public interface UserDao extends GenericDao<User, String> {
    public abstract void addSport(String user, String sport);
    public abstract List<String> usersBySport(String sport);
}
