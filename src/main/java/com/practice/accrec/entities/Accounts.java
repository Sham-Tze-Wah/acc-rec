package com.practice.accrec.entities;

import com.practice.accrec.utils.Global;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false, exclude = {"role"})
@Entity
@Table(name = "accounts")
@Lazy
public class Accounts extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -77806658444851291L;

    @Column(name = "USERNAME", nullable = false, length = Global.VARCHAR30)
    private String username;

    @Column(name = "EMAIL", nullable = false, length = Global.VARCHAR100)
    private String email;

    private String password;

    private Date resetDate;

    private String resetToken;

    private Integer loginAttempt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Roles roles;

}
