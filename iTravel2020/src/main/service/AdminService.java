package service;

import itravel.model.User;

import java.util.List;

/**
 * @author Hailian
 * @Poject name iTravel2020_2
 * @creat2020-11-10 11:45 PM
 */
public interface AdminService {

    public void addUser(User user);

    public void deleteUserById(String id);

    public User queryUserById(String id);

}
