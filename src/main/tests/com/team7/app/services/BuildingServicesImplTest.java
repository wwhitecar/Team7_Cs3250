package com.team7.app.services;

import com.team7.app.business.dto.BuildingDto;
import com.team7.app.repositories.BuildingRepository;
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
public class BuildingServicesImplTest {

    @Mock
    BuildingRepository buildingRepo;
    BuildingServicesImpl buildingServ;

    @Before
    public void before(){
        buildingServ = new BuildingServicesImpl();
        buildingServ.setBuildingRepository(buildingRepo);
    }

    @Test
    public void listAllCoursesList(){
        Iterable<BuildingDto> buildingList = new ArrayList<>();
        when(buildingRepo.findAll()).thenReturn(buildingList);
        assertNotNull(buildingServ.listAllBuilding());
    }

    @Test
    public void getCourseByIdTest(){
        BuildingDto building = new BuildingDto();
        when(buildingRepo.findOne(anyInt())).thenReturn(building);
        assertNotNull(buildingServ.getBuildingByName(123));
    }

    @Test
    public void saveCourseTest(){
        BuildingDto building = new BuildingDto();
        when(buildingRepo.save(building)).thenReturn(building);
        assertNotNull(buildingServ.saveBuilding(building));
    }

    @Test
    public void deleteCourseTest(){
        buildingServ.deleteBuildingByName(123);
    }
}
