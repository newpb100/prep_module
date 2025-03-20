package com.ams.train.abstr;

import com.ams.train.supply.SampleInterface;

public class CheckAbstractAndInterface {

    SampleInterface sampleInterface = new MyChildSampleAbstract() {

        @Override
        public void doSomethingInInterface2() {

        }

        @Override
        public void doSomething1() {

        }

        @Override
        public void doSomething2() {

        }
    };

}
