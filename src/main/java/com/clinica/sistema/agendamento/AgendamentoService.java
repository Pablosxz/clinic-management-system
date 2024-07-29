package com.clinica.sistema.agendamento;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    @Autowired
    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentoRepository.findAll();
    }


    public void addNewAgendamento(Agendamento agendamento) {
        Optional<Agendamento> existingAgendamentos = agendamentoRepository.findByMedicoAndDataConsultaAndHoraConsulta(
                agendamento.getMedico(), agendamento.getDataConsulta(), agendamento.getHoraConsulta()
        );
        if (!existingAgendamentos.isEmpty()){
            throw new IllegalStateException("Já existe um agendamento para o mesmo médico, dia e horário fornecidos.");
        }
        agendamentoRepository.save(agendamento);
    }

    public void deleteAgendamento(Long agendamentoId) {
        boolean exists = agendamentoRepository.existsById(agendamentoId);
        if (!exists){
            throw new IllegalStateException("Agendamento com o id " + agendamentoId + " não existe.");
        }
        agendamentoRepository.deleteById(agendamentoId);
    }

    @Transactional
    public void updateAgendamento(Long agendamentoId, String dataConsultaNew, String horaConsultaNew) {
        Agendamento agendamento = agendamentoRepository.findById(agendamentoId).orElseThrow(() -> new IllegalStateException(
                "Agendamento com o id " + agendamentoId + " não existe."));

        // Converte data e hora
        LocalDate dataConsulta = LocalDate.parse(dataConsultaNew);
        LocalTime horaConsulta = LocalTime.parse(horaConsultaNew);

        // Verifica se a data e horário estão disponíveis
        Optional<Agendamento> existingAgendamentos = agendamentoRepository.findByMedicoAndDataConsultaAndHoraConsulta(
                agendamento.getMedico(), dataConsulta, horaConsulta
        );
        if (!existingAgendamentos.isEmpty()){
            throw new IllegalStateException("Já existe um agendamento para o mesmo médico, dia: " + dataConsulta
                    + "e horário:" + horaConsulta + ".");
        }

        // Atribui a nova data e o novo horário
        agendamento.setDataConsulta(dataConsulta);
        agendamento.setHoraConsulta(horaConsulta);
    }
}