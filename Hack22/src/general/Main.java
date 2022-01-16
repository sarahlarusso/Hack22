package general;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import test.MasterTest;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Created a website to output recommended community service opportunities
// to high school students based upon their interests. Organizations can
// add themselves to the site, give a description, and add tags of what
// it is they do (Cooking, Tutoring, Engineering, Outdoors, etc).
// Then these tags are compared to the student's interests, and they can
// hit add to join an organization

// Created by WPI students:
// Tony Vuolo, Deepti Gosukonda, Phillip Brush, Cole Ouellette, and Sarah LaRusso
// for Hack@WPI 2022 Competition

public class Main {
	public static void main(String[] args) throws IOException {
		//Testing
		MasterTest.runTests();

		// Parsing Files
		Controller.initialize();

		HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);

		String path = System.getProperty("user.dir");
		String pathToRoot = (path.endsWith("\\") ? path : path + "\\") + "Hack22\\src\\frontend\\";
		System.out.println(pathToRoot);

		File base = new File(pathToRoot);
		if (! base.exists() || ! base.isDirectory()) {
			throw new IllegalStateException("Couldn't find webroot: "+pathToRoot);
		}
		httpServer.createContext("/", ex -> handle(pathToRoot, ex));
		httpServer.createContext("/profile/", ex -> handleProfile(pathToRoot, ex));
		httpServer.createContext("/orgRecs/", ex -> handleCategories(pathToRoot, ex));
		//int port = Integer.parseInt(args[1]);

		httpServer.setExecutor(null); // creates a default executor
		httpServer.start();
	}

	public static void handle(String pathToRoot, HttpExchange httpExchange) throws IOException {
		String path = httpExchange.getRequestURI().getPath();
		try {
			path = path.substring(1);
			path = path.replaceAll("//", "/");
			if (path.length() == 0)
				path = "index.html";

			File file = new File(pathToRoot + path);
			InputStream in = new FileInputStream(file);
			if (in == null) {
				String toAsset = pathToRoot + path + ".html";
				file = new File(toAsset);
			}

			if (path.endsWith(".js"))
				httpExchange.getResponseHeaders().set("Content-Type", "text/javascript");
			else if (path.endsWith(".html"))
				httpExchange.getResponseHeaders().set("Content-Type", "text/html");
			else if (path.endsWith(".css"))
				httpExchange.getResponseHeaders().set("Content-Type", "text/css");
			else if (path.endsWith(".json"))
				httpExchange.getResponseHeaders().set("Content-Type", "application/json");
			else if (path.endsWith(".svg"))
				httpExchange.getResponseHeaders().set("Content-Type", "image/svg+xml");
			if (httpExchange.getRequestMethod().equals("HEAD")) {
				httpExchange.getResponseHeaders().set("Content-Length", "" + file.length());
				httpExchange.sendResponseHeaders(200, -1);
				return;
			}

			httpExchange.sendResponseHeaders(200, file.length());
			OutputStream body = httpExchange.getResponseBody();
			byte[] tmp = new byte[4096];
			int r;
			while ((r=in.read(tmp)) >= 0)
				body.write(tmp, 0, r);
			body.flush();
			body.close();
		} catch (FileNotFoundException t) {
			System.err.println("Error retrieving: " + path);
			t.printStackTrace();
			httpExchange.sendResponseHeaders(404, 0);
			httpExchange.getResponseBody().close();
		} catch (Throwable t) {
			System.err.println("Error retrieving: " + path);
			t.printStackTrace();
		}
	}

	public static void handleProfile(String pathToRoot, HttpExchange httpExchange) throws IOException {
		InputStream inputStream = httpExchange.getRequestBody();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = reader.lines().collect(Collectors.joining("\n"));
		String[] ar = line.split("&");

		File file = new File(pathToRoot + "username.txt");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(ar[0].substring(6));
		fileWriter.close();

		final String response = "<meta http-equiv=\"Refresh\" content=\"0; url='/profile.html'\" />\n";
		httpExchange.getResponseHeaders().set("Content-Type", "text/html");
		httpExchange.sendResponseHeaders(200, response.length());
		OutputStream outputStream = httpExchange.getResponseBody();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		writer.write(response);
		writer.flush();
		writer.close();
	}

	public static void handleCategories(String pathToRoot, HttpExchange httpExchange) throws IOException {
		System.out.println("guakamole");

		InputStream inputStream = httpExchange.getRequestBody();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = reader.lines().collect(Collectors.joining("\n"));
		System.out.println(line);

		final String response = "<meta http-equiv=\"Refresh\" content=\"0; url='/orgRecs.html'\" />\n";
		httpExchange.getResponseHeaders().set("Content-Type", "text/html");
		httpExchange.sendResponseHeaders(200, response.length());
		OutputStream outputStream = httpExchange.getResponseBody();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		writer.write(response);
		writer.flush();
		writer.close();
	}
}

