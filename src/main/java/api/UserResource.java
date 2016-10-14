package api;

import controllers.SportController;
import controllers.UserController;
import exceptions.InvalidFieldException;
import exceptions.NotFoundSportException;
import exceptions.UserExistException;
import wrapper.UserListWrapper;
import wrapper.UsersSportWrapper;

public class UserResource {
    public UserListWrapper userList() {
        return new UserController().userList();
    }

    public void createUser(String nick, String name) throws InvalidFieldException, UserExistException {
        this.validateField(nick);
        this.validateField(name);
        if(new UserController().existUser(nick)){
            throw new UserExistException(nick);
        }
        new UserController().createUser(nick, name);
    }

    private void validateField(String field) throws InvalidFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidFieldException(field);
        }
    }

    public UsersSportWrapper usersBySport(String sport) throws NotFoundSportException {
        UsersSportWrapper usersSportWrapper = new UserController().usersBySport(sport);
        if (usersSportWrapper == null) {
            throw new NotFoundSportException("" + sport);
        } else {
            return usersSportWrapper;
        }
    }

    public void addSport(String user, String sport) throws InvalidFieldException, NotFoundSportException {
        this.validateField(sport);
        this.validateField(user);
        if(new SportController().existSport(sport)){
            new UserController().addSport(user, sport);
        }else{
            throw new NotFoundSportException();
        }
       
    }
}
