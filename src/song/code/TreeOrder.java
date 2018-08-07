package song.code;
import java.util.ArrayDeque;


public class TreeOrder {
	static class Node{
		public Node left=null;
		public Node right= null;
		int value =0;
		public Node(int val){
			this.value =val;
		}
	}
	public static void preOrderRec(Node head){
		
		if(head==null){
			return ;
		}
		System.out.print (head.value+" ");
		preOrderRec(head.left);
		preOrderRec(head.right);
		
	}
	
	public static void preOrderUnrec(Node head){
		if(head==null){
			return ;
		}
		ArrayDeque<Node> stack = new ArrayDeque<>();
		stack.push(head);
		while(!stack.isEmpty()){
			Node temp=stack.pop();
			System.out.print(temp.value+" ");
			
			if(temp.right!=null){
				stack.push(temp.right);
			}
			if(temp.left!=null){
				stack.push(temp.left);
			}
			
		}
	}
	
	
	public static void inOrderRec(Node head){
		if(head==null){
			return ;
		}

		inOrderRec(head.left);
		System.out.print (head.value+" ");
		inOrderRec(head.right);
		
	}
	public static void inOrderUnrec(Node head){
		if(head==null){
			return ;
		}
		ArrayDeque<Node> stack =new ArrayDeque<Node>();
		while(head!=null){
			stack.push(head);
			head=head.left;
		}
		while(!stack.isEmpty()){
			Node temp =stack.pop();
			System.out.print(temp.value+" ");
			Node tr =temp.right;
			while(tr!=null){
				stack.push(tr);
				tr=tr.left;
			}
			
		}
	}
	
	
	public static void posOrderRec(Node head){
		if(head==null){
			return ;
		}

		posOrderRec(head.left);
		posOrderRec(head.right);
		System.out.print (head.value+" ");
		
	}
	public static void posOrderUnrec(Node head){
		if(head==null){
			return ;
		}
		
		ArrayDeque<Node> stack1 = new ArrayDeque<>();
		ArrayDeque<Node> stack2 = new ArrayDeque<>();
		stack1.add(head);
		while(!stack1.isEmpty()){
			Node temp = stack1.pop();
			stack2.push(temp);
			if(temp.left!=null){
				stack1.push(temp.left);
			}
			if(temp.right!=null){
				stack1.push(temp.right);
			}
			
		}	
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop().value+" ");
		}
		
	}
	

	public static void main(String[] args) {

		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);
		
		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRec(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRec(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRec(head);
		System.out.println();

		// unrecursive
		System.out.println("============unrecursive=============");
		preOrderUnrec(head);
		System.out.println();
		inOrderUnrec(head);
		System.out.println();
		posOrderUnrec(head);
//		posOrderUnRecur2(head);

	}

}
