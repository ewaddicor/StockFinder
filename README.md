# README
This is a Java Servlet Application which looks up stock information and displays it on a website. 

To run this application you need to install Apache Tomcat v8.0, see instructions on how to do so here: https://www.youtube.com/watch?v=ZpMmpEAGPaQ

This application provides the user the ability to search information about a specific stock. It is comprised of the following files:

index.html - Outlines the website for the user. Allows the user to input a stock symbol and displays information about the stock upon request.
StockQuoteServlet.java - Establishes the Java Servlet connection and handles the GET requests sent from the form in index.html. Passes on stock information to stock_view.jsp
StockQuote.java - Responsible for establishing a connection to AlphaVantage to lookup stock information and stores it in a StockQuote object.
stock_view.jsp - Passes on the dynamic stock data to the index.html file.
web.xml - Contains Java Servlet configuration properties.
