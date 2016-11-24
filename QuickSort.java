//快速排序
public class QuickSort {
	public static void main(String[] args) {
		String[] a = new String[]{"G","F","E","D","C","B","A","H","I","J","K"};
		quickSort(a);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}
	public static void quickSort(Comparable[] a){
		subsort(a,0,a.length-1);
	}
	private static void subsort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		Comparable v = a[lo];
		int i = lo;
		int j = hi+1;
		while(true){
			while(i < hi && a[++i].compareTo(v) < 0);
			while(a[--j].compareTo(v) > 0);
			if(i >= j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		subsort(a,lo,j-1);
		subsort(a,j+1,hi);
		
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
