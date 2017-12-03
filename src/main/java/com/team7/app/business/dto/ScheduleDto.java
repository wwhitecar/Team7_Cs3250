package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Buildings that will be stored into the
 * database.
 */
@Entity
public class ScheduleDto {

    /**
     * Id for the database that is auto generated
     * to assure no duplicates are created.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbKey;

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    @ManyToOne
    private StudentDto studentName;

    /**
     * The Dto.
     */
    @ManyToOne
    private SectionDto sectionDto;
//
//    @OneToMany
//    private Set<RoomDto> Rooms = new HashSet<RoomDto>(0);
//
//    /**
//     * The course number to identify a course by more then
//     * just the name.
//     */
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building_name")
//    @Column(name = "building_name", unique = true, nullable = false)
//    public Set<RoomDto> getBuildingRooms() {
//        return this.Rooms;
//    }
//
//    public void setBuildingRooms(Set<RoomDto> Rooms) {
//        this.Rooms = Rooms;
//    }

    /**
     * Empty Constructer.
     */
    public ScheduleDto() {

    }

    /**
     * Param constructer.
     * @param section - section Dto
     * @param studentDto - student Dto
     */
    public ScheduleDto(final StudentDto studentDto,
                       final SectionDto section) {
        this.studentName = studentDto;
        this.sectionDto = section;
    }


    /**
     * Getter for ScheduleName.
     * @return name of the Schedule.
     */
    public StudentDto getStudentByName() {
        return studentName;
    }

    /**
     * Getter for sectionDto.
     * @return section Dto.
     */
    public SectionDto getSection() {
        return sectionDto;
    }

    /**
     * Setter for buildingName.
     * @param newStudentName - the new schedule name
     */
    public void setStudentName(final StudentDto newStudentName) {
        this.studentName = newStudentName;
    }

    /**
     * Getter for dBKey.
     * @return id of the schedule
     */
    public int getDbKey() {
        return dbKey;
    }

}


