import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Menu da classe main
        System.out.println("==== Menu Principal ====");
        System.out.println("Informe seu tipo:");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Secretário");
        System.out.println("4 - Sair");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
            // Aluno
                System.out.println("Você é um aluno.");
                break;
            case 2:
            // Professor
                System.out.println("Você é um professor.");
                break;
            case 3:
            // Secretário
                System.out.println("Você é um secretário.");
                break;
            case 4:
            // Sair
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

    
        // Instanciando um professor
        Professor professor = new Professor("João", "123", "123");
        
        // Instanciando um aluno
        Aluno aluno = new Aluno("Maria", "456");
        
        // Instanciando uma disciplina
        Disciplina disciplina = new Disciplina("POO", "1", 60);
        
        // Adicionando aluno à disciplina
        disciplina.adicionarAluno(aluno);
        
        // Adicionando disciplina ao curso
        Curso curso = new Curso("Ciência da Computação", 240);
        curso.adicionarDisciplina(disciplina);
        
        // Adicionando disciplina ao professor (pass the Disciplina object)
        professor.cadastrarEmDisciplina(disciplina);

        // Matriculando o aluno na disciplina
        aluno.matricularEmDisciplina(disciplina);
        
        // Imprimindo disciplinas do curso
        curso.imprimirDisciplinas();
        
        // Imprimindo disciplinas do professor
        professor.imprimirDisciplinas();

        // Imprimindo os alunos da disciplina do professor
        professor.imprimirAlunosDeDisciplina("1"); 
    }
}