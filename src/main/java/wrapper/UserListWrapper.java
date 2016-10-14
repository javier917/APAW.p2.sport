package wrapper;

import java.util.ArrayList;
import java.util.List;

public class UserListWrapper {
    List<UserWrapper> userList;

    public UserListWrapper() {
        this.userList = new ArrayList<UserWrapper>();
    }

    public List<UserWrapper> getUserList() {
        return userList;
    }

    public void addUserWrapper(UserWrapper userWrapper) {
        this.userList.add(userWrapper);
    }

    @Override
    public String toString() {
        String result = "{\"userList\":[ ";
        for (UserWrapper userWrapper : userList) {
            result += userWrapper.toString() + ",";
        }
        return result.substring(0, result.length() - 1) + "]}";
    }
}
