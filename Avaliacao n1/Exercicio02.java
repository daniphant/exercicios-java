import java.util.Arrays;
import java.util.Scanner;

public class Exercicio02 {
    /*
     Observação: no pdf do exercício mosttra o exemplo de output contendo "?" como elementos. 
     Estão pedindo para nós inicializarmos vetores de DOUBLE, como que eu vou mostrar na tela um ? com DOUBLE ? 
    */

    // Uma função com 3 índices j k i que recebe todos os vetores e a variável de corte e preenche os vetores de acordo com o enunciado. 
    private static void preencher_vetores(double[] v1, double[] v2, double[] v3, double corte) {
        int j = 0; // j, k e i permitem que cada vetor "progrida" independentemente.
        int k = 0;
        for (int i = 0; i < v1.length; i++) {
            if(v1[i] >= corte) {
                v2[j] = v1[i];
                j++;
            } else {
                v3[k] = v1[i];
                k++;
            }
        }

        // Usando a função toString da util Arrays para converter nossos vetores em strings, imprimimos para o usuário o resultado.
        System.out.println("Valores acima ou iguais ao do corte: ");
        System.out.println(Arrays.toString(v2));
        
        System.out.println("Valores abaixo do corte: ");
        System.out.println(Arrays.toString(v3));
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Obtendo a variável para o tamanho dos vetores. Esse código é simples demais não sei o que comentar é tudo tão trivial kkk
        System.out.println("Insira o tamanho dos vetores: ");
        int tamanho = scan.nextInt();

        // Inicializando os vetores
        double[] v1 = new double[tamanho];
        double[] v2 = new double[tamanho];
        double[] v3 = new double[tamanho];

        // Preenchendo v1 com dados do usuário. 
        System.out.println("Preencha o vetor v1 com numeros reais: ");
        for (int i = 0; i < tamanho; i++) 
            v1[i] = scan.nextDouble();
        
        // Por fim, obtemos o valor de corte que será a parte detrimental para a execução da etapa 2 do nosso programa que acontece no método preencher_vetores().
        System.out.println("Insira o valor de corte: ");
        double valorDeCorte = scan.nextDouble();

        preencher_vetores(v1, v2, v3, valorDeCorte); // Iniciando a função preencher_vetores

        scan.close(); // Fechando o scanner
    }
}
