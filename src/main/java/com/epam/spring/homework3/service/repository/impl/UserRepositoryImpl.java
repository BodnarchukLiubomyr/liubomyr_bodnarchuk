package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.service.model.Place;
import com.epam.spring.homework3.service.model.User;
import com.epam.spring.homework3.service.model.UserDetails;
import com.epam.spring.homework3.service.model.Wallet;
import com.epam.spring.homework3.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository {
    private int id;
    private String login;
    private final List<User> users = new ArrayList<>();

    @Override
    public User insertUser(User entity){
        id++;
        entity.setId(id);
        users.add(entity);
        log.info("successfully created user with id:{}", entity.getId());
        return entity;
    }

    @Override
    public User getUser(String login) {
        User user = users.stream().filter(a -> Objects.equals(a.getLogin(), login)).findFirst().orElse(null);
        if (user != null){
            log.info("user with this login is found: {}", user.getLogin());
        }
        else {
            log.info("user with this login doesn't exist: {}", login);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        log.info("successfully received users");
        return new ArrayList<>(users);
    }

//    @Override
//    public User update(User entity) {
//        User user = null;
//        Optional<User> userOptional = users.stream()
//                .filter(a -> a.getId() == id)
//                .findFirst();
//        if (userOptional.isPresent()) {
//            user = userOptional.get();
//            user.setRole(user.getRole());
//            user.setLogin(user.getLogin());
//            user.setPassword(user.getPassword());
//            UserDetails details = user.getDetails();
//            details.setId(details.getId());
//            details.setFirstnameEn(details.getFirstnameEn());
//            details.setLastnameEn(details.getLastnameEn());
//            details.setEmail(details.getEmail());
//            details.setPhone(details.getPhone());
//            Place place = user.getPlace();
//            place.setId(place.getId());
//            place.setStreet(place.getStreet());
//            place.setDistrict(place.getDistrict());
//            place.setCity(place.getCity());
//            Wallet wallet = user.getWallet();
//            wallet.setId(wallet.getId());
//            wallet.setFunds(wallet.getFunds());
//            wallet.setChange(wallet.getChange());
//        }
//        return user;
//    }
}
