package com.manhattan.services.interfaces;

import com.manhattan.models.dtos.UserSoldDto;
import com.manhattan.models.dtos.UsersAndProductsDto;
import com.manhattan.models.entities.User;

import java.util.List;

public interface UserService {
    User getRandomUser();

    void saveAll(Iterable<User> collect);

    List<UserSoldDto> getAllUsersWithMoreThanOneSoldProducts();

    UsersAndProductsDto getAllUsersWithMoreThanOneSoldProductsOrderByProductSoldDescThenByLastName();
}
