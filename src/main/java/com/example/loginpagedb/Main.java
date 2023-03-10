package com.example.loginpagedb;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private BorderPane root = new BorderPane();
    private Scene scene = new Scene(root);
    private VBox choice = new VBox();
    private Button singInButt = new Button("Sign in");
    private Button registerButt = new Button("Register");


    @Override
    public void start(Stage stage) throws IOException {

        singInButt.setFont(new Font(null, 15));
        registerButt.setFont(new Font(null, 15));

        choice.getChildren().addAll(singInButt, registerButt);
        choice.setSpacing(30);

        singInButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SignIn.start();
                stage.close();
            }
        });

        registerButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Register.start();
                stage.close();
            }
        });

        root.setCenter(choice);
        root.setPadding(new Insets(35, 40, 35, 80));
        stage.setWidth(250);
        stage.setHeight(200);
        stage.setResizable(false);
        stage.setTitle("Start Page!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}














        // НУ ВОТ!! І ВСЬО!! МИ ЗРОБИЛИ ЦЕ! ВСЬО ПРАЦЮЄ ТАК ЯК НАМ ТРЕБА ДЛЯ НАШОЇ ЗАДАЧІ! МИ ПРОВЕЛИ ПРЕКРАСНУ ПРАКТИКУ І ЗАКРІПЛЕННЯ МАТЕРІАЛУ ПО ОСНОВАМ JDBС
// МИ СПРАВИЛИСЬ ЗА... 3.5 ГОДИНИ)) ДОВГО ДУЖЕ КАНЕШНО НО ТІПА Я ЦЕ РОБИВ ОПШЕ ПЕРШИЙ РАЗ ПРОСТО ПІСЛЯ ПЕРЕГЛЯДУ ДЕСЬ 7 ВІДОСІВ ПО ЦІЙ ТЕМІ НО!!!
// ЦЯ ПРАКТИКА ДАЛА ДУЖЕ БАГАТО ЗНАНЬ ВІДНОСНО ДО ЦЬОЇ ТЕМИ, ВПЕВНЕНОСТІ НУ І ОПИТУ ТІПА)) ЧЕРЕЗ ЯКИСЬ ЧАС (1 МІСЯЦЬ +-) БУДУ РОБИТИ СВІЙ ПРОЕКТ ЛІЧНИЙ
// А САМЕ САЙТ З ВЛАСНИМ БЕК ЕНДОМ, ШО ЗА САЙТ БУДЕ Я ХЗ ПОКАШО НО ЦЕ БУДЕ ПРОЕКТ ЯК ЗАКРІПЛЕННЯ І ПРАКТИКА ВСЬОГО ШО Я ВЧИВ РІК ЧАСУ І ПІСЛЯ ЦЬОГО ШУКАТИ РОБОТУ ЙДУ
// А САЙТ ЦЕЙ БУДУ КАНЕШНО ШО ДОРОБЛЮВАТИ ПОСТІЙНО БО ПОСТІЙНО ШОСЬ НОВЕ БУДУ ВЗНАВАТИ, ВЧИТИ ТАКШО КАК ТО ТАК)) НА РАХУНОК ОЦЬОЇ ТЕМИ З БАЗАМИ ДАНИХ Я ШЕ ДЕСЬ 1-2 ДНЯ БУДУ
// ДИВИТИСЬ ВІДОСИ І ПРАКТИКУВАТИСЬ ПАРАЛЕЛЬНО І МБ ШЕ ЯКИСЬ ТАКИЙ ПОХОЖИЙ МІНІ ПРОЕКТІК ЯК ОЦЕЙ ЗРОБЛЮ НО ХЗ ЧИ БУДУ ЗАПИСУВАТИ ВІДОС. А ПІСЛЯ ЦЬОЇ ТЕМИ ШЕ... 2.5 ТЕМИ ТРЕБА ВИВЧИТИ
// 2 ТРОХИ БІЛЬШИХ І СЛОЖНІШИХ І 1 ЛЕГЕНЬКА І МАЛЕНЬКА ТОМУ КАЖУ ШО 2.5 ТЕМИ)) НУ І ПОТІМ ОЦЕ ВСЬО І ВСЬО ШО ЗА ВЕСЬ ЧАС ВЧИВ ЗАКРІПЛЮ ВЛАСНИМ САЙТОМ І ТОДІ СТАЮ НА КАРЄРНУ СТЕЖИНКУ))
// ЗБС! ПРАВДА ШО РОБИТИ З ФРОНТОМ ТОГО САЙТУ? XDDD Я БЕЗ ПОНЯТТЯ НО ДУМАВ ПРОСТ НА ЯКОМУСЬ WIX OR WORDPRESS ДЕСЬ ТАМ ЗРОБИТИ ФРОНТ І ПІД НИХ ВЖЕ САМОМУ ПИСАТИ БЕК НО ЯК Я ШЕ ХЗ
// НА ТО І ШЕ НА ПРИДУМАННЯ ТЕМИ І ШЕ НА ВСЯКІ ТАКІ ШТУКИ ТО ТРЕБА БУДЕ ДЕСЬ БІЛЯ ТИЖНЯ ЧАСУ ШОБ РОЗІБРАТИСЬ) НУ А ЗАРАЗ КАРОЧЕ ВСЬО ЙДЕ ЧОТКО!! ДЯКУЮ! ТИ РОБИШ ТО ШО ТРЕБА! ДАЛІ!
// НЕ ЗУПИНЯЙСЯ! І ПАМЯТАЙ ПРО СВОЇ МРІЇ І ПРО ТО ЗВІДКИ ТИ І ШО ТИ ТУТ РОБИШ ДЛЯ ЧОГО ПРИЇХАВ!!! ВСЬО ВИЙДЕ! ЕБАШ! ПАКА! ;) <3 BYE! <3









