package MVPtest.view;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MijnKaartje extends VBox {
private Text naam;
private ImageView fotoPersoon;
private Text eenTekst1;
private Text eenTekst2;
    private Text eenTekst3;
    private Text eenTekst4;
    private Text eenTekst5;
    private Text eenTekst6;

    private Text eenTekst7;
    private Text eenTekst8;
    private Text eenTekst9;
    private Text eenTekst10;

    public MijnKaartje() {

        this.initialiseNodes();
        this.layoutNodes();

    }

    public void initialiseNodes() {
        this.naam=new Text();
        this.eenTekst1=new Text();
        this.eenTekst2=new Text();
        this.eenTekst3=new Text();
        this.eenTekst4=new Text();
        this.eenTekst5=new Text();
        this.eenTekst6=new Text();
        this.eenTekst7=new Text();
        this.eenTekst8=new Text();
        this.eenTekst9=new Text();
        this.eenTekst10=new Text();

        this.fotoPersoon = new ImageView("Cheeseburger.jpg");



    }
    public void layoutNodes(){
        fotoPersoon.isPreserveRatio();
        fotoPersoon.setFitHeight(200);
        fotoPersoon.setFitWidth(150);
       // fotoPersoon.getStyleClass().add("hidden2");
fotoPersoon.setVisible(false);


        // naam.setStyle("-fx-text-fill: inputMijnKaartje");






        this.getChildren().addAll(naam,fotoPersoon,eenTekst1,eenTekst2,eenTekst3,eenTekst4,eenTekst5,eenTekst6,eenTekst7,eenTekst8,eenTekst9,eenTekst10);


    }


}
