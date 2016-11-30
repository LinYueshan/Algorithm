//基于无序链表实现的顺序查找
//主要方法：put(); get().
public class SequentialSearch<Key, Value> {
	private int size = 0;
	private Node first;
	private class Node{
		Key key;
		Value value;
		Node next;
		public Node(Key key, Value value, Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	public Value get(Key key){
		for(Node node = first; node != null; node = node.next){
			if(node.key.equals(key)){
				return node.value;
			}
		}
		return null;
	}
	public boolean put(Key key, Value value){
		for(Node node = first; node != null; node = node.next){
			if(node.key.equals(key)){
				node.value = value;
				return true;
			}
		}
		first = new Node(key,value,first);
		size++;
		return true;
	}
	public int size(){
		return size;
	}
	public boolean delete(Key key){
		if(first.key.equals(key)){
			first = first.next;
			size--;
			return true;
		}
		Node pre = first;
		Node last = first.next;
		while(last != null){
			if(last.key.equals(key)){
				pre.next = last.next;
				size--;
				return true;
			}
			last = last.next;
			pre = pre.next;
		}
		return true;
	}
}
