import java.util.Scanner;

/**
 Assumindo que a potência é dada em kilowatt/hora, caso contrário, a computação potencia*horasDeUso não faz sentido. 
 Como não foi dado um testcase com input e output, é impossivel saber ao certo se os cálculos estão sendo feitos como o esperado.
**/ 

// Classe de eletrodomesticos. Chamei a variavel identificadora de id e a declarei como String pois não fica claro a um usuario que um id é um numero.
class Eletrodomestico {
    String id;
    double potencia;
    int horasDeUso;
    
    // Uma função que facilita o calculo repetitivo do consumoDiario de cada eletrodomestico.
    double consumoDiario() {
        return this.potencia * this.horasDeUso;
    }
    // Constructor da classe para corrigir problemas que podem vir a correr caso a String id não seja inicializada.
    Eletrodomestico() {
        this.id = new String();
    }

}
public class Exercicio01 {
    private static final int NUM = 7; // Constante de eletrodomesticos totais.

    private static void calculando_consumo_total(Eletrodomestico[] eletrodomesticos, double consumo, int dias) {
        consumo *= dias; // Multiplicando o somatorio do consumo diario pela quantidade de dias. Já que esse é o valor que todos os eletrodomesticos JUNTOS irão consumir nesse período.
        for (int i = 0; i < eletrodomesticos.length; i++)
            // Enfim, mostramos ao usuário o consumo total de cada eletrodomestico e a porcentagem do total que ele representa.
            System.out.println("O eletrodomestico " + eletrodomesticos[i].id + " consome " + (eletrodomesticos[i].consumoDiario()*dias/consumo*100) + "% (" + eletrodomesticos[i].consumoDiario()*dias + " KW).");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Criando um vetor de objeto eletrodomesticos. Por mais que o enunciado peça sete eletrodomesticos, essa sintaxe permite que o valor seja alterado, mudando a constante NUM, o que me ajudou MUITO para testar o código.
        Eletrodomestico[] eletrodomesticos = new Eletrodomestico[NUM];
        double somatorioConsumoDiario = 0; // Serve como um somatório do consumoDiario de cada componente

        // Inicializando e lendo os valores de cada eletrodomestico.
        for (int i = 0; i < eletrodomesticos.length; i++) {
            eletrodomesticos[i] = new Eletrodomestico();

            System.out.println("Insira o nome ou identificador único do eletrodomestico número " + (i+1) + ": ");
            eletrodomesticos[i].id = scan.nextLine();

            System.out.println("Insira sua potência ( somente o valor numérico ): ");
            eletrodomesticos[i].potencia = scan.nextDouble();

            do { 
                // Enforça que o valor de horas seja coerente à faixa entre 0 a 24.  
                System.out.println("Insira a quantidade de horas no qual ele fica ligado, entre 0 e 24 horas: ");
                eletrodomesticos[i].horasDeUso = scan.nextInt();

                // Aqui eu normalmente iria dar um throw new exception e parar o aplicativo, mas isso quebra a experiência do usuário. Portanto, criei esse if redundante para explicar ao usuário o porquê dessa ação repetir.
                if(eletrodomesticos[i].horasDeUso > 24 || eletrodomesticos[i].horasDeUso < 0)
                    System.out.println("Quantidade de horas inválida. Por favor, tente novamente.");
            } while(eletrodomesticos[i].horasDeUso > 24 || eletrodomesticos[i].horasDeUso < 0); 

            somatorioConsumoDiario += eletrodomesticos[i].consumoDiario(); // Atribuindo o consumo diario desse eletrodomestico ao somatório do consumo de todos eletrodomesticos.

            scan.nextLine(); // Dando um "flush" para poder ler o proximo id sem problemas.
        }

        System.out.println("Insira o período de tempo em dias: ");
        int intervaloDias = scan.nextInt(); // Lendo a variável intervaloDias que iremos usar para determinar quanto cada eletrodomestico consome nesse periodo de tempo.
        calculando_consumo_total(eletrodomesticos, somatorioConsumoDiario, intervaloDias);

        scan.close(); // Fechando o scanner

    }
    
}