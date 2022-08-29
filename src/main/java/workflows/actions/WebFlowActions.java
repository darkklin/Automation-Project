package workflows.actions;

import workflows.WebFlows;

import java.util.function.Consumer;

import static workflows.WebFlows.*;

public class WebFlowActions {


    public static final Consumer<WebFlows> invalidCCV = (p) -> fillcreditCard("text231","4111111111","2023","123");
    public static final Consumer<WebFlows> invaliDate = (p) -> fillcreditCard("textdasdad","4111111111111111","2022","123");
    public static final Consumer<WebFlows> invaliCode = (p) -> fillcreditCard("textddddddddd","4111111111111111","2023","");
    public static final Consumer<WebFlows> invaliCardHolderName= (p) -> fillcreditCard("","4111111111111111","2023","123");

    public static final Consumer<WebFlows> clickSave = (p) -> savePayMentInfo();
    public static final Consumer<WebFlows>  cardNmError= (p) -> getError("Wrong card number");
    public static final Consumer<WebFlows>  cardDateError= (p) -> getError("Card is expired");
    public static final Consumer<WebFlows>  cardCodeError= (p) -> getError("Wrong card code");
    public static final Consumer<WebFlows>  cardHolderError= (p) -> getError("Enter cardholder name");



}
