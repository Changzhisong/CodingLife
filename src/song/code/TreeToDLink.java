package song.code;

import java.util.ArrayDeque;

public class TreeToDLink {
	public static class Node{
		int value ;
		Node left;
		Node right;
		
		public Node(int val){
			this.value=val;
		}
	}
	

	public static void BTtoLink(Node head){
		if (head == null){
			return;
		}
		
		Node node =head;
		
		//按照中序遍历修改
		ArrayDeque<Node> stack =new ArrayDeque<>(); 
		//将左边界全部压入栈中
		while(node!=null){
			stack.push(node);
			node=node.left;
		}
		Node preNode = null;
		while(!stack.isEmpty()){		
			Node cur = stack.pop();		
			//中序遍历打印节点
//			System.out.print(cur.value+"++");
			
			//在中序遍历打印当前节点时，改变节点的指针
			if(preNode!=null){
				preNode.right=cur;
				cur.left= preNode;
			}
			preNode =cur;
			
			node =cur.right;//右子树的左边界
			//将右子树的边界全部压入栈中
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
			
		}
		
		//输出判断结果是否正确  从后往前打印
		System.out.println();
		System.out.print(preNode.value+"==");
		while (preNode.left!=null){
			System.out.print(preNode.left.value+"==");
			preNode=preNode.left;
		}
		//从前往后打印
		System.out.println();
		while(preNode!=null){
			System.out.print(preNode.value+"--");
			preNode = preNode.right;
		}
		
	}
	

	
	public static void main(String[] args) {
		
		Node node =new Node(5);
		node.left =new Node(2);
		node.left.left = new Node (1);
		node.left.right = new Node(4);
		node.left.right.left = new Node(3);
		node.right=new Node(7);
		node.right.left = new Node (6);
		node.right.right = new Node(8);
/*	二叉树	
					      5
			  2		       		      7
		 1        4     		  6	        8
    null null   3 null       null null   null null 
*/		
		BTtoLink(node);
	}

}
