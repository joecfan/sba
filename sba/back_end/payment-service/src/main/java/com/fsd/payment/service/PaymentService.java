package com.fsd.payment.service;



import com.fsd.common.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    boolean save(PaymentDTO paymentDTO);

    boolean delete(Long id);

    boolean update(PaymentDTO paymentDTO);

    PaymentDTO findById(Long id);

    List<PaymentDTO> findByUserId(Long userId);

}
