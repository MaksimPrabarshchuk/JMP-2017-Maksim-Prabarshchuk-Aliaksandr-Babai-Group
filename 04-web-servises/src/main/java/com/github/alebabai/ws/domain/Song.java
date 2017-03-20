package com.github.alebabai.ws.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(of = {"id"})
@Accessors(chain = true)
public class Song {
    @NonNull
    private Long id;

    @NonNull
    private Text text;
}
