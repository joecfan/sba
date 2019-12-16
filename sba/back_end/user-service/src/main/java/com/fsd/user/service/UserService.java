package com.fsd.user.service;


import com.fsd.common.dto.TrainingDTO;
import com.fsd.common.dto.UserDTO;

public interface UserService {

    UserDTO login(UserDTO userDTO);

    boolean save(UserDTO userDTO);

    boolean delete(Long id);

    boolean update(UserDTO userDTO);

    UserDTO findById(Long id);

    boolean book(UserDTO userDTO, TrainingDTO trainingDTO);
}
