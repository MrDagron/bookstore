package net.sirdagron.bookstore.domain.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import net.sirdagron.bookstore.domain.entities.User;
import net.sirdagron.bookstore.domain.interfaces.ICustomUserRepository;

import java.util.Optional;

public class UserRepositoryImpl implements ICustomUserRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Optional<User> findUserByUsername(String username) {
        try {
            Object q = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :uName")
                    .setParameter("uName", username)
                    .getSingleResult();

            return Optional.of((User) q);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean findIfUserExists(String username, String email) {
        return false;
    }
}
