package serviceImp;

import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.User;
import service.AdminService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hailian
 * @Poject name iTravel2020_2
 * @creat2020-11-10 11:59 PM
 */
public class AdminServiceImp implements AdminService {
    Data userData = DataFactory.getInstance();

    @Override
    public void addUser(User user) {
        userData.getUserList().add(user);
    }

    @Override
    public void deleteUserById(String id) {
        userData.delUser(id);
    }

    @Override
    public User queryUserById(String id) {
        return userData.getUser(id);
    }
    public List showDeactivated(){
        return userData.getDeactivUserList();

    }
}
