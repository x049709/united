package allchapters;

import java.util.ArrayDeque;
import java.util.Queue;

public class EdQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Deque");
		new ADeque().printList();
		System.out.println("Stack");
		new AStack().printList();

	}

}

class ADeque {

	public void printList() {
		Queue<Integer> qI = new ArrayDeque<>();
		System.out.println(qI.offer(10));
		System.out.println(qI.offer(4));
		System.out.println(qI.offer(45));
		System.out.println(qI.peek());
		System.out.println(qI.poll());
		System.out.println(qI.poll());
		System.out.println(qI.peek());
		System.out.println(qI.poll());
		System.out.println(qI.offer(456));
		System.out.println(qI.poll());
	}
}
class AStack {

	public void printList() {
		ArrayDeque<Integer> qI = new ArrayDeque<>();
		qI.offer(25);
		qI.push(256);
		qI.push(2567);
		System.out.println(qI.peek());
		System.out.println(qI.poll());
		System.out.println(qI.pop());
		System.out.println(qI.pop());
		//System.out.println(qI.pop()); will cause exception - no more entries
		System.out.println(qI.offer(456));
		System.out.println(qI.poll());
	}
}
