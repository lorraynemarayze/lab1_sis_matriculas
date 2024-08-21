package lab1_sis_matriculas.Codigo;

import java.util.List;
import java.util.ArrayList;

public class Aluno implements IPessoa {
    private List<Disciplina> gradeCurricular;

    public Aluno() {
        this.gradeCurricular = new ArrayList<>();
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
            disciplina.adicionarAlunos(this); // Adiciona o aluno à disciplina
            System.out.println("Aluno matriculado em " + disciplina.getNome() + " com sucesso!");
        } else {
            System.out.println("Aluno já está matriculado nesta disciplina.");
        }
    }

    public void cancelarMatriculaDisciplina(Disciplina disciplina) {
        // Implementação para cancelar a matrícula do aluno na disciplina
        if (gradeCurricular.contains(disciplina)) {
            this.gradeCurricular.remove(disciplina);
            disciplina.removerAluno(this); // Remove o aluno da disciplina
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