package com.learn.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	// create static member
    private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {

		todos.add(new Todo(1, "Mahesh", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "Mahesh", "Learn Spring batch", new Date(), false));
		todos.add(new Todo(3, "Mahesh", "Learn Spring boot", new Date(), false));
	}

	public void addTodo(String user, String desc, Date targetDate, boolean isDone) {

		todos.add(new Todo(++todoCount, user, desc, targetDate, isDone));

	}

	public void deleteTodo(int todoId) {

		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {

			Todo deleteTodos = iterator.next();
			if (deleteTodos.getId() == todoId) {

				iterator.remove();
			}

		}

	}

	public List<Todo> retrieveTodos(String user) {

		List<Todo> listTodos = new ArrayList<Todo>();

		for (Todo userTodoList : todos) {

			if (userTodoList.getUser() == user) {

				listTodos.add(userTodoList);

			}

		}

		return listTodos;
	}

	public Todo retrieve(int id) {

		for(Todo todo:todos) {
			
			if(todo.getId() == id) {
				
				return todo;
			}
			
		
		}
		return null;
	}

	public void updateTodo(Todo todo) {

		todos.remove(todo);
		todos.add(todo);

	}

}
