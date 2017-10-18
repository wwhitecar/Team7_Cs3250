package com.team7.app.services;

import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.repositories.ProfessorRepository;
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
public class ProfessorServicesImplTest {

    @Mock
    ProfessorRepository pRepo;
    ProfessorServicesImpl profServ;

    @Before
    public void before() {
        profServ = new ProfessorServicesImpl();
        profServ.professorRepository = pRepo;
    }

    @Test
    public void listAllProfessorList(){
        Iterable<ProfessorDto> sectionList = new ArrayList<>();
        when(pRepo.findAll()).thenReturn(sectionList);
        assertNotNull(profServ.listAllProfessor());
    }

    @Test
    public void getCourseByIdTest(){
        ProfessorDto professor = new ProfessorDto();

        when(pRepo.findOne(anyInt())).thenReturn(professor);
        assertNotNull(profServ.getProfessorById(123));
    }

    @Test
    public void saveCourseTest(){
        ProfessorDto professor = new ProfessorDto();
        when(pRepo.save(professor)).thenReturn(professor);
        assertNotNull(profServ.saveProfessor(professor));
    }

    @Test
    public void deleteCourseTest(){
        profServ.deleteProfessor(123);
    }
}
