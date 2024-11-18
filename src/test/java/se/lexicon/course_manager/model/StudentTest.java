package se.lexicon.course_manager.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    Student testObject;

    @BeforeEach
    void setUp() {
        testObject = new Student(1);
    }

    @Test
    void setName() {
        String testName = "Karl Anderson";
        testObject.setName(testName);
        assertTrue(testObject.getName().trim().toLowerCase().contains(testName.trim().toLowerCase()));
    }

    @Test
    void setEmail() {
        String testEmail = "karl@lexicon.se";
        testObject.setEmail(testEmail);
        assertTrue(testObject.getEmail().trim().toLowerCase().contains(testEmail.trim().toLowerCase()));
    }

    @Test
    void setAddress() {
        String testAddress = "The roof";
        testObject.setAddress(testAddress);
        assertTrue(testObject.getAddress().trim().toLowerCase().contains(testAddress.trim().toLowerCase()));

    }
}
