package com.example.Capstone.Project.user;

import com.example.Capstone.Project.enums.Role;
import com.example.Capstone.Project.enums.Season;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "user")
@JsonIgnoreProperties({"password", "credentialNonExpired", "accountNonExpired", "authorities",  "accountNonLocked", "enabled"})
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name= "id", nullable = false)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Season season;
    @Enumerated(EnumType.STRING)
    private Set<Role> roles= new HashSet<>();

    public User(String name, String surname, String email, String password, Season season, Set<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.season = season;
        this.roles.add(Role.USER);
    }

    public User(String name, String surname, String encode) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
