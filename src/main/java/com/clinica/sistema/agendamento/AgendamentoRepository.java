package com.clinica.sistema.agendamento;

import com.clinica.sistema.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Optional<Agendamento> findByMedicoAndDataConsultaAndHoraConsulta(Medico medico, LocalDate dataConsulta, LocalTime horaConsulta);
}
