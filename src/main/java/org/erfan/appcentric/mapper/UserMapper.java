package org.erfan.appcentric.mapper;

import org.erfan.appcentric.domain.Enum.UserRole;
import org.erfan.appcentric.domain.User;
import org.erfan.appcentric.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class UserMapper {
    @Autowired
    PasswordEncoder encoder;

    ModelMapper modelMapper = new ModelMapper();

    public UserEntity domainToEntity(User user) {
        return modelMapper.map(user, UserEntity.class);
    }

    public User entityToDomain(UserEntity userEntity) {
        return modelMapper.map(userEntity, User.class);
    }

    public List<User> entityToDomainList(List<UserEntity> userEntities) {

        Type listType = new TypeToken<List<User>>(){}.getType();
        return modelMapper.map(userEntities,  listType);

    }

    public ResultMapper<User, UserEntity> domainToEntityMapping() {
        return domain ->
                new UserEntity().setId(domain.getId())
                        .setFirstName(domain.getFirstName())
                        .setUsername(domain.getUsername())
                        .setLastName(domain.getLastName())
                        .setEmail(domain.getEmail())
                        .setPassword(encoder.encode(domain.getPassword()))
                        .setUserType(UserRole.Customer);
    }

    public ResultMapper<UserEntity, User> entityToDomainMapping() {
        return entity ->
                new User().setId(entity.getId())
                        .setFirstName(entity.getFirstName())
                        .setLastName(entity.getLastName())
                        .setEmail(entity.getEmail())
                        .setUserType(entity.getUserType());
    }
}
