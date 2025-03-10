package io.codeforall.bootcamp.bqueue;

import java.util.AbstractQueue;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Blocking Queue
 *
 * @param <Pizza> the type of elements stored by this queue
 */
public class BQueue<Pizza> {

    private LinkedTransferQueue queue;
    private int limit;

    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    public BQueue(int limit) {
        this.queue = new LinkedTransferQueue();
        this.limit = limit;
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param pizza the data to add to the queue
     */
    public synchronized void offer(Pizza pizza) {
        if (this.queue.size() < this.limit) {
            this.queue.offer(pizza);
            System.out.println(Thread.currentThread().getName() + " added a new pizza.");
            notifyAll();
            System.out.println(queue.size());
        } else {
            try {
                System.out.println("No more space for pizzas.");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */
    public synchronized Pizza poll() {
        if (!this.queue.isEmpty()) {
            Pizza consumedPizza = (Pizza) this.queue.poll();
            System.out.println(Thread.currentThread().getName() + " consumed a pizza.");
            System.out.println(queue.size());
            notifyAll();
            return consumedPizza;
        } else {
            try {
                System.out.println("There is no pizzas to be consumed.");
                wait();

            } catch (InterruptedException e) {
                System.out.println("Error");
            }
            return null;
        }
    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public LinkedTransferQueue getQueue() {
        return this.queue;
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {
        return this.limit;
    }
}

