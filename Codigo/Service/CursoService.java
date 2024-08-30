package Service;

import java.io.IOException;
import java.util.List;

import Model.Curso;
import Model.Disciplina;
import Repository.CursoRepository;

public class CursoService {
    private CursoRepository cursoRepository; 

    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    //Método para adicionar disciplina ao curso
    public void adicionarDisciplina(Curso curso, Disciplina disciplina) throws IOException {
        List<Disciplina> disciplinas = curso.getDisciplinas(); 
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }

        cursoRepository.writeCurso(curso); 

    }

    // Método para remover disciplina do curso
    public void removerDisciplina(Curso curso, Disciplina disciplina) throws IOException {
        List<Disciplina> disciplinas = curso.getDisciplinas(); 
        disciplinas.remove(disciplina);
        cursoRepository.writeCurso(curso); 
    }

    


}


