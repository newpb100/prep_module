package com.ams.train;

import com.ams.train.supply.CloneableRabbit;

public class Step37CloneObjects {

    public static void main(String[] args) {

        CloneableRabbit fakeCloneRabbit;

        CloneableRabbit originalRabbit = new CloneableRabbit();
        originalRabbit.printObjectHash();

        fakeCloneRabbit = originalRabbit;
        fakeCloneRabbit.printObjectHash();

        CloneableRabbit cloneRabbit = (CloneableRabbit) originalRabbit.clone();
        cloneRabbit.printObjectHash();
    }
}
