package com.team7.app.services;

import com.team7.app.business.dto.SemesterDto;
import com.team7.app.repositories.SemesterRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SemesterServicesImplTest {
    @Mock
    private SemesterRepository semesterRepo;

    private SemesterServicesImpl semesterService;

    private SemesterDto semester;

    @Before
    public void before(){
        semester = new SemesterDto(null);
        semesterService = new SemesterServicesImpl();
        semesterService.setSemesterRepository(semesterRepo);
    }

    @Test
    public void listAllSemesters() throws Exception {
        List<SemesterDto> listy = new ArrayList<>();
        when(semesterRepo.findAll()).thenReturn(listy);
        assertNotNull(semesterService.listAllSemesters());
    }

    @Test
    public void getSemesterByName() throws Exception {
        when(semesterRepo.findOne(anyInt())).thenReturn(semester);
        assertEquals(semesterService.getSemesterById(semester.getDbKey()), semester);
    }

    @Test
    public void saveSemester() throws Exception {
        when(semesterRepo.save(semester)).thenReturn(semester);
        assertEquals(semesterService.saveSemester(semester), semester);
    }

    @Test
    public void deleteSemesterByName() throws Exception {
        semesterService.deleteSemesterById(semester.getDbKey());
    }

}