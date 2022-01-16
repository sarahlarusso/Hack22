package general;

import test.MasterTest;

import java.io.IOException;

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

	}
}

