
public class SelectionSort {
    public static <E extends Comparable<E>> E[] sort (E[] table) {
        int n = table.length;
        for (int fill = 0; fill < n - 1; fill++) {
            int posMin = fill;
            for (int next = fill+1; next < n; next++) {
                if (table[next].compareTo(table[posMin]) < 0) {
                    //minimum should be updated
                    posMin = next;
                }
            }
            swap(fill, posMin, table);
        }
        return table;
    }

    public static <E extends Comparable<E>> void swap(int fill, int posMin, E[] table){
        E temp = table[fill];
        table[fill] = table[posMin];
        table[posMin] = temp;
    }

    public static <E> void main(String[] args) {
        Integer[] array = {50, 10, 25, 16, 21, 8};
        array = SelectionSort.sort(array);
        System.out.println("Sorted array: ");
        for(Integer i:array) {
        	System.out.print(i + " ");
        }
    }
}
