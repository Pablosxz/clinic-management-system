package com.clinica.sistema.agendamento;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/agendamento")
@Tag(name = "Agendamento", description = "Gerenciamento dos agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @Autowired
    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    @Operation(summary = "Obter todos os agendamentos", description = "Recupera a lista de todos os agendamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public List<Agendamento> getAgendamentos() {
        return agendamentoService.getAgendamentos();
    }

    @PostMapping
    @Operation(summary = "Registrar novo agendamento", description = "Registra um agendamento com os detalhes passados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Agendamento criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public void registerNewAgendamento(@RequestBody Agendamento agendamento){
        agendamentoService.addNewAgendamento(agendamento);
    }

    @DeleteMapping(path = "{agendamentoId}")
    @Operation(summary = "Deletar um agendamento", description = "Deleta um agendamento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agendamento deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Agendamento não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public void deleteAgendamento(@PathVariable("agendamentoId") Long agendamentoId){
        agendamentoService.deleteAgendamento(agendamentoId);
    }

    @PutMapping(path = "{agendamentoId}")
    @Operation(summary = "Atualizar agendamento", description = "Atualiza a data e o horário de um agendamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agendamento atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Agendamento não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public void updateAgendamento(@PathVariable("agendamentoId") Long agendamentoId,
                               @RequestParam(required = true) String dataConsulta,
                               @RequestParam(required = true) String horaConsulta){
        agendamentoService.updateAgendamento(agendamentoId, dataConsulta, horaConsulta);
    }
}
