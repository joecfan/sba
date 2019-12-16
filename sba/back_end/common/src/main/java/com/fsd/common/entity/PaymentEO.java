package com.fsd.common.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payment")
public class PaymentEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mentorIdd;

    private String trainingId;

    private String txnType;

    private Float amount;

    private String remarks;

}
