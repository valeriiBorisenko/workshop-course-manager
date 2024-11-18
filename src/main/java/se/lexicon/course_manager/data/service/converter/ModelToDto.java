package se.lexicon.course_manager.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager.dto.views.CourseView;
import se.lexicon.course_manager.dto.views.StudentView;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// TODO Convert model -> view & models -> views

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student) {
        return new StudentView(student.getId(), student.getName(), student.getEmail(), student.getAddress());
    }

    @Override
    public CourseView courseToCourseView(Course course) {
        List<StudentView> studentViewList = studentsToStudentViews(course.getStudents());
        return new CourseView(course.getId(), course.getCourseName(), course.getStartDate(), course.getWeekDuration(), studentViewList);
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
        if (courses == null) return null;

        List<CourseView> courseViewList = new ArrayList<>();
        for (Course course: courses) {
            courseViewList.add(courseToCourseView(course));
        }
        return courseViewList;
    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {
        if (students == null) return null;

        List<StudentView> studentViewList = new ArrayList<>();
        for (Student student: students) {
            studentViewList.add(studentToStudentView(student));
        }
        return studentViewList;
    }
}
