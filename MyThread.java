class MyThread implements Runnable {
    private int init;
    private int increment;
    private int delay;

    public MyThread(int init, int increment, int delay) {
        this.init = init;
        this.increment = increment;
        this.delay = delay;
    }

    public void run() {
        while (init < 1000) {  // Prevents infinite loop (Change condition as needed)
            try {
                System.out.println(init + " ");
                init += increment;
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;  // Exit loop if an exception occurs
            }
        }
    }
}
