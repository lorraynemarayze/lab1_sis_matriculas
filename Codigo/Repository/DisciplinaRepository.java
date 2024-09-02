package Repository;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;

import Model.Aluno;
import Model.Disciplina;
import Model.Professor;



public class DisciplinaRepository {
    private String arquivoCSV;
    private AlunoRepository alunoRepository;
    private ProfessorRepository professorRepository;

    public DisciplinaRepository(String arquivoCSV, AlunoRepository alunoRepository) {
        this.arquivoCSV = arquivoCSV;
        this.alunoRepository = alunoRepository;

    }

    // Este método lê todas as disciplinas do arquivo CSV.
    public List<Disciplina> findDisciplinas() throws IOException {
        List<Disciplina> disciplinas = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>(); 
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                int periodo = Integer.parseInt(campos[2]);
                int cargaHoraria = Integer.parseInt(campos[3]); 
                boolean isAtivo = Boolean.parseBoolean(campos[4]);
                Disciplina disciplina = new Disciplina(id, nome, periodo, cargaHoraria, isAtivo);

                int idProfessor = Integer.parseInt(campos[5]); 
                Professor professor = professorRepository.findProfessorById(idProfessor);
                disciplina.setProfessor(professor);

                for (int i = 3; i < campos.length; i++) {
                    int idAluno = Integer.parseInt(campos[i]);
                    Aluno aluno = alunoRepository.findAlunoById(idAluno);
                    alunos.add(aluno);
                }
                disciplinas.add(disciplina);
            }
        }
        return disciplinas;
    }

    // Este método busca uma disciplina pelo ID no arquivo CSV.
    public Disciplina findDisciplinaById(int id) throws IOException {
        List<Disciplina> disciplinas = findDisciplinas();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                return disciplina;
            }
        }
        return null; // retorna null se não encontrar nenhuma disciplina com o ID fornecido
    }

    public void writeDisciplina (Disciplina disciplina) throws IOException{
        // Escreve os disciplinas de volta para o arquivo CSV.
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoCSV))) {
            writer.print(disciplina.getId());
            writer.print(",");
            writer.print(disciplina.getNome());
            writer.print(",");
            writer.print(disciplina.getPeriodo());
            writer.print(",");
            writer.print(disciplina.isAtivo());
            writer.print(",");
            writer.print(disciplina.getProfessor().getId());
            for (Aluno a : disciplina.getAlunos()) {
                writer.print(",");
                writer.print(a.getId());
            }
        }
    }
} 