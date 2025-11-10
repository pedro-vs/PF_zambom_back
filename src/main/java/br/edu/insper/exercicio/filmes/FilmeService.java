package br.edu.insper.exercicio.filmes;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository repo;

    public FilmeService(FilmeRepository repo) {
        this.repo = repo;
    }

    public List<Filme> listar() {
        return repo.findAll();
    }

    public Filme criar(Filme filme) {
        return repo.save(filme);
    }

    public void excluir(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Filme não encontrado");
        }
        repo.deleteById(id);
    }
}

