var username = document.forms["vform"]["username"];
var password = document.forms["vform"]["password"];
var firstName = document.forms["vform"]["firstName"];
var secondName = document.forms["vform"]["secondName"];
var email = document.forms["vform"]["email"];
var phoneNumber = document.forms["vform"]["phoneNumber"];

var username_error = document.getElementById("username_error");
var password_error = document.getElementById("password_error");
var firstName_error = document.getElementById("firstName_error");
var secondName_error = document.getElementById("secondName_error");
var email_error = document.getElementById("email_error");
var phoneNumber_error = document.getElementById("phoneNumber_error");

username.addEventListener("blur", usernameVerify, true);
password.addEventListener("blur", passwordVerify, true);
firstName.addEventListener("blur", firstNameVerify, true);
secondName.addEventListener("blur", secondNameVerify, true);
email.addEventListener("blur", emailVerify, true);
phoneNumber.addEventListener("blur", phoneNumberVerify, true);

function Validate() {
    if (username.value == "") {
        username.style.border = "2px solid red";
        document.getElementById('username_div').style.color = "red";
        username_error.textContent = "Username can not be empty";
        username.focus();
        return false;
    }

    if (password.value == "") {
        password.style.border = "2px solid red";
        document.getElementById('password_div').style.color = "red";
        password_error.textContent = "Password can not be empty";
        password.focus();
        return false;
    }

    if (!validatePassword(password.value)) {
        password.style.border = "2px solid red";
        document.getElementById('password_div').style.color = "red";
        password_error.textContent = "At least 8 characters (1 number, 1 character, 1 lowercase, 1 uppercase)";
        password.focus();
        return false;
    }

    if (firstName.value == "") {
        firstName.style.border = "2px solid red";
        document.getElementById('firstName_div').style.color = "red";
        firstName_error.textContent = "First name can not be empty";
        firstName.focus();
        return false;
    }

    if (secondName.value == "") {
        secondName.style.border = "2px solid red";
        document.getElementById('secondName_div').style.color = "red";
        secondName_error.textContent = "Second name can not be empty";
        secondName.focus();
        return false;
    }

    if (email.value == "") {
        email.style.border = "2px solid red";
        document.getElementById('email_div').style.color = "red";
        email_error.textContent = "Email can not be empty";
        email.focus();
        return false;
    }

    if (!validateEmail(email.value)) {
        email.style.border = "2px solid red";
        document.getElementById('email_div').style.color = "red";
        email_error.textContent = "Incorrect email";
        email.focus();
        return false;
    }

    if (phoneNumber.value == "") {
        phoneNumber.style.border = "2px solid red";
        document.getElementById('phoneNumber_div').style.color = "red";
        phoneNumber_error.textContent = "Phone number can not be empty";
        phoneNumber.focus();
        return false;
    }

    if (!validatePhone(phoneNumber.value)) {
        phoneNumber.style.border = "2px solid red";
        document.getElementById('phoneNumber_div').style.color = "red";
        phoneNumber_error.textContent = "Incorrect phone number";
        phoneNumber.focus();
        return false;
    }
}

function usernameVerify() {
    if (username.value != "") {
        username.style.border = "1px solid #5e6e66";
        document.getElementById('username_div').style.color = "#5e6e66";
        username_error.innerHTML = "";
        return true;
    }
}

function passwordVerify() {
    if (password.value != "") {
        password.style.border = "1px solid #5e6e66";
        document.getElementById('password_div').style.color = "#5e6e66";
        password_error.innerHTML = "";
        return true;
    }
    if (validatePassword(password.value)) {
        password.style.border = "1px solid #5e6e66";
        document.getElementById('password_div').style.color = "#5e6e66";
        password_error.innerHTML = "";
        return true;
    }
}

function firstNameVerify() {
    if (firstName.value != "") {
        firstName.style.border = "1px solid #5e6e66";
        document.getElementById('firstName_div').style.color = "#5e6e66";
        firstName_error.innerHTML = "";
        return true;
    }
}

function secondNameVerify() {
    if (secondName.value != "") {
        secondName.style.border = "1px solid #5e6e66";
        document.getElementById('secondName_div').style.color = "#5e6e66";
        secondName_error.innerHTML = "";
        return true;
    }
}

function emailVerify() {
    if (email.value != "") {
        email.style.border = "1px solid #5e6e66";
        document.getElementById('email_div').style.color = "#5e6e66";
        email_error.innerHTML = "";
        return true;
    }
    if (validateEmail(email.value)) {
        email.style.border = "1px solid #5e6e66";
        document.getElementById('email_div').style.color = "#5e6e66";
        email_error.innerHTML = "";
        return true;
    }
}

function phoneNumberVerify() {
    if (phoneNumber.value != "") {
        phoneNumber.style.border = "1px solid #5e6e66";
        document.getElementById('phoneNumber_div').style.color = "#5e6e66";
        phoneNumber_error.innerHTML = "";
        return true;
    }
    if (validatePhone(phoneNumber.value)) {
        phoneNumber.style.border = "1px solid #5e6e66";
        document.getElementById('phoneNumber_div').style.color = "#5e6e66";
        phoneNumber_error.innerHTML = "";
        return true;
    }
}

function validateEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

function validatePassword(password) {
    return /^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{8,}$/.test(password)
}

function validatePhone(phoneNumber) {
    return /^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$/.test(phoneNumber)
}

