package com.clinica.sistema.paciente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/paciente")
@Tag(name = "Paciente", description = "Gerenciamento dos pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    @Operation(summary = "Get de pacientes", description = "Retorna os pacientes cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public List<Paciente> getPacientes() {
        return pacienteService.getPacientes();
    }

    @PostMapping
    @Operation(summary = "Registrar paciente", description = "Registra um novo paciente com os detalhes passados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paciente registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public void registerNewPaciente(@RequestBody Paciente paciente){
        pacienteService.addNewPaciente(paciente);
    }

    @DeleteMapping(path = "{pacienteId}")
    @Operation(summary = "Deletar paciente", description = "Deleta um paciente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public void deletePaciente(@PathVariable("pacienteId") Long pacienteId){
        pacienteService.deletePaciente(pacienteId);
    }

    @PutMapping(path = "{pacienteId}")
    @Operation(summary = "Atualizar paciente", description = "Permite atualizar nome e email de um paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public void updatePaciente(@PathVariable("pacienteId") Long pacienteId,
                               @RequestParam(required = false) String nomeCompleto,
                               @RequestParam(required = false) String email){
        pacienteService.updatePaciente(pacienteId, nomeCompleto, email);
    }
}
