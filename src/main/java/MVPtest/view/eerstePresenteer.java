package MVPtest.view;

import MVPtest.model.Persoon;
import MVPtest.model.Spel;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.w3c.dom.NodeList;
import javafx.event.ActionEvent;
import java.util.Objects;


import static java.lang.Boolean.parseBoolean;

public class eerstePresenteer {
    private final Geheel view;
    private Spel model;

    public eerstePresenteer(Geheel view,Spel model) {
        this.model=model;
        this.view = view;
        this.addEventFilters();
        this.addEventHandlers();
        this.updateView();

    }


    private void addEventFilters() {
/*view.getScene().getWindow().addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("mouse click detected! " + mouseEvent.getSource());
    }



    });*/
    }

    private void addEventHandlers() {
        Bord bord = (Bord) view.getBord();
        bord.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String id1;
                if (event.getTarget().toString().contains("id")) {
                    id1 = event.getTarget().toString().split("id=")[1].substring(0, 2);


                    String id;
                    if (id1.contains(",")) {
                        id = id1.split(",")[0];
                    } else {
                        id = id1.split("]")[0];
                    }
                   // System.out.println(id);
                    if (view.titel.getText().equals("Kies een kaart")) {

                        model.setGekozenPersoon1(model.getSpelbord1().getAllePersonen().get(Integer.parseInt(id)));
                        System.out.println(model.getGekozenPersoon1().getNaam());
                        VBox mijnKaartje = view.getMijnKaartje();
                        Text naamKaartje = (Text) mijnKaartje.getChildren().get(0);
                        naamKaartje.setText(model.getGekozenPersoon1().getNaam());
                        Text geslacht = (Text) mijnKaartje.getChildren().get(2);
                         if(!model.getGekozenPersoon1().isVrouw()){
                            geslacht.setText("???");}
                         else{geslacht.setText("???");}
                        Text bril = (Text) mijnKaartje.getChildren().get(3);
                        if(!model.getGekozenPersoon1().isBril()){
                            bril.setText("bril: \uD83D\uDDF8");}
                        else{bril.setText("bril: ???");}
                        Text baard = (Text) mijnKaartje.getChildren().get(4);
                        if(!model.getGekozenPersoon1().isBaard()){
                            baard.setText("baard: \uD83D\uDDF8");}
                        else{baard.setText("baard:???");}
                        Text kaal = (Text) mijnKaartje.getChildren().get(5);
                        if(!model.getGekozenPersoon1().isKaal()){
                            kaal.setText("kaal: \uD83D\uDDF8");}
                        else{kaal.setText("kaal: ???");}
                        Text hoofddeksel = (Text) mijnKaartje.getChildren().get(6);
                        if(!model.getGekozenPersoon1().isHoofddeksel()){
                            hoofddeksel.setText("hoofddeksel: \uD83D\uDDF8");}
                        else{hoofddeksel.setText("hoofddeksel: ???");}
                        Text snor = (Text) mijnKaartje.getChildren().get(7);
                        if(!model.getGekozenPersoon1().isSnor()){
                            snor.setText("snor: \uD83D\uDDF8");}
                        else{snor.setText("hoofddeksel: ???");}



                        Text ogen = (Text) mijnKaartje.getChildren().get(8);
                        if ("GRIJS".equals(String.valueOf(model.getGekozenPersoon1().getOogkleur())) ) {
                            ogen.setText("oogkleur: Grijs");
                        }
                        else if ("BRUIN".equals(String.valueOf(model.getGekozenPersoon1().getOogkleur())) ) {
                            ogen.setText("oogkleur: Bruin");
                        }
                       else if ("ZWART".equals(String.valueOf(model.getGekozenPersoon1().getOogkleur())) ) {
                            ogen.setText("oogkleur:Zwart");
                        }
                        Text haren = (Text) mijnKaartje.getChildren().get(9);
                        if ("ZWART".equals(String.valueOf(model.getGekozenPersoon1().getHaarkleur())) ) {
                            haren.setText("haarkleur: Zwart");
                        }
                        if ("BRUIN".equals(String.valueOf(model.getGekozenPersoon1().getHaarkleur())) ) {
                            haren.setText("haarkleur: Bruin");
                        }
                        if ("BLOND".equals(String.valueOf(model.getGekozenPersoon1().getHaarkleur())) ) {
                            haren.setText("haarkleur:blond");
                        }

                        ImageView ImageKaartje = (ImageView) mijnKaartje.getChildren().get(1);

                        ImageKaartje.setImage(new Image("MogelijkeFotos.PNG"));
                        ImageKaartje.setVisible(true);
//Hier ook de foto Aanpassen
                    }
                    //getter voor titel
                    else if ((view.titel.getText().equals("ja")||view.titel.getText().equals("Nee")||view.getBevestigKnop().getText().equals("Klaar met bord")||view.getBevestigKnop().getText().equals("Ja"))&&(view.titel.getText().charAt(view.titel.getText().length()-1)!='?'&&view.titel.getText().charAt(view.titel.getText().length()-1)!='!'|| view.getBevestigKnop().getText().equalsIgnoreCase("ja"))) {
                        System.out.println(view.titel.getText().charAt(view.titel.getText().length()-1));
                  //String klasseKaartje= String.valueOf(event.getTarget().getClass());
                   if(! view.getBord().getChildren().get(Integer.parseInt(id)).getStyleClass().contains("uitgeschakeld")){
                       view.getBord().getChildren().get(Integer.parseInt(id)).getStyleClass().add("uitgeschakeld");
                  // System.out.println(  view.getBord().getChildren().get(Integer.parseInt(id)).getStyleClass().contains("uitgeschakeld"));
                   } else {
                       view.getBord().getChildren().get(Integer.parseInt(id)).getStyleClass().remove("uitgeschakeld");
                   }
                  String erStaatErNogMaarEenRecht= model.draaiKaartjeOm(Integer.parseInt(id));
                  //   String HuidigeTitel=   String.valueOf(view.titel.getText());
                    if(!erStaatErNogMaarEenRecht.equals("meerDanEen")){
                    view.titel.setUserData(view.titel.getText());
                        view.titel.setText("Denk je dat "+erStaatErNogMaarEenRecht+" de persoon is?");
                        view.getBevestigKnop().setText("Ja");
                        }
                    else{
                        if(view.titel.getUserData()!=null) {
                            view.titel.setText((String) view.titel.getUserData());
                            view.titel.setUserData(null);
                        }
                        view.getBevestigKnop().setText("Klaar met bord");


                    }
                    }
                }
            }

        });
        Button bevestigbutton=view.getBevestigKnop();
        bevestigbutton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //Maak getter voor titel
              //  System.out.println("JA");
                if(view.titel.getText().equals("Kies een kaart")&&!model.getGekozenPersoon1().getNaam().equals("anoniem")){

                    view.titel.setText("Welke vraag zou je willen stellen?");
                    view.getVragen().setVisible(true);


                }
                else if(view.titel.getText().equals("Welke vraag zou je willen stellen?")){
                    if(view.getBevestigKnop().getUserData()!=null){

                     // System.out.println(model.vraagBeantwoorden(view.getBevestigKnop().getUserData().toString()));
                      boolean antwoord= model.vraagBeantwoorden(view.getBevestigKnop().getUserData().toString());
                        System.out.println(antwoord);
                      if(antwoord){    view.titel.setText("Ja");}
                      else{view.titel.setText("Nee");}
                        view.getBevestigKnop().setText("Klaar met bord"); // gewijzigd
                      view.getVragen().setVisible(false);

                    }
                }
                  else if(view.getBevestigKnop().getText().equals("Klaar met bord")){


                            try {
                                String[] vraagComputer=model.computerSteltVraag();

                                view.titel.setText(vraagComputer[0]);
                                bevestigbutton.setText("Bevestigen");

                                bevestigbutton.setVisible(false);
                                Button positief= (Button) view.getKnoppenPosEnNeg().getChildren().get(0);
                                Button negatief= (Button) view.getKnoppenPosEnNeg().getChildren().get(1);

                                if( parseBoolean(vraagComputer[1])) {
                                     positief.setUserData(true);
                                    negatief.setUserData(false);

                                }
                                 else {
                                     negatief.setUserData(true);
                                    positief.setUserData(false);

                                }

                                view.getKnoppenPosEnNeg().setVisible(true);

                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }


                        }



            }});

        GridPane vragen = view.getVragen();

        for(Node child:   vragen.getChildren()){
            if(child instanceof Button){
child.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                //System.out.println(event.getSource().toString().split("'")[1]);
                            view.getBevestigKnop().setUserData(event.getSource().toString().split("'")[1]);
                               // System.out.println(bevestigbutton.getUserData());
                            }



        });
            }}

         Button pos= (Button) view.getKnoppenPosEnNeg().getChildren().get(0);
        Button neg= (Button) view.getKnoppenPosEnNeg().getChildren().get(1);
//Dit moet 1 handler worden voor beide knoppen.
        pos.setOnAction(new EventHandler<ActionEvent>() {
                                         @Override
                                         public void handle(ActionEvent event) {
                                            //Dit werkt, onthouden voor ieder verder gebruik!!!,
                                           final Button target=(Button) event.getTarget();
                                             System.out.println(target.getUserData());
                                           if(parseBoolean(target.getUserData().toString())) {
                                                view.getBevestigKnop().setVisible(true);
                                               view.getVragen().setVisible(true);
                                               view.getKnoppenPosEnNeg().setVisible(false);
                                                view.titel.setText("Welke vraag zou je willen stellen?");
                                           }

                                         }
                                     });
   neg.setOnAction(new EventHandler<ActionEvent>() {
       @Override
       public void handle(ActionEvent event) {
           final Button target=(Button) event.getTarget();
           System.out.println(target.getUserData());
           if(parseBoolean(target.getUserData().toString())){
               view.getBevestigKnop().setVisible(true);
               view.getVragen().setVisible(true);
               view.getKnoppenPosEnNeg().setVisible(false);
               view.titel.setText("Welke vraag zou je willen stellen?");
           }
       }
   });


    };


       /*
        });*/



        /*view.getMyButton().setOnAction( new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {;
view.getTekstveldje().setText("Er is gedrukt");




    }

});
*/


    //updateView is updaten met modelData
    private void updateView() {

 for(int i=0;i<20;i++) {
     String tekst=model.getSpelbord1().getAllePersonen().get(i).getNaam();
     VBox X =(VBox)(view.getBord().getChildren().get(i));
     Text bordnaam=(Text)X.getChildren().get(0);

     bordnaam.setText(tekst);

//Onderstaande code werkt even goed zou he voorzien op ongekend aantal vakjes
     /*Text naam=new Text(tekst);
     naam.setId(String.valueOf(i));
     ImageView fotoPersoon=new ImageView("Cheeseburger.jpg");
    fotoPersoon.setId(String.valueOf(i));
     fotoPersoon.setFitHeight(150);
     fotoPersoon.setFitWidth(150);
//view.getChildren().
    view.getBord().getChildren().add(new VBox(naam,fotoPersoon));//.getChildren().get(i);//.get(i);
    */

 }





   if (model.getGekozenPersoon1().getNaam() == "anoniem") {
       VBox mijnKaartje=view.getMijnKaartje();

    Text tekst=(Text) mijnKaartje.getChildren().get(0);
tekst.setText("Kies Een kaartje");

        }



}
}



