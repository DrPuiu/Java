import jdk.nashorn.internal.ir.WhileNode;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        // initializam string ul cu valorile date
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        //insumamam n ul cu numerele in baza 2 respectiv 16
        n = n + 0b10101 + 0xFF;
        n *= 6;
        int k = 0, sum = 0, i, j;
        //in k efectuam suma cifrelor lui n
        while (n != 0) {
            k += n % 10;
            n /= 10;
        }
        //in urmatorul while se efectueaza suma cifrelor lui k pana cand k devine o cifra
        while (k > 9) {
            while (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            k = sum;
        }
        System.out.println("Willy-nilwly, this semester I will learn " + languages[k]);

        //construim matricea in urmatorul mod:
        int[][] matrix = new int[n + 1][n + 1];
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++) {
                if (i <= j)
                    matrix[i][j] = j - i + 1;
                else matrix[i][j] = j - i + 1 + n;
            }
        //concatenam elementele de pe fiecare linie si le afisam pe ecran
        for (i = 1; i <= n; i++) {
            StringBuilder obiect = new StringBuilder();
            for (j = 1; j <= n; j++)
                obiect.append(matrix[i][j]);
                System.out.println(obiect);

        }
        //concatenam elementele de pe fiecare coloana si le afisam pe ecran

        for (i = 1; i <= n; i++) {
            StringBuilder obiect = new StringBuilder();
            for (j = 1; j <= n; j++)
                obiect.append(matrix[j][i]);
            System.out.println(obiect);

        }
    }
}