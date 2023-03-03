public class Main {

    public static void main(String[] args) {

        Sample sm = new Sample("test string",1);

        //lombock
        String s = sm.getF1();
        sm.setA(100);

        System.out.println("f1 value = " + s);
        System.out.println("a value = " + sm.getA());

        sm.useOwnerToCreateCfg();

    }

}
