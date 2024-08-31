package Model;
import java.util.List;
import java.util.ArrayList;

public class Professor extends Pessoa implements IPessoa {
    private String nome;
    private int id;
    private String senha;
    private String tipo;
    private List<String> idDisciplinas;

    public Professor(int id, String nome, String senha) {
        super(nome, id, senha);
        this.tipo = "Professor";
        this.idDisciplinas = new ArrayList<>();
    }

    public void cadastrarEmDisciplina(String disciplinaId) {
        this.idDisciplinas.add(disciplinaId);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<String> getIdDisciplinas() {
        return this.idDisciplinas;
    }

    public void setIdDisciplinas(List<String> idDisciplinas) {
        this.idDisciplinas = idDisciplinas;
    }



    @Override
    public void exibirMenu() {
        System.out.println("Menu do Professor:");
        System.out.println("1. Visualizar disciplinas");
        System.out.println("2. Imprimir alunos de uma disciplina");
    }
}
