package com.fsd.payment.service.impl;

import com.fsd.payment.service.PaymentService;
import com.fsd.common.dao.PaymentDAO;
import com.fsd.common.dto.PaymentDTO;
import com.fsd.common.entity.PaymentEO;
import com.fsd.common.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDAO paymentDAO;

    @Override
    public boolean save(PaymentDTO paymentDTO) {
        PaymentEO paymentEO = CopyUtils.copy(paymentDTO, PaymentEO.class);
        paymentEO.setId(null);
        paymentDAO.save(paymentEO);
        if(null != paymentEO.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        paymentDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean update(PaymentDTO paymentDTO) {
        PaymentEO paymentEO = CopyUtils.copy(paymentDTO, PaymentEO.class);
        paymentDAO.save(paymentEO);
        return true;
    }

    @Override
    public PaymentDTO findById(Long id) {
        PaymentEO paymentEO = paymentDAO.findById(id).get();
        PaymentDTO paymentDTO = CopyUtils.copy(paymentEO, PaymentDTO.class);
        return paymentDTO;
    }

    @Override
    public List<PaymentDTO> findByUserId(Long userId) {
        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        List<PaymentEO> paymentEOList = paymentDAO.findAllById(userId);
        for (PaymentEO paymentEO : paymentEOList) {
            PaymentDTO paymentDTO = CopyUtils.copy(paymentEO, PaymentDTO.class);
            paymentDTOList.add(paymentDTO);
        }
        return paymentDTOList;
    }

}
