package com.chat.app.repository;

import com.chat.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);
    
    Optional<User> findByEmail(String email);
    
    Boolean existsByUsername(String username);
    
    Boolean existsByEmail(String email);
    
    List<User> findByIsOnlineTrue();
    
    @Modifying
    @Query("UPDATE User u SET u.isOnline = :isOnline, u.lastLogin = :lastLogin WHERE u.username = :username")
    void updateUserOnlineStatus(@Param("username") String username, 
                               @Param("isOnline") Boolean isOnline, 
                               @Param("lastLogin") LocalDateTime lastLogin);
}
