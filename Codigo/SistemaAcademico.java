

import Model.Aluno;
import Model.Disciplina;
import Model.Professor;
import Model.Secretario;
import Repository.AlunoRepository;
import Repository.CursoRepository;
import Repository.DisciplinaRepository;
import Repository.ProfessorRepository;
import Service.AlunoService;
import Service.ProfessorService;
import Service.SecretarioService;
import java.io.IOException;
import java.util.Scanner;

public class SistemaAcademico {

    public static void main(String[] args) throws IOException {
        // Configuração dos Repositórios 
        String arquivoDisciplinas = "lab1_sis_matriculas\\Codigo\\dados\\disciplinas.txt";
        String arquivoAlunos = "lab1_sis_matriculas\\Codigo\\dados\\alunos.txt";
        String arquivoProfessores = "lab1_sis_matriculas\\Codigo\\dados\\professores.txt";
        String arquivoCursos = "lab1_sis_matriculas\\Codigo\\dados\\cursos.txt";

        //erro: disciplina não pode ser null
        AlunoRepository alunoRepository = new AlunoRepository(arquivoAlunos); 
        DisciplinaRepository disciplinaRepository = new DisciplinaRepository(arquivoDisciplinas);
        ProfessorRepository professorRepository = new ProfessorRepository(arquivoProfessores);
        CursoRepository cursoRepository = new CursoRepository(arquivoCursos, disciplinaRepository);
        
        // Injeção de Dependências nos Services
        AlunoService alunoService = new AlunoService(alunoRepository, disciplinaRepository);
        ProfessorService professorService = new ProfessorService(professorRepository, disciplinaRepository);
        SecretarioService secretarioService = new SecretarioService(cursoRepository, disciplinaRepository, professorRepository, alunoRepository);
        alunoRepository.setDisciplinaRepository(disciplinaRepository); 
        disciplinaRepository.setAlunoRepository(alunoRepository); 
        disciplinaRepository.setProfessorRepository(professorRepository);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n------------------------");
                System.out.println("Sistema Acadêmico");
                System.out.println("------------------------");
                System.out.println("1. Login como Aluno");
                System.out.println("2. Login como Professor");
                System.out.println("3. Login como Secretário");
                System.out.println("4. Sair");

                System.out.print("Escolha uma opção: ");
                int opcaoLogin = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                switch (opcaoLogin) {
                    case 1:
                        menuAluno(alunoService, scanner, alunoRepository);
                        break;
                    case 2:
                        menuProfessor(professorService, scanner, professorRepository);
                        break;
                    case 3:
                        menuSecretario(secretarioService, scanner);
                        break;
                    case 4:
                        System.out.println("Saindo do sistema...");
                        return; // Encerra o programa
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }

    // === Métodos para os Menus ===

    private static void menuAluno(AlunoService alunoService, Scanner scanner, AlunoRepository alunoRepository) throws IOException {
        // Implemente a lógica de login do aluno aqui (solicitar ID e senha)
        // ...
        System.out.print("Digite seu ID: ");
        int alunoId = scanner.nextInt();
        scanner.nextLine(); 

        Aluno alunoLogado = null;  // Inicializa o alunoLogado como null
        try {
            alunoLogado = alunoRepository.findAlunoById(alunoId); // Tenta encontrar o aluno pelo ID
        } catch (IOException e) {
            System.out.println("Erro ao acessar os dados do aluno. Tente novamente mais tarde.");
            e.printStackTrace(); // Imprime o erro para debug
            return; // Retorna para evitar NullPointerException
        }

        if (alunoLogado == null) {
            System.out.println("Aluno não encontrado.");
            return; // Retorna ao menu principal
        }
        while (true) {
            System.out.println("\n--- Menu do Aluno ---");
            System.out.println("1. Matricular em Disciplina");
            System.out.println("2. Cancelar Matrícula em Disciplina");
            System.out.println("3. Visualizar Grade Curricular");
            System.out.println("4. Voltar ao menu anterior");

            System.out.print("Escolha uma opção: ");
            int opcaoAluno = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcaoAluno) {
                case 1:
                    // Lógica para matricular em disciplina
                    System.out.print("Digite o ID da disciplina para matrícula: ");
                    int idDisciplina = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    alunoService.matricularEmDisciplina(alunoLogado, idDisciplina); 

                    break;
                case 2:
                    // Lógica para cancelar matrícula
                    System.out.print("Digite o ID da disciplina para cancelar a matrícula: ");
                    int idDisciplinaCancelar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    alunoService.cancelarMatriculaDisciplina(alunoLogado, idDisciplinaCancelar);

                    break;
                case 3:
                    alunoService.verGradeCurricular(alunoLogado);
                    break;
                case 4:
                    return; // Volta para o menu principal
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void menuProfessor(ProfessorService professorService, Scanner scanner, ProfessorRepository professorRepository) throws IOException {
        // Implemente a lógica de login do professor aqui (solicitar ID e senha)
        // ... 
        System.out.print("Digite seu ID: ");
        int professorId = scanner.nextInt();
        scanner.nextLine();

        // Implementar lógica para buscar o professor pelo ID (no repositório?)
        Professor professorLogado = null; 
        try {
            professorLogado = professorRepository.findProfessorById(professorId); // Tenta encontrar o professor pelo ID
        } catch (IOException e) {
            System.out.println("Erro ao acessar os dados do professor. Tente novamente mais tarde.");
            e.printStackTrace(); // Imprime o erro para debug
            return; // Retorna para evitar NullPointerException
        }

        if (professorLogado == null) {
            System.out.println("Professor não encontrado.");
            return; // Retorna ao menu principal
        }

        while (true) {
            System.out.println("\n--- Menu do Professor ---");
            System.out.println("1. Visualizar Disciplinas");
            System.out.println("2. Imprimir Alunos de uma Disciplina");
            System.out.println("3. Voltar ao menu anterior");

            System.out.print("Escolha uma opção: ");
            int opcaoProfessor = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcaoProfessor) {
                case 1:
                    professorService.imprimirDisciplinas(professorLogado.getId());
                    break;
                case 2:
                    System.out.print("Digite o ID da disciplina: ");
                    String disciplinaId = scanner.nextLine();
                    professorService.imprimirAlunosDeDisciplina(professorLogado.getId(), disciplinaId);
                    break;
                case 3:
                    return; // Volta ao menu principal
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void menuSecretario(SecretarioService secretarioService, Scanner scanner) throws IOException {
        while (true) {
            System.out.println("\n--- Menu do Secretário ---");
            System.out.println("1. Gerenciar Currículo");
            System.out.println("2. Gerenciar Disciplinas");
            System.out.println("3. Gerenciar Professores");
            System.out.println("4. Gerenciar Alunos");
            System.out.println("5. Voltar ao menu anterior");

            System.out.print("Escolha uma opção: ");
            int opcaoSecretario = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcaoSecretario) {
                case 1:
                    secretarioService.gerenciarCurriculo(scanner);
                    break;
                case 2:
                    gerenciarDisciplinas(secretarioService, scanner);
                    break;
                case 3:
                    gerenciarProfessores(secretarioService, scanner);
                    break;
                case 4:
                    gerenciarAlunos(secretarioService, scanner);
                    break; 
                case 5:
                    return; // Volta ao menu principal
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    
    private static void gerenciarDisciplinas(SecretarioService secretarioService, Scanner scanner) throws IOException {
        while (true) {
            System.out.println("\n--- Gerenciar Disciplinas ---");
            System.out.println("1. Visualizar Disciplinas");
            // Adicione outras opções de gerenciamento de disciplinas aqui
            System.out.println("2. Voltar ao menu anterior"); 

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    secretarioService.visualizarDisciplina();
                    break;
                // Implemente os outros cases para as opções adicionadas
                case 2:
                    return; // Volta ao menu do Secretário
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void gerenciarProfessores(SecretarioService secretarioService, Scanner scanner) throws IOException {
        while (true) {
            System.out.println("\n--- Gerenciar Professores ---");
            System.out.println("1. Adicionar Professor");
            System.out.println("2. Remover Professor");
            System.out.println("3. Renomear Professor"); // Exemplo de nova funcionalidade
            System.out.println("4. Visualizar Professores");
            System.out.println("5. Voltar ao menu anterior");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    secretarioService.adicionarProfessor(scanner);
                    break;
                case 2:
                    // Implemente a lógica para remover professor
                    System.out.println("Implementar remoção de professor..."); 
                    break;
                case 3:
                    // Implemente a lógica para renomear professor
                    System.out.println("Implementar renomear professor...");
                    break;
                case 4:
                    // Implemente a lógica para visualizar professores
                    System.out.println("Implementar visualização de professores..."); 
                    break;
                case 5:
                    return; // Volta ao menu do Secretário
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void gerenciarAlunos(SecretarioService secretarioService, Scanner scanner) throws IOException {
        while (true) {
            System.out.println("\n--- Gerenciar Alunos ---");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Remover Aluno");
            System.out.println("3. Renomear Aluno"); 
            System.out.println("4. Voltar ao menu anterior");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    secretarioService.adicionarAluno(scanner);
                    break;
                case 2:
                    // Implemente a lógica para remover aluno
                    System.out.println("Implementar remoção de aluno...");
                    break;
                case 3:
                    // Implemente a lógica para renomear aluno
                    System.out.println("Implementar renomear aluno..."); 
                    break;
                case 4:
                    return; // Volta ao menu do Secretário
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}