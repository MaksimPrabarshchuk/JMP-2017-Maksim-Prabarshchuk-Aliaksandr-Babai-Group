package com.github.alebabai.jmp2k17.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "jmp_role")
@Cacheable
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jmp_role_id_seq")
    @SequenceGenerator(name = "jmp_role_id_seq", sequenceName = "jmp_role_id_seq", allocationSize = 1)
    private Integer id;

    @NotNull(message = "Role name is required!")
    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
