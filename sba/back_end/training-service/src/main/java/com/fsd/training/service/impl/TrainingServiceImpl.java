package com.fsd.training.service.impl;

import com.fsd.training.service.TrainingService;
import com.fsd.common.dao.SkillDAO;
import com.fsd.common.dao.TrainingDAO;
import com.fsd.common.dao.UserDAO;
import com.fsd.common.dto.SkillDTO;
import com.fsd.common.dto.TrainingDTO;
import com.fsd.common.entity.MentorSkillsEO;
import com.fsd.common.entity.TrainingEO;
import com.fsd.common.entity.UserEO;
import com.fsd.common.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingDAO trainingDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private SkillDAO skillDAO;

    @Override
    public boolean save(TrainingDTO trainingDTO) {
        TrainingEO trainingEO = CopyUtils.copy(trainingDTO, TrainingEO.class);
        trainingEO.setId(null);
        MentorSkillsEO skillEO = CopyUtils.copy(trainingDTO.getSkill(), MentorSkillsEO.class);
        trainingEO.setSkill(skillEO);
        trainingDAO.save(trainingEO);
        if(null != trainingEO.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        trainingDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean update(TrainingDTO trainingDTO) {
        TrainingEO trainingEO = CopyUtils.copy(trainingDTO, TrainingEO.class);
        MentorSkillsEO skillEO = CopyUtils.copy(trainingDTO.getSkill(), MentorSkillsEO.class);
        trainingEO.setSkill(skillEO);
        trainingDAO.save(trainingEO);
        return true;
    }

    @Override
    public TrainingDTO findById(Long id) {
        TrainingEO trainingEO = trainingDAO.findById(id).get();
        TrainingDTO trainingDTO = CopyUtils.copy(trainingEO, TrainingDTO.class);
        SkillDTO skillDTO = CopyUtils.copy(trainingEO.getSkill(), SkillDTO.class);
        trainingDTO.setSkill(skillDTO);
        return trainingDTO;
    }

    @Override
    public List<TrainingDTO> findByUserId(Long userId) {
        UserEO user = userDAO.findById(userId).get();
        List<TrainingEO> trainingList = user.getTrainingList();
        List<TrainingDTO> result = new ArrayList<>();
        for (TrainingEO trainingEO : trainingList) {
            TrainingDTO dto = CopyUtils.copy(trainingEO, TrainingDTO.class);
            MentorSkillsEO skillEO = skillDAO.findById(dto.getId()).get();
            SkillDTO skillDTO = CopyUtils.copy(skillEO, SkillDTO.class);
            dto.setSkill(skillDTO);
            result.add(dto);
        }
        return result;
    }

    @Override
    public List<TrainingDTO> search(String title) {
        List<TrainingDTO> trainingDTOList = new ArrayList<>();
        List<TrainingEO> trainingEOList = trainingDAO.findByTitleLike("%"+title+"%");
        for (TrainingEO trainingEO : trainingEOList) {
            TrainingDTO trainingDTO = CopyUtils.copy(trainingEO, TrainingDTO.class);
            SkillDTO skillDTO = CopyUtils.copy(trainingEO.getSkill(), SkillDTO.class);
            trainingDTO.setSkill(skillDTO);
            trainingDTOList.add(trainingDTO);
        }
        return trainingDTOList;
    }
}
