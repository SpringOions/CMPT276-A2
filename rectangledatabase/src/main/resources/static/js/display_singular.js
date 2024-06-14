
var display_rectangle = document.getElementById("rectangle_object");

var height = document.getElementById("height").value;
var width = document.getElementById("weight").value;
var color = document.getElementById("color-picker").value;
var pattern = document.getElementById("pattern").value;

display_rectangle.style.width = width + 'px';
display_rectangle.style.height = height + 'px';
display_rectangle.style.backgroundColor = color;
display_rectangle.classList.add(pattern);

