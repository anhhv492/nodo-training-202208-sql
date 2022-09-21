package thread;

public class PrintNumber implements Runnable{

    private int number =1;
    private boolean alive=true;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

//    @Override
//    public void run() {
//        Thread current = Thread.currentThread();
//        while (alive){
//            number++;
//            System.out.println(current.getName()+"number is\""+number+"\"");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(current.getName()+"is stoped!");
//        }
//    }
//    @Override
//    public void run() {
//        Thread current = Thread.currentThread();
//        while (number<10){
//            number++;
//            System.out.println(current.getName()+"number is\""+number+"\"");
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println(current.getName()+"is stoped!");
//    }
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (number<30){
            number++;
            try {
                System.out.println(current.getName()+"number is\""+number+"\"");
                Thread.sleep(300);
                if (number%10==0){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(current.getName()+"is stopped");
    }
}
