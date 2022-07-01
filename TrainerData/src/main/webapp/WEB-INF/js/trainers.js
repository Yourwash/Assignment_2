$(document).ready(function () {

    $("#create-trainer").ready(function () {
        var fname_not_valid = false;
        var lname_not_valid = false;
        var subList_not_valid = false;

        $("#first-name").focusout(function () {
            checkFirstName();
        });

        $("#last-name").focusout(function () {
            checkLastName();
        });

        $("#subject-list").mouseleave(function () {
            checkSubjectList();
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

        function checkSubjectList() {

            var check = false;
            $(`[id^=subject-]`).each(function () {
                if (this.checked) {
                    check = true;
                }
            });

            if (check === true) {
                $("#subject-list-invalid").hide();
                $("#subject-list-valid").show();
                subList_not_valid = false;
            } else {
                $("#subject-list-valid").hide();
                $("#subject-list-invalid").show();
                subList_not_valid = true;
            }
        }


        $("#create-trainer").submit(function () {
            checkFirstName();
            checkLastName();
            checkSubjectList();
            if (fname_not_valid === false && lname_not_valid === false && subList_not_valid === false) {
                alert("Trainer created!");
                return true; //proceed with submit
            } else {
                alert("Please fill the form correctly!");
                return false;
            }
        });
    });

    $("[id^=update-form-]").each(function () {

        var key = $(this).attr("id");
        key = key.replace(/[^0-9]/g, '');

        var fname_not_valid = false;
        var lname_not_valid = false;
        var subList_not_valid = false;

        $("#first-name-" + key).focusout(function () {
            checkFirstName();
        });

        $("#last-name-" + key).focusout(function () {
            checkLastName();
        });

        $("#subject-list-" + key).mouseleave(function () {
            checkSubjectList();
            console.log(key);
        });


        function checkFirstName() {

            var pattern = /^[a-zA-Z]*$/;
            var firstName = $("#first-name-" + key).val();
            if (pattern.test(firstName) && firstName !== "") {
                $("#first-name-" + key).removeClass().addClass("form-control is-valid mt-2");
                fname_not_valid = false;
            } else {
                $("#first-name-" + key).removeClass().addClass("form-control is-invalid mt-2");
                fname_not_valid = true;
            }
        }

        function checkLastName() {

            var pattern = /^[a-zA-Z]*$/;
            var lastName = $("#last-name-" + key).val();
            if (pattern.test(lastName) && lastName !== "") {
                $("#last-name-" + key).removeClass().addClass("form-control is-valid mt-2");
                lname_not_valid = false;
            } else {
                $("#last-name-" + key).removeClass().addClass("form-control is-invalid mt-2");
                lname_not_valid = true;
            }
        }

        function checkSubjectList() {

            var check = false;
            $(`[id^=subject-` + key+`-]`).each(function () {
                if (this.checked) {
                    check = true;
                }
            });

            if (check === true) {
                $("#subject-list-invalid-"+ key).hide();
                $("#subject-list-valid-"+ key).show();
                subList_not_valid = false;
            } else {
                $("#subject-list-valid-"+ key).hide();
                $("#subject-list-invalid-"+ key).show();
                subList_not_valid = true;
            }
        }


        $("#update-form-" + key).submit(function () {
            checkFirstName();
            checkLastName();
            checkSubjectList();
            if (fname_not_valid === false && lname_not_valid === false && subList_not_valid === false) {
                alert("Trainer updated!");
                return true; //proceed with submit
            } else {
                alert("Please fill the form correctly!");
                return false;
            }
        });

    });

    $('[id^=table-row-]').on('click', "button", function () {
        const key = $(this).val();
        replaceDiv(key);
    });

    function replaceDiv(key) {
        var str = "update-form-" + key;
        console.log(str);
        $("#update-form-" + key).show();
        $("#table-row-" + key).hide();
    }

});