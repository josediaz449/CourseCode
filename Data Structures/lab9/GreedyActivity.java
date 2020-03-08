package lab9;

import java.util.PriorityQueue;
import java.util.Scanner;

public class GreedyActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = 0;
		PriorityQueue<Activity> act = new PriorityQueue<Activity>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i<n;i++) {
			String name = in.next();
			double start = in.nextDouble();
			double finish = in.nextDouble();
			Activity activity = new Activity(name, start, finish);
			act.add(activity);
		}
		for(int i = 0; i<act.size();i++) {
			System.out.println(act.size());
			Activity act1 = act.poll();
			Activity act2 = act.peek();
			if(act1.getFinish()<=act2.getStart()) {
				System.out.println(act1.toString());
			}
		}
		double last_end = 0;

	}

}
