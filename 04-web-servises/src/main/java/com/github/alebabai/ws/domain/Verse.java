package com.github.alebabai.ws.domain;


import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors
public class Verse {
    @NonNull
    private List<Quote> quotes;
}
