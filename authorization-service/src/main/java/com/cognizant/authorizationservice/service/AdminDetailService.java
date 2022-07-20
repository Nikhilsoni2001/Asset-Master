package com.cognizant.authorizationservice.service;

import com.cognizant.authorizationservice.model.UserData;
import com.cognizant.authorizationservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminDetailService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AdminDetailService.class);


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String uid) {
        logger.info("START");
        try {
            UserData customer = userRepository.findById(uid).orElse(null);
            if (customer != null) {
                logger.info("END - User found {}", customer.getUname());
                return new User(customer.getUserid(), customer.getUpassword(), new ArrayList<>());
            } else {
                logger.info("END - UsernameNotFound");
                throw new UsernameNotFoundException("UsernameNotFoundException");
            }
        } catch (Exception e) {
            logger.info("EXCEPTION - UsernameNotFoundException");
            throw new UsernameNotFoundException("UsernameNotFoundException");
        }

    }

}
