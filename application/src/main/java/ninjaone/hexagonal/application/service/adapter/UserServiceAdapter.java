package ninjaone.hexagonal.application.service.adapter;

import ninjaone.hexagonal.application.service.api.UserService;
import ninjaone.hexagonal.domain.model.User;
import ninjaone.hexagonal.domain.spi.UserPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceAdapter implements UserService {

    private UserPersistencePort userPersistencePort;

    @Autowired
    public UserServiceAdapter(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User findOneByEmail(String email) {
        return userPersistencePort.findOneByEmail(email);
    }
}