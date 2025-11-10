package br.edu.insper.exercicio.filmes;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Column(length = 1000)
    private String descricao;

    @NotNull
    @Min(0) @Max(5)
    private Integer nota;

    @NotBlank
    private String diretor;

    public Filme() {}

    public Filme(String nome, String descricao, Integer nota, String diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.nota = nota;
        this.diretor = diretor;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }
    public String getDiretor() { return diretor; }
    public void setDiretor(String diretor) { this.diretor = diretor; }
}
