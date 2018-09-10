package web;
import domain.Course;
import domain.Language;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping("/registerUser.htm")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("courseList")
    public List<Course> populateCoursesList() {
        return userService.getAllCourses();
    }

    @ModelAttribute("languageList")
    public List<Language> populateLanguagesList() {
        return userService.getAllLanguages();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUserForm(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String receiveData(@ModelAttribute("user") User user) {
        userService.add(user);
        //return "redirect:userSuccess.htm";
        return "userSuccess";
    }


}
