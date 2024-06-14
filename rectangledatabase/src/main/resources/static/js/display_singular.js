
var display_rectangle = document.getElementById("rectangle_object");

    var height = document.getElementById("height").textContent;
    var width = document.getElementById("weight").textContent;
    var color = document.getElementById("color-picker").textContent;
    var pattern = document.getElementById("pattern").textContent;
    
    display_rectangle.style.width = width + 'px';
    display_rectangle.style.height = height + 'px';
    display_rectangle.style.color = color;
    display_rectangle.classList.add(pattern);

