package com.swwan.research.demo.retry;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author swwan
 * @date 2022/3/7 - 14:16
 */
public class Test02 {

    // 最大缓存数量
    private final int CAPACITY = 10;

    // 总量
    private final int MAX_NUMBER = 200;

    // 已生产的数量
    volatile AtomicInteger productNum = new AtomicInteger(0);

    // 已消费的数量
    volatile AtomicInteger comsumedNum = new AtomicInteger(0);

    // 同步阻塞队列
    private LinkedBlockingQueue<NumberObject> queue = new LinkedBlockingQueue(CAPACITY);

    public static void main(String[] args) {

        Test02 test02 = new Test02();

        Consumer consumer = test02.new Consumer();
        Producer producer = test02.new Producer();

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 60, TimeUnit.MICROSECONDS, queue);

        pool.execute(consumer);
        pool.execute(consumer);
        pool.execute(consumer);

        pool.execute(producer);

        pool.shutdown();

    }

    public class NumberObject {
        private Integer num;

        public NumberObject(Integer num) {
            this.num = num;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }

    public class Consumer implements Runnable {
        @Override
        public void run() {
            while (comsumedNum.getAndIncrement() < MAX_NUMBER) {
                try {
                    NumberObject num = queue.take();
                    System.out.println("receive number:" + num.getNum());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    int index = productNum.getAndIncrement();
                    if (index > MAX_NUMBER) {
                        break;
                    }
                    queue.put(new NumberObject(index));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
