package com.ua.tokarenko.hotel.service;

import com.ua.tokarenko.hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;
import com.ua.tokarenko.hotel.domain.Room;
import com.ua.tokarenko.hotel.dto.RoomDto;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<RoomDto> findAll() {
        return roomRepository.findAll()
                .stream()
                .map(room -> RoomDto
                        .builder()
                        .id(room.getId())
                        .numberRoom(room.getNumberRoom())
                        .number_of_beds(room.getNumberOfBeds())
                        .price(room.getPrice())
                        .isReserved(room.isReserved())
                        .build())
                .collect(Collectors.toList());
    }

    public RoomDto findById(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            return RoomDto
                    .builder()
                    .id(optionalRoom.get().getId())
                    .numberRoom(optionalRoom.get().getNumberRoom())
                    .number_of_beds(optionalRoom.get().getNumberOfBeds())
                    .price(optionalRoom.get().getPrice())
                    .isReserved(optionalRoom.get().isReserved())
                    .build();
        } else {
            throw new RuntimeException("Reservation not found");
        }
    }

    public RoomDto findByPrice(Long price) {
        Optional<Room> roomOptional = roomRepository.findByPrice(price);
        if (roomOptional.isPresent()) {
            return RoomDto
                    .builder()
                    .id(roomOptional.get().getId())
                    .price(roomOptional.get().getPrice())
                    .numberRoom(roomOptional.get().getNumberRoom())
                    .number_of_beds(roomOptional.get().getNumberOfBeds())
                    .isReserved(roomOptional.get().isReserved())
                    .build();
        } else {
            throw new RuntimeException("Room is not found");
        }

    }
    public RoomDto findByNumberOfBeds(Long numberOfBeds) {
        Optional<Room> roomOptional = roomRepository.findByNumberOfBeds(numberOfBeds);
        if (roomOptional.isPresent()) {
            return RoomDto
                    .builder()
                    .id(roomOptional.get().getId())
                    .numberRoom(roomOptional.get().getNumberRoom())
                    .number_of_beds(roomOptional.get().getNumberOfBeds())
                    .price(roomOptional.get().getPrice())
                    .isReserved(roomOptional.get().isReserved())
                    .build();
        } else {
            throw new RuntimeException("Room is not found");
        }
    }

    public boolean findByIsReservation(boolean isReservation) {
        List<Room> roomOptional = roomRepository.findAll();
        for (Room room : roomOptional) {
            if (!room.getReservations().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Room update(Long id, Room room) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()) {
            Room updateRoom = roomOptional.get();
            updateRoom.setId(room.getId());
            updateRoom.setNumberRoom(room.getNumberRoom());
            updateRoom.setNumberOfBeds(room.getNumberOfBeds());
            updateRoom.setPrice(room.getPrice());
            updateRoom.setReservations(room.getReservations());
            return roomRepository.save(updateRoom);
        } else {
            throw new RuntimeException("Room not found");
        }
    }


    public void deleteRoom(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            Room roomDelete = optionalRoom.get();
            roomRepository.delete(roomDelete);
        } else {
            throw new RuntimeException("Reservation not found");
        }
    }
}
