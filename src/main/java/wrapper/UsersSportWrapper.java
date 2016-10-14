package wrapper;

import java.util.ArrayList;
import java.util.List;

public class UsersSportWrapper {
    List<String> userList;

    public UsersSportWrapper(List<String> list) {
        this.userList = new ArrayList<String>();
        userList=list;
    }

    public List<String> getUserList() {
        return userList;
    }

    @Override
    public String toString() {
        String result = "{\"userListBySport\":[ ";
        for (String user : userList) {
            result += user+ ",";
        }
        return result.substring(0, result.length() - 1) + "]}";
    }
}
