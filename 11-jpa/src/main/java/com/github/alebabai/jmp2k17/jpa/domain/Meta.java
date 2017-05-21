package com.github.alebabai.jmp2k17.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Meta {
    private String data;
}
