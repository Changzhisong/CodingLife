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
		
		//������������޸�
		ArrayDeque<Node> stack =new ArrayDeque<>(); 
		//����߽�ȫ��ѹ��ջ��
		while(node!=null){
			stack.push(node);
			node=node.left;
		}
		Node preNode = null;
		while(!stack.isEmpty()){		
			Node cur = stack.pop();		
			//���������ӡ�ڵ�
//			System.out.print(cur.value+"++");
			
			//�����������ӡ��ǰ�ڵ�ʱ���ı�ڵ��ָ��
			if(preNode!=null){
				preNode.right=cur;
				cur.left= preNode;
			}
			preNode =cur;
			
			node =cur.right;//����������߽�
			//���������ı߽�ȫ��ѹ��ջ��
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
			
		}
		
		//����жϽ���Ƿ���ȷ  �Ӻ���ǰ��ӡ
		System.out.println();
		System.out.print(preNode.value+"==");
		while (preNode.left!=null){
			System.out.print(preNode.left.value+"==");
			preNode=preNode.left;
		}
		//��ǰ�����ӡ
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
/*	������	
					      5
			  2		       		      7
		 1        4     		  6	        8
    null null   3 null       null null   null null 
*/		
		BTtoLink(node);
	}

}
