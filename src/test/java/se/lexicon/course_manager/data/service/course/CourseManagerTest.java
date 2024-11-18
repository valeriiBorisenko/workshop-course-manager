package se.lexicon.course_manager.data.service.course;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager.data.dao.CourseCollectionRepository;
import se.lexicon.course_manager.data.dao.CourseDao;
import se.lexicon.course_manager.data.dao.StudentCollectionRepository;
import se.lexicon.course_manager.data.sequencers.CourseSequencer;
import se.lexicon.course_manager.data.service.converter.ModelToDto;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {CourseManager.class, CourseCollectionRepository.class, ModelToDto.class, StudentCollectionRepository.class})
public class CourseManagerTest {

    @Autowired
    private CourseService testObject;

    @Autowired
    private CourseDao courseDao;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertNotNull(testObject);
        assertNotNull(courseDao);
    }


    @BeforeEach
    void setUp() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void searchByCourseName() {
    }

    @Test
    void searchByDateBefore() {
    }

    @Test
    void searchByDateAfter() {
    }

    @Test
    void addStudentToCourse() {
    }

    @Test
    void removeStudentFromCourse() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByStudentId() {
    }

    @Test
    void deleteCourse() {
    }

    @AfterEach
    void tearDown() {
        courseDao.clear();
        CourseSequencer.setCourseSequencer(0);
    }
}
