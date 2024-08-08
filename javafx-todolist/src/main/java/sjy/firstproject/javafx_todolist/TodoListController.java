package sjy.firstproject.javafx_todolist;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TodoListController {

	@FXML
	private TextField inputField;
	
	@FXML
	private ListView<String> taskList;
	
	@FXML
	private void handleAddTask() {
		// 텍스트 필드에 입력된 값을 가져와서 리스트 뷰에 추가
		String task = inputField.getText();
		if(task!=null && !task.isEmpty()) {
			taskList.getItems().add(task);
			inputField.clear();
		}
	}
	
	@FXML
	private void handleDeleteTask() {
		String selectedTask = taskList.getSelectionModel().getSelectedItem();
		if(selectedTask!=null) {
			taskList.getItems().remove(selectedTask);
		}
	}
	
	@FXML
	private TextField editField;
	
	@FXML
	private void handleEditTask() {
		String selectedTask = taskList.getSelectionModel().getSelectedItem();
		String newTask = editField.getText();
		if(selectedTask!=null && newTask!=null && !newTask.isEmpty()) {
			int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
			taskList.getItems().set(selectedIndex, newTask);
			editField.clear();
		}
	}
}

