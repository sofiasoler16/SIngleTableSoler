package com.example.sigleTable;

import com.example.sigleTable.entidades.Profesor;
import com.example.sigleTable.entidades.Alumno;
import com.example.sigleTable.enuneraciones.Especialidades;
import com.example.sigleTable.enuneraciones.Titulos;
import com.example.sigleTable.repositorios.AlumnoRepository;
import com.example.sigleTable.repositorios.PersonaRepository;
import com.example.sigleTable.repositorios.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class SigleTableApplication {

	private static final Logger logger = LoggerFactory.getLogger(SigleTableApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SigleTableApplication.class, args);
		System.out.println("Aplicación en funcionamiento");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository,
						   AlumnoRepository alumnoRepository,
						   ProfesorRepository profesorRepository) {
		return args -> {
			// Crear dos profesores
			Profesor profesor1 = Profesor.builder()
					.nombre("Alberto")
					.apellido("Cortez")
					.fechaIngreso(LocalDate.of(2022, 1, 1))
					.cantHijos(2)
					.titulo(Titulos.MASTER)
					.sueldo(new BigDecimal("123.45"))
					.build();

			Profesor profesor2 = Profesor.builder()
					.nombre("Laura")
					.apellido("Gómez")
					.fechaIngreso(LocalDate.of(2021, 9, 15))
					.cantHijos(1)
					.titulo(Titulos.LICENCIADO)
					.sueldo(new BigDecimal("150.75"))
					.build();

			// Crear dos alumnos
			Alumno alumno1 = Alumno.builder()
					.nombre("Carlos")
					.apellido("Pérez")
					.legajo(62085)
					.especialidad(Especialidades.BACHILLER)
					.build();

			Alumno alumno2 = Alumno.builder()
					.nombre("Ana")
					.apellido("López")
					.legajo(62082)
					.especialidad(Especialidades.PERITO_MERCANTIL)
					.build();

			// Persistir los profesores
			profesorRepository.save(profesor1);
			profesorRepository.save(profesor2);

			// Persistir los alumnos
			alumnoRepository.save(alumno1);
			alumnoRepository.save(alumno2);

			logger.info("Profesores y alumnos creados y persistidos correctamente.");
		};
	}
}