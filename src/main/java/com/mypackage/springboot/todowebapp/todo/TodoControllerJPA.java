package com.mypackage.springboot.todowebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping("/todowebapp/list-todos")
    public String listAllTodos(Model model) {
        String username = getLoggedUsername();
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @GetMapping("/todowebapp/add-todo")
    public String showNewTodoPage(Model model) {
        String username = getLoggedUsername();
        Todo todo = new Todo(0, username, "", LocalDate.now().plusDays(1), false);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("/todowebapp/add-todo")
    public String addNewTodo(Model model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedUsername();
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:/todowebapp/list-todos";
    }

    @GetMapping("/todowebapp/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:/todowebapp/list-todos";
    }

    @GetMapping("/todowebapp/update-todo")
    public String showUpdateTodoPage(@RequestParam int id, Model model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("/todowebapp/update-todo")
    public String updateTodo(Model model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedUsername();
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:/todowebapp/list-todos";
    }

    private String getLoggedUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/todowebapp/status-todo")
    public String changetoDome(@RequestParam int id) {
        Todo todo = todoRepository.findById(id).get();
        if (todo.isDone()) {
            todo.setDone(false);
        }
        else{
            todo.setDone(true);

        }
        todoRepository.save(todo);
        return "redirect:/todowebapp/list-todos";
    }

}
