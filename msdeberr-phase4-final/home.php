<!DOCTYPE html>
<html>
<head>
    <meta name="charset" content="UTF-8"/>
    <title> Iconic Nail Salon </title>
    <link rel="stylesheet" type="text/css" href="cssfiles/styles.css"/>
</head>
<body>
     
    
<div id="wrapper">
    <header>
        <h1>Iconic Nail Salon</h1>
        <h2>Relax. You Deserve it.</h2>
    </header>
    <nav>
        <ul class="main_menu">
            <li><a href="home.php">Home</a></li>
            <li><a href="services.html">Services</a></li>
            <li><a href="directions.html">Directions</a></li>
            <li><a href="aboutus.html">About Us</a></li>
            <li><a href="contact.php">Contact Us</a></li>
        </ul>
    </nav>
</div>
<div id="nameheader">
    <h1> Welcome To Iconic Nail Salon! </h1>

    <img id="homephotos" height="600" src="img/nail1.jpg"
 alt="" width="800" />
    
</div>

<div id="arraystyle">
<script type="text/javascript">
    var i = 0,
        path = new Array();
    path[0] = "img/nail1.jpg";
    path[1] = "img/nail2.jpg";
    path[2] = "img/nail3.jpg";

    function swapImage()
    {
        document.getElementById("homephotos").src = path[i];

        if(i < path.length - 1)
            i++;
        else
            i = 0;

        setTimeout("swapImage()",3000);
    }

    window.onload=swapImage;
</script>
</div>




<footer>
       
        <ul class="footer_menu">
            <li><a href="home.php">Home</a></li>
            <li><a href="services.html">Services</a></li>
            <li><a href="directions.html">Directions</a></li>
            <li><a href="aboutus.html">About Us</a></li>
            <li><a href="contact.php">Contact Us</a></li>

        </ul>

        </footer>
</body>
</html>