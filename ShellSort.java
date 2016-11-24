//希尔排序
//插入排序的加强，每轮确定的是h有序的。
public class ShellSort {
	public static void main(String[] args) {
		String[] a = new String[]{"G","F","E","D","C","B","A","H","I","J","K"};
		shellSort(a);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}
	public static void shellSort(Comparable[] a){
		int h =1;
		while(h < a.length/3) h = h*3 + 1;
		while(h >= 1){
			for(int i = h; i < a.length; i++)
				for(int j = i; j >= h && a[j].compareTo(a[j-h]) < 0; j-=h)
					exch(a,j,j-h);
			h/=3;
		}
		
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
