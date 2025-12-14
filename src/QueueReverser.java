import java.util.*;

public class QueueReverser {
    public static <T> void printQueueReversed(Queue<T> queue) {
        if (queue == null || queue.isEmpty()) {
            System.out.println("Очередь пуста");
            return;
        }

        Stack<T> stack = new Stack<>();
        Queue<T> tempQueue = new LinkedList<>(queue);

        while (!tempQueue.isEmpty()) {
            stack.push(tempQueue.poll());
        }

        System.out.print("В обратном порядке: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}