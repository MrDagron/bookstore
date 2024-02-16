package net.sirdagron.bookstore.services;

import net.sirdagron.bookstore.domain.dto.UserDto;
import net.sirdagron.bookstore.domain.entities.User;
import net.sirdagron.bookstore.domain.interfaces.IUserService;
import net.sirdagron.bookstore.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User registerNewUserAccount(UserDto userDto) {
        return null;
    }
    private boolean userExists(String username, String email) {
        return userRepository.findIfUserExists(username, email);
    }
}
