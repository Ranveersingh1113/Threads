# Threads


This Java project illustrates the use of the `Runnable` interface to create and run multiple threads concurrently. Each thread prints a sequence of numbers, starting from a specified initial value, incrementing by a fixed step, and pausing for a given delay between prints.

---

## Project Structure

```
├── Main.java       # Launches the threads
└── MyThread.java   # Implements the Runnable logic
```

---

## Classes and Methods

### 1. MyThread Class

```java
public class MyThread implements Runnable {
    private int init;
    private int increment;
    private int delay;

    public MyThread(int init, int increment, int delay) {
        this.init = init;
        this.increment = increment;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (init < 1000) {  // Prevents infinite loop
            try {
                System.out.print(init + " ");
                init += increment;
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;  // Exit loop on interruption
            }
        }
    }
}
```

- **Fields**
  - `init` (int): Starting value.
  - `increment` (int): Value to add after each print.
  - `delay` (int): Milliseconds to sleep between prints.

- **Constructor**
  - `MyThread(int init, int increment, int delay)`: Initializes the fields.

- **run()**
  - Prints the current value of `init`, adds `increment`, then sleeps for `delay` ms.
  - Stops when `init` ≥ 1000 or if interrupted.

---

### 2. Main Class

```java
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread(1, 3, 3000));
        Thread t2 = new Thread(new MyThread(100, 50, 1000));

        t1.start();
        t2.start();
    }
}
```

- **main(String[] args)**
  - Creates two `Thread` objects, each with its own `MyThread` instance.
  - `t1`: starts at 1, increments by 3, 3000 ms delay.
  - `t2`: starts at 100, increments by 50, 1000 ms delay.
  - Starts both threads concurrently with `start()`.

---

## Execution Flow

1. `Main` initializes and starts `t1` and `t2`.
2. Threads run in parallel, printing numbers based on their parameters.
3. Outputs may interleave due to concurrent scheduling.
4. Each thread terminates when its counter reaches or exceeds 1000.

---

## Example Output

```
1 100 4 150 7 200 10 250 ...
```

*Actual order may vary.*

---


