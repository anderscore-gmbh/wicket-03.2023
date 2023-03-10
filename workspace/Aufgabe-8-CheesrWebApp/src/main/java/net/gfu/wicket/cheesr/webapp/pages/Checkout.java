package net.gfu.wicket.cheesr.webapp.pages;

import net.gfu.wicket.backend.BOServices;
import net.gfu.wicket.backend.bo.Address;
import net.gfu.wicket.backend.bo.Cart;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

public class Checkout extends CheesrPage {

    private static final long serialVersionUID = 1L;

    public Checkout() {
        add(new FeedbackPanel("feedback"));
        Form<Address> form = new Form<>("form");
        add(form);
        Address address = getCart().getBillingAddress();
        form.add(new TextField<>("name", new PropertyModel<String>(address, "name")).setRequired(true));
        form.add(new TextField<>("street", new PropertyModel<String>(address, "street")).setRequired(true));
        form.add(new TextField<>("zipcode", new PropertyModel<String>(address, "zipcode")).setRequired(true));
        form.add(new TextField<>("city", new PropertyModel<String>(address, "city")).setRequired(true));
        form.add(new Link<Void>("cancel") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }
        });
        form.add(new Button("order") {
            @Override
            public void onSubmit() {
                BOServices.get().proccessOrder(getCart());
                Cart cart = getCart();
                cart.getCheeses().clear();
                setResponsePage(Index.class);
            }
        });
//		add(new ShoppingCartPanel("cart",getCartModel()));
    }

//    @Override
//    protected void onInitialize() {
//        super.onInitialize();
//        // Checkout-Link soll auf der Checkout-Seite nicht angezeigt werden, da wir schon da sind.
//        getShoppingCartPanel().getCheckoutLink().add(AttributeAppender.append("class", "invisble"));
//    }

}