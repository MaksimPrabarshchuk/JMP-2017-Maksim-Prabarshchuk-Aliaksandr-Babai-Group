package com.github.alebabai.ws.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Text {
    @NonNull
    private List<Verse> verses;
}
