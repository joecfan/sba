package com.fsd.common.dao;

import com.fsd.common.entity.MentorSkillsEO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillDAO extends JpaRepository<MentorSkillsEO, Long> {

    List<MentorSkillsEO> findByNameLike(String name);

}
