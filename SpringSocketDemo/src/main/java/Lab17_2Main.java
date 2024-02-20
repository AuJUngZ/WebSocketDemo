import java.util.Random;

public class Lab17_2Main {
    public static void main(String[] args) {
        int N = 63;
        int seed = 2022;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        Random rand = new Random(seed);
        // create a random permutation
        for (int i = 0; i < N; i++) {
            int j = rand.nextInt(N-i)+i;
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        AVLTree<Integer> t = new AVLTree<>();
        for (int i = 0; i < N; i++)
            t.add(a[i]);

        System.out.print("Preorder : ");
        for (Iterator<Integer> itr = t.iterator(1); itr.hasNext();)
            System.out.print(itr.next() + " ");
        System.out.println();

        /** Challenge!!! **/
        System.out.print("Postorder : ");
        for (Iterator<Integer> itr = t.iterator(2); itr.hasNext(); )
            System.out.print(itr.next() + " ");
        System.out.println();

        // expected preorder:
        // 32 19 9 5 2 1 0 3 4 7 6 8 16 13 11 10 12 15 14 17 18 27 23 21 20 22 25 24 26 30 29 28 31
        // 47 40 36 34 33 35 38 37 39 44 42 41 43 45 46 55 50 48 49 52 51 54 53 59 57 56 58 61 60 62

        // expected postorder (challenge):
        // 0 1 4 3 2 6 8 7 5 10 12 11 14 15 13 18 17 16 9 20 22 21 24 26 25 23 28 29 31 30 27 19 33
        // 35 34 37 39 38 36 41 43 42 46 45 44 40 49 48 51 53 54 52 50 56 58 57 60 62 61 59 55 47 32
    }
}