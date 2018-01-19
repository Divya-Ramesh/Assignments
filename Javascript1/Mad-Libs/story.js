var name = prompt('Please enter your name');
var word1 = prompt('Please give a noun');
var word2 = prompt('Please give an adjective');
var word3 = prompt('Please give a place');
var word4 = prompt('Please give a food');
var word5 = prompt('Please give an adjective');
var color = prompt('Please give a color');


var sentence = "<br><h2>Green Eggs And Ham</h2><br><h3>You do not like green eggs and ham? <div  style=\"display:inline;background:"+color+"\" >"+word1+"</div>";
sentence+=" I  not like<div  style=\"display:inline; background:"+color+"\" >"+word1+"</div>";
sentence+=" ,  Sam-I-am. <div  style=\"display:inline; background:"+color+"\" >"+word1+"</div>";
sentence+="Could you, would you, with a<div  style=\"display:inline;background:"+color+"\" >"+word1+"</div>";
sentence+=" I would not, could not, with a goat!Would<div  style=\"display:inline;background:"+color+"\" >"+word1+"</div>";
document.write(sentence);