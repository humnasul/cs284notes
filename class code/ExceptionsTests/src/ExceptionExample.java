import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionExample {
    public void readFile(String filename) {
        File f = new File(filename);
        Scanner c;
        try {
            c = new Scanner(f);
            while (c.hasNextLine()) {
                System.out.println(c.nextLine());
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Error! File Not Found!!!");
            e.printStackTrace();
        }
        /*
        ExceptionExample ee = new ExceptionExample();
        ee.readFile("myFile.txt");
        int[] a = new int[3];
        try {
            ee.get(a, -3);
         } catch(ArrayOutOfBoundsException e) {
            System.out.println("Careful!");
         }
         */
    }

    public static void main(String[] args) {
        ExceptionExample ee = new ExceptionExample();
        ee.readFile("myFile.txt");
        int[] a = new int[3];
        ee.get(a, -3);
    }


    public int get(int a[], int index) {
        if (index < 0)
            throw new ArrayIndexOutOfBoundsException("Error! Index Out of Bounds!");
        return a[index];
    }
}
