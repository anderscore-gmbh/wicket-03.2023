package net.gfu.wicket.cheesr.webapp.pages;

import net.gfu.wicket.backend.bo.Cart;
import net.gfu.wicket.cheesr.webapp.CheesrSession;
import net.gfu.wicket.cheesr.webapp.components.ShoppingCartPanel;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class CheesrPage extends WebPage {
    private static final long serialVersionUID = 1L;

    ShoppingCartPanel shoppingCartPanel;

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(new CssResourceReference(Index.class, "../assets/bootstrap.min.css")));
        response.render(CssHeaderItem.forReference(new CssResourceReference(Index.class, "../assets/bootstrap-theme.min.css")));
        response.render(CssHeaderItem.forReference(new CssResourceReference(Index.class, "../assets/style.css")));
        response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(Index.class, "../assets/jquery-3.3.1.slim.min.js")));
        response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(Index.class, "../assets/bootstrap.min.js")));
        response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(Index.class, "../assets/popper.min.js")));
    }

    public CheesrPage() {
        add(shoppingCartPanel = new ShoppingCartPanel("cart", getCartModel()));
    }

    public ShoppingCartPanel getShoppingCartPanel() {
        return shoppingCartPanel;
    }

    public Cart getCart() {
        return ((CheesrSession) getSession()).getCart();
    }

    public Model<Cart> getCartModel() {
        return new Model<Cart>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Cart getObject() {
                return getCart();
            }
        };
    }
}
