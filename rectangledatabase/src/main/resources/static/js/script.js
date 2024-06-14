const rectangle = document.getElementById("rectangle_object");

const color_picker = document.getElementById("color-picker");

//On colorpicker change, change display rectangle
color_picker.addEventListener("change", function(ev){
    rectangle.style.backgroundColor = color_picker.value;
})

//on height change. change height of display rectangle
document.getElementById("height").addEventListener("change", function(){
    rectangle.style.height = document.getElementById("height").value +'px';
})

//on weight change change width of rectangle
document.getElementById("weight").addEventListener("change", function(){
    rectangle.style.width = document.getElementById("weight").value + 'px';
})

document.getElementById("pattern").addEventListener("change", function(){
    var cur_pattern = document.getElementById("pattern").value;
    var patterns = rectangle.classList;

    //if there are no existing classes or the none pattern class, add the new pattern
    if (rectangle.classList.contains('None') || rectangle.classList.length==0){
        rectangle.classList.remove('None')
        rectangle.className += cur_pattern;
    }
    //if already contains a pattern, remove the existing pattern and replace it with the new selection
    else{
        patterns.forEach((pattern) => {
            switch(pattern){
                case "Striped":
                    patterns.remove("Striped");
                    break;
                case "Dotted":
                    patterns.remove("Dotted")
                    break;
                case "Triangles":
                    patterns.remove("Triangles")
                    break;
                case "Checkered":
                    patterns.remove("Checkered")
                    break;
            }
        })
        patterns.add(cur_pattern)
    }  
})