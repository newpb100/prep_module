package com.ams.train.coffeeshop;

public enum DoughnutFactory {

    ALMOND {
        @Override
        public Doughnut createDoughnut() {
            return new Doughnut() {
                @Override
                public void setTopping() {
                    System.out.println("for Almond doughnut use caramel");
                }
                // метод, которого нет в интерфейсе (его не удастся вызвать никак..)
                public void eat(){
                    System.out.println("Very tasty almond doughnut!");
                }
            };
        }
    },
    CHERRY{
        @Override
        public Doughnut createDoughnut() {
            return new Doughnut() {
                @Override
                public void setTopping() {
                    System.out.println("for Cherry doughnut use powder");
                }
            };
        }
    },
    CHOCOLATE{
        @Override
        public Doughnut createDoughnut() {
            return new Doughnut() {
                @Override
                public void setTopping() {
                    System.out.println("for Chocolate doughnut use mint");
                }
            };
        }
    };

    abstract public Doughnut createDoughnut();
}
