package se.lexicon.course_manager.data.service.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {ModelToDto.class})
public class ModelToDtoTest {

    @Autowired
    private Converters testObject;
    private Student student;
    private Course course;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertNotNull(testObject);
    }

    @BeforeEach
    void setUp() {
        student = new Student(1, "Karl Anderson", "karl@lexicon.se", "The roof");
        course = new Course(1, "Lexicon", LocalDate.of(2024, Month.NOVEMBER,15), 7);
    }

    @Test
    void studentToStudentView() {

    }

    @Test
    void courseToCourseView() {
    }

    @Test
    void coursesToCourseViews() {
    }

    @Test
    void studentsToStudentViews() {
    }

}
