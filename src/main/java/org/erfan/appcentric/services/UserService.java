package org.erfan.appcentric.services;

import org.erfan.appcentric.domain.Enum.UserRole;
import org.erfan.appcentric.domain.User;
import org.erfan.appcentric.entity.UserEntity;
import org.erfan.appcentric.mapper.UserMapper;
import org.erfan.appcentric.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> getUser() {
        return userRepository.findAll()
                .stream()
                .map(userEntity -> userMapper
                        .entityToDomainMapping()
                        .map(userEntity))
                .collect(Collectors.toList());
    }

    public boolean emailExist(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userEntity != null;
    }

    public User getUserById(long id) {
        return userMapper.entityToDomain(userRepository.findById(id).get());
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public User saveUser(User user) {
        return userMapper.entityToDomainMapping().map(
                userRepository.save(userMapper.domainToEntityMapping().map(user)));
    }

    public String updateUser(User user, long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            return "User Not Found";
        }
        UserEntity userEntity = userMapper.domainToEntity(user);
        userEntity.setId(id);
        if (userOptional.get().getUserType() != null ) {
            UserRole userRole = userOptional.get().getUserType();
            userEntity.setUserType(userRole);
        }
        userRepository.save(userEntity);
        return "Update Success";
    }
}
