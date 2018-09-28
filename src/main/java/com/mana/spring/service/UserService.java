package com.mana.spring.service;

import com.mana.spring.domain.Course;
import com.mana.spring.domain.Language;
import com.mana.spring.domain.User;

import java.util.List;

public interface UserService {

    void add(User user);
    List<Course> getAllCourses();
    List<Language> getAllLanguages();
}
