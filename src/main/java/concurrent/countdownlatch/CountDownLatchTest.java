package concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch judge = new CountDownLatch(1);
        CountDownLatch sprinters = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {

            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println("选手" + Thread.currentThread().getName() + "正在等待裁判发布口令");
                        judge.await();

                        System.out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令，正在冲刺。。。");
                        double score = Math.random() * 10000;
                        Thread.sleep((long) score);
                        System.out.println("选手" + Thread.currentThread().getName() + "到达终点，用时：" + score);
                        sprinters.countDown();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            };

            executorService.execute(runnable);
        }

        try {
            Thread.sleep(1000);
            System.out.println("------------------------------所有选手都已准备好--------------------------------------");
            System.out.println("裁判" + Thread.currentThread().getName() + "即将发布口令");
            judge.countDown();
            System.out.println("裁判" + Thread.currentThread().getName() + "已发送口令，正在等待所有选手到达终点");
            sprinters.await();

            System.out.println("所有选手都到达终点");
            System.out.println("裁判" + Thread.currentThread().getName() + "汇总成绩排名");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean terminated = executorService.isTerminated();
        System.out.println(terminated + "------------------------------");
        executorService.shutdown();

    }

}
