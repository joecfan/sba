package com.fsd.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String contactNumber;

    private Date regDatetime;

    private String regCode;

    private int forceResetPassword;

    private int active;


//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "id",foreignKey = @ForeignKey(name = "id"))
    @ManyToOne(targetEntity = RoleEO.class)
    @JoinColumn(name="role_id")
    private RoleEO role;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="user_training", joinColumns ={@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name="training_id")})
    private List<TrainingEO> trainingList;

    @Transient
    private List<PaymentEO> paymentList;

}
