package controllers;

import model.Forecast;
import play.libs.F.Promise;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	public Result index() {
		return ok("my index");
	}

	public Promise<Result> getForecast(String city, String state) {
		Forecast forecast = new Forecast();

		Promise<WSResponse> wsResponse = forecast.getForecast(city, state);

		return wsResponse.map(response -> ok(response.asJson()));
	}

}
