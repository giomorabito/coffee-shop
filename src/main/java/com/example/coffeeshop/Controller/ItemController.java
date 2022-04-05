package com.example.coffeeshop.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.example.coffeeshop.models.Item;
import com.example.coffeeshop.ItemListener;
import java.text.NumberFormat;

public class ItemController {

    @FXML
    private ImageView itemImage;

    @FXML
    private Label itemNameLabel;

    @FXML
    private Label itemPriceLabel;
    
    @FXML
    public void click(MouseEvent mouseEvent){
        itemListener.onClickListener(item);
    }
    
    private Item item;
    private ItemListener itemListener;

    public void setInfo(Item item, ItemListener itemListener){
        this.item = item;
        this.itemListener = itemListener;
        itemNameLabel.setText(item.getName());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        itemPriceLabel.setText(formatter.format(item.getPrice()));
        Image image = new Image(getClass().getResourceAsStream(item.getImage()));
        itemImage.setImage(image);
    }
}