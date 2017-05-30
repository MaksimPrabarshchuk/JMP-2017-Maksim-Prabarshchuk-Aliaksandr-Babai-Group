package com.github.alebabai.jmp2k17.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Meta implements Serializable{
    private String data;
}
