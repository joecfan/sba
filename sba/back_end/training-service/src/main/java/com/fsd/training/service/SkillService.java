package com.fsd.training.service;



import com.fsd.common.dto.SkillDTO;

import java.util.List;

public interface SkillService {

    boolean save(SkillDTO skillDTO);

    boolean delete(Long id);

    boolean update(SkillDTO skillDTO);

    SkillDTO findById(Long id);

    List<SkillDTO> search(String name);

}
