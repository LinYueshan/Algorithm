//插入排序
//循环N-1次，每轮循环的前面项都已有序；内循环依次和前面的比较，小于则交换
public class InsertionSort {
	public static void main(String[] args) {
		String[] a = new String[]{"G","F","E","D","C","B","A","H","I","J","K"};
		insertionSort(a);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}
	public static void insertionSort(Comparable[] a){
		for(int i = 1; i < a.length; i++)
			for(int j = i; j > 0 && a[j].compareTo(a[j-1]) < 0; j--)
				exch(a,j,j-1);
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
