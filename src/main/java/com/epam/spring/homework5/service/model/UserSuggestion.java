package com.epam.spring.homework5.service.model;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserSuggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name_en;

    @Column(nullable = false)
    private int time;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "service_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Service service;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserSuggestion userSuggestion = (UserSuggestion) o;
        return id != null && Objects.equals(id, userSuggestion.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
