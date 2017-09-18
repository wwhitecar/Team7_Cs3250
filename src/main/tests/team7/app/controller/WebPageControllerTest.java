package team7.app.controller;

import com.team7.app.controller.WebPageController;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebPageControllerTest {

    @Test
    public void webPageControllerTest(){
        WebPageController wPC = new WebPageController();
        assertTrue(wPC != null);
    }
}