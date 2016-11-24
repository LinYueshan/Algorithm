public class MergeSort {
	private static Comparable[] aux;
	public static void main(String[] args) {
		String[] a = new String[]{"G","F","E","D","C","B","A","H","I","J","K"};
		aux = new Comparable[a.length];
		
		mergeSort2(a);
		
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}
	public static void mergeSort2(Comparable[] a){
		int N = a.length;
		for(int sz = 1; sz < N; sz*=2){
			for(int lo = 0; lo < N-sz; lo = lo + sz*2){
				merge(a,lo,lo+sz-1,Math.min(lo+sz*2-1, N-1));
			}
		}
	}
	public static void mergeSort1(Comparable[] a, int lo, int hi){
		if(lo >= hi) return;
		int mid = lo + (hi - lo)/2;
		mergeSort1(a,lo,mid);
		mergeSort1(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		for(int i = lo; i <= hi; i++)
			aux[i] = a[i];
		int i = lo, j = mid+1;
		for(int k = lo; k <= hi; k++){
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(aux[i].compareTo(aux[j]) < 0) a[k] = aux[i++];
			else a[k]=  aux[j++];
		}
	}
}
