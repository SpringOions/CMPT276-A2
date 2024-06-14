var display_rectangle = document.getElementById("rectangle_object");
console.log("wa")

var height = document.getElementById("height").textContent;
var width = document.getElementById("width").textContent;
var color = document.getElementById("color").textContent;
var pattern = document.getElementById("pattern").textContent;

console.log(height);
console.log(width);
console.log(color);
console.log(pattern);

display_rectangle.classList.add(pattern);
display_rectangle.style.width = width + 'px';
display_rectangle.style.height = height + 'px';
display_rectangle.style.backgroundColor = color;
