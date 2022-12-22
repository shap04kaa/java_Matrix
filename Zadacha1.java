import java.util.Scanner;

public class Zadacha1 {
    private static class Matrix {
        private double a[][];
        int m, n;
        private Matrix(int n, int m) {
            a = new double[n][m];
            this.m = m;
            this.n = n;
        }

        //заполнение матрицы случайными элементами
        private void rnd() {
            for (int i = 0; i < m; i++) {
                for (int i1 = 0; i1 < n; i1++) {
                    a[i1][i] = (int) (10 * Math.random());
                }
            }
        }

        //вывод матрицы
        private void vyvod() {
            for (int i = 0; i < m; i++) {
                for (int i1 = 0; i1 < n; i1++) {
                    System.out.print(a[i1][i] + " ");
                }
                System.out.println();
            }
        }

        //сложение матриц
        //метод класса
        private static Matrix sloj(Matrix ma1, Matrix ma2) {
            Matrix ma = new Matrix(0, 0);
            if (ma1.m != ma2.m || ma1.n != ma2.n){
                System.out.println("ошибка");
            }
            else {
                ma = new Matrix(ma1.n, ma1.m);
                for (int i = 0; i < ma1.m; i++) {
                    for (int i1 = 0; i1 < ma1.n; i1++) {
                        ma.a[i1][i] = ma1.a[i1][i] + ma2.a[i1][i];
                    }
                }
            }
            return ma;
        }
        //метод экземпляра класса
        private Matrix sloj(Matrix ma1){
            Matrix ma = new Matrix(0, 0);
            if (ma1.m != m || ma1.n != n){
                System.out.println("ошибка");
            }
            else {
                ma = new Matrix(n, m);
                for (int i = 0; i < ma1.m; i++) {
                    for (int i1 = 0; i1 < ma1.n; i1++) {
                        ma.a[i1][i] = a[i1][i] + ma1.a[i1][i];
                    }
                }
            }
            return ma;
        }

        //умножение матрицы на число
        //метод класса
        private static Matrix umnachislo(Matrix m1, double x){
            Matrix ma = new Matrix(m1.n, m1.m);
            for (int i = 0; i < m1.m; i++) {
                for (int i1 = 0; i1 < m1.n; i1++) {
                    ma.a[i1][i] = m1.a[i1][i] * x ;
                }
            }
            return ma;
        }
        //метод экземпляра класса
        private Matrix umnachislo(double x){
            Matrix ma = new Matrix(n, m);
            for (int i = 0; i < m; i++) {
                for (int i1 = 0; i1 < n; i1++) {
                    ma.a[i1][i] = a[i1][i] * x ;
                }
            }
            return ma;
        }

        //умножение матрицы на матрицу
        //метод класса
        private static Matrix umnaj(Matrix ma1, Matrix ma2){
            Matrix ma = new Matrix(0, 0);
            if (ma1.n != ma2.m){
                System.out.println("ошибка");
            }
            else {
                ma = new Matrix(ma2.n, ma1.m);
                for (int i = 0; i < ma1.m; i++){
                    for (int i1 = 0; i1 < ma2.n; i1++) {
                        for (int i2 = 0; i2 < ma1.n; i2++){
                            ma.a[i1][i] += ma1.a[i2][i] * ma2.a[i1][i2];
                        }
                    }
                }
            }
            return ma;
        }
        //метод экземпляра класса
        private Matrix umnaj(Matrix ma2){
            Matrix ma = new Matrix(0, 0);
            if (n != ma2.m){
                System.out.println("ошибка");
            }
            else {
                ma = new Matrix(ma2.n, m);
                for (int i = 0; i < m; i++){
                    for (int i1 = 0; i1 < ma2.n; i1++) {
                        for (int i2 = 0; i2 < n; i2++){
                            ma.a[i1][i] += a[i2][i] * ma2.a[i1][i2];
                        }
                    }
                }
            }
            return ma;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //n - длина
        //m - высота
        Matrix ma1 = new Matrix(3, 4);
        Matrix ma2 = new Matrix( 3, 4);
        Matrix ma;
        ma1.rnd();
        ma2.rnd();
        System.out.println(" Матрица 1:");
        ma1.vyvod();
        System.out.println(" Матрица 2:");
        ma2.vyvod();
        //сложение матриц
        System.out.println("\n" + "Сложение матриц:" + "\n");
        ma = Matrix.sloj(ma1, ma2);
        ma.vyvod();
        System.out.println();
        ma = ma1.sloj(ma2);
        ma.vyvod();
        //умножение матрицы на число
        System.out.println("\n" + "Умножение матрицы на число:" + "\n");
        ma = Matrix.umnachislo(ma1, 2);
        ma.vyvod();
        System.out.println();
        ma = ma1.umnachislo(2);
        ma.vyvod();
        //умножение матриц
        Matrix ma3 = new Matrix(4, 3);
        Matrix ma4 = new Matrix(2, 4);
        System.out.println("\n" + "Умножение матриц:" + "\n");
        System.out.println(" Матрица 3:");
        ma3.rnd();
        ma3.vyvod();
        System.out.println(" Матрица 4:");
        ma4.rnd();
        ma4.vyvod();
        System.out.println("\n" + "Матрица, образовшаяся после перемножения матриц 3 и 4:" + "\n");
        ma = Matrix.umnaj(ma3, ma4);
        ma.vyvod();
        System.out.println();
        ma = ma3.umnaj(ma4);
        ma.vyvod();
    }
}
