import java.util.List;
import java.util.Scanner;

public class Secretario extends Pessoa {
    public Secretario(String nome, String id, String senha) {
        super(nome, id, senha, "Secretario");
    }

    // Métodos para gerenciar o período de matrícula
    public void alterarPeriodoMatricula() {
        System.out.println("Método alterarPeriodoMatricula() ainda não implementado.");
        // Implemente a lógica para alterar o período de matrícula
    }

    public void gerenciarCurriculo() {
        System.out.println("Método gerenciarCurriculo() ainda não implementado.");
        // Implemente a lógica para gerenciar o currículo dos cursos
    }

    // Métodos para gerenciar disciplinas
    public void visualizarDisciplina(List<Disciplina> disciplinas) {
        if (disciplinas.isEmpty()) {
            System.out.println("Não há disciplinas cadastradas.");
            return;
        }
        System.out.println("Disciplinas:");
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina);
        }
    }

    public void adicionarDisciplina(List<Disciplina> disciplinas, Scanner scanner) {
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ID da disciplina: ");
        String id = scanner.nextLine();
        disciplinas.add(new Disciplina(nome, id));
        System.out.println("Disciplina adicionada com sucesso!");
    }

    public void removerDisciplina(List<Disciplina> disciplinas, Scanner scanner) {
        System.out.print("Digite o ID da disciplina a ser removida: ");
        String id = scanner.nextLine();
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getId().equals(id)) {
                disciplinas.remove(i);
                System.out.println("Disciplina removida com sucesso!");
                return;
            }
        }
        System.out.println("Disciplina não encontrada.");
    }

    public void renomearDisciplina(List<Disciplina> disciplinas, Scanner scanner) {
        System.out.print("Digite o ID da disciplina a ser renomeada: ");
        String id = scanner.nextLine();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId().equals(id)) {
                System.out.print("Digite o novo nome da disciplina: ");
                String novoNome = scanner.nextLine();
                disciplina.setNome(novoNome);
                System.out.println("Disciplina renomeada com sucesso!");
                return;
            }
        }
        System.out.println("Disciplina não encontrada.");
    }

    public void atribuirProfessor(List<Disciplina> disciplinas, List<Professor> professores, Scanner scanner) {
        System.out.print("Digite o ID da disciplina: ");
        String disciplinaId = scanner.nextLine();
        System.out.print("Digite o ID do professor: ");
        String professorId = scanner.nextLine();

        Disciplina disciplina = null;
        Professor professor = null;

        for (Disciplina d : disciplinas) {
            if (d.getId().equals(disciplinaId)) {
                disciplina = d;
                break;
            }
        }

        for (Professor p : professores) {
            if (p.getId().equals(professorId)) {
                professor = p;
                break;
            }
        }

        if (disciplina != null && professor != null) {
            disciplina.setProfessor(professor);
            professor.cadastrarEmDisciplina(disciplina.getId());
            System.out.println("Professor atribuído à disciplina com sucesso!");
        } else {
            System.out.println("Disciplina ou professor não encontrado.");
        }
    }

    // Métodos para gerenciar professores
    public void visualizarProfessor(List<Professor> professores) {
        if (professores.isEmpty()) {
            System.out.println("Não há professores cadastrados.");
            return;
        }
        System.out.println("Professores:");
        for (Professor professor : professores) {
            System.out.println(professor);
        }
    }

    public void adicionarProfessor(List<Professor> professores, Scanner scanner) {
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ID do professor: ");
        String id = scanner.nextLine();
        System.out.print("Digite a senha do professor: ");
        String senha = scanner.nextLine();
        professores.add(new Professor(nome, id, senha));
        System.out.println("Professor adicionado com sucesso!");
    }

    public void removerProfessor(List<Professor> professores, Scanner scanner) {
        System.out.print("Digite o ID do professor a ser removido: ");
        String id = scanner.nextLine();
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getId().equals(id)) {
                professores.remove(i);
                System.out.println("Professor removido com sucesso!");
                return;
            }
        }
        System.out.println("Professor não encontrado.");
    }

    // Métodos para gerenciar usuários
    public void visualizarUsuario() {
        System.out.println("Método visualizarUsuario() ainda não implementado.");
        // Implemente a lógica para visualizar usuários
    }

    public void adicionarAluno(List<Aluno> alunos, Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ID do aluno: ");
        String id = scanner.nextLine();
        alunos.add(new Aluno(nome, id));
        System.out.println("Aluno adicionado com sucesso!");
    }

    public void removerUsuario(List<? extends Pessoa> usuarios, Scanner scanner) {
        System.out.print("Digite o ID do usuário a ser removido: ");
        String id = scanner.nextLine();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id)) {
                usuarios.remove(i);
                System.out.println("Usuário removido com sucesso!");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    public void renomearUsuario(List<? extends Pessoa> usuarios, Scanner scanner) {
        System.out.print("Digite o ID do usuário a ser renomeado: ");
        String id = scanner.nextLine();
        for (Pessoa usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                System.out.print("Digite o novo nome do usuário: ");
                String novoNome = scanner.nextLine();
                usuario.setNome(novoNome);
                System.out.println("Usuário renomeado com sucesso!");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    @Override
    public void exibirMenu() {
        System.out.println("Menu do Secretário:");
        System.out.println("1. Gerenciar Disciplinas");
        System.out.println("2. Gerenciar Professores");
        System.out.println("3. Gerenciar Usuários");
        System.out.println("4. Sair");
    }
}