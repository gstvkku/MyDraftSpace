package io.codeforall.kernelfc;

import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;

public class TodoList {

    private PriorityQueue<Task> priorityQueue;

    public TodoList() {
        this.priorityQueue = new PriorityQueue();
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    public void add(Importance importance, int priority, String description) {
        priorityQueue.add(new Task(importance, priority, description));
    }

    public String remove() {
        for (Task task : priorityQueue) {
            Task currentTask = (Task) task;

            for (Task task2 : priorityQueue) {
                Task currentTask2 = (Task) task2;

                if (currentTask.compareTo(currentTask2) == -1) {
                    priorityQueue.remove(currentTask2);
                    return currentTask2.toString();
                } else if (currentTask.compareTo(currentTask2) == 1) {
                    priorityQueue.remove(currentTask);
                    return currentTask.toString();
                }
                else {
                    continue;
                }
            }
        }
        return null;
    }

}
