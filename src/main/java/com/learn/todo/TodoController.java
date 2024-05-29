package com.learn.todo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String todoListPage(ModelMap model) {

		
		List<Todo> todoList = todoService.retrieveTodos("Mahesh");
		model.addAttribute("todoUserList", todoList);
		return "list-todos";
	}

	@RequestMapping(value="/add-todos", method= RequestMethod.GET)
	public String showAddTodoPage() {

		
		
		return "add-todos";
	}
	
	@RequestMapping(value="/add-todos", method= RequestMethod.POST)
	public String addTodoPage(@RequestParam String desc, ModelMap model) {

		
		todoService.addTodo("Mahesh", desc, new Date(), false);
		model.clear();
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="/delete-todos", method= RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {

		
		model.clear();
		todoService.deleteTodo(id);
		return "redirect:list-todos";
	}
}
