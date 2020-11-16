/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgoritms;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author summe
 */
public class maintest {

    static int count = 1;

    public static void main(String[] args) {
        
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();

        Thread thread = new Thread() {
            @Override
            public void run() {
                
                reentrantLock.lock();
                System.out.println("thread 1");
                count++;
                newCondition.signalAll();
                reentrantLock.unlock();
            }

        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                reentrantLock.lock();
                while (count != 2) {
                    try {
                        System.out.println("2 wait");
                        newCondition.await();
                    } catch (InterruptedException ex) {
                    }
                }
                System.out.println("thread 2");
                count++;
                newCondition.signalAll();
                reentrantLock.unlock();
            }

        };
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                reentrantLock.lock();
                while (count != 3) {
                    try {
                        System.out.println("3 wait");
                        newCondition.await();
                    } catch (InterruptedException ex) {
                    }
                }
                
                System.out.println("thread 3");
                count++;
                reentrantLock.unlock();
            }

        };
        thread3.start();
        thread.start();
        thread2.start();

    }

}
