import java.util.List;
import java.util.ArrayList;

public class Professor implements IPessoa {
    private String nome;
    private String id;
    private String senha;
    private List<String> idsClasses;

    public Professor(String nome, String id, String senha) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.idsClasses = new ArrayList<>();
    }

    // Construtor padrão
    public Professor() {
        this.idsClasses = new ArrayList<>();
    }

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

    public List<String> getIdsClasses() {
        return this.idsClasses;
    }

    public void setIdsClasses(List<String> idsClasses) {
        this.idsClasses = idsClasses;
    }


    public void cadastrarEmDisciplina(String disciplina) {
        this.idsClasses.add(disciplina);
    }    

    public void imprimirDisciplinas() {
        if (idsClasses.isEmpty()) {
            System.out.println("Este professor não está cadastrado em nenhuma disciplina.");
            return;
        }
        System.out.println("Disciplinas ministradas por este professor:");
        for (String disciplina : idsClasses) {
            System.out.println("- " + disciplina);
        }
    }

    @Override
    public void exibirMenu() {
        System.out.println("Menu do Professor:");
        System.out.println("1. Visualizar disciplinas");
        System.out.println("2. Imprimir alunos de uma disciplina");
    }

    public void imprimirAlunosDeDisciplina(String disciplinaId) {
        // Implementação para recuperar a disciplina pelo ID e imprimir os alunos matriculados
        System.out.println("Método imprimirAlunosDeDisciplina ainda não implementado.");
    }
}
