package com.fsd.training.service;


import com.fsd.common.dto.TrainingDTO;

import java.util.List;

public interface TrainingService {

    boolean save(TrainingDTO trainingDTO);

    boolean delete(Long id);

    boolean update(TrainingDTO trainingDTO);

    TrainingDTO findById(Long id);

    List<TrainingDTO> findByUserId(Long userId);

    List<TrainingDTO> search(String title);

}
