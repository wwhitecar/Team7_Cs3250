package com.team7.app.services;

import com.team7.app.business.dto.SectionDto;
import com.team7.app.repositories.SectionRepository;
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
public class SectionServicesImplTest {

    @Mock
    SectionRepository sRepo;
    SectionServicesImpl sectionServ;

    @Before
    public void before(){
        sectionServ = new SectionServicesImpl();
        sectionServ.sectionRepository = sRepo;
    }

    @Test
    public void listAllCoursesList(){
        Iterable<SectionDto> sectionList = new ArrayList<>();
        when(sRepo.findAll()).thenReturn(sectionList);
        assertNotNull(sectionServ.listAllSection());
    }

    @Test
    public void getCourseByIdTest(){
        SectionDto section = new SectionDto();

        when(sRepo.findOne(anyInt())).thenReturn(section);
        assertNotNull(sectionServ.getSectionById(123));
    }

    @Test
    public void saveCourseTest(){
        SectionDto section = new SectionDto();
        when(sRepo.save(section)).thenReturn(section);
        assertNotNull(sectionServ.saveSection(section));
    }

    @Test
    public void deleteCourseTest(){
        sectionServ.deleteSection(123);
    }
}
