package com.fsd.common.dao;

import com.fsd.common.entity.UserEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEO, Long> {

    UserEO findByUserName(String username);

}
