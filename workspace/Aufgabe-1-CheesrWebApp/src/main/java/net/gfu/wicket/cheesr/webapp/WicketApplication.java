package net.gfu.wicket.cheesr.webapp;

import net.gfu.wicket.cheesr.webapp.pages.Checkout;
import net.gfu.wicket.cheesr.webapp.pages.Index;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see net.gfu.wicket.cheesr.webapp.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return Index.class;
	}

	@Override
	public void init() {
		super.init();

		mountPage("/checkout", Checkout.class);
		// getCspSettings().blocking().disabled();
		// add your configuration here
	}
}
