package service.impl;

import domain.Course;
import domain.Language;
import domain.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    public void add(User user){
        System.out.println("User added successfully");
    }

    public List<Course> getAllCourses() {
        List<Course> courseList = new ArrayList<Course>();
        courseList.add(new Course(1,"Struts"));
        courseList.add(new Course(2,"Hibernate"));
        courseList.add(new Course(3,"Spring"));
        courseList.add(new Course(4,"Ajax"));
        courseList.add(new Course(5,"Flex"));
        return courseList;
    }

    public List<Language> getAllLanguages() {
        List<Language> languageList = new ArrayList<Language>();
        languageList.add(new Language("English","English"));
        languageList.add(new Language("Hindi","Hindi"));
        languageList.add(new Language("Spanish","Spanish"));
        return languageList;
    }


}
