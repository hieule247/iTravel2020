
//var pwd2 = $('#pwd2');

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("RegisterServlet",
        {cmdType: $cmdType},
        function () {alert("data loaded...!");});
}
function updateStep(step){
	if(step == 'step3'){
		var ha = validateStep2();
		if(ha == false){
			return false;
		}
	}else if(step == 'submit'){
	    var va = checkForm();
        console.log(va)
	    if(va==false){

	        return false;
        }
    }

	$('.step_panel').hide();
	
	$('.'+step).show();

	
}

function validateStep2(){
	var state = $('#state');
    var city = $('#city');
    var zipCode = $('#zip');
    var street = $('#street');

	if(state.val()==''||city.val()==''||zipCode.val()==''||street.val() == ''){
		alert('Please input all your information');
		return false;
	}
	return true;
}


function checkPassword(str) {
    var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
    return re.test(str);
}

function checkForm() {
    const name = $('#fname');
    const email = $('#email');
    const email1 = $('#email1');
    const pwd1 = $('#pwd1');
    if(name.val() == "") {
      alert("Error: Username cannot be blank!");
      name.focus();
      return false;
    }
    // re = /^\w+$/;
    // if(!re.test(form.name.value)) {
    //   alert("Error: Username must contain only letters, numbers and underscores!");
    //   form.name.focus();
    //   return false;

    
 
    const x=email.val();
    const y=email1.val();
    const atposition=x.indexOf("@");
    const dotposition=x.lastIndexOf(".");
    if (x!=y||x==""||y==""||atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){

    alert("Please enter a valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);  
    email.focus();
    return false;  
    }  

    if(pwd1.val() != "" && pwd1.val() == pwd2.val()) {
      if(!checkPassword(pwd1.val())) {
        alert("The password you have entered is not valid! password must include 6 characters, at least 1 number, 1 uper/lower character");
        pwd1.focus();
        return false;
      }
    } else {
      alert("Error: Please check that you've entered and confirmed your password!");
      pwd1.focus();
      return false;
    }
	// var gender = document.getElementsByName("optradio");
    //     var genValue = false;
    //
    //     for(var i=0; i<gender.length;i++){
    //         if(gender[i].checked == true){
    //             genValue = true;
    //         }
    //     }
    //     if(!genValue){
    //         alert("Please Choose the gender");
    //         return false;
    //     }
    return true;
}
function chooseFile() {
      $("#fileInput").click();
}

	
	

	
