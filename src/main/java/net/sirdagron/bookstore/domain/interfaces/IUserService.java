package net.sirdagron.bookstore.domain.interfaces;

import net.sirdagron.bookstore.domain.dto.UserDto;
import net.sirdagron.bookstore.domain.entities.User;

public interface IUserService {
    User registerNewUserAccount(UserDto userDto);
}
