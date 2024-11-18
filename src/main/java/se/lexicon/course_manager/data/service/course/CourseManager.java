package se.lexicon.course_manager.data.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager.data.dao.CourseDao;
import se.lexicon.course_manager.data.dao.StudentDao;
import se.lexicon.course_manager.data.service.converter.Converters;
import se.lexicon.course_manager.dto.forms.CreateCourseForm;
import se.lexicon.course_manager.dto.forms.UpdateCourseForm;
import se.lexicon.course_manager.dto.views.CourseView;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

// TODO provide proper implementation.
@Service
public class CourseManager implements CourseService {

    private final CourseDao courseDao;
    private final StudentDao studentDao;
    private final Converters converters;

    @Autowired
    public CourseManager(CourseDao courseDao, StudentDao studentDao, Converters converters) {
        this.courseDao = courseDao;
        this.studentDao = studentDao;
        this.converters = converters;
    }

    @Override
    public CourseView create(CreateCourseForm form) {
        Course course = courseDao.createCourse(form.getCourseName(), form.getStartDate(), form.getWeekDuration());
        return converters.courseToCourseView(course);
    }

    @Override
    public CourseView update(UpdateCourseForm form) {
        Course courseUpdated = courseDao.findById(form.getId());

        if (courseUpdated != null) {
            courseUpdated.setCourseName(form.getCourseName());
            courseUpdated.setStartDate(form.getStartDate());
            courseUpdated.setWeekDuration(form.getWeekDuration());
        }
        return converters.courseToCourseView(courseUpdated);
    }

    @Override
    public List<CourseView> searchByCourseName(String courseName) {
        Collection<Course> coursesList = courseDao.findByNameContains(courseName);
        return converters.coursesToCourseViews(coursesList);
    }

    @Override
    public List<CourseView> searchByDateBefore(LocalDate end) {
        Collection<Course> coursesList = courseDao.findByDateBefore(end);
        return converters.coursesToCourseViews(coursesList);
    }

    @Override
    public List<CourseView> searchByDateAfter(LocalDate start) {
        Collection<Course> coursesList = courseDao.findByDateAfter(start);
        return converters.coursesToCourseViews(coursesList);
    }

    @Override
    public boolean addStudentToCourse(int courseId, int studentId) {
        Course course = courseDao.findById(courseId);
        Student student = studentDao.findById(studentId);
        return course.enrollStudent(student);
    }

    @Override
    public boolean removeStudentFromCourse(int courseId, int studentId) {
        Course course = courseDao.findById(courseId);
        Student student = studentDao.findById(studentId);
        return course.unenrollStudent(student);
    }

    @Override
    public CourseView findById(int id) {
        Course course = courseDao.findById(id);
        return converters.courseToCourseView(course);
    }

    @Override
    public List<CourseView> findAll() {
        Collection<Course> coursesList = courseDao.findAll();
        return converters.coursesToCourseViews(coursesList);
    }

    @Override
    public List<CourseView> findByStudentId(int studentId) {
        Collection<Course> findStudentList = courseDao.findByStudentId(studentId);
        return converters.coursesToCourseViews(findStudentList);
    }

    @Override
    public boolean deleteCourse(int id) {
        Course course = courseDao.findById(id);
        return courseDao.removeCourse(course);
    }
}
