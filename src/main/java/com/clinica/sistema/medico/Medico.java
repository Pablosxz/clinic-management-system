package com.clinica.sistema.medico;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String conselhoMedico;
    private String ufConselho;
    private String numeroConselho;
    private String cbo;
    private String cpf;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String telefone;
    private String email;

    public Medico(String nomeCompleto, String conselhoMedico, String ufConselho, String numeroConselho, String cbo, String cpf, String logradouro, String bairro, String cidade, String uf, String cep, String telefone, String email) {
        this.nomeCompleto = nomeCompleto;
        this.conselhoMedico = conselhoMedico;
        this.ufConselho = ufConselho;
        this.numeroConselho = numeroConselho;
        this.cbo = cbo;
        this.cpf = cpf;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
    }

}