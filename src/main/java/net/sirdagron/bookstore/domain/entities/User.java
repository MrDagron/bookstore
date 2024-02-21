package net.sirdagron.bookstore.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.sirdagron.bookstore.domain.enums.UserRole;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Types;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Column(unique = true, nullable = false, length = 45)
    private String username;
    @Setter
    @Column(nullable = false)
    private String password;
    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name="is_locked")
    @Setter
    private Boolean isLocked;
    @Setter
    private Boolean isEnabled;
    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    public User() {}
    public User(String username, String password, boolean isLocked, boolean isEnabled, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.isLocked = isLocked;
        this.isEnabled = isEnabled;
        this.email = username;
        this.userRole = userRole;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        //todo: actual logic
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
