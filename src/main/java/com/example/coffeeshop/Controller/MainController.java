package com.example.coffeeshop.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.example.coffeeshop.ItemListener;
import com.example.coffeeshop.models.Item;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MainController implements Initializable{
    @FXML
    private Label checkoutCountLabel;
    
    @FXML
    private VBox checkboxVBox;

    @FXML
    private ImageView checkoutButton;

    @FXML
    private TableView<Item> checkoutTableView;

    @FXML
    private Button completeOrderButton;

    @FXML
    private TableColumn<Item, String> customizationsTableColumn;

    @FXML
    private GridPane grid;

    @FXML
    private Button itemAddToOrderButton;

    @FXML
    private Spinner<Integer> itemCountSpinner;

    @FXML
    private ImageView itemImg;

    @FXML
    private Label itemNameLabel;

    @FXML
    private Label itemPriceLabel;

    @FXML
    private TableColumn<Item, String> itemTableColumn;

    @FXML
    private TableColumn<Item, Double> priceTableColumn;

    @FXML
    private TableColumn<Item, Integer> quantityTableColumn;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label subtotalLabel;

    @FXML
    private Label taxesAndFeesLabel;

    @FXML
    private Label totalLabel;

    @FXML
    void completeOrderButtonClicked(MouseEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order completed");
        alert.setHeaderText("Order has been completed!");
        alert.setContentText("A receipt of the order will now be printed.");
        alert.showAndWait();
        
        list.clear();
        checkoutTableView.getItems().clear();
        orderSubtotal = 0.00;
        orderTaxesAndFees = 0.00;
        orderTotal = 0.00;
        
        checkoutCountLabel.setText("0");
        subtotalLabel.setText("0.00");
        taxesAndFeesLabel.setText("0.00");
        totalLabel.setText("0.00");
        checkoutCountLabel.setText("0");
    }
    
    private double orderSubtotal;
    private double orderTaxesAndFees;
    private double orderTotal;
    
    CheckBox nonFatMilkCB = new CheckBox("Nonfat Milk");
    CheckBox twoPercentMilkCB = new CheckBox("2% Milk");
    CheckBox wholeMilkCB = new CheckBox("Whole Milk");
    CheckBox almondMilkCB = new CheckBox("Almond Milk +$0.80");
    CheckBox coconutMilkCB = new CheckBox("Coconut Milk +$0.80");
    CheckBox oatMilkCB = new CheckBox("Oat Milk +$0.80");
    CheckBox soyMilkCB = new CheckBox("Soy Milk +$0.80");
    CheckBox shotOfEspressoCB = new CheckBox("Shot of Espresso +$1.00");
    CheckBox noWhippedCreamCB = new CheckBox("No Whipped Cream");
    CheckBox sugarCB = new CheckBox("Sugar");
    CheckBox honeyCB = new CheckBox("Honey +$0.40");
    CheckBox splendaCB = new CheckBox("Splenda");
    CheckBox lemonadeCB = new CheckBox("Lemonade +$0.80");
    CheckBox everythingCB = new CheckBox("Everything");
    CheckBox plainCB = new CheckBox("Plain");
    CheckBox sesameCB = new CheckBox("Sesame");
    CheckBox cinnamonRaisinCB = new CheckBox("Cinnamon Raisin");
    CheckBox creamCheeseCB = new CheckBox("Cream Cheese +$1.00");
    CheckBox baconCB = new CheckBox("Bacon +$2.00");
    CheckBox butterCB = new CheckBox("Butter +$0.50");
    CheckBox jellyCB = new CheckBox("Jelly +$0.50");
    CheckBox substituteCheddarCheeseCB = new CheckBox("Substitute Cheddar Cheese +$0.50");
    CheckBox substituteEggWhitesCB = new CheckBox("Substitute Egg Whites +$0.50");
    CheckBox noCheeseCB = new CheckBox("No Cheese");
    CheckBox plainGlazedCB = new CheckBox("Plain Glazed");
    CheckBox chocolateGlazedCB = new CheckBox("Chocolate Glazed");
    CheckBox rainbowSprinkleCB = new CheckBox("Rainbow Sprinkle");
    CheckBox maplePecanCB = new CheckBox("Maple Pecan");
    CheckBox fruityPebblesCB = new CheckBox("Fruity Pebbles");
    CheckBox blueberryCB = new CheckBox("Blueberry");
    CheckBox chocolateChipCB = new CheckBox("Chocolate Chip");

    @FXML
    void itemAddToOrderButtonClicked(MouseEvent event) {
        double itemTotal = Double.parseDouble(itemPriceLabel.getText().substring(1)) * itemCountSpinner.getValue();
        
        List<String> customizations = new ArrayList<String>();
        if(nonFatMilkCB.isSelected()){
            customizations.add("Nonfat Milk");
            nonFatMilkCB.setSelected(false);
        }
        if(twoPercentMilkCB.isSelected()){
            customizations.add("2% Milk");
            twoPercentMilkCB.setSelected(false);
        }
        if(wholeMilkCB.isSelected()){
            customizations.add("Whole Milk");
            wholeMilkCB.setSelected(false);
        }
        if(almondMilkCB.isSelected()){
            customizations.add("Almond Milk +$0.80");
            itemTotal += 0.80;
            almondMilkCB.setSelected(false);
        }
        if(coconutMilkCB.isSelected()){
            customizations.add("Coconut Milk +$0.80");
            itemTotal += 0.80;
            coconutMilkCB.setSelected(false);
        }
        if(oatMilkCB.isSelected()){
            customizations.add("Oat Milk +$0.80");
            itemTotal += 0.80;
            oatMilkCB.setSelected(false);
        }
        if(soyMilkCB.isSelected()){
            customizations.add("Soy Milk +$0.80");
            itemTotal += 0.80;
            soyMilkCB.setSelected(false);
        }
        if(shotOfEspressoCB.isSelected()){
            customizations.add("Shot of Espresso +$1.00");
            itemTotal += 1.00;
            shotOfEspressoCB.setSelected(false);
        }
        if(noWhippedCreamCB.isSelected()){
            customizations.add("No Whipped Cream");
            itemTotal += 0.80;
            noWhippedCreamCB.setSelected(false);
        }
        if(sugarCB.isSelected()){
            customizations.add("Sugar");
            sugarCB.setSelected(false);
        }
        if(honeyCB.isSelected()){
            customizations.add("Honey +$0.40");
            itemTotal += 0.40;
            honeyCB.setSelected(false);
        }
        if(soyMilkCB.isSelected()){
            customizations.add("Splenda");
            soyMilkCB.setSelected(false);
        }
        if(lemonadeCB.isSelected()){
            customizations.add("Lemonade +$0.80");
            itemTotal += 0.80;
            lemonadeCB.setSelected(false);
        }
        if(everythingCB.isSelected()){
            customizations.add("Everything");
            everythingCB.setSelected(false);
        }
        if(plainCB.isSelected()){
            customizations.add("Plain");
            plainCB.setSelected(false);
        }
        if(everythingCB.isSelected()){
            customizations.add("Everything");
            everythingCB.setSelected(false);
        }
        if(plainCB.isSelected()){
            customizations.add("Plain");
            plainCB.setSelected(false);
        }
        if(sesameCB.isSelected()){
            customizations.add("Sesame");
            sesameCB.setSelected(false);
        }
        if(cinnamonRaisinCB.isSelected()){
            customizations.add("Cinnamon Raisin");
            cinnamonRaisinCB.setSelected(false);
        }
        if(creamCheeseCB.isSelected()){
            customizations.add("Cream Cheese +$1.00");
            itemTotal += 1.00;
            creamCheeseCB.setSelected(false);
        }
        if(baconCB.isSelected()){
            customizations.add("Bacon +$2.00");
            itemTotal += 2.00;
            baconCB.setSelected(false);
        }
        if(butterCB.isSelected()){
            customizations.add("Butter +$0.50");
            itemTotal += 0.50;
            butterCB.setSelected(false);
        }
        if(jellyCB.isSelected()){
            customizations.add("Jelly +$0.50");
            itemTotal += 0.50;
            jellyCB.setSelected(false);
        }
        if(substituteCheddarCheeseCB.isSelected()){
            customizations.add("Substitute Cheddar Cheese +$0.50");
            itemTotal += 0.50;
            substituteCheddarCheeseCB.setSelected(false);
        }
        if(substituteEggWhitesCB.isSelected()){
            customizations.add("Substitute Egg Whites +$0.50");
            itemTotal += 0.50;
            substituteEggWhitesCB.setSelected(false);
        }
        if(noCheeseCB.isSelected()){
            customizations.add("No Cheese");
            noCheeseCB.setSelected(false);
        }
        if(plainGlazedCB.isSelected()){
            customizations.add("Plain Glazed");
            plainGlazedCB.setSelected(false);
        }
        if(chocolateGlazedCB.isSelected()){
            customizations.add("Chocolate Glazed");
            chocolateGlazedCB.setSelected(false);
        }
        if(rainbowSprinkleCB.isSelected()){
            customizations.add("Rainbow Sprinkle");
            rainbowSprinkleCB.setSelected(false);
        }
        if(maplePecanCB.isSelected()){
            customizations.add("Maple Pecan");
            maplePecanCB.setSelected(false);
        }
        if(fruityPebblesCB.isSelected()){
            customizations.add("Fruity Pebbles");
            fruityPebblesCB.setSelected(false);
        }
        if(blueberryCB.isSelected()){
            customizations.add("Plain Glazed");
            blueberryCB.setSelected(false);
        }
        if(plainGlazedCB.isSelected()){
            customizations.add("Chocolate Chip");
            plainGlazedCB.setSelected(false);
        }
        
        orderSubtotal += itemTotal;
        orderTaxesAndFees = orderSubtotal *.0875;
        orderTotal = orderSubtotal + orderTaxesAndFees;
        
        String customizationsJoined = String.join(", ", customizations);
        
        list.add(new Item(itemNameLabel.getText(), itemTotal, itemCountSpinner.getValue(), customizationsJoined));
        checkoutTableView.setItems(list);
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        
        subtotalLabel.setText(formatter.format(orderSubtotal));
        taxesAndFeesLabel.setText(formatter.format(orderTaxesAndFees));
        totalLabel.setText(formatter.format(orderTotal));
        checkoutCountLabel.setText(Integer.toString(list.size()));
        customizations.clear();
    }
    
    private ObservableList<Item> list = FXCollections.observableArrayList();
    
    
    private List<Item> items = new ArrayList<>();
    private Image image;
    private ItemListener itemListener;
    
    public List<Item> getInfo(){
        List<Item> items = new ArrayList<>();
        Item item;
        
        // Breakfast
        
        item = new Item();
        item.setName("Bagel");
        item.setPrice(4.00);
        item.setImage("/com/example/coffeeshop/images/bagel.png");
        items.add(item);
        
        item = new Item();
        item.setName("Egg and Cheese Sandwich");
        item.setPrice(6.00);
        item.setImage("/com/example/coffeeshop/images/egg-and-cheese-sandwich.png");
        items.add(item);
        
        // Bakery
        
        item = new Item();
        item.setName("Donut");
        item.setPrice(4.50);
        item.setImage("/com/example/coffeeshop/images/donut.png");
        items.add(item);
        
        item = new Item();
        item.setName("Scone");
        item.setPrice(4.50);
        item.setImage("/com/example/coffeeshop/images/scone.png");
        items.add(item);
        
        // Hot Coffees
        
        item = new Item();
        item.setName("Cappuccino");
        item.setPrice(4.50);
        item.setImage("/com/example/coffeeshop/images/cappuccino.png");
        items.add(item);
        
        item = new Item();
        item.setName("Latte");
        item.setPrice(5.00);
        item.setImage("/com/example/coffeeshop/images/latte.png");
        items.add(item);
        
        item = new Item();
        item.setName("Espresso");
        item.setPrice(3.00);
        item.setImage("/com/example/coffeeshop/images/espresso.png");
        items.add(item);
        
        // Hot Teas
        
        item = new Item();
        item.setName("Chai Tea Latte");
        item.setPrice(4.50);
        item.setImage("/com/example/coffeeshop/images/chai-tea-latte.png");
        items.add(item);
        
        item = new Item();
        item.setName("Matcha Tea Latte");
        item.setPrice(6.00);
        item.setImage("/com/example/coffeeshop/images/matcha-tea-latte.png");
        items.add(item);
        
        item = new Item();
        item.setName("Earl Grey Tea");
        item.setPrice(2.50);
        item.setImage("/com/example/coffeeshop/images/earl-grey-tea.png");
        items.add(item);
        
        // Hot Drinks
        
        item = new Item();
        item.setName("Hot Chocolate");
        item.setPrice(3.50);
        item.setImage("/com/example/coffeeshop/images/hot-chocolate.png");
        items.add(item);
        
        // Cold Coffees
        
        item = new Item();
        item.setName("Iced Coffee");
        item.setPrice(5.00);
        item.setImage("/com/example/coffeeshop/images/iced-coffee.png");
        items.add(item);
        
        item = new Item();
        item.setName("Iced Latte");
        item.setPrice(5.00);
        item.setImage("/com/example/coffeeshop/images/iced-latte.png");
        items.add(item);
        
        item = new Item();
        item.setName("Cold Brew");
        item.setPrice(5.00);
        item.setImage("/com/example/coffeeshop/images/cold-brew.png");
        items.add(item);
        
        // Iced Teas
        
        item = new Item();
        item.setName("Iced Chai Tea Latte");
        item.setPrice(4.50);
        item.setImage("/com/example/coffeeshop/images/iced-chai-tea-latte.png");
        items.add(item);
        
        item = new Item();
        item.setName("Iced Matcha Tea Latte");
        item.setPrice(6.00);
        item.setImage("/com/example/coffeeshop/images/iced-matcha-tea-latte.png");
        items.add(item);
        
        // Cold Drinks
        
        item = new Item();
        item.setName("Orange Juice");
        item.setPrice(4.00);
        item.setImage("/com/example/coffeeshop/images/orange-juice.png");
        items.add(item);
        
        item = new Item();
        item.setName("Apple Juice");
        item.setPrice(4.00);
        item.setImage("/com/example/coffeeshop/images/apple-juice.png");
        items.add(item);
        
        item = new Item();
        item.setName("Lemonade");
        item.setPrice(4.00);
        item.setImage("/com/example/coffeeshop/images/lemonade.png");
        items.add(item);
        
        item = new Item();
        item.setName("Sparkling Water");
        item.setPrice(2.50);
        item.setImage("/com/example/coffeeshop/images/sparkling-water.png");
        items.add(item);

        return items;
    }
    
    public void setChosenItem(Item item){
        checkboxVBox.getChildren().clear();
        itemNameLabel.setText(item.getName());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        itemPriceLabel.setText(formatter.format(item.getPrice()));
        image = new Image(getClass().getResourceAsStream(item.getImage()));
        itemImg.setImage(image);
        
        if(item.getName() == "Bagel"){
            checkboxVBox.getChildren().add(everythingCB);
            checkboxVBox.getChildren().add(plainCB);
            checkboxVBox.getChildren().add(sesameCB);
            checkboxVBox.getChildren().add(cinnamonRaisinCB);
            checkboxVBox.getChildren().add(creamCheeseCB);
            checkboxVBox.getChildren().add(baconCB);
            checkboxVBox.getChildren().add(butterCB);
            checkboxVBox.getChildren().add(jellyCB);
        }
        
        if(item.getName() == "Egg and Cheese Sandwich"){
            checkboxVBox.getChildren().add(baconCB);
            checkboxVBox.getChildren().add(substituteCheddarCheeseCB);
            checkboxVBox.getChildren().add(substituteEggWhitesCB);
            checkboxVBox.getChildren().add(noCheeseCB);
        }
        
        if(item.getName() == "Donut"){
            checkboxVBox.getChildren().add(plainGlazedCB);
            checkboxVBox.getChildren().add(chocolateGlazedCB);
            checkboxVBox.getChildren().add(rainbowSprinkleCB);
            checkboxVBox.getChildren().add(maplePecanCB);
            checkboxVBox.getChildren().add(fruityPebblesCB);
        }
        
        if(item.getName() == "Scone"){
            checkboxVBox.getChildren().add(blueberryCB);
            checkboxVBox.getChildren().add(chocolateChipCB);
            checkboxVBox.getChildren().add(maplePecanCB);
        }
        
        if(item.getName() == "Cappuccino" || item.getName() == "Espresso" || item.getName() == "Latte" || item.getName() == "Chai Tea Latte"
        || item.getName() == "Matcha Tea Latte" || item.getName() == "Iced Coffee" || item.getName() == "Iced Latte"
        || item.getName() == "Cold Brew" || item.getName() == "Iced Chai Tea Latte" || item.getName() == "Iced Matcha Tea Latte"){
            checkboxVBox.getChildren().add(nonFatMilkCB);
            checkboxVBox.getChildren().add(twoPercentMilkCB);
            checkboxVBox.getChildren().add(wholeMilkCB);
            checkboxVBox.getChildren().add(almondMilkCB);
            checkboxVBox.getChildren().add(coconutMilkCB);
            checkboxVBox.getChildren().add(oatMilkCB);
            checkboxVBox.getChildren().add(soyMilkCB);
            checkboxVBox.getChildren().add(sugarCB);
            checkboxVBox.getChildren().add(honeyCB);
            checkboxVBox.getChildren().add(splendaCB);
            checkboxVBox.getChildren().add(shotOfEspressoCB);
        }
        
        if(item.getName() == "Earl Grey Tea"){
            checkboxVBox.getChildren().add(sugarCB);
            checkboxVBox.getChildren().add(honeyCB);
            checkboxVBox.getChildren().add(splendaCB);
            checkboxVBox.getChildren().add(lemonadeCB);
        }
        
        if(item.getName() == "Hot Chocolate"){
            checkboxVBox.getChildren().add(nonFatMilkCB);
            checkboxVBox.getChildren().add(twoPercentMilkCB);
            checkboxVBox.getChildren().add(wholeMilkCB);
            checkboxVBox.getChildren().add(almondMilkCB);
            checkboxVBox.getChildren().add(coconutMilkCB);
            checkboxVBox.getChildren().add(oatMilkCB);
            checkboxVBox.getChildren().add(soyMilkCB);
            checkboxVBox.getChildren().add(noWhippedCreamCB);
        }
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        itemTableColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));
        quantityTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
        customizationsTableColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("customizations"));
        
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10);
        valueFactory.setValue(1);
        itemCountSpinner.setValueFactory(valueFactory);
        
        items.addAll(getInfo());
        if(!items.isEmpty()){
            setChosenItem(items.get(0));
            itemListener = new ItemListener(){
                @Override
                public void onClickListener(Item item){
                    setChosenItem(item);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for(int i=0;i<items.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/coffeeshop/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setInfo(items.get(i),itemListener);
                
                if (column == 4) {
                    column = 0;
                    row++;
                }
                
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                //grid.setMinWidth(700);
                //grid.setPrefWidth(700);
                //grid.setMaxWidth(700);

                //set grid height
                //grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                //grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                //grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
    }

}
