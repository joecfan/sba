package com.fsd.common.dao;

import com.fsd.common.entity.PaymentEO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentDAO extends JpaRepository<PaymentEO, Long> {

    List<PaymentEO> findAllById(Long userId);

}
