package net.gfu.wicket.cheesr.webapp.pages;

import net.gfu.wicket.cheesr.webapp.components.CheckoutFormPanel;
import net.gfu.wicket.cheesr.webapp.components.ShoppingCartPanel;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class Checkout extends CheesrPage {

	private static final long serialVersionUID = 1L;

	public Checkout() {
		add(new FeedbackPanel("feedback"));
//		Form<Address> form = new Form<>("form");
//		add(form);
//		Address address = getCart().getBillingAddress();
//		form.add(new TextField<>("name", new PropertyModel<String>(address, "name")).setRequired(true));
//		form.add(new TextField<>("street", new PropertyModel<String>(address, "street")).setRequired(true));
//		form.add(new TextField<>("zipcode", new PropertyModel<String>(address, "zipcode")).setRequired(true));
//		form.add(new TextField<>("city", new PropertyModel<String>(address, "city")).setRequired(true));
//
//		form.add(new Link<Void>("cancel") {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void onClick() {
//				setResponsePage(Index.class);
//			}
//		});
//		form.add(new Button("order") {
//			@Override
//			public void onSubmit() {
//				BOServices.get().proccessOrder(getCart());
//				Cart cart = getCart();
//				cart.getCheeses().clear();
//				setResponsePage(Index.class);
//			}
//		});
		add(new CheckoutFormPanel("checkout"));
		add(new ShoppingCartPanel("cart",getCartModel()));
	}
}