package com.epam.spring.homework5.service.model;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal funds;

    @Column(nullable = false)
    private BigDecimal change;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Wallet wallet = (Wallet) o;
        return id != null && Objects.equals(id, wallet.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
