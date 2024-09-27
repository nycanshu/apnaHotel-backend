package com.example.apnaHotel.service.interfac;

import com.example.apnaHotel.dto.LoginRequest;
import com.example.apnaHotel.dto.Response;
import com.example.apnaHotel.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}
