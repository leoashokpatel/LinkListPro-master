import java.util.Scanner;

/***
 * Link class will have 1. data -> will hold int data 2. nextLink -> will
 * connect to next node
 * 
 * @author Ganesh
 *
 */

class Link {
	public int data;
	public Link nextLink;

	// Link constructor
	public Link(int data) {
		nextLink = null;
		this.data = data;
	}

	// Print Link data
	public void printLink() {
		System.out.print("{" + data + "} ");
	}
}

class LinkList {
	private Link first;
	private Link last;
	private Link secondlast;

	// LinkList constructor
	public LinkList() {
		first = null;
		last = null;
	}

	// Returns true if list is empty
	public boolean isEmpty() {
		return first == null;
	}

	// Inserts a new Link at the first of the list
	public void append(int data) {
		Link link = new Link(data);

		if (first == null) {
			link.nextLink = null;
			first = link;
			last = link;
		} else {
			secondlast = last;
			last.nextLink = link;
			link.nextLink = null;
			last = link;
		}

	}

	// Deletes the link at the first of the list
	public Link delete() {
		Link temp = first;
		System.out.println("first.data" + first.data);
		if (first == null) {
			return null;
		}
		first = first.nextLink;
		return temp;
	}

	// Deletes the link at the last of the list
	public Link deletelast() {
		Link temp = last;
		if (first == null) {
			return null;
		} else {
			Link prev = first;
			Link end = first.nextLink;
			while (end.nextLink != null) {
				prev = end;
				end = end.nextLink;
			}
			prev.nextLink = null;

		}
		return temp;
	}

	// Prints list data
	public void printList() {
		Link currentLink = first;
		System.out.print("List: ");
		while (currentLink != null) {
			currentLink.printLink();
			currentLink = currentLink.nextLink;
		}
		System.out.println("");
	}

	public boolean removeAll(int target) {

		if (first == null)

			if (first.data > target && first.nextLink == null)
				first = null;

		Link cur = first;
		Link prev = null;
		Link temp = null;

		while (cur != null && cur.data > target) {
			prev = cur;
			cur = cur.nextLink;
		}

		if (prev != null)
			prev.nextLink = null;

		Link newLink = cur;

		while (cur.nextLink != null) {
			if (cur.nextLink.data > target) {
				cur.nextLink = cur.nextLink.nextLink;

			} else {
				cur = cur.nextLink;
			}
		}

		first = newLink;

		return true;
	}
}

class LinkListTest {
	public static void main(String[] args) {
		LinkList list = new LinkList();
		Scanner input = new Scanner(System.in);
		int choice;
		list.append(10);
		list.append(20);
		list.append(30);
		list.append(40);
		list.append(50);
		do {
			System.out.println("\nEnter 1 for append data to linkedlist");
			System.out.println("\nEnter 2 for removing tail element from linkedlist");
			System.out.println("\nEnter 3 for removing the elements which are greater than the target value");
			System.out.println("\nEnter 4 for exit");
			choice = input.nextInt();
			switch (choice) {
			
			case 1:
				System.out.println("Enter new element :");
				int data = input.nextInt();
				list.append(data);
				list.printList();
				break;

			case 2:
				System.out.println("Removing last element from linked list : " + list.deletelast());
				list.printList();
				break;
				
			case 3:
				System.out.println("Enter target value");
				int target = input.nextInt();
				System.out.println("Removing elements greater than target value :" + list.removeAll(target));
				list.printList();
				break;
				
			case 4:
				System.exit(0);

			default:
				System.out.println("Invalid Choice");

			}

		} while (choice != 0);

	}
}