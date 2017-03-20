package com.github.alebabai.ws.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Quote {
    @NonNull
    private String phrase;
}
