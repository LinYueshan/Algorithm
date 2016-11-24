public class HeapSort {
	public static void main(String[] args) {
		String[] a = new String[]{"G","F","E","D","C","B","A","H","I","J","K"};
		heapSort(a);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}
	public static void heapSort(Comparable a[]){
		int N = a.length-1;
		for(int i = (N-1)/2; i >= 0; i--){
			sink(a,i,N);
		}
		while(N > 0){
			exch(a,0,N--);
			sink(a,0,N);
		}
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	private static void sink(Comparable[] a, int i, int N) {
		while(2*i+1 <= N){
			int j = 2*i+1;
			if(j < N && a[j].compareTo(a[j+1]) < 0) j++;
			if(a[i].compareTo(a[j])> 0) break;
			exch(a,i,j);
			i = j;
		}
	}
}
