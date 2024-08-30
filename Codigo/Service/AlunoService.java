package Service;

import Model.Disciplina;
import Model.Aluno;


public class AlunoService {
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
}
