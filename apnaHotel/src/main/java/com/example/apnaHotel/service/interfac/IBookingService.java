package com.example.apnaHotel.service.interfac;

import com.example.apnaHotel.dto.Response;
import com.example.apnaHotel.entity.Booking;

public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);

}
