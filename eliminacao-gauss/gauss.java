import java.util.Scanner;

public class EliminacaoGauss {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor de n: ");
        int n = scanner.nextInt();
        
        double[][] matriz = new double[n][n+1];
        
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                matriz[i][j] = scanner.nextDouble();
            }
        }
        
        //eliminação de Gauss
        for (int i = 0; i < n; i++) {
            if (matriz[i][i] == 0) {
                throw new ArithmeticException("Não é possível realizar divisão por zero");
            }
            
            for (int j = i + 1; j < n; j++) {
                double fator = matriz[j][i] / matriz[i][i];
                
                for (int k = i; k < n + 1; k++) {
                    matriz[j][k] -= fator * matriz[i][k];
                }
            }
        }
        
        double[] solucao = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solucao[i] = matriz[i][n];
            
            for (int j = i + 1; j < n; j++) {
                solucao[i] -= matriz[i][j] * solucao[j];
            }
            
            solucao[i] /= matriz[i][i];
        }
        
        // Exibir a solução para k=0 e k=1
        System.out.println("Solução do sistema de equações para k=0 e k=1:");
        for (int i = 0; i < 2; i++) {
            System.out.printf("x%d = %.2f%n", i, solucao[i]);
        }
    }
}
