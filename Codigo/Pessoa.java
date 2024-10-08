public class Pessoa {
    private String nome;
    private String id;
    private String senha;
    private IPessoa tipo;

    // Construtor para inicializar uma Pessoa
    public Pessoa(String nome, String id, String senha, IPessoa tipo) {
        this.nome = nome;
        this.id = id;
        this.senha = senha;
        this.tipo = tipo;
    }

    // Método para renomear a pessoa
    public void renomear(String nome) {
        this.nome = nome;
    }

    // Método privado para encontrar o tipo de pessoa a partir de uma string
    private IPessoa findTipoByString(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo não pode ser nulo");
        }

        switch (tipo.toUpperCase()) {
            case "PROFESSOR": {
                return new Professor("", "", "");
                //Construindo professor vazio.
            }
            case "ALUNO": {
                return new Aluno();
            }
            case "SECRETARIO": {
                return new Secretario();
            }

            default:
            throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
        }
    }

    // Getters e Setters
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

    public IPessoa getTipo() {
        return tipo;
    }

    public void setTipo(IPessoa tipo) {
        this.tipo = tipo;
    }
}
