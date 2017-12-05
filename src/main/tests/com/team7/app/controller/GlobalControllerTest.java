package com.team7.app.controller;

import com.team7.app.business.dto.GlobalDto;
import com.team7.app.services.GlobalServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GlobalControllerTest {

    @Mock
    GlobalServicesImpl globalMock;

    GlobalController globalController = new GlobalController();

    GlobalDto global;

    @Before
    public void before(){
        globalController.setGlobalService(globalMock);
        global = new GlobalDto("metro", 3);
    }


    @Test
    public void createGlobalTest() {
        List<GlobalDto> listGlobal = new ArrayList<>();
        listGlobal.add(global);
        when(globalMock.listAllGlobals()).thenReturn(listGlobal);
        assertEquals(globalController.createGlobal("metro",3), ("Failed to add School name"));
        when(globalMock.getGlobalByName(anyObject())).thenReturn(global);
        assertEquals(globalController.createGlobal("metro", 3), (global.toString() + "Added Successfully <br/> <a href="
                + "/" + ">Go Back to main screen</a>"));
    }

    @Test
    public void updateGlobalTest() {
        List<GlobalDto> listGlobal = new ArrayList<>();
        listGlobal.add(global);
        when(globalMock.listAllGlobals()).thenReturn(listGlobal);
        assertEquals(globalController.updateGlobalByName("metro",3), ("global" +" Added Successfully <br/> <a href=" + "/" + ">Go Back to main screen</a>"));
    }


    @Test
    public void deleteGlobalTest() {
        assertEquals(globalController.deleteGlobalByName("Harvard"), "Removed School"
                + "<br/> <a href=" + "/" + ">Go Back to main screen<a/>");
    }

    @Test
    public void readGlobalTest() {
        assertEquals(globalController.readGlobalByName("Harvard"), "Unable to find School");
        when(globalMock.getGlobalByName(anyString())).thenReturn(global);
        assertEquals(globalController.readGlobalByName("Harvard"), global + " <br/> <a href=" + "/" + ">Go Back to main screen</a>");

    }
}