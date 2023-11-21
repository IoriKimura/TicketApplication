package ru.iorikimura.elitejavaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PreliterateApplication {

	public static void main(String[] args) {
		// Метод для запуска проекта
		// Входящий аргумент сообщает спрингу относительно какого класса сканировать проект на компоненты
		SpringApplication.run(PreliterateApplication.class, args);
	}

}
