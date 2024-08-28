import java.util.List;
import java.util.ArrayList;

public class Professor implements IPessoa {
    private String nome;
    private String id;
    private String senha;
    private List<Disciplina> disciplinas; // List to store Disciplina objects

    public Professor(String nome, String id, String senha) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.disciplinas = new ArrayList<>(); // Initialize the list
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    // Other methods

    public void cadastrarEmDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void imprimirDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Este professor não está cadastrado em nenhuma disciplina.");
            return;
        }
        System.out.println("Disciplinas ministradas por este professor:");
        for (Disciplina disciplina : disciplinas) {
            System.out.println("- " + disciplina.getNome());
        }
    }

    public void imprimirAlunosDeDisciplina(String disciplinaId) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId().equals(disciplinaId)) {
                System.out.println("Alunos matriculados em " + disciplina.getNome() + ":");
                disciplina.imprimirAlunos();
                return;
            }
        }
        System.out.println("Disciplina não encontrada.");
    }

    @Override
    public void exibirMenu() {
        System.out.println("Menu do Professor:");
        System.out.println("1. Visualizar disciplinas");
        System.out.println("2. Imprimir alunos de uma disciplina");
    }
}