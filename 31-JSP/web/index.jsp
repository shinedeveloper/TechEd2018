<%@page contentType="text/html;charset=UTF-8" language="java"
%><!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Funny Quotes</title>
    <meta charset="UTF-8"/>
</head>
<body>
    <h1>Funny Quotes</h1>

    <%
        String[] quotes = {
            "If life gives you lemons, you should make lemonade... If you find somebody whom life has given vodka, have a party.",
            "I feel sorry for people who don't drink. When they wake up in the morning, that's as good as they're going to feel all day.",
            "I always wanted to be somebody, but now I realize I should have been more specific.",
            "A lot of people are afraid of heights. Not me, I'm afraid of widths.",
            "All right everyone, line up alphabetically according to your height.",
            "My fake plants died because I did not pretend to water them."
        };
        int index = (int) (Math.random() * quotes.length);
        out.println(quotes[index]);
    %>

</body>
</html>
