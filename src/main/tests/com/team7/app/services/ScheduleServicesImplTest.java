package com.team7.app.services;

import com.team7.app.business.dto.BuildingDto;
import com.team7.app.business.dto.ScheduleDto;
import com.team7.app.repositories.BuildingRepository;
import com.team7.app.repositories.ScheduleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScheduleServicesImplTest {

    @Mock
    ScheduleRepository scheduleRepo;
    ScheduleServicesImpl scheduleServ;

    @Before
    public void before(){
       scheduleServ = new ScheduleServicesImpl();
        scheduleServ.setScheduleRepository(scheduleRepo);
    }

    @Test
    public void listAllSchedulesList(){
        Iterable<ScheduleDto> scheduleList = new ArrayList<>();
        when(scheduleRepo.findAll()).thenReturn(scheduleList);
        assertNotNull(scheduleServ.listAllSchedule());
    }

    @Test
    public void getSectionByIdTest(){
        ScheduleDto schedule = new ScheduleDto();
        when(scheduleRepo.findOne(anyInt())).thenReturn(schedule);
        assertNotNull(scheduleServ.getScheduleByName(123));
    }

    @Test
    public void saveCourseTest(){
        ScheduleDto schedule = new ScheduleDto();
        when(scheduleRepo.save(schedule)).thenReturn(schedule);
        assertNotNull(scheduleServ.saveSchedule(schedule));
    }

    @Test
    public void deleteCourseTest(){
        scheduleServ.deleteScheduleByName(123);
    }
}
