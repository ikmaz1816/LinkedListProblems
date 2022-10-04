package linkedListProblems;

import java.util.*;

class Node
{
	int data;
	Node next;
	Node random;
	Node bottom;
	public Node(int data)
	{
		this.data=data;
	}
}
public class Linkedlist {
		public Node head;
		public Node tail;
		private int size;
		
		public Linkedlist()
		{
			this.size=0;
		}
		public int size()
		{
			return this.size;
		}
		public boolean isEmpty()
		{
			return this.size==0;
		}
		public void add(int value)
		{
			Node n=new Node(value);
			if(head==null)
			{
				head=n;
				tail=n;
			}
			else
			{
				tail.next=n;
				tail=n;
			}
			size++;
		}
		public void addFirst(int value)
		{
			size++;
			Node n=new Node(value);
			if(head==null)
			{
				head=n;
				tail=n;
				return;
			}
			n.next=head;
			head=n;
			
			
		}
		public void addLast(int value)
		{
			size++;
			Node n=new Node(value);
			if(head==null)
			{
				head=n;
				tail=n;
				return;
			}
			tail.next=n;
			tail=n;
			size++;
		}
		public void add(int value,int index)
		{
			if(index==0)
			{
				addFirst(value);
				return;
			}
			if(index==size-1)
			{
				addLast(value);
				return;
			}
			Node temp=get(index);
			Node n=new Node(value);
			n.next=temp.next;
			temp.next=n;
			size++;
			
		}
		public void deleteFirst()
		{
			if(head!=null)
			{
				head=head.next;
				size--;
			}
		}
		public void delete(int value)
		{
			Node temp=get(value);
			if(temp==null)
				return;
			if(temp.next!=null)
			{
				temp.next=temp.next.next;
				size--;
			}
		}
		public void delete1(int index)
		{
			Node temp=get(index);
			if(temp==null)
				return;
			if(temp.next!=null)
			{
			temp.next=temp.next.next;
			size--;
			}
		}
		public Node get(int value)
		{
			Node temp=head;
			while(!(temp.next.data==value))
			{
				temp=temp.next;
			}
			return temp;
		}
		public Node get1(int index)
		{
			Node temp=head;
			for(int i=1;i<index;i++)
			{
				temp=temp.next;
			}
			return temp;
		}
		public Node getindex(int index)
		{
			Node temp=head;
			for(int i=1;i<=index;i++)
			{
				temp=temp.next;
			}
			return temp;
		}
		public void deleteLast()
		{
			Node temp=get(size-2);
			if(size<1)
				return;
			temp.next=null;
			tail=temp;
			size--;
		}
		public void print()
		{
			Node temp=head;
			while(temp.next!=null)
			{
				System.out.print(temp.data+"->");
				temp=temp.next;
			}
			System.out.println(temp.data);
		}
		public void print(Node node)
		{
			Node temp=head;
			while(temp.next!=null)
			{
				System.out.print(temp.data+"->");
				temp=temp.next;
			}
			System.out.println(temp.data);
		}
		public Node insertRecursion(int index,int value,Node node)
		{
			if(index==0)
			{
				Node n=new Node(value);
				n.next=node;
				return n;
			}
			node.next=insertRecursion(index-1,value,node.next);
			return node;
		}
		public Node deleteRecursion(int index,Node node)
		{
			if(index==0)
			{
				if(node.next!=null)
				{
					return node.next;
				}
				return null;
			}
			node.next=deleteRecursion(index-1,node.next);
			return node;
		}
		public void removeDuplicates(Node node)
		{
			if(node==null || node.next==null)
				return;
			Node temp=node;
			while(temp!=null && temp.next!=null)
			{
				if(temp.data==temp.next.data)
				{
					temp.next=temp.next.next;
				}
				else
				{
					temp=temp.next;
				}
			}
		}
		public static Node merge(Node first,Node second)
		{
			Node dummyNode=new Node(-1);
			Node tail=dummyNode;
			while(first!=null && second!=null)
			{
				if(first.data>second.data)
				{
					tail.next=second;
					second=second.next;
					tail=tail.next;
				}
				else
				{
					tail.next=first;
					first=first.next;
					tail=tail.next;
				}
			}
			tail.next= first==null ? second: first;
			return dummyNode.next;
		}
		public boolean hasCycle(Node node)
		{
			Node s=node;
			Node f=node;
			while(f!=null && f.next!=null)
			{
				s=s.next;
				f=f.next.next;
				if(s.equals(f))
					return true;
			}
			return false;
		}
		public int lengthOfCycle(Node node)
		{
			if(node==null || node.next==null)
				return -1;
			Node s=node;
			Node f=node;
			int length=0;
			while(f!=null && f.next!=null)
			{
				s=s.next;
				f=f.next.next;
				if(s==f)
				{
					Node temp=s;
					do
					{
						temp=temp.next;
						length++;
					}while(temp!=s);
					break;
				}
			}
			if(length==0)
				return -1;
			return length;
		}
		public int findStartPointerOfLL(Node node)
		{
			if(node==null || node.next==null)
				return -1;
			Node s=node;
			Node f=node;
			while(f!=null && f.next!=null)
			{
				f=f.next.next;
				s=s.next;
				if(s==f)
				{
					Node temp=s;
					do
					{
						temp=temp.next;
					}while(temp!=s);
					break;
				}
			}
			Node temp1=head;
			while(temp1.equals(s))
			{
				s=s.next;
				temp1=temp1.next;
			}
			return s.data;
		}
		public Node middleOfLinkedList(Node node)
		{
			if(node==null || node.next==null)
				return node;
			Node s=node;
			Node f=node;
			while(f!=null && f.next!=null)
			{
				f=f.next.next;
				s=s.next;
			}
			return s;
		}
		public Node reverse(Node node)
		{
			if(node==null || node.next==null)
				return node;
			Node prev=null;
			Node current=node;
			Node next=current.next;
			while(current!=null)
			{
				current.next=prev;
				prev=current;
				current=next;
				if(next!=null)
					next=next.next;
			}
			return prev;
		}
		public void reverseRecursion(Node node)
		{
			if(node.next==null)
			{
				head=tail;
				return;
			}
			reverseRecursion(node.next);
			tail.next=node;
			tail=node;
			tail.next=null;
		}
		public void bubbleSort(Node n)
		{
			for(int i=0;i<size-1;i++)
			{
				boolean isSorted=false;
				for(int j=0;j<size-1-i;j++)
				{
					Node f=getindex(j);
					Node s=getindex(j+1);
					if(f.data>s.data)
					{
						isSorted=true;
						int temp=f.data;
						f.data=s.data;
						s.data=temp;
					}
				}
				if(!isSorted)
					return;
			}
		}
		public void bubblesort(Node node)
		{
			for(int i=0;i<size-1;i++)
			{
				boolean isSorted=false;
				for(int j=0;j<size-1-i;j++)
				{
					Node f=getindex(j);
					Node s=getindex(j+1);
					if(f.data>s.data)
					{
						isSorted=true;
						if(f==head)
						{
							f.next=s.next;
							s.next=f;
							head=s;
						}
						else if(s==tail)
						{
							Node prev=getindex(j-1);
							prev.next=f.next;
							s.next=f;
							f.next=null;
							tail=f;
						}
						else
						{
							Node prev=getindex(j-1);
							prev.next=f.next;
							f.next=s.next;
							s.next=f;
						}
					}
				}
				if(!isSorted)
					return;
			}
		}
		public Node midprev(Node node)
		{
			Node s=node;
			Node f=node;
			Node midprev=null;
			while(f!=null && f.next!=null)
			{
				midprev =s;
				s=s.next;
				f=f.next.next;
			}
			Node mid=midprev.next;
			midprev.next=null;
			return mid;
		}
		public Node mergeSort(Node head)
		{
			if(head==null || head.next==null)
				return head;
			Node mid=midprev(head);
			Node left=mergeSort(head);
			Node right=mergeSort(mid);
			return merge(left,right);
		}
		public void reverseCertainPart(int left,int right,Node node)
		{
			Node prev=null;
			Node current=node;
			for(int i=0;i<left-1;i++)
			{
				prev=current;
				current=current.next;
			}
			Node connector=prev;
			Node newEnd=current;
			Node next=current.next;
			for(int i=0;i<right-left+1;i++)
			{
				current.next=prev;
				prev=current;
				current=next;
				if(next!=null)
					next=next.next;
			}
			if(connector!=null)
			{
				connector.next=prev;
			}
			else
				head=prev;
			
			newEnd.next=current;
		}
		public void reverseGroup(Node node,int k)
		{
			Node prev=null;
			Node current=node;
			while(true)
			{
				Node connector=prev;
				Node newEnd=current;
				Node next=null;
				if(current!=null)
					next=current.next;
				for(int i=0;current!=null && i<k;i++)
				{
					current.next=prev;
					prev=current;
					current=next;
					if(next!=null)
						next=next.next;
				}
				if(connector!=null)
				{
					connector.next=prev;
				}
				else
					head=prev;
				
				newEnd.next=current;
				if(current==null)
					break;
				prev=newEnd;
			}
		}
		public void reverseGroupSkip(Node node,int k)
		{
			Node prev=null;
			Node current=node;
			while(true)
			{
				Node connector=prev;
				Node newEnd=current;
				Node next=null;
				if(current!=null)
					next=current.next;
				for(int i=0;current!=null && i<k;i++)
				{
					current.next=prev;
					prev=current;
					current=next;
					if(next!=null)
						next=next.next;
				}
				if(connector!=null)
				{
					connector.next=prev;
				}
				else
					head=prev;
				
				newEnd.next=current;
				if(current==null)
					break;
				for(int i=0;current!=null && i<k;i++)
				{
					prev=current;
					current=current.next;
				}
			}
		}
		public void rotate(int k)
		{
			Node temp=head;
			for(int i=1;i<size-k;i++)
			{
				temp=temp.next;
			}
			tail.next=head;
			head=temp.next;
			temp.next=null;
		}
		public boolean isPalindrome(Node node)
		{
			Node firstHead=node;
			Node secondHead=reverse(node);
			Node temp=secondHead;
			while(firstHead!=null && secondHead!=null)
			{
				if(firstHead.data!=secondHead.data)
				{
					reverse(temp);
					return false;
				}
				firstHead=firstHead.next;
				secondHead=secondHead.next;
			}
			reverse(temp);
			return true;
		}
		public void reorder(Node node)
		{
			Node firstHead=node;
			Node mid=middleOfLinkedList(node);
			Node secondHead=reverse(mid);
			while(firstHead!=null && secondHead!=null)
			{
				Node temp=firstHead.next;
				firstHead.next=secondHead;
				firstHead=temp;
				
				temp=secondHead.next;
				secondHead.next=firstHead;
				secondHead=temp;
			}
			if(firstHead!=null)
				firstHead.next=null;
		}
		public void delete(Node node)
		{
			if(node==null)
			{
				return;
			}
			else if(node.next==null)
			{
				node=null;
				return;
			}
			node.data=node.next.data;
			if(node.next!=null)
			{
				node.next=node.next.next;
			}
			
		}
		public Node addition(Node first,Node second)
		{
			Node f=first;
			Node s=second;
			Node dummyNode=new Node(-1);
			Node tail=dummyNode;
			int carry=0;
			while(s!=null || f!=null)
			{
				int sum=0;
				if(f!=null)
				{
					sum+=f.data;
				}
				if(s!=null)
				{
					sum+=s.data;
				}
				sum+=carry;
				carry=sum/10;
				Node n=new Node(sum%10);
				tail.next=n;
				tail=n;
			}
			if(carry==1)
			{
				Node n=new Node(carry);
				tail.next=n;
				tail=n;
			}
			return dummyNode.next;
		}
		public int intersection(Node a,Node b)
		{
			if(a==null || b==null)
				return -1;
			Node first=a;
			Node second=b;
			while(first!=second)
			{
				first = first==null ? b : first.next;
				second= second==null ? a: second.next;
			}
			if(a==null || b==null)
				return -1;
			return a.data;
		}
		public void cloneLL(Node node)
		{
			Node temp=node;
			while(temp!=null)
			{
				Node current=temp.next;
				temp.next=new Node(temp.data);
				temp.next.next=current;
				temp=current;
			}
			temp=head;
			while(temp!=null)
			{
				if(temp.next!=null)
					temp.next.random= temp.random!=null ? temp.random.next : null;
				temp=temp.next.next;
			}
			Node copy=head.next;
			Node org=head;
			while(org!=null)
			{
				if(org.next!=null)
					org.next=org.next.next;
				if(copy.next!=null)
					copy.next=copy.next.next;
				org=org.next;
				copy=copy.next;
			}
		}
		public Node flattenALinkedList(Node node)
		{
			if(node==null)
				return node;
			Queue<Node> q=new LinkedList<>();
			Node temp=node;
			while(temp!=null)
			{
				q.add(temp);
				temp=temp.next;
			}
			temp=head;
			while(!q.isEmpty())
			{
				Node current=q.poll();
				if(temp==head)
					temp=head;
				else
				{
					temp.next=current;
					temp=temp.next;
				}
					
				if(current.random!=null)
				{
					q.add(current);
					Node temp1=current.random;
					while(temp1.next!=null)
					{
						q.add(temp1.next);
						temp1=temp1.next;
					}
				}
			}
			return temp.next;
		}
		public Node mergeS(Node first,Node second)
		{
			Node f=first;
			Node s=second;
			Node dummyNode=new Node(-1);
			Node tail=dummyNode;
			while(f!=null && s!=null)
			{
				if(f.data<s.data)
				{
					tail.bottom=f.bottom;
					f=f.bottom;
					tail=tail.bottom;
				}
				else
				{
					tail.bottom=s.bottom;
					s=s.bottom;
					tail=tail.bottom;
				}
			}
			tail.bottom =f==null ? s : f;
			return dummyNode.next;
		}
		public Node flattenLinked(Node node)
		{
			if(node==null || node.next==null)
			{
				return node;
			}
			node.next=flattenLinked(node.next);
			
			node=mergeS(node,node.next);
			return node;
		}
		public static void main(String[] args) {
			Linkedlist LL = new Linkedlist();
			LL.add(1);
			LL.add(2);
			LL.add(3);
			LL.add(2);
			LL.add(1);
			
			System.out.println(LL.isPalindrome(LL.head));
			LL.print();
		}
}
