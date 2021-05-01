package sample;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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

    Image calling = new Image("sample/assets/phone-call.png");
    Image hanguping = new Image("sample/assets/phone-call-end.png");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
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


            }
        });
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
                    for (int i=1; i <=looping; i++) {
                        otherLinearStrategy();
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

            if (toggleLoop.isSelected()) {
                Integer looping = Integer.valueOf(loopFor.getText());
                for (int i = 0; i < looping; i++) {


                    if (toggleBtwCalls.isSelected()) {
                        Integer getSecondsBtwCalls = Integer.valueOf(secBtwCalls.getText());
                        try {
                            Thread.sleep(getSecondsBtwCalls);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(next);
                        phone.API_Call(-1, next);
                    }

                    if (toggleHangup.isSelected()) {
                        Integer hangupAfter = Integer.valueOf(secHangup.getText());
                        try {
                            Thread.sleep(hangupAfter);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        phone.API_Hangup(-1);


                    }
                }

            } else {
                if (toggleBtwCalls.isSelected()) {
                    Integer getSecondsBtwCalls = Integer.valueOf(secBtwCalls.getText());
                    try {
                        Thread.sleep(getSecondsBtwCalls);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(next);
                    phone.API_Call(-1, next);
                }

                if (toggleHangup.isSelected()) {
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

    }
    private void otherLinearStrategy() {
        String call = textArea.getText();


        List<String> stringList = Pattern.compile(",").splitAsStream(call).collect(Collectors.toList());

        Iterator<String> iter = stringList.iterator();


        while (iter.hasNext()) {
            String next = iter.next();

            if (toggleLoop.isSelected()) {
                Integer looping = Integer.valueOf(loopFor.getText());
                for (int i=1; i<looping; i++) {

                    if (toggleBtwCalls.isSelected()) {
                        Integer getSecondsBtwCalls = Integer.valueOf(secBtwCalls.getText());
                        try {
                            Thread.sleep(getSecondsBtwCalls);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(next);
                        phone.API_Call(-1, next);
                    }
                }
            }
                    if (toggleHangup.isSelected()) {
                        Integer hangupAfter = Integer.valueOf(secHangup.getText());
                        try {
                            Thread.sleep(hangupAfter);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        phone.API_Hangup(-1);


                    }

             else {
                if (toggleBtwCalls.isSelected()) {
                    Integer getSecondsBtwCalls = Integer.valueOf(secBtwCalls.getText());
                    try {
                        Thread.sleep(getSecondsBtwCalls);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(next);
                    phone.API_Call(-1, next);
                }

                if (toggleHangup.isSelected()) {
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

    }


    private void doesNothing() {

        textLabel.setVisible(true);
        textLabel.setText("Apparently it does nothing." + "\n" + "\n" +
                "But nevertheless," + "\n" + "\n" +
                "Have a nice holidays!");
    }

}



