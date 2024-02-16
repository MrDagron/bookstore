package net.sirdagron.bookstore.domain.repositories;

import jakarta.transaction.Transactional;
import net.sirdagron.bookstore.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Transactional
@Repository public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findDistinctFirstByEmail(String email);
    @Query("SELECT DISTINCT u.id FROM User u WHERE u.email = (:email)")
    Optional<UUID> findUserIdByEmail(String email);
}
