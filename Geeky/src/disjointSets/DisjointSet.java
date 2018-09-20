package disjointSets;

import java.util.Scanner;

public class DisjointSet {
    int value;
    DisjointSet parent;

    public DisjointSet(int value) {
        this.value = value;
        this.parent = null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer i = scanner.nextInt();
        double d = scanner.nextDouble();
        String s = scanner.nextLine();
        System.out.println(i);
        System.out.println(d);
        System.out.println(s);
    }
}
