package team7.app.controller;

import com.team7.app.controller.WebPageController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class WebPageControllerTest {

    WebPageController wPC;
    Map<String, Object> model;

    @Before
    public void Before() {
        wPC = new WebPageController();
        model = new HashMap<>();

    }

    @Test
    public void createTest() {
        assertTrue(wPC.create(model).equals( "create"));
    }

    @Test
    public void courseCreateTest() {
        assertTrue(wPC.courseCreate(model).equals("courseCreate"));
    }

    @Test
    public void courseUpdateTest() {
        assertTrue(wPC.courseUpdate(model).equals("courseUpdate"));
    }

    @Test
    public void courseDeleteTest() {
        assertTrue(wPC.courseDelete(model).equals("courseDelete"));
    }

    @Test
    public void courseReadTest() {
        assertTrue(wPC.courseRead(model).equals("courseRead"));
    }

    @Test
    public void deleteTest() {
        assertTrue(wPC.delete(model).equals("delete"));
    }

    @Test
    public void indexTest() {
        assertTrue(wPC.index(model).equals("index"));
    }

    @Test
    public void professorCreateTest() {
        assertTrue(wPC.professorCreate(model).equals("professorCreate"));
    }

    @Test
    public void professorDeleteTest() {
        assertTrue(wPC.professorDelete(model).equals("professorDelete"));
    }

    @Test
    public void professorReadTest() {
        assertTrue(wPC.professorRead(model).equals("professorRead"));
    }

    @Test
    public void professorUpdateTest() {
        assertTrue(wPC.professorUpdate(model).equals("professorUpdate"));
    }

    @Test
    public void readTest() {
        assertTrue(wPC.read(model).equals("read"));
    }

    @Test
    public void updateTest() {
        assertTrue(wPC.update(model).equals("update"));
    }
}