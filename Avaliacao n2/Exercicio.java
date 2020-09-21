import java.util.Scanner;

class Aluno {
    String nome;
    double[] notas;
    public Aluno() {
        super();
        nome = new String();
    }

    float media(){
        return (notas[0] + notas[1] + notas[2] + notas[3])/4;
    }
    float maior(){
        int maior = -1;
        for(float nota : notas)
            if (nota > maior) maior = nota;
        return maior;
    }
    float menor(){
        int menor = 101;
        for(float nota : notas) 
            if (nota < menor) menor = nota;
        return menor;
    }
    boolean estaAprovado(){
        if(media() >= 60) return true;
        return false;
    }
}

public class Exercicio() {

    private static final int SIZE = 3;
    public static void main(String[] args) {
        Aluno[] alunos = new Aluno[SIZE];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < alunos.length; i++){
            alunos[i] = new Aluno();
            System.out.println("Aluno " + (i+1) + " insira seu nome:");
            alunos[i].nome = scan.nextLine();
            System.out.println("Insira suas notas: ");
            for(int j = 0; j < 4; j++)
            {
                System.out.println("Nota " + (j+1) + ":");
                alunos[i].notas[j] = scan.nextDouble();
            }
        }
    }
}