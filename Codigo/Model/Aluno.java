package Model;

import java.util.List;
import java.util.ArrayList;

public class Aluno extends Pessoa implements IPessoa {
    private String nome;
    private int id;
    private String senha;
    private String tipo;
    private List<Disciplina> gradeCurricular;

    // Construtor com parâmetros nome e id
    public Aluno(String nome, int id, String senha) {
        super(nome, id, senha);
        this.tipo = "Aluno";
        this.gradeCurricular = new ArrayList<>();
    }

    @Override
    public void exibirMenu() {
        System.out.println("Menu do Aluno:");
        System.out.println("1. Matricular em disciplina");
        System.out.println("2. Cancelar matrícula em disciplina");
        System.out.println("3. Verificar grade curricular");
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

    public List<Disciplina> getGradeCurricular() {
        return gradeCurricular;
    }

    public void setGradeCurricular(List<Disciplina> gradeCurricular) {
        this.gradeCurricular = gradeCurricular;
    }

}