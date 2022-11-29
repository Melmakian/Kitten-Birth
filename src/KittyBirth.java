public class KittyBirth {
    public static void main(String[] args) {
        Cat catOne = new Cat("Murka");
        Cat catTwo = new Cat("Fluff");
    }
    public static class Cat extends Thread{
        protected Kitten kittenOne;
        protected Kitten kittenTwo;
        public Cat(String name){
            super(name);
            kittenOne = new Kitten("Kitten One, mother - " + getName());
            kittenTwo = new Kitten("Kitten Two, mother - " + getName());
            start();
        }

        @Override
        public void run() {
            System.out.println(getName() + " gave birth two kitten");
            try {
                initAllKitten();
            }catch (InterruptedException e){

            }
            System.out.println(getName()+": All kitten into the basket. "+getName()+" collected them back");
        }
        private void initAllKitten()throws InterruptedException{
            kittenOne.start();
            kittenOne.join();
            kittenTwo.start();
            kittenTwo.join();
        }
    }
    public static class Kitten extends Thread{
        public Kitten(String name){
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName()+ " got out of the basket");
            investigateWorld();
        }
    }
    public static void investigateWorld(){
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e){

        }
    }
}
