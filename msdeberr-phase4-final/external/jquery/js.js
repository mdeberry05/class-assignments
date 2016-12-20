
$(function(){

    var firstnames = [
      "Ashley",
      "Ashton",
      "Josh",
      "Jamie",
      "Judy",
      "Bethany",
      "Chad",
      "Crystal",
      "Don",
      "Donnie",
      "Bobbie",
      "Eric",
      "Michael",
      "Mikey",
      "Matthew",
      "Lida",
      "Nasheen",
      "Brad",
      "Hannah",
      "Chris",
      "Sean",
      "Tasha"
    ];
    $( "#pickdate" ).datepicker(); //Call the date pucker function
    $( "#firstnames" ).autocomplete({
      source: firstnames
    });

});












