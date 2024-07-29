package com.clinica.sistema.agendamento;

import com.clinica.sistema.medico.Medico;
import com.clinica.sistema.paciente.Paciente;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    private String motivoConsulta;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private String localConsulta;
    private String observacoes;

    public Agendamento() {
    }

    public Agendamento(Long id, Medico medico, Paciente paciente, String motivoConsulta, LocalDate dataConsulta, LocalTime horaConsulta, String localConsulta, String observacoes) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.motivoConsulta = motivoConsulta;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.localConsulta = localConsulta;
        this.observacoes = observacoes;
    }

    public Agendamento(Medico medico, Paciente paciente, String motivoConsulta, LocalDate dataConsulta, LocalTime horaConsulta, String localConsulta, String observacoes) {
        this.medico = medico;
        this.paciente = paciente;
        this.motivoConsulta = motivoConsulta;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.localConsulta = localConsulta;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico =  medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getLocalConsulta() {
        return localConsulta;
    }

    public void setLocalConsulta(String localConsulta) {
        this.localConsulta = localConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", motivoConsulta='" + motivoConsulta + '\'' +
                ", dataConsulta=" + dataConsulta +
                ", horaConsulta=" + horaConsulta +
                ", localConsulta='" + localConsulta + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}