package net.sirdagron.bookstore.domain.interfaces;

import net.sirdagron.bookstore.domain.entities.User;

import java.util.Optional;

public interface ICustomUserRepository {
    Optional<User> findUserByUsername(String username);
    boolean findIfUserExists(String username, String email);
}
