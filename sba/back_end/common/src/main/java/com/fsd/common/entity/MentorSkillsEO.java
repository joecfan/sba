package com.fsd.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "mentorskills")
public class MentorSkillsEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mid;

    private String sid;

    private BigDecimal selfRating;

    private int yearsOfExperience;

    private String trainingsDelivered;

    private String facilitiesOffered;

    private String name;
}
