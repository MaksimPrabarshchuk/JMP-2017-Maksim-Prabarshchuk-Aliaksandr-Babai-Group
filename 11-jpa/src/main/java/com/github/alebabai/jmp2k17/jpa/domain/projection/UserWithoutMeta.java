package com.github.alebabai.jmp2k17.jpa.domain.projection;

import com.github.alebabai.jmp2k17.jpa.domain.Role;
import com.github.alebabai.jmp2k17.jpa.domain.User;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name = "without-meta", types = {User.class})
public interface UserWithoutMeta {
    String getName();

    Set<Role> getRoles();
}
