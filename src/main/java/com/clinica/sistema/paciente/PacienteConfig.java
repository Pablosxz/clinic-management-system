package com.clinica.sistema.paciente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.AUGUST;

@Configuration
public class PacienteConfig {

    @Bean
    CommandLineRunner commandLineRunnerPaciente(PacienteRepository repository){
        return args -> {
            Paciente maria = new Paciente(
                    "Maria dos Santos",
                    "Feminino",
                    LocalDate.of(2000, AUGUST, 5),
                    "125.989.234-98",
                    "928.937.231",
                    "SSP",
                    "-",
                    "Boa vista",
                    "Mossoró",
                    "RN",
                    "59630-072",
                    "maria.santos@gmail.com",
                    "84 9 8765-0273",
                    "Diabetes"
            );

            Paciente joao = new Paciente(
                    "João dos Santos",
                    "Masculino",
                    LocalDate.of(2002, AUGUST, 23),
                    "125.989.234-56",
                    "358.937.231",
                    "SSP",
                    "-",
                    "Boa vista",
                    "Mossoró",
                    "RN",
                    "59630-072",
                    "joao.santos@gmail.com",
                    "84 9 9865-0273",
                    "Diabetes"
            );
            repository.saveAll(List.of(maria, joao));
        };
    }
}
