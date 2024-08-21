import java.util.List;
import java.util.ArrayList;

public class Professor implements IPessoa {
    private List<String> idsClasses;

    public Professor() {
        this.idsClasses = new ArrayList<>();
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

    public void exibirMenu() {
        System.out.println("Menu do Professor:");
        System.out.println("1. Visualizar disciplinas");
        System.out.println("2. Imprimir alunos de uma disciplina");
    }

    // Método para imprimir alunos de uma disciplina (a ser implementado)
    public void imprimirAlunosDeDisciplina(String disciplinaId) {
        // Implementação para recuperar a disciplina pelo ID e imprimir os alunos matriculados
        System.out.println("Método imprimirAlunosDeDisciplina ainda não implementado.");
    }
}
