package com.bookstore.controller.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rostyslav Kasprovych
 */
@Controller
public class AdminController {

    @RequestMapping("/adminHome")
    public String home() {
        return "adminHome";
    }

    @RequestMapping("/adminLogin")
    public String login() {
        return "adminLogin";
    }
}
