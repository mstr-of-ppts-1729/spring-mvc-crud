package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.Dao.UserDao;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    public UserDao userDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDao.index());
        // получим всех юзеров из дао и передадим на отображение в представление
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDao.show(id));
        return "show";
        // получим одного юзера из дао и передадим на отображение в представление
    }
}
