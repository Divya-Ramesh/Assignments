//Initialize the required data,called on body load
function initialize(){ 
	disp = document.getElementById("display");
	number = document.getElementById("number");
	detail = document.getElementById("detail");
	isChecked = document.getElementById("numberAccept");
	table = document.getElementById("details");
	checkAcceptNumber();
}

//Checks if check box is checked
function checkAcceptNumber(){
	if(isChecked.checked == true){
		number.style.visibility = 'visible';
		detail.style.display="none"; 
		display.innerHTML = "";
	}
	else{
		number.style.visibility = 'hidden'; 
		detail.style.display = "block";
		display.innerHTML = "";
	}
}

//Analyze the number entered and display appropriate message
function analyzeNumber(){
	input = document.getElementById("text").value;
	if (input>0 && input<1000){
		if (input<50)
			disp.innerHTML = "Number is lesser than 50";
		else if (input>50 && input<100)
			disp.innerHTML = "Number is greater than 50 and lesser than 100";
		else
			disp.innerHTML = "Number is greater than 100";
	}
	else
		disp.innerHTML = "Invalid input";
}

//Display user details
function displayDetails(){
	userName = document.getElementById("text1").value;
	var row = table.insertRow(1);
	var name = row.insertCell(0);
	var gender = row.insertCell(1);
	var details = row.insertCell(2);
	name.innerHTML = userName;
	if(document.getElementById("female").checked == true){
		details.innerHTML = "Ms."+userName;
		gender.innerHTML = "Female";
	}
	else{
		details.innerHTML = "Mr."+userName;
		gender.innerHTML = "Male";
	}
}