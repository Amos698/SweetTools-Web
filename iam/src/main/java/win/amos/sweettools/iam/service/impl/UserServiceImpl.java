package win.amos.sweettools.iam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import win.amos.sweettools.iam.repo.UserRepo;
import win.amos.sweettools.iam.repo.model.User;
import win.amos.sweettools.iam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public User createUser(User u) {
        User user = userRepo.findByUserNameAndUsed(u.getUserName(), 1);
        if (user == null) {
            return userRepo.save(u);
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public User updateUser(User u) {
        return userRepo.save(u);
    }

    @Override
    @Transactional
    public Long deleteUser(Long uid) {
        User user = userRepo.getOne(uid);
        user.setUsed(0);
        userRepo.save(user);
        return uid;
    }

    @Override
    public User findUser(Long uid) {
        return userRepo.getOne(uid);
    }

    @Override
    public User verifyUser(String username, String password) {
        User user = userRepo.findByUserNameAndUsed(username, 1);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
