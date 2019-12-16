package com.fsd.training.service.impl;

import com.fsd.training.service.SkillService;
import com.fsd.common.dao.SkillDAO;
import com.fsd.common.dto.SkillDTO;
import com.fsd.common.entity.MentorSkillsEO;
import com.fsd.common.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDAO skillDAO;

    @Override
    public boolean save(SkillDTO skillDTO) {
        MentorSkillsEO skillEO = CopyUtils.copy(skillDTO, MentorSkillsEO.class);
        skillEO.setId(null);
        skillDAO.save(skillEO);
        if (null != skillEO.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        skillDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean update(SkillDTO skillDTO) {
        MentorSkillsEO skillEO = CopyUtils.copy(skillDTO, MentorSkillsEO.class);
        skillDAO.save(skillEO);
        if (null != skillEO.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public SkillDTO findById(Long id) {
        MentorSkillsEO skillEO = skillDAO.findById(id).get();
        SkillDTO skillDTO = CopyUtils.copy(skillEO, SkillDTO.class);
        return skillDTO;
    }

    @Override
    public List<SkillDTO> search(String name) {
        List<SkillDTO> skillDTOList = new ArrayList<>();
        List<MentorSkillsEO> skillEOList = skillDAO.findByNameLike(name);
        for (MentorSkillsEO skillEO : skillEOList) {
            skillDTOList.add(CopyUtils.copy(skillEO, SkillDTO.class));
        }
        return skillDTOList;
    }

}
