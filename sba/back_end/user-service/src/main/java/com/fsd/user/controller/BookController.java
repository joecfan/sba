package com.fsd.user.controller;

import com.fsd.user.service.UserService;
import com.fsd.common.dto.RespMsg;
import com.fsd.common.dto.TrainingDTO;
import com.fsd.common.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Slf4j
public class BookController {

    @Autowired
    private UserService userService;

    @PostMapping("book/{userId}/{trainingId}")
    public @ResponseBody
    RespMsg book(@PathVariable("userId") Long userId, @PathVariable("trainingId") Long trainingId) {
        log.info("begin book");
        RespMsg respMsg = new RespMsg();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userId);
        TrainingDTO trainingDTO = new TrainingDTO();
        trainingDTO.setId(trainingId);
        if(userService.book(userDTO, trainingDTO)) {
            respMsg.setCode("1009");
            respMsg.setStatus(true);
            respMsg.setMsg("book successful.");
        } else {
            respMsg.setCode("0009");
            respMsg.setMsg("book failure.");
        }
        return respMsg;
    }

}
