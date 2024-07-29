package com.clinica.sistema.medico;

import jakarta.persistence.*;

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

    public Medico() {
    }

    public Medico(Long id, String nomeCompleto, String conselhoMedico, String ufConselho, String numeroConselho, String cbo, String cpf, String logradouro, String bairro, String cidade, String uf, String cep, String telefone, String email) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getConselhoMedico() {
        return conselhoMedico;
    }

    public void setConselhoMedico(String conselhoMedico) {
        this.conselhoMedico = conselhoMedico;
    }

    public String getUfConselho() {
        return ufConselho;
    }

    public void setUfConselho(String ufConselho) {
        this.ufConselho = ufConselho;
    }

    public String getNumeroConselho() {
        return numeroConselho;
    }

    public void setNumeroConselho(String numeroConselho) {
        this.numeroConselho = numeroConselho;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", conselhoMedico='" + conselhoMedico + '\'' +
                ", ufConselho='" + ufConselho + '\'' +
                ", numeroConselho='" + numeroConselho + '\'' +
                ", cbo='" + cbo + '\'' +
                ", cpf='" + cpf + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", cep='" + cep + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}