package com.imagine.communications;

import java.util.UUID;

/**
 * Created by venkatesh.muthusamy on 5/5/2016.
 */
public class ThreadRunner {

    private static ConcurrentList<String> threadSafeCollection = new ConcurrentList<String>();
    public static void main(String[] args) {
        Runnable creator = new Runnable() {
            public void run() {

                if(threadSafeCollection.getSize()<5) {
                    threadSafeCollection.add(UUID.randomUUID().toString());
                }

                try{
                    Thread.sleep(10);
                }catch (InterruptedException ie) {
                    ie.printStackTrace();
                }

            }
        };

        Thread creatorThread = new Thread(creator, "thread1");
        Thread creatorThread2 = new Thread(creator,"thread2");
        creatorThread.run();
        creatorThread2.run();

    }
}
