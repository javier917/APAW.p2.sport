package controllers;

import java.util.List;

import daos.DaoFactory;
import entities.User;
import exceptions.NotFoundSportException;
import wrapper.UserListWrapper;
import wrapper.UserWrapper;
import wrapper.UsersSportWrapper;

public class UserController {
    public UserListWrapper userList() {
        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        UserListWrapper userListWrapper = new UserListWrapper();
        for (User user : userList) {
            userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
        }
        return userListWrapper;
    }

    public void createUser(String nick, String name) {
        DaoFactory.getFactory().getUserDao().create(new User(nick, name));
    }

    public UsersSportWrapper usersBySport(String sport) {
        if (DaoFactory.getFactory().getSportDao().read(sport) == null) {
            return null;
        }
        List<String> users = DaoFactory.getFactory().getUserDao().usersBySport(sport);
        
        return new UsersSportWrapper(users);
    }

    public void addSport(String user, String sport) throws NotFoundSportException {
        if (DaoFactory.getFactory().getSportDao().read(sport) == null) {
            throw new NotFoundSportException("" + sport);
        }
        DaoFactory.getFactory().getUserDao().addSport(user, sport);
    }
}
