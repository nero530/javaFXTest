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


    public MijnKaartje() {

        this.initialiseNodes();
        this.layoutNodes();

    }

    public void initialiseNodes() {
        this.naam=new Text();
        this.eenTekst1=new Text();
        this.eenTekst2=new Text();


        this.fotoPersoon = new ImageView("Cheeseburger.jpg");



    }
    public void layoutNodes(){
        fotoPersoon.isPreserveRatio();
        fotoPersoon.setFitHeight(200);
        fotoPersoon.setFitWidth(150);
       // fotoPersoon.getStyleClass().add("hidden2");
fotoPersoon.setVisible(false);


        // naam.setStyle("-fx-text-fill: inputMijnKaartje");






        this.getChildren().addAll(naam,fotoPersoon,eenTekst1,eenTekst2);


    }


}
