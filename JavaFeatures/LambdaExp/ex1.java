package JavaFeatures.LambdaExp;

/*** Change the following anonymous Runnable class implementation to Lambda Expression: **/
 class DemoThreadMain {
    public static void main(String pars[]) {
//        Thread threadInstance = new Thread(new Runnable() {//run --- implementation
//            public void run() {
//                System.out.println(" Its me from thread");
//            }
//        });
    //with lambda
    Thread threadInstance = new Thread(()-> System.out.println("Its me From Thread using Lambda"));
        threadInstance.start();
    }
}

