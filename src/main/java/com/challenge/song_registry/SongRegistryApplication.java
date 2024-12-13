package com.challenge.song_registry;

import com.challenge.song_registry.main.Main;
import com.challenge.song_registry.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SongRegistryApplication implements CommandLineRunner {

	@Autowired
	private SingerRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SongRegistryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repository);
		main.showMenu();
	}
}
