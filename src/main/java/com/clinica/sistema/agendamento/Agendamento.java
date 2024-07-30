package com.clinica.sistema.agendamento;

import com.clinica.sistema.medico.Medico;
import com.clinica.sistema.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public Agendamento(Medico medico, Paciente paciente, String motivoConsulta, LocalDate dataConsulta, LocalTime horaConsulta, String localConsulta, String observacoes) {
        this.medico = medico;
        this.paciente = paciente;
        this.motivoConsulta = motivoConsulta;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.localConsulta = localConsulta;
        this.observacoes = observacoes;
    }
}