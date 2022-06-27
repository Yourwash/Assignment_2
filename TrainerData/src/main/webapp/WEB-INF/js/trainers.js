$(document).ready(function ()
{

    var fname_not_valid = false;
    var lname_not_valid = false;

    $("#first-name").focusout(function () {
        checkFirstName();

    });

    $("#last-name").focusout(function () {
        checkLastName();

    });

    function checkFirstName() {

        var pattern = /^[a-zA-Z]*$/;
        var firstName = $("#first-name").val();
        if (pattern.test(firstName) && firstName !== "") {
            $("#first-name").removeClass().addClass("form-control is-valid");
            fname_not_valid = false;
        } else {
            $("#first-name").removeClass().addClass("form-control is-invalid");
            fname_not_valid = true;
        }

    }

    function checkLastName() {

        var pattern = /^[a-zA-Z]*$/;
        var lastName = $("#last-name").val();
        if (pattern.test(lastName) && lastName !== "") {
            $("#last-name").removeClass().addClass("form-control is-valid");
            lname_not_valid = false;
        } else {
            $("#last-name").removeClass().addClass("form-control is-invalid");
            lname_not_valid = true;
        }

    }

    $("#registration").submit(function () {
        checkFirstName();
        checkLastName();

        if (fname_not_valid === false && lname_not_valid === false) {
            alert("Registration Successfully");
            return true; //proceed with submit
        } else {
            alert("Please Fill the Form Correctly");
            return false;

        }
    });

});