package daos;


public interface UserDao extends GenericDao<User, String> {
    public abstract void addSport(String user, String sport);
    public abstract void usersBySport(String sport);
}
