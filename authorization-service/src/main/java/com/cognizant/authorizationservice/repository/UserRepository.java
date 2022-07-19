package com.cognizant.authorizationservice.repository;

import com.cognizant.authorizationservice.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, String> {
}
