package model;

import play.libs.F.Promise;
import play.libs.ws.WS;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

public class Forecast {

	public Promise<WSResponse> getForecast(String city, String state) {

		WSRequest req = WS
				.url("https://query.yahooapis.com/v1/public/yql")
				.setQueryParameter(
						"q",
						"select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\""
								+ city + ", " + state + "\")")
				.setQueryParameter("format", "json");
		return req.get();
	}

}
