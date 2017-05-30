package com.github.alebabai.jmp2k17.jpa.domain.projection;

import com.github.alebabai.jmp2k17.jpa.domain.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "min", types = {User.class})
public interface UserMin {
    String getName();
}
