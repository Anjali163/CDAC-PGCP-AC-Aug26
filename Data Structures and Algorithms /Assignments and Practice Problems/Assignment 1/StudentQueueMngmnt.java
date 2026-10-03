package dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentQueueMngmnt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Students> ar = new ArrayList<Students>();
		while (true) {
			System.out.println("Enter your choice: \n 1.Add Student to queue \n 2. Remove student from queue "
					+ "\n 3.Display current queue \n 4. Search student in the queue \n 5. Total students currently waiting");

			int choice = sc.nextInt();
			int studID;
			switch (choice) {
			case 1:
				System.out.println("Enter student id: ");
				studID = sc.nextInt();
				ar.add(new Students(studID));
				break;
			case 2:
				System.out.println("Student " + ar.remove(0).getStudentID() + " submits! ");
				break;
			case 3:
				System.out.print("Queue: [ ");
				for (Students a : ar) {
					System.out.print(a.getStudentID() + ",");
				}
				System.out.print(" ]");
				System.out.println();
				break;
			case 4:
				System.out.print("Enter student id: ");
				studID = sc.nextInt();
				for(Students s : ar) {
					if(s.getStudentID() == studID) {
						System.out.println("Student" +  studID + " is waiting.");
						break;
					}else {
						System.out.println("Student not present!");
					}
				}
				break;
			case 5:
				System.out.println("Current number of students: "+ ar.size());
				break;
			case 6:
				return;
			}

		}

	}

}

class Students {
	private int studentID;

	public Students(int studentID) {
		super();
		this.studentID = studentID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
}