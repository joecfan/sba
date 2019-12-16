package com.fsd.user.service.impl;

import com.fsd.payment.service.PaymentService;
import com.fsd.user.service.UserService;
import com.fsd.common.dao.TrainingDAO;
import com.fsd.common.dao.UserDAO;
import com.fsd.common.dto.TrainingDTO;
import com.fsd.common.dto.UserDTO;
import com.fsd.common.entity.RoleEO;
import com.fsd.common.entity.TrainingEO;
import com.fsd.common.entity.UserEO;
import com.fsd.common.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TrainingDAO trainingDAO;

    @Autowired
    private PaymentService paymentService;

    @Override
    public UserDTO login(UserDTO userDTO) {
        UserEO userEO = userDAO.findByUserName(userDTO.getUsername());
        if (null != userEO && userEO.getPassword().equals(userDTO.getPassword())) {
            UserDTO result = CopyUtils.copy(userEO, UserDTO.class);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public boolean save(UserDTO userDTO) {
        UserEO userEO = CopyUtils.copy(userDTO, UserEO.class);
        userEO.setId(null);
        RoleEO role = CopyUtils.copy(userDTO.getRole(), RoleEO.class);
        userEO.setRole(role);
        userDAO.save(userEO);
        if (null != userEO.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        userDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean update(UserDTO userDTO) {
        UserEO userEO = CopyUtils.copy(userDTO, UserEO.class);
        RoleEO role = CopyUtils.copy(userDTO.getRole(), RoleEO.class);
        userEO.setRole(role);
        userDAO.save(userEO);
        return true;
    }

    @Override
    public UserDTO findById(Long id) {
        UserEO userEO = userDAO.findById(id).get();
        UserDTO userDTO = CopyUtils.copy(userEO, UserDTO.class);
        return userDTO;
    }

    @Override
    public boolean book(UserDTO userDTO, TrainingDTO trainingDTO) {
        try {
            UserEO userEO = userDAO.findById(userDTO.getId()).get();
            TrainingEO trainingEO = trainingDAO.findById(trainingDTO.getId()).get();
            userEO.getTrainingList().add(trainingEO);
            userDAO.save(userEO);
            return true;
        }catch (ConstraintViolationException e) {
            return false;
        } catch (RuntimeException e) {
            return false;
        }
    }

}
