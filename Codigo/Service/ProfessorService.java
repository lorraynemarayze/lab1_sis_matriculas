package Service;

import java.util.List;

import Model.Aluno;
import Model.Disciplina;
import Repository.DisciplinaRepository;
import Repository.ProfessorRepository;
import java.io.IOException;
import java.util.Optional;

public class ProfessorService {
    private ProfessorRepository professorRepository;
    private DisciplinaRepository disciplinaRepository;

    public ProfessorService(ProfessorRepository professorRepository, DisciplinaRepository disciplinaRepository) {
        this.professorRepository = professorRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public void cadastrarEmDisciplina(int professorId, String disciplinaId) throws IOException {
        // Busca o professor no repositório
        var professor = professorRepository.findProfessorById(professorId);

        if (professor != null) {
            professor.cadastrarEmDisciplina(disciplinaId);
            professorRepository.writeProfessor(professor); // Salva o professor
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public void imprimirDisciplinas(int professorId) throws IOException {
        var professor = professorRepository.findProfessorById(professorId);

        if (professor != null) {
            List<String> idDisciplinas = professor.getIdDisciplinas();
            if (idDisciplinas.isEmpty()) {
                System.out.println("Este professor não está cadastrado em nenhuma disciplina.");
                return;
            }
            System.out.println("Disciplinas ministradas por este professor:");
            for (String disciplina : idDisciplinas) {
                System.out.println("- " + disciplina);
            }
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public void imprimirAlunosDeDisciplina(int professorId, String disciplinaId) throws IOException {
        var professor = professorRepository.findProfessorById(professorId);

        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        Disciplina disciplina = disciplinaRepository.findDisciplinaById(Integer.parseInt(disciplinaId));

        if (disciplina != null) {
            List<Aluno> alunos = disciplina.getAlunos();

            if (alunos.isEmpty()) {
                System.out.println("Não há alunos matriculados nesta disciplina.");
            } else {
                System.out.println("Alunos matriculados em " + disciplina.getNome() + ":");
                for (Aluno aluno : alunos) {
                    System.out.println("- " + aluno.getNome());
                }
            }
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }
}