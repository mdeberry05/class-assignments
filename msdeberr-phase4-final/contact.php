<?PHP
if($_POST && isset($_POST['sendfeedback'], $_POST['firstName'], $_POST['lastName'], $_POST['email'], $_POST['phoneNumber'], $_POST['datepicker'])) {

    $firstName = $_POST['firstName'];
    $lastName = $_POST['lastName'];
    $email = $_POST['email'];
    $phoneNumber = $_POST['phoneNumber'];
    $date = $_POST['datepicker'];

    if(!$firstName) {
        $errorMsg = "Please enter your First Name";
    } if(!$firstName) {
        $errorMsg = "Please enter your Last Name";
    } elseif(!$email || !preg_match("/^\S+@\S+$/", $email)) {
        $errorMsg = "Please enter a valid Email address";
    } elseif(!$phoneNumber) {
        $errorMsg = "Please enter a valid phone number";
    } else {
        print "First Name: <b>" . $firstName . "</b><br>Last Name: <b>" . $lastName . "</b><br>Email: <b>" . $email ."</b><br>Date: <b>". $date ."</b><br>Phone Number: <b>" . $phoneNumber . "</b>";

        exit;
    }

    print $errorMsg;
}
?>

<!DOCTYPE html>

<html>

<head>
    <meta name="charset" content="UTF-8">
    <title> Iconic Nail Salon </title>
    <link rel="stylesheet" type="text/css" href="cssfiles/contact.css">
    <link rel="stylesheet" type="text/css" href="external/jquery/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="external/jquery/jquery-ui.css">
    <script type="text/javascript" src="external/jquery/jquery.js"></script>
    <script type="text/javascript" src="external/jquery/jquery-ui.js"></script>
    <script type="text/javascript" src="external/jquery/js.js"></script>  
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

    <form method="POST" action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" accept-charset="UTF-8">
        <h2>Make an Appointment</h2>
        <h4>We Will Contact You Soon!</h4>

        <div>

            <h5>First Name</h5>
            <input type="text"  id="firstnames" name="firstName"  placeholder="Enter First Name"value="<?php if(isset($_POST['firstName'])) echo htmlspecialchars($_POST['firstName']); ?>">
        </div>
        <div>
            <h5>Last Name</h5>
            <input type="text" name="lastName" placeholder="Enter Last Name" value="<?php if(isset($_POST['lastName'])) echo htmlspecialchars($_POST['lastName']); ?>">
        </div>
        <div>
            <h5>Email Address</h5>
            <input type="email" name="email" placeholder="Enter Valid Email" value="<?php if(isset($_POST['email'])) echo htmlspecialchars($_POST['email']); ?>">
        </div>


        <div>
        <h5>Date:</h5>
            <input type="text" name="datepicker"  id="pickdate" placeholder="Pick a Date" value="<?php if(isset($_POST['date'])) echo htmlspecialchars($_POST['date']); ?>">
        </div>


        <div>
            <h5>Phone Number</h5>
            <input type="number" name="phoneNumber" placeholder="555-555-5555" value="<?php if(isset($_POST['phoneNumber'])) echo htmlspecialchars($_POST['phoneNumber']); ?>">


        </div>

        <button type="submit" onclick="return confirm('Are you sure?')" name="sendfeedback" >Submit</button>
        <button type="reset" value="Reset">Reset</button>

            
    </form>

    <?PHP
    if(isset($errorMsg) && $errorMsg) {
        echo "<p style=\"color: red;\">*",htmlspecialchars($errorMsg),"</p>\n\n";
    }
    ?>

    
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