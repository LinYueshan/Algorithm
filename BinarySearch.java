//基于数组实现的二分查找
//用两个数组来存储Key,Value. 主要方法是rank(key),使用二分查找找到key所在的位置.
import java.util.LinkedList;
public class BinarySearch <Key extends Comparable, Value>{
	private Key[] keys;
	private Value[] values;
	private int N;
	public BinarySearch(int capacity){
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}
	public int size(){
		return N;
	}
	public boolean put(Key key, Value value){
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0){
			values[i] = value;
			return true;
		}
		for(int j = N; j > i; j--){
			keys[j] = keys[j-1];
			values[j] = values[j-1];
		}
		keys[i]= key;
		values[i] = value;
		N++;
		return true;
	}
	private int rank(Key key) {
		int lo = 0, hi = N-1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0) hi = mid - 1;
			else if(cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	public Value get(Key key){
		if(N == 0) return null;
		int i = rank(key);
		if(i < N && key.compareTo(keys[i]) == 0) return values[i];
		else return null;
	}
	public Key min(){
		return keys[0];
	}
	public Key max(){
		return keys[N-1];
	}
	public Iterable<Key> keys(Key lo, Key hi){
		LinkedList<Key> list = new LinkedList<>();
		for(int i = rank(lo); i < rank(hi); i++){
			list.add(keys[i]);
		}
		return list;
	}
	public Key delete(Key key){
		int i = rank(key);
		if(i < N && key.compareTo(keys[i]) == 0){
			for(; i < N-1; i++){
				keys[i] = keys[i+1];
				values[i] = values[i+1];
			}
			N--;
			return key;
		}
		return null;
	}
}
