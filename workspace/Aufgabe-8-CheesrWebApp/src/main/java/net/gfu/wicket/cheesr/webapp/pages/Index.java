package net.gfu.wicket.cheesr.webapp.pages;

import net.gfu.wicket.backend.bo.Cheese;
import net.gfu.wicket.cheesr.webapp.CheeseListModel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;


public class Index extends CheesrPage {
	private static final long serialVersionUID = 1L;
	
	public Index() {
		super();
		CheeseListModel m = new CheeseListModel();
		
		add(new ListView<Cheese>("cheeses", m) {
			private static final long serialVersionUID = 1L;
			@Override
			protected void populateItem(ListItem<Cheese> item) {
				Cheese cheese = item.getModelObject();
				item.add(new Label("name",cheese.getName()));
				item.add(new Label("description",cheese.getDescription()));
				item.add(new Label("price","$ " + cheese.getPrice()));
				item.add(new Link<Cheese>("add",item.getModel()){
					private static final long serialVersionUID = 1L;
					@Override
					public void onClick() {
						Cheese selected = getModelObject();
						getCart().getCheeses().add(selected);
					}
					
				});
			}
		});
		
//		add(new Link<String>("checkout"){
//			private static final long serialVersionUID = 1L;
//			@Override
//
//			public void onClick() {
//				setResponsePage(new Checkout());
//
//			}
//			@Override
//			public boolean isVisible() {
//				return !getCart().getCheeses().isEmpty();
//			}
//		});

//		add(new ShoppingCartPanel("cart",getCartModel()));
	}
}