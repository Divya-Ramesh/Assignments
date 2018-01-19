var close = document.getElementsByClassName("close");
var i;
for (i = 0; i < close.length; i++) {
  close[i].onclick = function() {
    var div = this.parentElement;
    div.style.display = "none";
  }
}
var list = document.querySelector('ul');
list.addEventListener('click', function(ev) {
  if (ev.target.tagName === 'LI') {
    ev.target.classList.toggle('checked');
  }
}, false);
function newElement() {
  var li = document.createElement("li");
  var inputValue = document.getElementById("myInput").value;
  var t = document.createTextNode(inputValue);
  li.appendChild(t);
  if (inputValue === '') {
    alert("You must write something!");
  } else {
    document.getElementById("myUL").appendChild(li);
  }
  document.getElementById("myInput").value = "";
  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.onclick = function(){
      var div = this.parentElement;
      div.style.display = "none";
  };
  span.appendChild(txt);
  li.appendChild(span);
}
function newElement_2(inputValue) {
  var li = document.createElement("li");
  
  var t = document.createTextNode(inputValue);
  li.appendChild(t);
    document.getElementById("myUL").appendChild(li);
  
  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.onclick = function(){
      var div = this.parentElement;
      div.style.display = "none";
  };
  span.appendChild(txt);
  li.appendChild(span);
}
function setTime(){
  var time = document.getElementById("time").value;
  var hrs = time.substr(0,2);
  var mins = time.substr(3,2);
  var date = new Date();
  date.setHours(hrs, mins, 0);
  var now = new Date(); 
  const wait = time => new Promise((resolve) => setTimeout(resolve, time));
  wait(Math.abs(date - now)).then(() => {
  
    var dat = new Date();
    console.log(dat);
    newElement_2("Walking");
    newElement_2("Jogging");
    newElement_2("Exercise");
}); 
}