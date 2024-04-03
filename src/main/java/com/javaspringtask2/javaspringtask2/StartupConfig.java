package com.javaspringtask2.javaspringtask2;

import com.javaspringtask2.javaspringtask2.model.Restaurant;
import com.javaspringtask2.javaspringtask2.model.RestaurantType;
import com.javaspringtask2.javaspringtask2.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupConfig implements CommandLineRunner {
    private final RestaurantRepository restaurantRepository;

    public StartupConfig(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantId(1);
        restaurant1.setCity("Konya");
        restaurant1.setState("Konya");
        restaurant1.setAltitude(37.8716); // Konya'nın enlem bilgisi
        restaurant1.setLongitude(32.4860); // Konya'nın boylam bilgisi
        restaurant1.setRestaurantType(RestaurantType.DONER);
        restaurantRepository.save(restaurant1);

        // İstanbul Kartal'da bir restoran oluştur
        Restaurant restaurant2 = new Restaurant();
        restaurant2.setRestaurantId(2);
        restaurant2.setCity("Istanbul");
        restaurant2.setState("Istanbul");
        restaurant2.setAltitude(40.8932); // İstanbul Kartal'ın enlem bilgisi
        restaurant2.setLongitude(29.2163); // İstanbul Kartal'ın boylam bilgisi
        restaurant2.setRestaurantType(RestaurantType.KOFTE);
        restaurantRepository.save(restaurant2);

        Restaurant customer = restaurantRepository.save(restaurant1);
        Restaurant customer2 = restaurantRepository.save(restaurant2);
    }
}