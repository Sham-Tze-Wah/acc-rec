package com.practice.accrec.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false, exclude = {"accounts"})
@Entity
@Table(name = "ROLES")
@Lazy
public class Roles extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -315919384999465060L;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    @JsonIgnore
    private Set<Accounts> accounts = new HashSet<>();
}
