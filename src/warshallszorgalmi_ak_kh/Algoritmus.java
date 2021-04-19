
package warshallszorgalmi_ak_kh;

import java.util.Scanner;


public class Algoritmus {
static int [][] Tomb;
static final int N =4;
    public static void main(String[] args) {
        int [][] M = {{0,999,30,20}, {20,0,50,40},{999,30,0,999}, {20,50,50,0}};
        Tomb = new int [N][N];
        System.out.println("Út: ");
        MatrixKiir(M);
        System.out.println("Legrövidebb út:");
        MatrixKiir(Warshall(M));
        System.out.println("Megelőző csúcs:");
        MatrixKiir(Tomb);
        
        BeKer();
    }
    
    public static int [][] Warshall(int [][]Matrix){
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Matrix[i][k]+Matrix[k][j]<Matrix[i][j]) {
                        Matrix[i][j]= Matrix[i][k]+Matrix[k][j];
                        Tomb[i][j]=k;
                    }
//                    Matrix[i][j]=min(Matrix[i][j],Matrix[i][k]+Matrix[k][j]);
                }
            }
        }
        return Matrix;
    }
    public static int min (int i, int j){
        if (i>j) {
            return j;
        }
        return i;
    }
    
    public static void MatrixKiir(int[][] Matrix){
        System.out.print("\n\t");
        for (int j = 0; j < N; j++) {
            System.out.print(j+"\t");
        }
        System.out.println();
        for (int j = 0; j < 50; j++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(i+" |\t");
            for (int j = 0; j < N; j++) {
                System.out.print(Matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    private static void BeKer() {
        System.out.println("Kérek egy pontot 0 és 3 között!: ");
        Scanner sc = new Scanner(System.in);
        String elsoPont = sc.next();
        System.out.println("Kérek még egy pontot 0 és 3 között!: ");
        String masodikPont = sc.next();
    }
}
