package com.epam.spring.homework5.service.repository;

import com.epam.spring.homework5.service.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
    boolean existsById(Integer id);
    boolean existsByIdIsNot(Integer id);
}
