package com.team7.app.business.dto;

import org.junit.Before;
import org.junit.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BuildingDtoTest {

    BuildingDto building;
    BuildingDto buildingTwo;

    @Before
    public void before(){
        building = new BuildingDto("Building Name");
        buildingTwo = new BuildingDto();
    }

    @Test
    public void getBuildingByNameTest(){
        assertTrue(building.getBuildingByName().equals("Building Name"));
    }

    @Test
    public void setBuildingNameTest(){
        assertTrue(building.getBuildingByName().equals("Building Name"));
        building.setBuildingName("This is a new name");
        assertTrue(building.getBuildingByName().equals("This is a new name"));
    }

    @Test
    public void getDbKeyTest() {
        assertNotNull(building.getDbKey());
    }

}
