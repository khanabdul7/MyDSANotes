package JavaFeatures.MultiThreading;

/**
 * Some Threads require to work in background, and they are called Daemon Threads.
 * */

class DaemonThread extends Thread{

    @Override
    public void run(){
        System.out.println("Inside Daemon Thread");
    }
}
class DaemonThreadDemo {
    public static void main(String[] args){
        DaemonThread d = new DaemonThread();
        d.setPriority(Thread.MAX_PRIORITY); // i.e: 10
        d.setDaemon(true);
        d.start();
        System.out.println(d.isDaemon());
    }
}
