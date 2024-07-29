package com.clinica.sistema.medico;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MedicoConfig {

    @Bean
    CommandLineRunner commandLineRunnerMedico(MedicoRepository repository){
        return args -> {
            Medico maria = new Medico(
                    "Maria do Santos",
                    "CRM",
                    "RN",
                    "123355",
                    "2251-25",
                    "125.878.345-01",
                    "-",
                    "Centro",
                    "Mossoro",
                    "RN",
                    "59630-024",
                    "84 9 9875-2983",
                    "maria@gmail.com"
            );

            Medico joao = new Medico(
                    "joao do Santos",
                    "CRM",
                    "RN",
                    "126355",
                    "2251-25",
                    "125.878.309-02",
                    "-",
                    "Aeroporto",
                    "Mossoro",
                    "RN",
                    "59630-034",
                    "84 9 9475-0923",
                    "joao@gmail.com"
            );
            repository.saveAll(List.of(maria, joao));
        };
    }
}
