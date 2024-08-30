package Service;

import Model.Aluno;
import java.util.List;
import java.io.IOException;
import Repository.DisciplinaRepository;

public class DisciplinaService {
    private DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository){
        this.disciplinaRepository = disciplinaRepository;
    }

    // Método para adicionar aluno
    public void adicionarAluno(int disciplinaId, Aluno aluno) throws IOException {
        // Busca a disciplina no repositório
        var disciplina = disciplinaRepository.findDisciplinaById(disciplinaId); 

        if (disciplina != null && disciplina.isAtivo()) {
            List<Aluno> alunos = disciplina.getAlunos();

            if (!alunos.contains(aluno)) {
                alunos.add(aluno);
                disciplinaRepository.writeDisciplina(disciplina); // Salva a disciplina
            } else {
                System.out.println("Aluno já está matriculado nesta disciplina.");
            }
        } else {
            System.out.println("Disciplina não encontrada ou inativa.");
        }
    }

    // Método para remover aluno
    public void removerAluno(int disciplinaId, Aluno aluno) throws IOException {
        var disciplina = disciplinaRepository.findDisciplinaById(disciplinaId);

        if (disciplina != null) {
            List<Aluno> alunos = disciplina.getAlunos();

            if (alunos.contains(aluno)) {
                alunos.remove(aluno);
                disciplinaRepository.writeDisciplina(disciplina);
            } else {
                System.out.println("Aluno não está matriculado nesta disciplina.");
            }
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }
}