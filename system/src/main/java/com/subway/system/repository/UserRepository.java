package com.subway.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subway.system.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
