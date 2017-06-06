package com.github.alebabai.jmp2k17.jpa.domain;

import com.github.alebabai.jmp2k17.jpa.converter.MetaConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(exclude = {"roles"})
@EqualsAndHashCode(exclude = {"roles"})
@Entity
@Table(name = "jmp_user")
////@Cache(region = "role", usage = READ_WRITE)
//@Cacheable
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jmp_user_id_seq")
    @SequenceGenerator(name = "jmp_user_id_seq", sequenceName = "jmp_user_id_seq", allocationSize = 1)
    private Integer id;

    @NotNull(message = "Name is required!")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @RestResource(path = "meta", rel = "meta")
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
