package com.ams.train.supply;

public class CheckAbstractAndInterface {

    SampleInterface sampleInterface = new MyChildSampleAbstract() {
        @Override
        public int hashCode() {
            return super.hashCode();
        }
    };

}
