package com.fundamentos.sprintboot.fundamentos.caseuse;

import com.fundamentos.sprintboot.fundamentos.entity.User;
import com.fundamentos.sprintboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User user, Long id) {
       return userService.update(user,id);
    }
}
