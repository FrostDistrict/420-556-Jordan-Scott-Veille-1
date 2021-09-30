package com.scott.reserved;

import com.scott.reserved.model.Client;
import com.scott.reserved.model.Reservation;
import com.scott.reserved.model.Restaurant;
import com.scott.reserved.model.Schedule;
import com.scott.reserved.repository.ClientRepository;
import com.scott.reserved.repository.ReservationRepository;
import com.scott.reserved.repository.RestaurantRepository;
import com.scott.reserved.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@SpringBootApplication
@EnableMongoRepositories("com.scott.reserved.repository")
public class ReservedApplication implements CommandLineRunner {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReservedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Restaurant rest1 = new Restaurant("Mcdonalds", "Fine cuisine Americaine.", "514-364-4313", "", "info@mcdonalds.com", 20);
        Schedule schedule = new Schedule();
        for (int i=1; i<8; i++){
            schedule.setOpeningClosingTimes(DayOfWeek.of(i).name(), LocalTime.of(15, 0), LocalTime.of(22, 0));
        }
        rest1.setSchedule(schedule);

        Restaurant rest2 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);
        Restaurant rest3 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);
        Restaurant rest4 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);
        Restaurant rest5 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);
        Restaurant rest6 = new Restaurant("toto", "restorante", "test", "test", "test@gmail.com", 2);

        Client cli1 = new Client("Default", "Le Test", "toto@mail.com", "514-444-4442");
        Client cli2 = new Client("toto", "lastname", "toto@mail.com", "514-444-4442");
        Client cli3 = new Client("toto", "lastname", "toto@mail.com", "514-444-4442");
        Client cli4 = new Client("toto", "lastname", "toto@mail.com", "514-444-4442");

        Reservation reservation1 = new Reservation(LocalDate.now().plusDays(2), LocalTime.of(18, 0), 5, "default", "default");
        Reservation reservation2 = new Reservation(LocalDate.now().plusDays(2), LocalTime.of(18, 0), 5, "default", "default");
        Reservation reservation3 = new Reservation(LocalDate.now().plusDays(2), LocalTime.of(18, 0), 5, "default", "default");
        Reservation reservation4 = new Reservation(LocalDate.now().plusDays(2), LocalTime.of(18, 0), 5, "default", "default");

        cli1.setId("default");
        rest1.setId("default");

        reservationRepository.deleteAll();
        clientRepository.deleteAll();
        restaurantRepository.deleteAll();

        reservationRepository.saveAll(Arrays.asList(reservation1, reservation2, reservation3, reservation4));
        clientRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));
        restaurantRepository.saveAll(Arrays.asList(rest1, rest2, rest3, rest4, rest5, rest6));
    }
}
