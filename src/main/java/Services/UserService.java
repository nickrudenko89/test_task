package Services;

import Daos.UserDao;
import Entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserEntity getLoggedUser(int id) {
        return userDao.getUserById(id);
    }

    public UserEntity logUser(String login, String password) {
        return userDao.getUserByLoginAndPassword(login, password);
    }
}
