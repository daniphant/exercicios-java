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

        // Mostrando os vetores.
        System.out.println("Total de valores acima ou igual ao valor de corte: " + j);


        // Usando switches para ter certeza que a mensagem mostrada na tela será coerente com a quantidade de valores. Não quero mostrar "Eles são" se só tenho 1 valor por exemplo.
        switch (j) {
            case 0:
                break;
            case 1:
                System.out.println("Esse valor é: " + v2[0]);
                break;
            default:
                System.out.print("Eles são:");
                for (int i = 0; i < j; i++) 
                    System.out.printf(" %.3f ", v2[i]);
                break;
        }
        System.out.println("\nTotal de valores abaixo do valor de corte: " + k);
        switch (k) {
            case 0:
                break;
            case 1:
                System.out.println("Esse valor é: " + v3[0]);
                break;
            default:
                System.out.print("Eles são:");
                for (int i = 0; i < k; i++) 
                    System.out.printf(" %.3f ", v3[i]);
                break;
        }
        System.out.println(); // Adicionando um \n para deixar o final da execução em uma linha separada da listagem de valores.
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
