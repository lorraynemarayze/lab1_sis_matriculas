package Repository;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;

import Model.Disciplina;
import Model.Aluno;


public class AlunoRepository {
    private String arquivoCSV;
    private DisciplinaRepository disciplinaRepository;

    public AlunoRepository(String arquivoCSV) {
        this.arquivoCSV = arquivoCSV;
    }

    // Este método lê todos os cursos do arquivo CSV.
    public List<Aluno> findAlunos() throws IOException {
        List<Aluno> alunos = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                String senha = campos[2];
                Aluno aluno = new Aluno(nome, id, senha);
                
                for (int i = 3; i < campos.length; i++) {
                    int idDisciplina = Integer.parseInt(campos[i]);
                    Disciplina disciplina = disciplinaRepository.findDisciplinaById(idDisciplina);
                    disciplinas.add(disciplina);
                }
                
                aluno.setGradeCurricular(disciplinas);
                
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    public Aluno findAlunoById(int id) throws IOException {
        List<Aluno> alunos = findAlunos();
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null; // retorna null se não encontrar nenhuma disciplina com o ID fornecido
    }

    public void writeAluno (Aluno aluno) throws IOException{
        // Escreve os cursos de volta para o arquivo CSV.
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoCSV))) {
            writer.print(aluno.getId());
            writer.print(",");
            writer.print(aluno.getNome());
            writer.print(",");
            writer.print(aluno.getSenha());
            for (Disciplina d : aluno.getGradeCurricular()) {
                writer.print(",");
                writer.print(d.getId());
            }
        }
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }
}