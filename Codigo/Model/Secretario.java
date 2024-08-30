package Model;

public class Secretario extends Pessoa implements IPessoa {

    private String nome;
    private int id;
    private String senha;
    private String tipo;

    public Secretario(String nome, int id, String senha) {
        super(nome, id, senha);
        this.tipo = "Secretario";
    }

    @Override
    public void exibirMenu() {
        System.out.println("Menu do Secretário:");
        System.out.println("1. Gerenciar Disciplinas");
        System.out.println("2. Gerenciar Professores");
        System.out.println("3. Gerenciar Usuários");
        System.out.println("4. Sair");
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
}