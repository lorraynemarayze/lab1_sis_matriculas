package Service;

public class ProfessorService {
    
    public void cadastrarEmDisciplina(String disciplina) {
        this.idDisciplinas.add(disciplina);
    }    

    public void imprimirDisciplinas() {
        if (idDisciplinas.isEmpty()) {
            System.out.println("Este professor não está cadastrado em nenhuma disciplina.");
            return;
        }
        System.out.println("Disciplinas ministradas por este professor:");
        for (String disciplina : idDisciplinas) {
            System.out.println("- " + disciplina);
        }
    }

    public void imprimirAlunosDeDisciplina(String disciplinaId) {
        // Implementação para recuperar a disciplina pelo ID e imprimir os alunos matriculados
        System.out.println("Método imprimirAlunosDeDisciplina ainda não implementado.");
    }
}
