package com.ams.train.supply;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ClassWithFinalNonNullMembers {

    private final String finalStringObject;

    @NonNull
    private String nonNullStringObject;

    private String nonFinalStringObject;

    // standard getters
}
