package com.ms.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import com.ms.user.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    
}
