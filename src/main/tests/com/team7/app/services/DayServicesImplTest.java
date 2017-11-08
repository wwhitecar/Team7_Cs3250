package com.team7.app.services;

import com.team7.app.business.dto.DayDto;
import com.team7.app.repositories.DayRepository;
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
public class DayServicesImplTest {

    @Mock
    DayRepository dayRepo;
    DayServicesImpl dayServ;

    @Before
    public void before(){
        dayServ = new DayServicesImpl();
        dayServ.setDayRepository(dayRepo);
    }

    @Test
    public void listAllDaysList(){
        Iterable<DayDto> dayList = new ArrayList<>();
        when(dayRepo.findAll()).thenReturn(dayList);
        assertNotNull(dayServ.listAllDays());
    }

    @Test
    public void getDayByIdTest(){
        DayDto day = new DayDto();
        when(dayRepo.findOne(anyInt())).thenReturn(day);
        assertNotNull(dayServ.getDayByName(123));
    }

    @Test
    public void saveDayTest(){
        DayDto day = new DayDto();
        when(dayRepo.save(day)).thenReturn(day);
        assertNotNull(dayServ.saveDay(day));
    }

    @Test
    public void deleteDayTest(){
        dayServ.deleteDayByName(123);
    }
}
