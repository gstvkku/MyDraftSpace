package io.codeforall.kernelfc;

public class Task implements Comparable {
    private Importance importance;
    private int priority;
    private String description;

    public Task(Importance importance, int priority, String description) {
        this.description = description;
        this.importance = importance;
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        Task task = (Task) o;

        if (this.importance.compareTo(task.importance) == 0) {
            if (this.priority > task.priority) {
                return 1;
            }
            return -1;
        }

        if (this.importance.compareTo(task.importance) == -1) {
            return -1;
        }

        if (this.importance.compareTo(task.importance) == 1) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return description;
    }
}
