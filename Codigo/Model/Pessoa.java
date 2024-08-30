package Model;

public class Pessoa {
    private String nome;
    private int id;
    private String senha;
    private String tipo;

    // Construtor para inicializar uma Pessoa
    public Pessoa(String nome, int id, String senha) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.tipo = null;
    }

    // Método para renomear a pessoa
    public void renomear(String nome) {
        this.nome = nome;
    }

    // // Método privado para encontrar o tipo de pessoa a partir de uma string
    // private IPessoa findTipoByString(String tipo) {
    //     if (tipo == null) {
    //         throw new IllegalArgumentException("Tipo não pode ser nulo");
    //     }

    //     switch (tipo.toUpperCase()) {
    //         case "PROFESSOR": {
    //             return new Professor();
    //         }
    //         case "ALUNO": {
    //             return new Aluno();
    //         }
    //         case "SECRETARIO": {
    //             return new Secretario();
    //         }

    //         default:
    //         throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
    //     }
    // }

    // Getters e Setters
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
