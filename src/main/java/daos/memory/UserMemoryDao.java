package daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import daos.UserDao;
import entities.User;

public class UserMemoryDao extends GenericMemoryDao<User> implements UserDao {
    public UserMemoryDao() {
        this.setMap(new HashMap<String, User>());
    }

    @Override
    protected String getId(User entity) {
        return entity.getNick();
    }

    @Override
    protected void setId(User entity, String id) {
        entity.setNick(id);

    }

    @Override
    public void addSport(String user, String sport) {
        this.read(user).addSport(sport);
    }

    @Override
    public List<String> usersBySport(String sport) {
        List<User> users = this.findAll();
        List<String> usersWithSport = new ArrayList<>();
        for (User user : users) {
            for (String sportUser : user.getSports()) {
                if (sportUser == sport) {
                    usersWithSport.add(user.getNick());
                }
            }
        }
        return usersWithSport;
    }

}
