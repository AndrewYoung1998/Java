import java.util.HashMap;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToe extends Application {
	//Sets turn to true or false
	static boolean turn;
	
	//Maps the board
	static HashMap<Button,Integer> mapButtons;
	
	static int id = 0;
	
	//array for board
	static int[] board;
	
	//Creates the grid for the board
	static GridPane grid;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mapButtons = new HashMap<Button, Integer>();
		board = new int[9];
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Labels for home page
		Label lbltitle = new Label("Play Game");
		Label lblRules = new Label("How to Play:");
		Label lblClicks = new Label("Left Click for X and Right Click for O");
		
		//Home page play button
		Button btnPlay = new Button("Play Game");
		
		//Vertically aligns all home page elements
		VBox play = new VBox(lbltitle, lblRules, lblClicks, btnPlay);
		play.setAlignment(Pos.CENTER);
		play.setSpacing(10);
		
		//Displays Home Page
		Scene scene = new Scene(play, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		//display board
		grid = new GridPane();
		grid.addRow(0,copyButton(),copyButton() , copyButton());
		grid.addRow(1,copyButton(),copyButton() , copyButton());
		grid.addRow(2,copyButton(),copyButton() , copyButton());
		
		
		//Displays grid vertically
		VBox rows = new VBox(grid);
		
		//Makes New Scene
		Scene Game = new Scene(rows, 600, 600);
		
		//When Play button is clicked Opens Game
		btnPlay.setOnAction(e -> primaryStage.setScene(Game));
	}
	
	//This method deals with the how the game works 
	public static Button copyButton() {
		//creates Buttons for the board
		Button btnNew = new Button();
		btnNew.setPrefSize(200,200);
		
		//Displays X or O depending on mouse click
		btnNew.setOnMouseClicked(e ->{
			if(e.getButton().compareTo(MouseButton.PRIMARY) == 0 && turn){
				btnNew.setText("X");
				
			}else if(e.getButton().compareTo(MouseButton.SECONDARY) == 0 && !turn) {
				btnNew.setText("O");
			}else {
				return;
			}
			
			
			btnNew.setDisable(true);
			
			int index = mapButtons.get(btnNew);
			
			//Sets player with X or O
			char player = turn?'X':'O';
			
			board[index] = player;
		
			//Finds whether there is 3 in a row diagonally left to right
		if(index == 0 || index == 4 || index == 8 ) {
			if(board[0] == board[4] && board[4] == board[8]) {
				 Winner(player);
			}
		}
		//Finds whether there is 3 in a row diagonally right to left
		if(index == 2 || index == 4 || index == 6 ) {
			if(board[2] == board[4] && board[4] == board[6]) {
				Winner(player);
			}
		}
		
		//Finds whether there is 3 in a row in a full row
		int m = (index/3)*3;
		if(board[m] == board[m+1] && board[m+1] == board[m+2]) {
			Winner(player);
		}
		
		//Finds whether there is 3 in a row in a column
		m = (index%3);
		if(board[m] == board[m+3] && board[m+3] == board[m+6]) {
			Winner(player);
		}
		
		//Only allows one person to go at a time
		turn = !turn;
		});
		
		mapButtons.put(btnNew, id++);
		
		return btnNew;
	}
	
	//This method displays JOptionPane and clears the board
	public static void Winner(char c) {
		JOptionPane.showMessageDialog(null,"Winner!" + c);
		grid.getChildren().clear();
		grid.addRow(0,copyButton(),copyButton() , copyButton());
		grid.addRow(1,copyButton(),copyButton() , copyButton());
		grid.addRow(2,copyButton(),copyButton() , copyButton());
	}
}
