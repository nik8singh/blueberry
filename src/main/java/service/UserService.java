package service;

import domain.Course;
import domain.Language;
import domain.User;

import java.util.List;

public interface UserService {

    void add(User user);
    List<Course> getAllCourses();
    List<Language> getAllLanguages();
}
