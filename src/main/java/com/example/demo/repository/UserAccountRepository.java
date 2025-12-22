package com.example.demo.repository;
import java.util.Optional;

import com.example.demo.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
// public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {}
  public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmail(String email);
}