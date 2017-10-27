package com.team7.app.controller;

import com.team7.app.business.dto.BuildingDto;
import com.team7.app.services.BuildingServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BuildingControllerTest {

    @Mock
    BuildingServicesImpl buildingMock;

    BuildingController buildingController = new BuildingController();

    BuildingDto building;

    @Before
    public void before(){
        buildingController.setBuildingServices(buildingMock);
        building = new BuildingDto("Building Name");
    }

    @Test
    public void createBuilding() throws Exception {
        assertEquals(buildingController.createBuilding("Building Name"),
                ("Unable to create Builing" + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));

        when(buildingMock.saveBuilding(anyObject())).thenReturn(building);
        assertEquals(buildingController.createBuilding("Building Name"),
                ("Successfully created Building"
                        + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

    @Test
    public void updateBuilding() throws Exception {
        List<BuildingDto> listy = new ArrayList<>();
        listy.add(building);
        when(buildingMock.listAllBuilding()).thenReturn(listy);
        when(buildingMock.getBuildingByName(anyInt())).thenReturn(building);
        assertEquals(buildingController.updateBuilding("Building Name", "New Building Name"),
                ("Successfully Updated" + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

    @Test
    public void readBuildingByName() throws Exception {
        List<BuildingDto> listy = new ArrayList<>();
        listy.add(building);
        when(buildingMock.listAllBuilding()).thenReturn(listy);
        when(buildingMock.getBuildingByName(anyInt())).thenReturn(building);
        assertEquals(buildingController.readBuildingByName("Building Name"),
                building.toString());
    }

    @Test
    public void deleteBuildingByName() throws Exception {
        List<BuildingDto> listy = new ArrayList<>();
        listy.add(building);
        when(buildingMock.listAllBuilding()).thenReturn(listy);

        assertEquals(buildingController.deleteBuildingByName("Building Name"),
                ("Removed Building"
                        + "<br/> <a href=" + "/"
                        + ">Go Back to main screen</a>"));
    }

}