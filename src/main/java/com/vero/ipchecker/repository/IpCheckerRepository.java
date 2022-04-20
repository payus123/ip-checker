package com.vero.ipchecker.repository;

import com.vero.ipchecker.domain.UserChecker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IpCheckerRepository extends JpaRepository<UserChecker,Long> {
    Optional<UserChecker> findUserCheckerByIpAddress(String ipAddress);
}
