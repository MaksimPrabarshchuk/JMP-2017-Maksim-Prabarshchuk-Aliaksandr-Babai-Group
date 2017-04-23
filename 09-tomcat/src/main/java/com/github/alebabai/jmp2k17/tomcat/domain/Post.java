package com.github.alebabai.jmp2k17.tomcat.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_seq")
    @SequenceGenerator(name = "post_id_seq", sequenceName = "post_id_seq", allocationSize = 1)
    @JsonIgnore
    private Integer id;

    @Column(name = "text", nullable = false)
    private String text;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    @JsonIgnore
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    @JsonIgnore
    private Date updatedAt;
}
