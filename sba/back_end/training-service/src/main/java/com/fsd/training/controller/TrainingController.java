package com.fsd.training.controller;

import com.fsd.training.service.TrainingService;
import com.fsd.common.dao.UserDAO;
import com.fsd.common.dto.RespMsg;
import com.fsd.common.dto.TrainingDTO;
import com.fsd.common.entity.TrainingEO;
import com.fsd.common.entity.UserEO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
@Slf4j
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("search/{userId}")
    public @ResponseBody
    RespMsg search(@PathVariable Long userId, @RequestBody TrainingDTO trainingDTO) {
        log.info("begin search");
        RespMsg respMsg = new RespMsg();
        List<TrainingDTO> trainingDTOList = trainingService.search(trainingDTO.getTitle());
        UserEO userEO = userDAO.findById(userId).get();
        List<TrainingEO> trainingEOList = userEO.getTrainingList();
        for (TrainingDTO training : trainingDTOList) {
            for (TrainingEO trainingEO : trainingEOList) {
                if (training.getId().longValue() == trainingEO.getId().longValue()) {
                    training.setBook(true);
                }
            }
        }
        respMsg.setCode("1201");
        respMsg.setStatus(true);
        respMsg.setData(trainingDTOList);
        respMsg.setMsg("search successful.");
        return respMsg;
    }

    @RequestMapping("findById/{id}")
    public RespMsg findById(@PathVariable("id") Long id) {
        log.info("begin findById");
        RespMsg respMsg = new RespMsg();
        TrainingDTO training = trainingService.findById(id);
        respMsg.setCode("1205");
        respMsg.setStatus(true);
        respMsg.setData(training);
        respMsg.setMsg("find successful.");
        return respMsg;
    }

    @RequestMapping("findById/{userId}")
    public RespMsg findByUserId(@PathVariable("userId") Long userId) {
        log.info("begin findById");
        RespMsg respMsg = new RespMsg();
        List<TrainingDTO> trainingList = trainingService.findByUserId(userId);
        respMsg.setCode("1206");
        respMsg.setStatus(true);
        respMsg.setData(trainingList);
        respMsg.setMsg("find successful.");
        return respMsg;
    }

    @RequestMapping("save")
    public @ResponseBody
    RespMsg save(@RequestBody TrainingDTO trainingDTO) {
        log.info("begin save");
        RespMsg respMsg = new RespMsg();
        if(trainingService.save(trainingDTO)) {
            respMsg.setCode("1202");
            respMsg.setStatus(true);
            respMsg.setMsg("save successful.");
        } else {
            respMsg.setCode("0202");
            respMsg.setMsg("save failure.");
        }
        return respMsg;
    }



    @RequestMapping("update")
    public @ResponseBody
    RespMsg update(@RequestBody TrainingDTO trainingDTO) {
        log.info("begin update");
        RespMsg respMsg = new RespMsg();
        if(trainingService.update(trainingDTO)) {
            respMsg.setCode("1203");
            respMsg.setStatus(true);
            respMsg.setMsg("update successful.");
        } else {
            respMsg.setCode("0203");
            respMsg.setStatus(false);
            respMsg.setMsg("update failure.");
        }
        return respMsg;
    }

    @RequestMapping("delete")
    public @ResponseBody
    RespMsg delete(@RequestBody TrainingDTO trainingDTO) {
        log.info("begin delete");
        RespMsg respMsg = new RespMsg();
        if(trainingService.delete(trainingDTO.getId())) {
            respMsg.setCode("1204");
            respMsg.setStatus(true);
            respMsg.setMsg("delete successful.");
        } else {
            respMsg.setCode("0204");
            respMsg.setMsg("delete failure.");
        }
        return respMsg;
    }

}
