package com.team7.app.controller;

import com.team7.app.business.dto.DayDto;
import com.team7.app.business.dto.RoomDto;
import com.team7.app.business.dto.WeekDto;
import com.team7.app.services.DayServices;
import com.team7.app.services.RoomServices;
import com.team7.app.services.WeekServices;
import com.team7.app.services.WeekServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that will communicate with both the webapplication
 * and the data base to transfer information.
 */

@RestController
@RequestMapping(value = "/room")
public class RoomController {

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private RoomServices roomServices;

    /**
     * Services to be used by hibernate to correctly add
     * information to the database.
     */
    @Autowired
    private WeekServices weekServices;

    @Autowired
    private static DayServices dayServices;

    /**
     * Bean to be used throughout the room class.
     * @param roomService - bean to be created
     */
    public void setRoomService(final RoomServices roomService) {
        this.roomServices = roomService;
    }

    /**
     * Creates a room and puts it in the database.
     * @param roomNumber - number of the room.
     * @param roomCapacity - capacity of the room.
     * @param buildingName - name of the building
     * @return message to be displayed after entry
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createRoom(final @RequestParam("Room Number")int roomNumber,
                     final @RequestParam("Room Capacity")int roomCapacity,
                     final @RequestParam("Building Name")String buildingName) {
        WeekDto week = new WeekDto();
        weekServices.saveWeek(week);
        RoomDto room = new RoomDto(roomNumber, roomCapacity, buildingName, week);
        room = roomServices.saveRoom(room);

        if (room != null) {
            return (room.toString()  + " Added Successfully <br/> <a href="
                    + "/" + ">Go Back to main screen</a>");
        }
        return ("Error adding Room for some reason");
    }

    /**
     * Read a user from the database.
     * @param roomNumber - number of the room
     * @return information about the room found
     */
    @RequestMapping(value = "/room_number", method = RequestMethod.GET)
    public String readRoomByNumber(
            final @RequestParam("room_number") Integer roomNumber) {
        RoomDto room = roomServices.getRoomByNumber(roomNumber);
        if (room == null) {
            return "Unable to find Room";
        }

        return room.toString()  + "<br/> <a href="
                + "/" + ">Go Back to main screen</a>";
    }

    /**
     * Update a user already in the database.
     * @param roomNumber - first name of the professor
     * @param roomCapacity - the last name of the professor.
     * @param buildingName - name of the building
     * @return String to be displayed to user after trying to update
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateRoomByNumber(
            final @RequestParam("Room Number")int roomNumber,
            final @RequestParam("Room Capacity")int roomCapacity,
            final @RequestParam("Building Name")String buildingName) {
        RoomDto room = new RoomDto(roomNumber, roomCapacity, buildingName);
        room = roomServices.saveRoom(room);
        if (room == null) {
            return "Unable to find Room";
        }
        return ("Successfully updated: <br/>"
                + readRoomByNumber(room.getRoomNumber()));
    }

    /**
     * Delete a user that is in the database.
     * @param roomNumber - number of the room to delete in database
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/id/", method = RequestMethod.POST)
    public String deleteRoomByNumber(
            final @RequestParam("room number") Integer roomNumber) {
        roomServices.deleteRoom(roomNumber);
        if (readRoomByNumber(roomNumber).equals("Unable to find Room")) {
            return ("Removed Room"
                    + "<br/> <a href=" + "/"
                    + ">Go Back to main screen</a>");
        }
        return "Unable to find student, plz try again";
    }
}
