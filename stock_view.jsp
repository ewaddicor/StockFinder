<jsp:useBean id="stock" class="StockQuote" scope="request" />

<html>
	<body>

		<table>
			<tr><th>Current Price:</th><td><jsp:getProperty name="stock" property="currentPrice" /></td></tr>
			<tr><th>Price Change:</th><td><jsp:getProperty name="stock" property="priceChange" /></td></tr>
			<tr><th>High:</th><td><jsp:getProperty name="stock" property="high" /></td></tr>
			<tr><th>Low:</th><td><jsp:getProperty name="stock" property="low" /></td></tr>
		</table>
	
		<form action="index.html" method="GET">
			<input type="submit" name="submit" value="Back">
		</form>
		
	</body>
</html>