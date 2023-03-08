package net.gfu.wicket.cheesr.webapp.components;

import net.gfu.wicket.backend.BOServices;
import net.gfu.wicket.backend.bo.Address;
import net.gfu.wicket.backend.bo.Cart;
import net.gfu.wicket.cheesr.webapp.CheesrSession;
import net.gfu.wicket.cheesr.webapp.pages.Index;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public class CheckoutFormPanel extends Panel {

    public CheckoutFormPanel(String id) {
        super(id);

        Form<Address> form = new Form<>("form");
        add(form);
        Address address = ((CheesrSession) getSession()).getCart().getBillingAddress();
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
                Cart cart = ((CheesrSession) getSession()).getCart();
                BOServices.get().proccessOrder(cart);
                cart.getCheeses().clear();
                setResponsePage(Index.class);
            }
        });
    }
}