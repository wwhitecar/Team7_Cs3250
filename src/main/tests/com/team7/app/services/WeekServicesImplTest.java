package com.team7.app.services;

import com.team7.app.business.dto.WeekDto;
import com.team7.app.repositories.WeekRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeekServicesImplTest {

    @Mock
    WeekRepository weekRepo;
    WeekServicesImpl weekServices;

    @Before
    public void before(){
        weekServices = new WeekServicesImpl();
        weekServices.setWeekService(weekRepo);
    }

    @Test
    public void listAllWeeks() throws Exception {
        Iterable<WeekDto> weekList = new ArrayList<>();
        when(weekRepo.findAll()).thenReturn(weekList);
        assertNotNull(weekServices.listAllWeeks());
    }

    @Test
    public void getWeekByDbKey() throws Exception {
        WeekDto week = new WeekDto();
        when(weekRepo.findOne(anyInt())).thenReturn(week);
        assertNotNull(weekServices.getWeekByDbKey(5));
    }

    @Test
    public void saveWeek() throws Exception {
        WeekDto week = new WeekDto();
        when(weekRepo.save(week)).thenReturn(week);
        assertNotNull(weekServices.saveWeek(week));
    }

    @Test
    public void deleteWeekByDbKey() throws Exception {
        weekServices.deleteWeekByDbKey(7);
    }

}