
package floydalgo;


public class Main {
static int [][] P;
static final int N =4;
    public static void main(String[] args) {
        int [][] M = {{0,5,999,999}, {50,0,15,5},{30,999,0,15}, {15,999,5,0}};
        P = new int [N][N];
        System.out.println("Legrövidebb út megtalálása");
        printMatrix(M);
        System.out.println("Legrövidebb út");
        printMatrix(FloydAlgo(M));
        System.out.println("Matrix elérés");
        printMatrix(P);
    }
    public static int [][] FloydAlgo(int [][]M){
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (M[i][k]+M[k][j]<M[i][j]) {
                        M[i][j]= M[i][k]+M[k][j];
                        P[i][j]=k;
                    }
                    //M[i][j]=min(M[i][j],M[i][k]+M[k][j]);
                }
            }
        }
        return M;
    }
    public static int min (int i, int j){
        if (i>j) {
            return j;
        }
        return i;
    }
    
    public static void printMatrix(int[][] Matrix){
        System.out.print("\n\t");
        for (int j = 0; j < N; j++) {
            System.out.print(j+"\t");
        }
        System.out.println();
        for (int j = 0; j < 35; j++) {
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
}
