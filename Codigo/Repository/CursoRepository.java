package Repository;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;

import Model.Curso;
import Model.Disciplina;



public class CursoRepository {
    private String arquivoTXT;
    private DisciplinaRepository disciplinaRepository;

    public CursoRepository(String arquivoTXT, DisciplinaRepository disciplinaRepository) {
        this.arquivoTXT = arquivoTXT;
        this.disciplinaRepository = disciplinaRepository;
    }

    // Este método lê todos os cursos do arquivo TXT.
    public List<Curso> findCursos() throws IOException {
        List<Curso> cursos = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoTXT))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                int qtdeCreditos = Integer.parseInt(campos[2]);
                Curso curso = new Curso(id, nome, qtdeCreditos);
                //Adiciona as disciplinas ao curso.
                for (int i = 3; i < campos.length; i++) {
                    int idDisciplina = Integer.parseInt(campos[i]);
                    Disciplina disciplina = disciplinaRepository.findDisciplinaById(idDisciplina);
                    disciplinas.add(disciplina);
                }
                
                curso.setDisciplinas(disciplinas);
                
                cursos.add(curso);
            }
        }
        return cursos;
    }

    // Este método busca um curso pelo nome no arquivo TXT.
    public Curso findCursoByNome(String nome) throws IOException {
        List<Curso> cursos = findCursos();
        for (Curso curso : cursos) {
            if (curso.getNome().equals(nome)) {
                return curso;
            }
        }
        return null; // retorna null se não encontrar nenhum curso com o nome fornecido
    }

    public void writeCurso (Curso curso) throws IOException{
        // Escreve os cursos de volta para o arquivo TXT.
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoTXT))) {
            writer.print(curso.getId());
            writer.print(",");
            writer.print(curso.getNome());
            writer.print(",");
            writer.print(curso.getQtdeCreditos());
            writer.print(",");
            writer.print(curso.isPeriodoMatricula());
            for (Disciplina d : curso.getDisciplinas()) {
                writer.print(",");
                writer.print(d.getId());
            }
        }
    }

}