package com.ams.train.oop1;

public class Aclass {

        public int public_field_Aclass = 1;

        protected int protected_field_Aclass = 1;

        int no_modifier_field_Aclass = 1;

        private int private_field_Aclass = 1;


        public Aclass(){
            this.public_field_Aclass = 0;
            this.protected_field_Aclass = 111;
            this.no_modifier_field_Aclass = 222;
            this.private_field_Aclass = 333;
        }
        protected Aclass(int a){
            this.public_field_Aclass = a;
            this.protected_field_Aclass = a;
            this.no_modifier_field_Aclass = a;
            this.private_field_Aclass = a;
        }


        protected int func_protected(){
            return protected_field_Aclass;
        }

        int func2_none(){
            return no_modifier_field_Aclass;
        }

        private int func3_private(){
            return private_field_Aclass;
        }
}
