package sjy.firstproject.javafx_todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// FXML 파일을 로드하여 Scene 설정하는 부분
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/sjy/firstproject/todolist/todolist.fxml"));
		Parent root = loader.load();				// 로드한 FXML 파일로 Parent 객체 생성
		Scene scene = new Scene(root); 				// Parent 객체로 Scene 객체 생성
		primaryStage.setScene(scene);				// primaryStage(기본무대)에 Scene을 설정
		primaryStage.setTitle("TODO List App");		// primaryStage 제목 설정
		primaryStage.show();						// primaryStage 나타내기
	}	
																																																																																																																																																																																																																																																																																																		
	public static void main(String[] args) {
		// JavaFX 애플리케이션 시작
		launch(args);
	}
}