package Service;

import Model.Disciplina;
import Model.Aluno;
import java.io.IOException;
import Repository.AlunoRepository;
import Repository.DisciplinaRepository;


public class AlunoService {
    private AlunoRepository alunoRepository;
    private DisciplinaRepository disciplinaRepository;

    public AlunoService(AlunoRepository alunoRepository, DisciplinaRepository disciplinaRepository){
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public void matricularEmDisciplina(Aluno aluno, Disciplina disciplina) throws IOException {
        // Utiliza o método da AlunoRepository para buscar o aluno por ID
        Aluno alunoExistente = alunoRepository.findAlunoById(aluno.getId());

        if (alunoExistente == null) {
            System.out.println("Aluno não encontrado.");
            return; 
        }

        // Verifica se a disciplina já está na grade do aluno
        if (!alunoExistente.getGradeCurricular().contains(disciplina)) {
            alunoExistente.getGradeCurricular().add(disciplina);

            // Utiliza o método da AlunoRepository para salvar o aluno atualizado
            alunoRepository.writeAluno(alunoExistente);
            System.out.println("Aluno matriculado em " + disciplina.getNome() + " com sucesso!");
        } else {
            System.out.println("Aluno já está matriculado nesta disciplina.");
        }
    }

    public void cancelarMatriculaDisciplina(Aluno aluno, Disciplina disciplina) throws IOException {
        Aluno alunoExistente = alunoRepository.findAlunoById(aluno.getId());

        if (alunoExistente == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if (alunoExistente.getGradeCurricular().contains(disciplina)) {
            alunoExistente.getGradeCurricular().remove(disciplina);

            alunoRepository.writeAluno(alunoExistente);
            System.out.println("Matrícula em " + disciplina.getNome() + " cancelada com sucesso!");
        } else {
            System.out.println("Aluno não está matriculado nesta disciplina.");
        }
    }

    public void verGradeCurricular(Aluno aluno) throws IOException {
        Aluno alunoExistente = alunoRepository.findAlunoById(aluno.getId());

        if (alunoExistente == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if (alunoExistente.getGradeCurricular().isEmpty()) {
            System.out.println("A grade curricular está vazia.");
        } else {
            System.out.println("Disciplinas matriculadas:");
            for (Disciplina disciplina : alunoExistente.getGradeCurricular()) {
                System.out.println("- " + disciplina.getNome());
            }
        }
    }
}