import sun.plugin2.message.JavaScriptCallMessage;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

//模拟用户互相发送消息
public class Main {
    //主程序
    public static void main(String[] args) {
        Speaker speaker = new Speaker();

        new Thread(speaker,"speaker1").start();
        new Thread(speaker,"speaker2").start();
    }
}

    //说话者
    class Speaker implements Runnable{


        public Speaker() {
        }

        private final ReentrantLock lock = new ReentrantLock();
        @Override
        public void run() {
            String chat;
            try{
                lock.lock();
                System.out.print(Thread.currentThread().getName()+":");
                Scanner scanner = new Scanner(System.in);
                if(scanner.hasNextLine()){
                    chat = scanner.nextLine();
                    System.out.println(Thread.currentThread().getName()+":"+chat);
                }
            }
            finally {
                lock.unlock();
            }

        }
    }


