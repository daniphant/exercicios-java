import java.util.Scanner;

class Aluno {
    String nome;
    double[] notas;
    public Aluno() {
        super();
        nome = new String();
        notas = new double[4];
    }

    double media(){
        return (notas[0] + notas[1] + notas[2] + notas[3]) / 4;
    }
    double maior(){
        double maior = -1;
        for(double nota : notas)
            if (nota > maior) maior = nota;
        return maior;
    }
    double menor(){
        double menor = 101;
        for(double nota : notas)
            if (nota < menor) menor = nota;
        return menor;
    }
    boolean estaAprovado(){
        if(media() >= 60) return true;
        return false;
    }
}

public class Exercicio {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Aluno[] alunos = new Aluno[3];

        for (int i = 0; i < alunos.length; i++){
            alunos[i] = new Aluno();
            System.out.println("Aluno " + (i+1) + " insira seu nome:");
            alunos[i].nome = scan.nextLine();
            System.out.println("Insira suas notas: ");
            for(int j = 0; j < 4; j++)
            {
                System.out.println("Nota " + (j+1) + ":");
                do {
                    alunos[i].notas[j] = scan.nextDouble();
                    if (alunos[i].notas[j] > 100 || alunos[i].notas[j] < 0)
                        System.out.println("Nota inválida. Seu valor deve ser entre 0 e 100.");
                } while(alunos[i].notas[j] > 100 || alunos[i].notas[j] < 0);
            }
            scan.nextLine();
        }
        for(Aluno a : alunos) {
            System.out.println(a.nome+"\nSua media é: " + a.media());
            System.out.println("Sua maior nota é: " + a.maior());
            System.out.println("Sua menor nota é: " + a.menor());
            if (a.estaAprovado()) System.out.println("Parabéns! Você foi aprovado!\n");
            else System.out.println("Você foi reprovado.\n");
        }
        scan.close();
    }
}