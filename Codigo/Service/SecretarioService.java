package Service;

import Model.Aluno;
import Model.Disciplina;
import Model.Professor;
import java.util.List;
import java.util.Scanner;
import Repository.AlunoRepository;
import Repository.CursoRepository;
import Repository.DisciplinaRepository;
import Repository.ProfessorRepository;
import java.io.IOException;

public class SecretarioService {
    private CursoRepository cursoRepository;
    private DisciplinaRepository disciplinaRepository;
    private ProfessorRepository professorRepository;
    private AlunoRepository alunoRepository;

    public SecretarioService(CursoRepository cursoRepository, DisciplinaRepository disciplinaRepository,
                             ProfessorRepository professorRepository, AlunoRepository alunoRepository) {
        this.cursoRepository = cursoRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
    }

    // ... (métodos para gerenciar o período de matrícula) ...

    public void gerenciarCurriculo(Scanner scanner) throws IOException {
        System.out.println("Gerenciar currículo:");
        System.out.println("1. Adicionar Disciplina");
        System.out.println("2. Remover Disciplina"); 
        System.out.println("3. Renomear Disciplina");
        System.out.println("4. Sair");

        // Lê a opção do usuário 
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        switch (opcao) {
            case 1:
                System.out.println("Informe o nome do curso: ");
                String nomeCurso = scanner.nextLine();
                System.out.println("Informe o nome da disciplina: ");
                String nomeDisciplina = scanner.nextLine();

                adicionarDisciplinaAoCurso(nomeCurso, nomeDisciplina, scanner);
                break;
            case 2:
                System.out.println("Informe o nome do curso: ");
                String nomeCursoRemover = scanner.nextLine();
                System.out.println("Informe o ID da disciplina: ");
                int idDisciplinaRemover = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                removerDisciplinaDoCurso(nomeCursoRemover, idDisciplinaRemover);
                break;
            case 3: 
                System.out.println("Informe o nome do curso: ");
                String nomeCursoRenomear = scanner.nextLine();
                System.out.println("Informe o ID da disciplina: ");
                int idDisciplinaRenomear = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                System.out.println("Informe o novo nome da disciplina: ");
                String novoNomeDisciplina = scanner.nextLine();

                renomearDisciplinaDoCurso(nomeCursoRenomear, idDisciplinaRenomear, novoNomeDisciplina);
                break;
            case 4:
                System.out.println("Voltando ao menu anterior...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void adicionarDisciplinaAoCurso(String nomeCurso, String nomeDisciplina, Scanner scanner) throws IOException {
        var curso = cursoRepository.findCursoByNome(nomeCurso);
        if (curso == null) {
            System.out.println("Curso não encontrado.");
            return;
        }

        System.out.print("Digite o ID da disciplina: ");
        int idDisciplina = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Digite o período da disciplina: ");
        int periodoDisciplina = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Digite a carga horária da disciplina: ");
        int cargaHorariaDisciplina = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Disciplina novaDisciplina = new Disciplina(idDisciplina, nomeDisciplina, periodoDisciplina, cargaHorariaDisciplina, true);

        disciplinaRepository.writeDisciplina(novaDisciplina);
        curso.getDisciplinas().add(novaDisciplina);
        cursoRepository.writeCurso(curso);

        System.out.println("Disciplina adicionada ao curso com sucesso!");
    }

    private void removerDisciplinaDoCurso(String nomeCurso, int idDisciplina) throws IOException {
        var curso = cursoRepository.findCursoByNome(nomeCurso);
        if (curso == null) {
            System.out.println("Curso não encontrado.");
            return;
        }
        
        boolean disciplinaRemovida = curso.getDisciplinas().removeIf(d -> d.getId() == idDisciplina);

        if (disciplinaRemovida) {
            cursoRepository.writeCurso(curso); 
            System.out.println("Disciplina removida do curso com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada no curso.");
        }
    }
    
    private void renomearDisciplinaDoCurso(String nomeCurso, int idDisciplina, String novoNome) throws IOException {
        var curso = cursoRepository.findCursoByNome(nomeCurso);
        if (curso == null) {
            System.out.println("Curso não encontrado.");
            return;
        }

        for (Disciplina disciplina : curso.getDisciplinas()) {
            if (disciplina.getId() == idDisciplina) {
                disciplina.setNome(novoNome);
                cursoRepository.writeCurso(curso); // Salva o curso após a atualização
                System.out.println("Disciplina renomeada com sucesso!");
                return;
            }
        }

        System.out.println("Disciplina não encontrada no curso.");
    }
    // Métodos para gerenciar disciplinas
    public void visualizarDisciplina() throws IOException {
        List<Disciplina> disciplinas = disciplinaRepository.findDisciplinas();
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas cadastradas.");
            return;
        }
        System.out.println("Disciplinas:");
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina);
        }
    }

    // ... (outros métodos para gerenciar disciplinas, professores e usuários) ...

    public void adicionarProfessor(Scanner scanner) throws IOException {
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ID do professor: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite a senha do professor: ");
        String senha = scanner.nextLine();

        Professor novoProfessor = new Professor(id, nome, senha);
        professorRepository.writeProfessor(novoProfessor);

        System.out.println("Professor adicionado com sucesso!");
    }

    // ... (outros métodos para gerenciar professores e usuários) ...

    public void adicionarAluno(Scanner scanner) throws IOException {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ID do aluno: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite a senha do aluno: ");
        String senha = scanner.nextLine();

        Aluno novoAluno = new Aluno(nome, id, senha);
        alunoRepository.writeAluno(novoAluno);

        System.out.println("Aluno adicionado com sucesso!");
    }
}