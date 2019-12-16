package com.fsd.common.dao;

import com.fsd.common.entity.RoleEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<RoleEO, Long> {

    RoleEO findByName(String name);

}
