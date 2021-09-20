package com.scott.reserved.repository;

import com.scott.reserved.model.Restaurant;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends BaseRepository<Restaurant, String> {
}
