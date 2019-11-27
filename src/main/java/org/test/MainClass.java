package org.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.userInterface.UserInterface;

public class MainClass {

	public static void main(String[] args) {
		UserInterface userInterface;

		/* Singleton 객체인 UserInterface 객체 가져옴 */
		userInterface = UserInterface.getUserInterface();

		/* 시작! */
		userInterface.run();

	}
}
