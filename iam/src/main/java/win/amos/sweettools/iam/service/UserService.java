package win.amos.sweettools.iam.service;

import win.amos.sweettools.iam.repo.model.User;

public interface UserService {

    User createUser(User u);

    User updateUser(User u);

    Long deleteUser(Long uid);

    User findUser(Long uid);

    User verifyUser(String username, String password);

}
