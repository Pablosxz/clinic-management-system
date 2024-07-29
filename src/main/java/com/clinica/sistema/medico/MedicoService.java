package com.clinica.sistema.medico;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> getMedicos() {
        return medicoRepository.findAll();
    }


    public void addNewMedico(Medico medico) {
        Optional<Medico> medicoOptional = medicoRepository.findMedicoByEmail(medico.getEmail());
        if (medicoOptional.isPresent()){
            throw new IllegalStateException("Email já cadastrado.");
        }
        medicoRepository.save(medico);
    }

    public void deleteMedico(Long medicoId) {
        boolean exists = medicoRepository.existsById(medicoId);
        if (!exists){
            throw new IllegalStateException("Medico com o id " + medicoId + " não existe.");
        }
        medicoRepository.deleteById(medicoId);
    }

    @Transactional
    public void updateMedico(Long medicoId, String nomeCompleto, String email) {
        Medico medico = medicoRepository.findById(medicoId).orElseThrow(() -> new IllegalStateException(
                "Medico com o id " + medicoId + " não existe."));

        if (nomeCompleto != null && nomeCompleto.length() > 0
        && !Objects.equals(medico.getNomeCompleto(), nomeCompleto)){
            medico.setNomeCompleto(nomeCompleto);
        }

        if (email != null && email.length() > 0
        && !Objects.equals(medico.getEmail(), email)){
            Optional<Medico> medicoOptional = medicoRepository.findMedicoByEmail(email);
            if (medicoOptional.isPresent()){
                throw new IllegalStateException("Já possui um usuário cadastrado com este email.");
            }
            medico.setEmail(email);
        }


    }

}
