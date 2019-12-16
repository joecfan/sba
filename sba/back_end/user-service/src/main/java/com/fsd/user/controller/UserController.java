package com.fsd.user.controller;

import com.fsd.payment.service.PaymentService;
import com.fsd.training.service.TrainingService;
import com.fsd.user.service.UserService;
import com.fsd.common.dto.RespMsg;
import com.fsd.common.dto.TrainingDTO;
import com.fsd.common.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserService userService;

    @Autowired
    private TrainingService trainingService;

    @PostMapping("/logout")
    public RespMsg logout(HttpServletRequest request) {
        log.info("begin logout");
        RespMsg respMsg = new RespMsg();
        HttpSession session = request.getSession(true);
        session.setAttribute("user", null);
        respMsg.setCode("1003");
        respMsg.setStatus(true);
        respMsg.setMsg("logout successful.");
        return respMsg;
    }

    @PostMapping("/login")
    public RespMsg login(HttpServletRequest request, @RequestBody UserDTO userDTO) {
        log.info("begin login");
        RespMsg respMsg = new RespMsg();
        UserDTO user = userService.login(userDTO);
        if (null != user) {
            List<TrainingDTO> trainingDTOList = trainingService.findByUserId(user.getId());
            user.setTrainingList(trainingDTOList);
            respMsg.setCode("1001");
            respMsg.setStatus(true);
            respMsg.setData(user);
            respMsg.setMsg("login successful.");
        } else {
            respMsg.setCode("0001");
            respMsg.setMsg("no account info or wrong password.");
        }
        return respMsg;
    }

    @PostMapping("/register")
    public RespMsg register(HttpServletRequest request, @RequestBody UserDTO userDTO) {
        log.info("begin register");
        RespMsg respMsg = new RespMsg();
        if(userService.save(userDTO)) {
            respMsg.setCode("1002");
            respMsg.setStatus(true);
            respMsg.setMsg("register successful.");
        } else {
            respMsg.setCode("0002");
            respMsg.setMsg("register failure.");
        }
        return respMsg;
    }

}
