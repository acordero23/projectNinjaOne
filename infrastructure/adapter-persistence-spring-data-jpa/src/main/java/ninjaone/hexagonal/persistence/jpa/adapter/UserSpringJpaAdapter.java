package ninjaone.hexagonal.persistence.jpa.adapter;

import ninjaone.hexagonal.domain.model.User;
import ninjaone.hexagonal.domain.spi.UserPersistencePort;
import ninjaone.hexagonal.persistence.jpa.entity.UserEntity;
import ninjaone.hexagonal.persistence.jpa.repository.UserRepository;

public class UserSpringJpaAdapter implements UserPersistencePort {

    private UserRepository userRepository;

    public UserSpringJpaAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findOneByEmail(String email) {
        UserEntity userEntity = userRepository.findOneByEmail(email);

        if (userEntity == null) return null;

        User user = new User();
        user.setEmail(userEntity.getEmail());
        user.setName(userEntity.getName());
        user.setPassword(userEntity.getPassword());

        return user;
    }
}
