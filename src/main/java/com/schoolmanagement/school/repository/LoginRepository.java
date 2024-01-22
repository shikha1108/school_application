package com.schoolmanagement.school.repository;

import com.schoolmanagement.school.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Credentials, Long> {
    public List<Credentials> findByUsername(String username);
}
