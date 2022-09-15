package com.epam.spring.homework5.service.repository;

import com.epam.spring.homework5.service.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {
    boolean existsById(Integer id);
    boolean existsByEmailOrPhone(String email,String phone);
    boolean existsByEmailAndPhoneOrIdIsNot(String email,String phone, Integer id);
}
