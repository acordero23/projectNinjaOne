package ninjaone.hexagonal.domain.spi;

import ninjaone.hexagonal.domain.model.User;

public interface UserPersistencePort {
    User findOneByEmail(String email);
}