package br.edu.insper.exercicio.filmes;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@CrossOrigin(origins = "http://localhost:5173") // ajuste se precisar
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }

    // TODOS autenticados podem listar
    @GetMapping
    public List<Filme> listar() {
        return service.listar();
    }

    // TODOS autenticados podem cadastrar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Filme criar(@Valid @RequestBody Filme filme) {
        return service.criar(filme);
    }

    // SOMENTE admin (ou quem tiver a permissão delete:movies) pode excluir
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('delete:movies') or hasRole('admin')")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

