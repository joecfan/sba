package com.fsd.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "trainings")
public class TrainingEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String mentorId;

    private String status;

    private String progress;

    private BigDecimal rating;

    private Date startDate;

    private Date endDate;

    private Date startTime;

    private Date endTime;

    private BigDecimal amountReceived;

    private String title;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private MentorSkillsEO skill;

}
