package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.CourseSequencer;
import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

// TODO provide proper implementation.

public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        Course course = new Course(CourseSequencer.nextCourseId(), courseName, startDate, weekDuration);
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course course: courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        HashSet<Course> findCourses = new HashSet<>();
        for (Course course : courses) {
            if (course.getCourseName().contains(name)) {
                findCourses.add(course);
            }
        }
        return findCourses;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        HashSet<Course> findCourses = new HashSet<>();
        for (Course course : courses) {
            if (course.getStartDate().isBefore(end)) {
                findCourses.add(course);
            }
        }
        return findCourses;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        HashSet<Course> findCourses = new HashSet<>();
        for (Course course : courses) {
            if (course.getStartDate().isAfter(start)) {
                findCourses.add(course);
            }
        }
        return findCourses;
    }

    @Override
    public Collection<Course> findAll() {
        return courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        HashSet<Course> findCourses = new HashSet<>();
        for (Course course: courses) {
            for (Student student: course.getStudents()) {
                if (student.getId() == studentId) {
                    findCourses.add(course);
                }
            }
        }
        return findCourses;
    }

    @Override
    public boolean removeCourse(Course course) {
        courses.remove(course);
        return true;
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}
