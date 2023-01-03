import java.util.HashMap;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXTemplate extends Application {
	
	Player playerOne = new Player();
	Player playerTwo = new Player();
	Dealer theDealer = new Dealer();
	
	HashMap<String, Scene> sceneMap = new HashMap<String, Scene>();
	BorderPane pane = new BorderPane();

	Button b1;
	Button b2;
	Button p1PlayBtn;
	Button p2PlayBtn;
	Button p1FoldBtn;
	Button p2FoldBtn;
	
	Button p1Ready;
	Button p2Ready;
	
	MenuItem iTwo;
	MenuItem iThree;
	
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	TextField p1Ante, p2Ante;
	TextField p1PP, p2PP;
	TextField p1Play, p2Play;
	TextField p1Total, p2Total;
	TextField dealerCard1, dealerCard2, dealerCard3;
	TextField player1Card1, player1Card2, player1Card3;
	TextField player2Card1, player2Card2, player2Card3;
	
	EventHandler<ActionEvent> myPlayHandler;
	EventHandler<ActionEvent> myPlayHandler2;
	EventHandler<ActionEvent> myPlayHandler3;
	EventHandler<ActionEvent> myPlayHandler4;
	EventHandler<ActionEvent> P1readyHandler;
	EventHandler<ActionEvent> P2readyHandler;
	EventHandler<ActionEvent> myFoldHandler1;
	EventHandler<ActionEvent> myFoldHandler2;
	EventHandler<ActionEvent> QueenHighHandler;
	EventHandler<ActionEvent> myFreshStartHandler;
	EventHandler<ActionEvent> myNewLookHandler;
	
	ObservableList<String> strList;
	ListView<String> Items;
	
	boolean p1WantToPlay = true;
	boolean p2WantToPlay = true;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		b1 = new Button("Start");
		b2 = new Button("Exit");
		p1PlayBtn = new Button("play");
		p1PlayBtn.setDisable(true);
		p1FoldBtn = new Button("fold");
		p1FoldBtn.setDisable(true);
		p2PlayBtn = new Button("play");
		p2PlayBtn.setDisable(true);
		p2FoldBtn = new Button("fold");
		p2FoldBtn.setDisable(true);
		p1Ready = new Button("P1 ready");
		p2Ready = new Button("P2 ready");
		
		iTwo = new MenuItem("Fresh Start");
		iThree = new MenuItem("New Look");
		
		
		strList = FXCollections.observableArrayList();
		Items = new ListView<String>();
		Items.setPrefHeight(250);
		
		b1.setMinSize(100, 100);
		b2.setMinSize(100, 100);
		
		b1.setOnAction(e->{
			Items.getItems().removeAll(strList);
			sceneMap.replace("game", setGameScene());
			primaryStage.setScene(sceneMap.get("game"));
			primaryStage.centerOnScreen();}
		);
		b2.setOnAction(e->Platform.exit());
		
		myPlayHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				p1WantToPlay = true;
				playerOne.setAnteBet(Integer.valueOf(p1Ante.getText()).intValue());
				playerOne.setPairPlusBet(Integer.valueOf(p1PP.getText()).intValue());
				playerOne.setPlayBet(Integer.valueOf(p1Ante.getText()).intValue());
				p1Play.setText(String.valueOf(playerOne.getAnteBet()));
				p1PlayBtn.setDisable(true);
				p1FoldBtn.setDisable(true);
				p1Ante.setDisable(true);
				p1PP.setDisable(true);
				strList.add("player2 choose to...");
				Items.setItems(strList);
				p2PlayBtn.setDisable(false);
				p2FoldBtn.setDisable(false);
			}
		};
		p1PlayBtn.setOnAction(myPlayHandler);
		
		myPlayHandler2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				p2WantToPlay = true;
				playerTwo.setAnteBet(Integer.valueOf(p2Ante.getText()).intValue());
				playerTwo.setPairPlusBet(Integer.valueOf(p2PP.getText()).intValue());
				playerTwo.setPlayBet(Integer.valueOf(p2Ante.getText()).intValue());
				p2Play.setText(String.valueOf(playerTwo.getAnteBet()));
				p2PlayBtn.setDisable(true);
				p2FoldBtn.setDisable(true);
				p2Ante.setDisable(true);
				p2PP.setDisable(true);
				strList.add("Dealer showing cards");
				Items.setItems(strList);
				
				dealerCard1.setText(theDealer.getDealersHand().get(0).getSuit() + String.valueOf(theDealer.getDealersHand().get(0).getValue()));
				dealerCard2.setText(theDealer.getDealersHand().get(1).getSuit() + String.valueOf(theDealer.getDealersHand().get(1).getValue()));
				dealerCard3.setText(theDealer.getDealersHand().get(2).getSuit() + String.valueOf(theDealer.getDealersHand().get(2).getValue()));
				PauseTransition pause = new PauseTransition(Duration.seconds(3));
				
				if(theDealer.getDealersHand().get(0).getValue() >= 12 || theDealer.getDealersHand().get(1).getValue() >= 12 || theDealer.getDealersHand().get(0).getValue() >= 12) {
					pause.setOnFinished(myPlayHandler3);
					pause.play();
				} else {
					strList.add("Dealer does not have at least Queen high; ante wager is pushed");
					Items.setItems(strList);
					if(p1WantToPlay == true) {
						int PPwin = ThreeCardLogic.evalPPWinnings(playerOne.getHand(), playerOne.getPairPlusBet());
						int PPTotalReturn = 0;
						if(PPwin != 0) {
							PPTotalReturn = playerOne.getPairPlusBet() + PPwin;
							strList.add("Player one wins Pair Plus");
							Items.setItems(strList);
						} else {
							strList.add("Player one loses Pair Plus");
							Items.setItems(strList);
						}
						int sum = playerOne.getTotalWinnings() - playerOne.getPairPlusBet() + PPTotalReturn;
						p1Total.setText(String.valueOf(sum)); 
						playerOne.setTotalWinnings(sum);
					}
					
					if(p2WantToPlay == true) {
						int PPwin = ThreeCardLogic.evalPPWinnings(playerTwo.getHand(), playerTwo.getPairPlusBet());
						int PPTotalReturn = 0;
						if(PPwin != 0) {
							PPTotalReturn = playerTwo.getPairPlusBet() + PPwin;
							strList.add("Player Two wins Pair Plus");
							Items.setItems(strList);
						} else {
							strList.add("Player Two loses Pair Plus");
							Items.setItems(strList);
						}
						int sum = playerTwo.getTotalWinnings() - playerTwo.getPairPlusBet() + PPTotalReturn;
						p2Total.setText(String.valueOf(sum)); 
						playerTwo.setTotalWinnings(sum);
					}
					theDealer.reSetDealersHand();
					pause.setOnFinished(QueenHighHandler);
					pause.play();
				}
			}
		};
		p2PlayBtn.setOnAction(myPlayHandler2);
		
		QueenHighHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				sceneMap.replace("game", setGameScene());
				primaryStage.setScene(sceneMap.get("game"));
				if(p1WantToPlay == true) {
					p1Ante.setText(String.valueOf(playerOne.getAnteBet()));
					p1Ante.setDisable(true);
				}
				if(p2WantToPlay == true) {
					p2Ante.setText(String.valueOf(playerTwo.getAnteBet()));
					p2Ante.setDisable(true);
				}
			}
		};
		
		
		myPlayHandler3 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// --------------------------------------- p1 ------------------------------------------------
				if(p1WantToPlay == true) {
					int PPwin = ThreeCardLogic.evalPPWinnings(playerOne.getHand(), playerOne.getPairPlusBet());
					int PPTotalReturn = 0;
					int AnteTotalReturn = 0;
					if(PPwin != 0) {
						PPTotalReturn = playerOne.getPairPlusBet() + PPwin;
						strList.add("Player one wins Pair Plus");
						Items.setItems(strList);
					} else {
						strList.add("Player one loses Pair Plus");
						Items.setItems(strList);
					}
					if(ThreeCardLogic.compareHands(theDealer.getDealersHand(), playerOne.getHand()) == 1){
						AnteTotalReturn = 0;
						strList.add("Player one loses to dealer");
						Items.setItems(strList);
					} else if (ThreeCardLogic.compareHands(theDealer.getDealersHand(), playerOne.getHand()) == 2) {
						AnteTotalReturn = 4 * playerOne.getAnteBet();
						strList.add("Player one beats dealer");
						Items.setItems(strList);
					} else {
						AnteTotalReturn = 2 * playerOne.getAnteBet();
						strList.add("Draw");
						Items.setItems(strList);
					}
					
					int CurrentTotal = playerOne.getTotalWinnings() - 2 * playerOne.getAnteBet() - playerOne.getPairPlusBet() + PPTotalReturn + AnteTotalReturn;
					playerOne.setTotalWinnings(CurrentTotal);
					p1Total.setText(String.valueOf(CurrentTotal));
				}
				
				// --------------------------------------- p2 ------------------------------------------------
				if(p2WantToPlay == true) {
					int PPwin2 = ThreeCardLogic.evalPPWinnings(playerTwo.getHand(), playerTwo.getPairPlusBet());
					int PPTotalReturn2 = 0;
					int AnteTotalReturn2 = 0;
					if(PPwin2 != 0) {
						PPTotalReturn2 = playerTwo.getPairPlusBet() + PPwin2;
						strList.add("Player two wins Pair Plus");
						Items.setItems(strList);
					} else {
						strList.add("Player two loses Pair Plus");
						Items.setItems(strList);
					}
					if(ThreeCardLogic.compareHands(theDealer.getDealersHand(), playerTwo.getHand()) == 1){
						AnteTotalReturn2 = 0;
						strList.add("Player two loses to dealer");
						Items.setItems(strList);
					} else if (ThreeCardLogic.compareHands(theDealer.getDealersHand(), playerTwo.getHand()) == 2) {
						AnteTotalReturn2 = 4 * playerTwo.getAnteBet();
						strList.add("Player two beats dealer");
						Items.setItems(strList);
					} else {
						AnteTotalReturn2 = 2 * playerTwo.getAnteBet();
						strList.add("Draw");
						Items.setItems(strList);
					}
					
					int CurrentTotal2 = playerTwo.getTotalWinnings() - 2 * playerTwo.getAnteBet() - playerTwo.getPairPlusBet() + PPTotalReturn2 + AnteTotalReturn2;
					playerTwo.setTotalWinnings(CurrentTotal2);
					p2Total.setText(String.valueOf(CurrentTotal2));
				}
				PauseTransition pause = new PauseTransition(Duration.seconds(10));
				pause.setOnFinished(myPlayHandler4);
				pause.play();
			}
		};
		
		myPlayHandler4 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// ------------------------------------------- reset ----------------------------------------------
				p1PlayBtn.setDisable(false);
				p1FoldBtn.setDisable(false);
				p2PlayBtn.setDisable(false);
				p2FoldBtn.setDisable(false);
				strList.clear();
				Items.setItems(strList);
				theDealer.reSetDealersHand();
				sceneMap.replace("game", setGameScene());
				primaryStage.setScene(sceneMap.get("game"));
			}
		};
		
		P1readyHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(p1PP.getText().isEmpty()) {
					p1PP.setText(String.valueOf(0));
				}
				System.out.println("Outside");
				if(Integer.valueOf(p1Ante.getText()).intValue() > 25 || Integer.valueOf(p1Ante.getText()).intValue() < 5
						 || Integer.valueOf(p1PP.getText()).intValue() > 25 || (Integer.valueOf(p1PP.getText()).intValue() < 5) && Integer.valueOf(p1PP.getText()).intValue() !=0) {
					strList.add("Ante wager and Pair Plus wager should between $5-$25");
					Items.setItems(strList);
				} else {
					p1Ante.setDisable(true);
					p1PP.setDisable(true);
					p2Ready.setDisable(false);
					p1Ready.setDisable(true);
					strList.add("P1 ready");
					Items.setItems(strList);
				}
			}
		};
		p1Ready.setOnAction(P1readyHandler);
		
		P2readyHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(p2PP.getText().isEmpty()) {
					p2PP.setText(String.valueOf(0));
				}
				if(Integer.valueOf(p2Ante.getText()).intValue() > 25 || Integer.valueOf(p2Ante.getText()).intValue() < 5
						|| Integer.valueOf(p2PP.getText()).intValue() > 25 || (Integer.valueOf(p2PP.getText()).intValue() < 5 && Integer.valueOf(p2PP.getText()).intValue() !=0)) {
					strList.add("Ante wager and Pair Plus wager should between $5-$25");
					Items.setItems(strList);
				} else {
					player1Card1.setText(playerOne.getHand().get(0).getSuit() + String.valueOf(playerOne.getHand().get(0).getValue()));
					player1Card2.setText(playerOne.getHand().get(1).getSuit() + String.valueOf(playerOne.getHand().get(1).getValue()));
					player1Card3.setText(playerOne.getHand().get(2).getSuit() + String.valueOf(playerOne.getHand().get(2).getValue()));
					player2Card1.setText(playerTwo.getHand().get(0).getSuit() + String.valueOf(playerTwo.getHand().get(0).getValue()));
					player2Card2.setText(playerTwo.getHand().get(1).getSuit() + String.valueOf(playerTwo.getHand().get(1).getValue()));
					player2Card3.setText(playerTwo.getHand().get(2).getSuit() + String.valueOf(playerTwo.getHand().get(2).getValue()));

					p2Ante.setDisable(true);
					p2PP.setDisable(true);
					p1PlayBtn.setDisable(false);
					// p2PlayBtn.setDisable(false);
					p1FoldBtn.setDisable(false);
					// p2FoldBtn.setDisable(false);
					p2Ready.setDisable(true);
					strList.add("P2 ready");
					strList.add("player1 choose to...");
					Items.setItems(strList);
				}
			}
		};
		p2Ready.setOnAction(P2readyHandler);
		
		myFoldHandler1 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				p1WantToPlay = false;
				p1PlayBtn.setDisable(true);
				p1FoldBtn.setDisable(true);
				p2PlayBtn.setDisable(false);
				p2FoldBtn.setDisable(false);
				strList.add("P1 fold");
				Items.setItems(strList);
				
				int CurrentTotal = playerOne.getTotalWinnings() - Integer.valueOf(p1Ante.getText()).intValue() - Integer.valueOf(p1PP.getText()).intValue();
				p1Total.setText(String.valueOf(CurrentTotal));
				playerOne.setTotalWinnings(CurrentTotal);
			}
		};
		p1FoldBtn.setOnAction(myFoldHandler1);
		
		myFoldHandler2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				strList.add("P2 fold");
				Items.setItems(strList);
				p2PlayBtn.setDisable(true);
				p2FoldBtn.setDisable(true);
				p2WantToPlay = false;
				int CurrentTotal = playerTwo.getTotalWinnings() - Integer.valueOf(p2Ante.getText()).intValue() - Integer.valueOf(p2PP.getText()).intValue();
				p2Total.setText(String.valueOf(CurrentTotal));
				playerTwo.setTotalWinnings(CurrentTotal);
				if(p1WantToPlay == false) {
					PauseTransition pause = new PauseTransition(Duration.seconds(5));
					pause.setOnFinished(myPlayHandler4);
					pause.play();
				}
				else {
					dealerCard1.setText(theDealer.getDealersHand().get(0).getSuit() + String.valueOf(theDealer.getDealersHand().get(0).getValue()));
					dealerCard2.setText(theDealer.getDealersHand().get(1).getSuit() + String.valueOf(theDealer.getDealersHand().get(1).getValue()));
					dealerCard3.setText(theDealer.getDealersHand().get(2).getSuit() + String.valueOf(theDealer.getDealersHand().get(2).getValue()));
					PauseTransition pause = new PauseTransition(Duration.seconds(3));
					
					
					
					if(theDealer.getDealersHand().get(0).getValue() >= 12 || theDealer.getDealersHand().get(1).getValue() >= 12 || theDealer.getDealersHand().get(0).getValue() >= 12) {
						pause.setOnFinished(myPlayHandler3);
						pause.play();
					} else {
						strList.add("Dealer does not have at least Queen high; ante wager is pushed");
						Items.setItems(strList);
						if(p1WantToPlay == true) {
							int PPwin = ThreeCardLogic.evalPPWinnings(playerOne.getHand(), playerOne.getPairPlusBet());
							int PPTotalReturn = 0;
							if(PPwin != 0) {
								PPTotalReturn = playerOne.getPairPlusBet() + PPwin;
								strList.add("Player one wins Pair Plus");
								Items.setItems(strList);
							} else {
								strList.add("Player one loses Pair Plus");
								Items.setItems(strList);
							}
							int sum = playerOne.getTotalWinnings() - playerOne.getPairPlusBet() + PPTotalReturn;
							p1Total.setText(String.valueOf(sum)); 
							playerOne.setTotalWinnings(sum);
						}
						theDealer.reSetDealersHand();
						pause.setOnFinished(QueenHighHandler);
						pause.play();
					}
				}
			}
		};
		p2FoldBtn.setOnAction(myFoldHandler2);
		
		myFreshStartHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				playerOne = new Player();
				playerTwo = new Player();
				theDealer = new Dealer();
				strList.clear();
				Items.setItems(strList);
				sceneMap.replace("game", setGameScene());
				primaryStage.setScene(sceneMap.get("game"));
			}
		};
		iTwo.setOnAction(myFreshStartHandler);
		
		sceneMap.put("game", setGameScene());//playerOne,playerTwo,theDealer
		sceneMap.put("menu", setMenuScene());
		
		
		myNewLookHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				pane.setStyle("-fx-background-color: lightPink;");
			}
		};
		iThree.setOnAction(myNewLookHandler);
		
		primaryStage.setScene(sceneMap.get("menu"));
		primaryStage.show();
	}
	
	public Scene setMenuScene() {
		BorderPane bpane = new BorderPane();
		HBox hbox = new HBox(b1,b2);
		hbox.setSpacing(5);
		bpane.setCenter(hbox);
		bpane.setPadding(new Insets(100));
		
		Scene scene = new Scene(bpane,400,300);
		return scene;
	}
	
	public Scene setGameScene() { //Player playerOne, Player playerTwo, Dealer theDealer
		BorderPane bpane = new BorderPane();
		pane = bpane;
		p1Ready.setDisable(false);
		p1PlayBtn.setDisable(true);
		p1FoldBtn.setDisable(true);
		p2PlayBtn.setDisable(true);
		p2FoldBtn.setDisable(true);
		
		// --------------------Menu on top----------------------
		MenuBar m = new MenuBar();
		Menu option = new Menu("Options");
		MenuItem iOne = new MenuItem("Exit");
		
		iOne.setOnAction(e->Platform.exit());
		
		option.getItems().add(iOne);
		option.getItems().add(iTwo);
		option.getItems().add(iThree);
		
		m.getMenus().add(option);
		bpane.setTop(m);
		
		//-------------------------left------------------------
		t1 = new TextField("P1 Ante Wager");
		t1.setDisable(true);
		t2 = new TextField("P1 Pair Plus Wager");
		t2.setDisable(true);
		t3 = new TextField("P1 Play Wager");
		t3.setDisable(true);
		
		p1Ante = new TextField();
		p1PP = new TextField();
		p1Play = new TextField();
		p1Play.setDisable(true);
		
		
		
		VBox vbox = new VBox(t1,p1Ante,t2,p1PP,t3,p1Play,p1Ready);
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		bpane.setLeft(vbox);
		
		//----------------------------right------------------------------
		t4 = new TextField("P2 Ante Wager");
		t4.setDisable(true);
		t5 = new TextField("P2 Pair Plus Wager");
		t5.setDisable(true);
		t6 = new TextField("P2 Play Wager");
		t6.setDisable(true);
		
		p2Ante = new TextField();
		p2PP = new TextField();
		p2Play = new TextField();
		p2Play.setDisable(true);
		
		
		p2Ready.setDisable(true);
		
		VBox vbox2 = new VBox(t4,p2Ante,t5,p2PP,t6,p2Play,p2Ready);
		vbox2.setAlignment(Pos.BOTTOM_CENTER);
		bpane.setRight(vbox2);
		
		//-----------------------------bottom-----------------------------
		t7 = new TextField("P1 Total");
		t7.setDisable(true);
		t8 = new TextField("P2 Total");
		t8.setDisable(true);
		
		p1Total = new TextField();
		p1Total.setText(String.valueOf(playerOne.getTotalWinnings()));
		p1Total.setDisable(true);
		p2Total = new TextField();
		p2Total.setText(String.valueOf(playerTwo.getTotalWinnings()));
		p2Total.setDisable(true);
		
		VBox bottomVbox1 = new VBox(t7,p1Total);
		bottomVbox1.setPadding(new Insets(50));
		VBox bottomVbox2 = new VBox(t8,p2Total);
		bottomVbox2.setPadding(new Insets(50));
		HBox bottomHbox = new HBox(150,bottomVbox1,Items,bottomVbox2);
		bottomHbox.setAlignment(Pos.BOTTOM_CENTER);
		bpane.setBottom(bottomHbox);
		
		//--------------------------center--------------------------------
		
		t9 = new TextField("Dealer");
		t9.setDisable(true);
		
		dealerCard1 = new TextField();
		dealerCard1.setDisable(true);
		dealerCard2 = new TextField();
		dealerCard2.setDisable(true);
		dealerCard3 = new TextField();
		dealerCard3.setDisable(true);
		HBox dealerSide = new HBox(t9,dealerCard1,dealerCard2,dealerCard3);
		dealerSide.setAlignment(Pos.TOP_CENTER);
		
		t10 = new TextField("Player1");
		t10.setDisable(true);
		// p1PlayBtn = new Button("play");
		// p1FoldBtn = new Button("fold");
		HBox hboxCenterPlayerOneInfo = new HBox(t10,p1PlayBtn,p1FoldBtn);
		playerOne.setHand(theDealer.dealHand());
		player1Card1 = new TextField();
		player1Card1.setDisable(true);
		player1Card2 = new TextField();
		player1Card2.setDisable(true);
		player1Card3 = new TextField();
		player1Card3.setDisable(true);
		HBox hboxCenterPlayerOneCard = new HBox(player1Card1,player1Card2,player1Card3);
		VBox p1Side = new VBox(hboxCenterPlayerOneInfo, hboxCenterPlayerOneCard);
		
		t11 = new TextField("Player2");
		t11.setDisable(true);
		// p2PlayBtn = new Button("play");
		// p2FoldBtn = new Button("fold");
		HBox hboxCenterPlayerTwoInfo = new HBox(t11,p2PlayBtn,p2FoldBtn);
		playerTwo.setHand(theDealer.dealHand());
		player2Card1 = new TextField();
		player2Card1.setDisable(true);
		player2Card2 = new TextField();
		player2Card2.setDisable(true);
		player2Card3 = new TextField();
		player2Card3.setDisable(true);
		HBox hboxCenterPlayerTwoCard = new HBox(player2Card1,player2Card2,player2Card3);
		VBox p2Side = new VBox(hboxCenterPlayerTwoInfo, hboxCenterPlayerTwoCard);
		
		HBox playerSide = new HBox(50,p1Side,p2Side);
		playerSide.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox wholeCenterPiece = new VBox(250,dealerSide,playerSide);
		wholeCenterPiece.setPadding(new Insets(50));
		
		bpane.setCenter(wholeCenterPiece);
		// --------------------------------------------------------------
		
		Scene scene = new Scene(bpane,1100,850);
		return scene;
	}
		
}
