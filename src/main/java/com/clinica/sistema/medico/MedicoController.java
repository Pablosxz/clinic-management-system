package com.clinica.sistema.medico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/medico")
@Tag(name = "Médico", description = "Gerenciamento dos médicos")
public class MedicoController {

    private final MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    @Operation(summary = "Get médicos", description = "Retorna todos os médicos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public List<Medico> getMedicos() {
        return medicoService.getMedicos();
    }

    @PostMapping
    @Operation(summary = "Registrar um novo médico", description = "Registra um médico de acordo com os detalhes passados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Médico registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public void registerNewMedico(@RequestBody Medico medico){
        medicoService.addNewMedico(medico);
    }

    @DeleteMapping(path = "{medicoId}")
    @Operation(summary = "Deletar um médico", description = "Deleta um médico da base de dados por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Médico não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public void deleteMedico(@PathVariable("medicoId") Long medicoId){
        medicoService.deleteMedico(medicoId);
    }

    @PutMapping(path = "{medicoId}")
    @Operation(summary = "Atualizar informações do médico", description = "Permite a atualização do nome e do email de um médico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Médico não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public void updateMedico(@PathVariable("medicoId") Long medicoId,
                               @RequestParam(required = false) String nomeCompleto,
                               @RequestParam(required = false) String email){
        medicoService.updateMedico(medicoId, nomeCompleto, email);
    }
}
