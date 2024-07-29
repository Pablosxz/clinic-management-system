package com.clinica.sistema.paciente;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> getPacientes() {
        return pacienteRepository.findAll();
    }


    public void addNewPaciente(Paciente paciente) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findPacienteByEmail(paciente.getEmail());
        if (pacienteOptional.isPresent()){
            throw new IllegalStateException("Email já cadastrado.");
        }
        pacienteRepository.save(paciente);
    }

    public void deletePaciente(Long pacienteId) {
        boolean exists = pacienteRepository.existsById(pacienteId);
        if (!exists){
            throw new IllegalStateException("Paciente com o id " + pacienteId + " não existe.");
        }
        pacienteRepository.deleteById(pacienteId);
    }

    @Transactional
    public void updatePaciente(Long pacienteId, String nomeCompleto, String email) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() -> new IllegalStateException(
                "Paciente com o id " + pacienteId + " não existe."));

        if (nomeCompleto != null && nomeCompleto.length() > 0
        && !Objects.equals(paciente.getNomeCompleto(), nomeCompleto)){
            paciente.setNomeCompleto(nomeCompleto);
        }

        if (email != null && email.length() > 0
        && !Objects.equals(paciente.getEmail(), email)){
            Optional<Paciente> pacienteOptional = pacienteRepository.findPacienteByEmail(email);
            if (pacienteOptional.isPresent()){
                throw new IllegalStateException("Já possui um usuário cadastrado com este email.");
            }
            paciente.setEmail(email);
        }


    }

}
