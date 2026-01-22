package com.ams.train.supply;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ClassWithFinalMembers {

    private String stringObjectNonFinal;    // не будет инициализироваться @RequiredArgsConstructor

    private final String stringObject;
}
