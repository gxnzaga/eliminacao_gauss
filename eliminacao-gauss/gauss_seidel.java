import java.util.Scanner;

public class gauss_seidel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("valor de n: ");
        int n = scanner.nextInt();
        
        double[][] matriz = new double[n][n+1];
        
        System.out.println("elementos da matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                matriz[i][j] = scanner.nextDouble();
            }
        }
        
        System.out.print("valor de epsilon: ");
        double epsilon = scanner.nextDouble();
        
        double[] solucaoAtual = new double[n];
        double[] solucaoAnterior = new double[n];
        
        for (int i = 0; i < n; i++) {
            solucaoAtual[i] = 0; // Valores iniciais da solução
        }
        
        double erro = Double.MAX_VALUE;
        
        while (erro > epsilon) {
            for (int i = 0; i < n; i++) {
                solucaoAnterior[i] = solucaoAtual[i];
            }
            
            for (int i = 0; i < n; i++) {
                double soma = matriz[i][n];
                
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        soma -= matriz[i][j] * solucaoAtual[j];
                    }
                }
                
                solucaoAtual[i] = soma / matriz[i][i];
            }
            
            erro = 0;
            for (int i = 0; i < n; i++) {
                erro += Math.abs(solucaoAtual[i] - solucaoAnterior[i]);
            }
        }
        
        System.out.println("Matriz x(0):");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.4f%n", i, solucaoAtual[i]);
        }
    }
}
