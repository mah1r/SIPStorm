package sample;

import animatefx.animation.*;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import de.jensd.fx.glyphs.fontawesome.utils.FontAwesomeIconFactory;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.materialicons.utils.MaterialIconFactory;
import de.jensd.fx.glyphs.octicons.OctIcon;
import de.jensd.fx.glyphs.octicons.OctIconView;
import de.jensd.fx.glyphs.octicons.utils.OctIconFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import webphone.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Controller implements Initializable {

    public Button button;
    public Button button1;
    public Button hangup;
    public TextField ip_addr;  // IP Address
    public TextField username;  // Tenant Number
    public TextField secret;
    public TextField calee;// Tenant Name
    public webphone phone;
    public TextField noofcalls;
    public Button addtolist;
    public ArrayList list;
    public ListView listView;
    public TextArea textArea;
    public JFXToggleButton toggleBtwCalls;
    public TextField secBtwCalls;
    public JFXToggleButton toggleHangup;
    public TextField secHangup;
    public JFXToggleButton toggleLoop;
    public TextField loopFor;
    public JFXCheckBox checkBox;
    public ChoiceBox select;
    public Label textLabel;
    public ImageView callKey;
    public ImageView hangupKey;
    public VBox vBox;
    public Button hangupOneByOne;
    public JFXHamburger hamburger;
    public JFXDrawer drawer;
    public HBox hBox1;
    public HBox hBox2;
    public HBox hBox3;
    public VBox vBoxRegister;
    public JFXDrawer drawerRegister;
    public Button styling;
    public Button styling2;



    Image calling = new Image("sample/assets/call1.png");
    Image hanguping = new Image("sample/assets/call2.png");

    OctIconView icon = new OctIconView(OctIcon.HOME);
    Text icon2 = OctIconFactory.get().createIcon(OctIcon.HOME);




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea.setVisible(false);
        toggleBtwCalls.setVisible(false);
        secBtwCalls.setVisible(false);
        toggleHangup.setVisible(false);
        secHangup.setVisible(false);
        toggleLoop.setVisible(false);
        loopFor.setVisible(false);
        addtolist.setVisible(false);
        select.setVisible(false);



      //  arrowDown.setSize("4em");


            hangupOneByOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {

                if (hangupOneByOne.getAccessibleText().contains("Show Advanced")) {
                    new FadeIn(textArea).play();
                    textArea.setVisible(true);
                    new FadeIn(toggleBtwCalls).play();
                    toggleBtwCalls.setVisible(true);
                    new FadeIn(secBtwCalls).play();
                    secBtwCalls.setVisible(true);
                    new FadeIn(toggleHangup).play();
                    toggleHangup.setVisible(true);
                    new FadeIn(secHangup).play();
                    secHangup.setVisible(true);
                    new FadeIn(toggleLoop).play();
                    toggleLoop.setVisible(true);
                    new FadeIn(loopFor).play();
                    loopFor.setVisible(true);
                    new FadeIn(addtolist).play();
                    addtolist.setVisible(true);
                    new FadeIn(select).play();
                    select.setVisible(true);
                    hangupOneByOne.setAccessibleText("Hide Advanced");
                    hangupOneByOne.setText("Hide Advanced");

                } else if(hangupOneByOne.getAccessibleText().contains("Hide Advanced")){

                        new FadeOut(textArea).play();
                      //  textArea.setVisible(false);
                        new FadeOut(toggleBtwCalls).play();
                      //  toggleBtwCalls.setVisible(false);
                        new FadeOut(secBtwCalls).play();
                     //   secBtwCalls.setVisible(false);
                        new FadeOut(toggleHangup).play();
                      //  toggleHangup.setVisible(false);
                        new FadeOut(secHangup).play();
                    //    secHangup.setVisible(false);
                        new FadeOut(toggleLoop).play();
                   //     toggleLoop.setVisible(false);
                        new FadeOut(loopFor).play();
                     //   loopFor.setVisible(false);
                        new FadeOut(addtolist).play();
                    //    addtolist.setVisible(false);
                        new FadeOut(select).play();
                   //     select.setVisible(false);
                    hangupOneByOne.setAccessibleText("Show Advanced");
                    hangupOneByOne.setText("Show Advanced");



                     }
                    }

                });
        //drawerPane.getStyleClass().add("red-400");

        /*drawer.setDefaultDrawerSize(500);
        drawer.setOverLayVisible(true);
        drawer.setResizableOnDrag(false);*/
       // hBox1.setAlignment(Pos.BOTTOM_CENTER);
       // hBox1.setAlignment(Pos.BASELINE_LEFT);
      //  hBox1.setPadding(new Insets(0,0,0,0));
       // hBox2.setAlignment(Pos.BASELINE_LEFT);
     //   hBox2.setPadding(new Insets(0,0,0,0));
      //  hBox3.setAlignment(Pos.BASELINE_LEFT);
     //   hBox3.setPadding(new Insets(0,0,0,0));


        vBox.setSpacing(5);
        vBox.setPadding(new Insets(5,15,5,15));

        secBtwCalls.setPrefWidth(30);
      //  vBox.getChildren().addAll(textArea,toggleBtwCalls,secBtwCalls,toggleHangup,secHangup,toggleLoop,loopFor,addtolist,select);
        drawer.setSidePane(vBox);
        drawer.setOverLayVisible(false);
        HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(hamburger);
        burgerTask2.setRate(-1);

        hamburger.setVisible(false);

        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            drawer.setDirection(JFXDrawer.DrawerDirection.LEFT);

            burgerTask2.setRate(burgerTask2.getRate() * -1);

            burgerTask2.play();

            if (drawer.isClosed()) {
                drawer.open();
            } else {
                drawer.close();
            }
        });

        styling.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (drawer.isClosed()) {
                    drawer.open();
                } else {
                    drawer.close();
                }

            }
        });



        vBoxRegister.setSpacing(5);
        vBoxRegister.setPadding(new Insets(5,15,5,15));
        drawerRegister.setSidePane(vBoxRegister);
        drawerRegister.setOverLayVisible(false);
        callKey.setVisible(false);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                phone = new webphone();
                String ipaddr = ip_addr.getText();
                String user = username.getText();
                String secr = secret.getText();

                phone.API_SetParameter("serveraddress", ipaddr);
                phone.API_SetParameter("username", user);
                phone.API_SetParameter("password", secr);


//Initialize the sip stack
                phone.API_Start();
                new Shake(button).play();
                button.setText("Registered!");



                drawer.setDirection(JFXDrawer.DrawerDirection.LEFT);

                new FadeInLeftBig(callKey).play();
                callKey.setVisible(true);

                if (drawer.isClosed()) {
                    drawer.open();
                } else {
                    drawer.close();
                }


            }
        });


        /*StackPane drawerPane = new StackPane();
        drawerPane.getStyleClass().add("red-400");
        drawerPane.getChildren().add(new JFXButton("Left Content"));
        drawer.setSidePane(drawerPane);
        drawer.setDefaultDrawerSize(250);
        drawer.setOverLayVisible(true);
        drawer.setDirection(JFXDrawer.DrawerDirection.TOP);
        drawer.setResizableOnDrag(true);*/





        textLabel.setVisible(false);
        Tooltip tooltip = new Tooltip();
        tooltip.setText("User can set one destination only or multiple destinations separated by the comma sign");
        textArea.setTooltip(tooltip);
        secBtwCalls.setDisable(true);
        toggleBtwCalls.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (toggleBtwCalls.isSelected()) {
                    secBtwCalls.setDisable(false);
                } else {
                    secBtwCalls.setDisable(true);
                    secBtwCalls.clear();
                }

            }
        });
        secHangup.setDisable(true);
        toggleHangup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (toggleHangup.isSelected()) {
                    secHangup.setDisable(false);
                } else {
                    secHangup.setDisable(true);
                    secHangup.clear();
                }

            }
        });
        loopFor.setDisable(true);
        toggleLoop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (toggleLoop.isSelected()) {
                    loopFor.setDisable(false);
                } else {
                    loopFor.setDisable(true);
                    loopFor.clear();
                }
            }
        });



        addtolist.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String selected = String.valueOf(select.getValue());

                System.out.println(selected);

                if (selected.contains("Linear OneByOne")) {
                    Integer looping = Integer.valueOf(loopFor.getText());
                    Integer hanguping = Integer.valueOf(secHangup.getText());

                        for (int i=0; i<= looping; i++) {
                            testOtherLinearStrategy();



                        }
                    registerExtension();
                    return;


                } else if (selected.contains("Linear FirstOneAll")) {
                    linearStrategy();
                    registerExtension();
                    return;
                } else if (selected.contains("No idea what this does")) {
                    doesNothing();
                    textLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            textLabel.setVisible(false);
                        }
                    });
                }


            }
        });


    }

    public void mousePressed() {
        String call = calee.getText();
        String noofcallss = noofcalls.getText();
        int calls = Integer.valueOf(noofcalls.getText());
        list = new ArrayList();
        list.add(call);
        if (noofcallss.contains("")) {
            phone.API_Call(-1, call);
            System.out.println("Nema nista");
        } else if (!noofcallss.isEmpty()) {

            List<String> stringList = Pattern.compile(",")
                    .splitAsStream(call)
                    .collect(Collectors.toList());

            for (int i = 0; i < calls; i++) {

                stringList.forEach(s -> phone.API_Call(-1, s));

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phone.API_Hangup(-1);
                System.out.println("ima neki broj");
                System.out.println(calls);
                return;

            }
        }
    }

    public void mousePressed2() {
        phone.API_Hangup(-1);
        return;

    }

    private void linearStrategy() {
        String call = textArea.getText();

        List<String> stringList = Pattern.compile(",").splitAsStream(call).collect(Collectors.toList());

        Iterator<String> iter = stringList.iterator();


        while (iter.hasNext()) {
            String next = iter.next();

            Integer looping = Integer.valueOf(loopFor.getText());
            for (int i=0; i<looping; i++) {
                Integer getSecondsBtwCalls = Integer.valueOf(secBtwCalls.getText());
                try {
                    Thread.sleep(getSecondsBtwCalls);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(next);
                phone.API_Call(-1, next);

                Integer hangupAfter = Integer.valueOf(secHangup.getText());
                try {
                    Thread.sleep(hangupAfter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phone.API_Hangup(-1);
            }


        }

    }
    private void testOtherLinearStrategy() {
        String call = textArea.getText();

        List<String> stringList = Pattern.compile(",").splitAsStream(call).collect(Collectors.toList());

        Iterator<String> iter = stringList.iterator();


        while (iter.hasNext()) {
            String next = iter.next();

            Integer looping = Integer.valueOf(loopFor.getText());
            for (int i=0; i<looping; i++) {
                Integer getSecondsBtwCalls = Integer.valueOf(secBtwCalls.getText());
                try {
                    Thread.sleep(getSecondsBtwCalls);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(next);
                phone.API_Call(-1, next);

            }
            Integer hanguping = Integer.valueOf(secHangup.getText());
            try {
                Thread.sleep(hanguping);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            phone.API_Hangup(-1);
        }
    }





    private void doesNothing() {

        textLabel.setVisible(true);
        textLabel.setText("Apparently it does nothing." + "\n" + "\n" +
                "But nevertheless," + "\n" + "\n" +
                "Have a nice holidays!");
    }
    public void mousePressedcallKey() {

        new Shake(callKey).play();
        hangupKey.setVisible(true);
        new Flip(hangupKey).play();



        new Shake(callKey).play();
        hangupKey.setVisible(true);
        new Flip(hangupKey).play();
        String call = calee.getText();
        String noofcallss = noofcalls.getText();

        list = new ArrayList();
        list.add(call);
        if (noofcallss.contains("")) {
            phone.API_Call(-1, call);
            System.out.println("Nema nista");
        } else if (!noofcallss.isEmpty()) {
            List<String> stringList = Pattern.compile(",")
                    .splitAsStream(call)
                    .collect(Collectors.toList());

            int calls = Integer.valueOf(noofcalls.getText());

            for (int i = 0; i < calls; i++) {

                stringList.forEach(s -> phone.API_Call(-1, s));

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phone.API_Hangup(-1);
                System.out.println("ima neki broj");
                System.out.println(calls);
               // hangupKey.setVisible(false);
                return;


            }
        }


    }
    public void mousePressed2hangupKey() {
       // hangupKey.setVisible(false);
        new Flip(hangupKey).play();
        phone.API_Hangup(-1);

    }
    public void dialerMode() {
        String selected = String.valueOf(select.getValue());

        System.out.println(selected);

        if (selected.contains("Linear OneByOne")) {
            Integer looping = Integer.valueOf(loopFor.getText());
            for (int i=1; i <=looping; i++) {
                testOtherLinearStrategy();
            }
        } else if (selected.contains("Linear FirstOneAll")) {
            linearStrategy();
        } else if (selected.contains("No idea what this does")) {
            doesNothing();
            textLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    textLabel.setVisible(false);
                }
            });
        }


    }

    public void stylingPressed() {


        styling.setVisible(false);
        styling2.setVisible(true);
        // new Flip(styling).play();
        if (drawer.isClosed()) {
            drawer.open();
        } else {
            drawer.close();
        }
        new Flip(styling).play();

    }
    public void stylingPressed2() {


        styling.setVisible(true);
        styling2.setVisible(false);

        if (drawer.isClosed()) {
            drawer.open();
        } else {
            drawer.close();
        }
        new Flip(styling2).play();
}
private void registerExtension() {
    phone = new webphone();
    String ipaddr = ip_addr.getText();
    String user = username.getText();
    String secr = secret.getText();

    phone.API_SetParameter("serveraddress", ipaddr);
    phone.API_SetParameter("username", user);
    phone.API_SetParameter("password", secr);


//Initialize the sip stack
    phone.API_Start();


}
}






