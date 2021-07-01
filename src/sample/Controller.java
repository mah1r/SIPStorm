package sample;

import animatefx.animation.*;
import com.jfoenix.controls.*;
import com.jfoenix.controls.events.JFXDrawerEvent;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.sun.tools.corba.se.idl.StringGen;
import de.jensd.fx.glyphs.fontawesome.utils.FontAwesomeIconFactory;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.materialicons.utils.MaterialIconFactory;
import de.jensd.fx.glyphs.octicons.OctIcon;
import de.jensd.fx.glyphs.octicons.OctIconView;
import de.jensd.fx.glyphs.octicons.utils.OctIconFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.pbx.*;
import org.asteriskjava.pbx.activities.DialActivity;
import org.asteriskjava.pbx.internal.core.AsteriskPBX;
import webphone.*;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.BaseAgiScript;


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
    public JFXDrawer drawerDialpad;
    public HBox hBox1;
    public HBox hBox2;
    public HBox hBox3;
    public VBox vBoxRegister;
    public JFXDrawer drawerRegister;
    public Button styling;
    public Button styling2;
    public Button iconWeb;
    public Button dialpad;
    public VBox dialpadVbox;
    public AnchorPane anchorPane1;
    public AnchorPane anchorPaneDialpad;

    public Button one;
    public Button two;
    public Button three;
    public Button four;
    public Button five;
    public Button six;
    public Button seven;
    public Button eight;
    public Button nine;
    public Button zero;
    public Button asterisk;
    public Button hash;
    public TextField dtmfText;
    public Button sendDtmf;
    public Button newAsterisk;



    Image calling = new Image("sample/assets/call1.png");
    Image hanguping = new Image("sample/assets/call2.png");

    OctIconView icon = new OctIconView(OctIcon.HOME);
    Text icon2 = OctIconFactory.get().createIcon(OctIcon.HOME);


    @Override
    public void initialize(URL location, ResourceBundle resources) {



        newAsterisk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ManagerConnectionFactory factory = new ManagerConnectionFactory(
                        "192.168.1.115", "[myconnection]", "test123");
                // Retrieve the connection from the factory
                ManagerConnection managerConnection = factory.createManagerConnection();

                    // login to Asterisk
                    try {
                        managerConnection.login();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AuthenticationFailedException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                }
        });




        textArea.setVisible(false);
        toggleBtwCalls.setVisible(false);
        secBtwCalls.setVisible(false);
        toggleHangup.setVisible(false);
        secHangup.setVisible(false);
        toggleLoop.setVisible(false);
        loopFor.setVisible(false);
        addtolist.setVisible(false);
        select.setVisible(false);


        calee.focusedProperty().addListener((observable, oldValue, newValue) -> {
           one.setOnAction(event -> {
               String one1 = one.getText();
               calee.appendText(one1);
            });
            two.setOnAction(event -> {
                String two1 = two.getText();
                calee.appendText(two1);
            });
            three.setOnAction(event -> {
                String three1 = three.getText();
                calee.appendText(three1);
            });
            four.setOnAction(event -> {
                String four1 = four.getText();
                calee.appendText(four1);
            });
            five.setOnAction(event -> {
                String five1 = five.getText();
                calee.appendText(five1);
            });
            six.setOnAction(event -> {
                String six1 = six.getText();
                calee.appendText(six1);
            });
            seven.setOnAction(event -> {
                String seven1 = seven.getText();
                calee.appendText(seven1);
            });
            eight.setOnAction(event -> {
                String eight1 = eight.getText();
                calee.appendText(eight1);
            });
            nine.setOnAction(event -> {
                String nine1 = nine.getText();
                calee.appendText(nine1);
            });
            zero.setOnAction(event -> {
                String zero1 = zero.getText();
                calee.appendText(zero1);
            });
            asterisk.setOnAction(event -> {
                String asterisk1 = asterisk.getText();
                calee.appendText(asterisk1);
            });
            hash.setOnAction(event -> {
                String hash1 = hash.getText();
                calee.appendText(hash1);
            });
        });

        dtmfText.focusedProperty().addListener((observable, oldValue, newValue) -> {
            one.setOnAction(event -> {
                String one1 = one.getText();
                dtmfText.appendText(one1);
            });
            two.setOnAction(event -> {
                String two1 = two.getText();
                dtmfText.appendText(two1);
            });
            three.setOnAction(event -> {
                String three1 = three.getText();
                dtmfText.appendText(three1);
            });
            four.setOnAction(event -> {
                String four1 = four.getText();
                dtmfText.appendText(four1);
            });
            five.setOnAction(event -> {
                String five1 = five.getText();
                dtmfText.appendText(five1);
            });
            six.setOnAction(event -> {
                String six1 = six.getText();
                dtmfText.appendText(six1);
            });
            seven.setOnAction(event -> {
                String seven1 = seven.getText();
                dtmfText.appendText(seven1);
            });
            eight.setOnAction(event -> {
                String eight1 = eight.getText();
                dtmfText.appendText(eight1);
            });
            nine.setOnAction(event -> {
                String nine1 = nine.getText();
                dtmfText.appendText(nine1);
            });
            zero.setOnAction(event -> {
                String zero1 = zero.getText();
                dtmfText.appendText(zero1);
            });
            asterisk.setOnAction(event -> {
                String asterisk1 = asterisk.getText();
                dtmfText.appendText(asterisk1);
            });
            hash.setOnAction(event -> {
                String hash1 = hash.getText();
                dtmfText.appendText(hash1);
            });
        });




        sendDtmf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String dtmf = calee.getText();
                phone.API_Dtmf(-1, dtmf);
            }
        });





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

            iconWeb.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
               //     Integer dtmf = Integer.valueOf(calee.getText());
                    String dtmf1 = calee.getText();
                    String setText1 = "nekitekst";

                    phone.API_Dtmf(-1, dtmf1);




                }
            });


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
        styling.setVisible(false);
        styling2.setVisible(false);
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
        dialpadVbox.setSpacing(15);
        dialpadVbox.setPadding(new Insets(5,20,5,40));
        drawerDialpad.setSidePane(dialpadVbox);
        drawerDialpad.setOverLayVisible(false);
        dialpad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                drawerDialpad.setDirection(JFXDrawer.DrawerDirection.LEFT);

                new FadeInLeftBig(callKey).play();
                hangupKey.setVisible(true);
                new FadeInLeftBig(hangupKey).play();
                callKey.setVisible(true);

                if (drawerDialpad.isClosed()) {
                    anchorPaneDialpad.setDisable(false);
                    drawerDialpad.open();
                    drawer.close();

                } else {
                    drawerDialpad.close();
                    anchorPaneDialpad.setDisable(true);
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



    static private void syncDial()
    {
        try
        {
            PBX pbx = PBXFactory.getActivePBX();

            // The trunk MUST match the section header (e.g. [default]) that
            // appears
            // in your /etc/asterisk/sip.d file (assuming you are using a SIP
            // trunk).
            // The trunk is used to select which SIP trunk to dial through.
            Trunk trunk = pbx.buildTrunk("default");

            // We are going to dial from extension 100
            EndPoint from = pbx.buildEndPoint(TechType.SIP, "100");
            // The caller ID to show on extension 100.
            CallerID fromCallerID = pbx.buildCallerID("100", "My Phone");

            // The caller ID to display on the called parties phone
            CallerID toCallerID = pbx.buildCallerID("83208100", "Asterisk Java is calling");
            // The party we are going to call.
            EndPoint to = pbx.buildEndPoint(TechType.SIP, trunk, "5551234");

            // Trunk is currently ignored so set to null
            // The call is dialed and only returns when the call comes up (it
            // doesn't wait for the remote end to answer).
            DialActivity dial = pbx.dial(from, fromCallerID, to, toCallerID);

            Call call = dial.getNewCall();

            Thread.sleep(20000);

           //  logger.warn("Hanging up");
            pbx.hangup(call);
        }
        catch (PBXException | InterruptedException e)
        {
            System.out.println(e);
        }
    }


}






