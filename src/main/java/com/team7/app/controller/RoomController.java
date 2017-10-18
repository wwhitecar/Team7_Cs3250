package com.team7.app.controller;

import com.team7.app.business.dto.BuildingDto;
import com.team7.app.business.dto.RoomDto;
import com.team7.app.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private RoomServices roomServices;

    /**
     * Bean to be used throughout the room class.
     * @param roomService - bean to be created
     */
    @Autowired
    public void setRoomService(final RoomServices roomService) {
        this.roomServices = roomService;
    }

    /**
     * Creates a room and puts it in the database.
     * @param roomNumber - number of the room.
     * @param roomCapacity - capacity of the room.
     * @return message to be displayed after entry
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createRoom(final @RequestParam("Room Number")int roomNumber,
                             final @RequestParam("Last Name")int roomCapacity,
                             final @RequestParam("Building Name")String buildingName) {
        RoomDto room = new RoomDto(roomNumber, roomCapacity, buildingName);
        roomServices.saveRoom(room);

        if (!readRoomByNumber(roomNumber).equals("Unable to find Student")) {
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
    @RequestMapping(value = "/room_number")
    public String readRoomByNumber(final @RequestParam("room_number") Integer roomNumber) {
        RoomDto room = roomServices.getRoomByNumber(roomNumber);
        if (room == null) {
            return "Unable to find Room";
        }
        String string = "/";
        return room.toString()  + "<br/> <a href="
                + string + ">Go Back to main screen</a>";
    }

    /**
     * Update a user already in the database.
     * @param roomNumber - first name of the professor
     * @param roomCapacity - the last name of the professor.
     * @return String to be displayed to user after trying to update
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateRoomByNumber(final @RequestParam("room Number")int roomNumber,
                                     final @RequestParam("room Capacity")int roomCapacity,
                                     final @RequestParam("building Name")String buildingName) {
        RoomDto room = new RoomDto(roomNumber, roomCapacity, buildingName);
        roomServices.saveRoom(room);
        return ("Successfully updated: <br/>"
                + readRoomByNumber(room.getRoomNumber()));
    }

    /**
     * Delete a user that is in the database.
     * @param roomNumber - number of the room to delete in database
     * @return String to be displayed to user after deleting them
     */
    @RequestMapping(value = "/id/", method = RequestMethod.GET)
    public String deleteRoomByNumber(final @RequestParam("room number") Integer roomNumber) {
        roomServices.deleteRoom(roomNumber);
        if (readRoomByNumber(roomNumber).equals("Unable to find Room")) {
            return ("Removed Room"
                    + "<br/> <a href=" + "/"
                    + ">Go Back to main screen</a>");
        }
        return "Unable to find student, plz try again";
    }
}
