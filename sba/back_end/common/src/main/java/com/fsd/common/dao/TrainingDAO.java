package com.fsd.common.dao;

import com.fsd.common.entity.TrainingEO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingDAO extends JpaRepository<TrainingEO, Long> {

//    @Query("select t from TraingingEO t where t.title like '%title%'")
    List<TrainingEO> findByTitleLike(String title);

}
