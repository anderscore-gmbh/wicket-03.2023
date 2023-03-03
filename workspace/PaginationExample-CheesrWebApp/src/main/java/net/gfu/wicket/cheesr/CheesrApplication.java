package net.gfu.wicket.cheesr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import net.gfu.wicket.cheesr.bo.Cheese;
import net.gfu.wicket.cheesr.pages.Index;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see net.gfu.wicket.cheesr.Start#main(String[])
 */
public class CheesrApplication extends WebApplication {
	
	private final List<Cheese> cheeses = Arrays.asList(
			new Cheese("Gouda", "Gouda is a yellowish Dutch[...]",
			 1.65),
			new Cheese("Edam", "Edam (Dutch Edammer) is a D[...]",
			 1.05),
			new Cheese("Maasdam", "Maasdam cheese is a Dutc[...]",
			 2.35),
			new Cheese("Brie", "Brie is a soft cows' milk c[...]",
			 3.15),
			new Cheese("Buxton Blue", "Buxton Blue cheese i[...]",
			 0.99),
			new Cheese("Parmesan", "Parmesan is a grana, a [...]",
			 1.99),
			new Cheese("Cheddar", "Cheddar cheese is a hard[...]",
			 2.95),
			new Cheese("Roquefort", "Roquefort is a ewe's-m[...]",
			 1.67),
			new Cheese("Boursin", "Boursin Cheese is a soft[...]",
			 1.33),
			new Cheese("Camembert", "Camembert is a soft, c[...]",
			 1.69),
			new Cheese("Emmental", "Emmental is a yellow, m[...]",
			 2.39),
			new Cheese("Reblochon", "Reblochon is a French [...]",
			 2.99));

	

	@Override
	public Class<? extends WebPage> getHomePage() {
		return Index.class;
	}

	public static CheesrApplication get() {
		return (CheesrApplication) Application.get();
	}
	
	public List<Cheese> getCheeses() {
		return Collections.unmodifiableList(cheeses);
	}
	
	@Override
	public Session newSession(Request request, Response response) {
		return new CheesrSession(request);
	}


	@Override
	public void init()
	{
		super.init();

		// add your configuration here
	}
}