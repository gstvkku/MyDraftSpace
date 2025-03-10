package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bqueue.BQueue;
import io.codeforall.bootcamp.bqueue.Pizza;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    public int getElementNum() {
        return elementNum;
    }

    public void setElementNum(int elementNum) {
        this.elementNum = elementNum;
    }

    @Override
    public void run() {
        while (elementNum > 0) {
            int currentQueueSize = this.queue.getQueue().size();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.queue.offer(new Pizza());
            elementNum--;
        }
    }
}


