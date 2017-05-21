package com.github.alebabai.jmp2k17.jpa.domain;

import com.github.alebabai.jmp2k17.jpa.converter.MetaConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(exclude = {"roles"})
@EqualsAndHashCode(exclude = {"roles"})
@Entity
@Table(name = "jmp_user")
@Cacheable
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jmp_user_id_seq")
    @SequenceGenerator(name = "jmp_user_id_seq", sequenceName = "jmp_user_id_seq", allocationSize = 1)
    private Integer id;

    @NotNull(message = "Name is required!")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "meta", nullable = false, columnDefinition = "jsonb")
    @Convert(converter = MetaConverter.class)
    private Meta meta;

    @ManyToMany
    @JoinTable(
            name = "jmp_user_role",
            joinColumns = {
                    @JoinColumn(name = "user_id", nullable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", nullable = false)
            }
    )
    private Set<Role> roles;
}
