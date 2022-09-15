package com.epam.spring.homework5.service.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Place {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @Column(nullable = false)
    private String street;

//    @Column(nullable = false)
    private String district;

//    @Column(nullable = false)
    private String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Place place = (Place) o;
        return id != null && Objects.equals(id, place.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
