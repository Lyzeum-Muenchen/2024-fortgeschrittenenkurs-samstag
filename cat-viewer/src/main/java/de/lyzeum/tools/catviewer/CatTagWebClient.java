package de.lyzeum.tools.catviewer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CatTagWebClient {

	// 3.) 100 zufällige Radiobuttons anzeigen
	private final String url = "https://cataas.com/api/tags";

	public CatTagWebClient() {

	}

	public List<String> fetchTags() {
		// 1.) Http-Request
		HttpClient httpClient = HttpClient.newHttpClient();
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI(url))
					.GET().build();
			HttpResponse<String> response = httpClient
					.send(
							request,
							HttpResponse.BodyHandlers.ofString()
					);
			// 2.) JSON-Antwort --> List<String> Umwandeln
			System.out.println("Statuscode: " + response.statusCode());
			System.out.println("Body: " + response.body());
			httpClient.close(); // schliesse Verbindung zu Server

			ObjectMapper objectMapper = new ObjectMapper();
			// Wandel JSON in ein String-Array um
			var tags = objectMapper.readValue(response.body(), String[].class);
			return Arrays.asList(tags);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
