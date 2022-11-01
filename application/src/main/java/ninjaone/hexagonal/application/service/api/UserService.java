package ninjaone.hexagonal.application.service.api;

import ninjaone.hexagonal.domain.model.User;

public interface UserService {
    User findOneByEmail(String email);
}