// Ranveer Singh
// 23070126102
// 23-27
class Main {
    public static void main(String[] args) {
        // Creating threads properly
        Thread t1 = new Thread(new MyThread(1, 3, 3000));
        Thread t2 = new Thread(new MyThread(100, 50, 1000));

        // Starting threads
        t1.start();
        t2.start();
    }
}
