import java.util.List;
import java.util.ArrayList;

public class Aluno implements IPessoa {
    private String nome;
    private String id;
    private List<Disciplina> gradeCurricular;

    // Construtor com parâmetros nome e id
    public Aluno(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.gradeCurricular = new ArrayList<>();
    }

    // Construtor padrão
    public Aluno() {
        this.gradeCurricular = new ArrayList<>();
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

    public List<Disciplina> getGradeCurricular() {
        return gradeCurricular;
    }

    public void realizarMatriculaNaMemoria(Disciplina disciplina) {
        this.gradeCurricular.add(disciplina);
    }

    public void matricularEmDisciplina(Disciplina disciplina) {
        // Implementação para matricular o aluno na disciplina
        // Verifique se a disciplina já está na grade curricular antes de adicionar
        if (!gradeCurricular.contains(disciplina)) {
            this.realizarMatriculaNaMemoria(disciplina);
            disciplina.adicionarAluno(this);
            System.out.println("Aluno matriculado em " + disciplina.getNome() + " com sucesso!");
        } else {
            System.out.println("Aluno já está matriculado nesta disciplina.");
        }
    }

    public void cancelarMatriculaDisciplina(Disciplina disciplina) {
        // Implementação para cancelar a matrícula do aluno na disciplina
        if (gradeCurricular.contains(disciplina)) {
            this.gradeCurricular.remove(disciplina);
            disciplina.removerAluno(this); 
            System.out.println("Matrícula em " + disciplina.getNome() + " cancelada com sucesso!");
        } else {
            System.out.println("Aluno não está matriculado nesta disciplina.");
        }
    }

    public void verGradeCurricular() {
        // Implementação para exibir a grade curricular do aluno
        if (gradeCurricular.isEmpty()) {
            System.out.println("A grade curricular está vazia.");
        } else {
            System.out.println("Disciplinas matriculadas:");
            for (Disciplina disciplina : gradeCurricular) {
                System.out.println("- " + disciplina.getNome());
            }
        }
    }

    @Override
    public void exibirMenu() {
        System.out.println("Menu do Aluno:");
        System.out.println("1. Matricular em disciplina");
        System.out.println("2. Cancelar matrícula em disciplina");
        System.out.println("3. Verificar grade curricular");
    }
}