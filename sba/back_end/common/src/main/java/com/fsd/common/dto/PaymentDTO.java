package com.fsd.common.dto;

import lombok.Data;

@Data
public class PaymentDTO {

    private Long id;

    private Float amount;

    private String remarks;

    private String trainingId;

    private String trainingName;

    private Long userId;

}
