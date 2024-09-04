package Repository;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;

import Model.Professor;

public class ProfessorRepository {
    private String arquivoCSV;

    public ProfessorRepository(String arquivoCSV) {
        this.arquivoCSV = arquivoCSV;
    }

    public List<Professor> findProfessores() throws IOException {
        List<Professor> professores = new ArrayList<>();
        List<String> idDisciplinas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                String senha = campos[2];
                Professor professor = new Professor(id, nome, senha);

                for (int i = 3; i < campos.length; i++) {
                    String idDisciplina = campos[i];
                    idDisciplinas.add(idDisciplina);
                }
                professor.setIdDisciplinas(idDisciplinas);

                professores.add(professor);
            }
        }
        return professores;
    }

    public Professor findProfessorById(int id) throws IOException {
        List<Professor> professores = findProfessores();
        for (Professor professor : professores) {
            if (professor.getId() == id) {
                return professor;
            }
        }
        return null; // retorna null se não encontrar nenhuma disciplina com o ID fornecido
    }

    public void writeProfessor(Professor professor) throws IOException {
        // Escreve os professors de volta para o arquivo CSV.
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoCSV))) {
            writer.print(professor.getId());
            writer.print(",");
            writer.print(professor.getNome());
            writer.print(",");
            writer.print(professor.getSenha());
            // for (String ids : professor.getIdDisciplinas()) {
            // writer.print(",");
            // writer.print(ids.);
            // }
        }
    }
}
