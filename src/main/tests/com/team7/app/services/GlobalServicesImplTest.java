package com.team7.app.services;

import com.team7.app.business.dto.GlobalDto;
import com.team7.app.repositories.GlobalRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GlobalServicesImplTest {

    @Mock
    GlobalRepository gRepo;
    GlobalServicesImpl globalServ;

    @Before
    public void before() {
        globalServ = new GlobalServicesImpl();
        globalServ.setGlobalRepository(gRepo);
    }

    @Test
    public void listAllProfessorList(){
        Iterable<GlobalDto> globalList = new ArrayList<>();
        when(gRepo.findAll()).thenReturn(globalList);
        assertNotNull(globalServ.listAllGlobals());
    }

    @Test
    public void getCourseByIdTest(){
        GlobalDto global = new GlobalDto();

        when(gRepo.findOne(anyObject())).thenReturn(global);
        assertNotNull(globalServ.getGlobalByName("Name"));
    }

    @Test
    public void saveCourseTest(){
        GlobalDto global = new GlobalDto();
        when(gRepo.save(global)).thenReturn(global);
        assertNotNull(globalServ.saveGlobal(global));
    }

    @Test
    public void deleteCourseTest(){
        globalServ.deleteGlobal("Name");
    }
}
