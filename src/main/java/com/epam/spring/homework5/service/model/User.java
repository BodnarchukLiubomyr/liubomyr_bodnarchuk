package com.epam.spring.homework5.service.model;

import com.epam.spring.homework5.service.model.enums.Role;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false, unique = true)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @Column(nullable = false)
    private UserDetails details;

    @OneToOne
    @Column(nullable = false)
    private Place place;

    @OneToOne
    @Column(nullable = false)
    private Wallet wallet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
