package sjy.firstproject.javafx_todolist;

import javafx.fxml.FXML;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class TodoListController {

	@FXML
	private TextField inputField;
	
	@FXML
	private ListView<String> taskList;
	
	@FXML
	private TextField editField;
	
	private final String DATA_FILE = "tasks.json";
	private final Gson gson = new Gson();
	
	@FXML
	private void initialize( ) {
		loadTasks();
	}
	
	@FXML
	private void handleAddTask() {
		// 텍스트 필드에 입력된 값을 가져와서 리스트 뷰에 추가
		String task = inputField.getText();
		if(task!=null && !task.isEmpty()) {
			taskList.getItems().add(task);
			inputField.clear();
			saveTask();
		}
	}
	
	@FXML
	private void handleDeleteTask() {
		String selectedTask = taskList.getSelectionModel().getSelectedItem();
		if(selectedTask!=null) {
			taskList.getItems().remove(selectedTask);
			saveTask();
		}
	}
	
	@FXML
	private void handleEditTask() {
		String selectedTask = taskList.getSelectionModel().getSelectedItem();
		String newTask = editField.getText();
		if(selectedTask!=null && newTask!=null && !newTask.isEmpty()) {
			int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
			taskList.getItems().set(selectedIndex, newTask);
			editField.clear();
			saveTask();
		}
	}
	
	private void saveTask() {
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			gson.toJson(taskList.getItems(), writer);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadTasks() {
		try (FileReader reader = new FileReader(DATA_FILE)) {
			Type type = new TypeToken<List<String>>() {}.getType();
			List<String> tasks = gson.fromJson(reader, type);
			if(tasks != null) {
				taskList.getItems().addAll(tasks);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

