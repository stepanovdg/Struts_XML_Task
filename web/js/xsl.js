/**
 * Created by IntelliJ IDEA.
 * User: Dzmitry_Stsiapanau
 * Date: 3/29/12
 * Time: 8:22 AM
 */
(function($) {
    $.fn.stockPlugin = function () {
        $(this).change(function() {
            var idn = this.id;
            var check = $(this);
            var sel = check.is(":checked");
            if (sel) {
                var te = $(("#unitPr" + idn));
                te.attr('value', true);
                te.change();
                te.hide();
            } else {
                var te = $("#unitPr" + idn);
                te.attr('value', "");
                te.show();
            }
        });

        return this;
    }
})(jQuery);
function validateName(name, alertmsg) {
    if (name == "") {
        return alertmsg

    }
    return "";
}
function validateProducer(name, alertmsg) {
    if (name == "") {
        return alertmsg
    }
    return "";
}
function validateModel(model, alertmsg) {
    var MODEL_LENGTH = 5;
    var MODEL_REGEX = /[a-zA-ZА-Яа-я]{2}[0-9]{3}/;
    if (!model.match(MODEL_REGEX)
            || model.length != MODEL_LENGTH
            ) {
        return alertmsg
    }
    return "";
}
function validateDate(name, alertmsg) {
    var DATE_LENGTH = 10;

    var DATE_REGEX = /(((0[1-9]|[12][0-9]|3[01])([-])(0[13578]|10|12)([-])(\d{4}))|(([0][1-9]|[12][0-9]|30)([-])(0[469]|11)([-])(\d{4}))|((0[1-9]|1[0-9]|2[0-8])([-])(02)([-])(\d{4}))|((29)(\.|-|\/)(02)([-])([02468][048]00))|((29)([-])(02)([-])([13579][26]00))|((29)([-])(02)([-])([0-9][0-9][0][48]))|((29)([-])(02)([-])([0-9][0-9][2468][048]))|((29)([-])(02)([-])([0-9][0-9][13579][26])))/;

    var eDate = name;
    if (
            !eDate.match(DATE_REGEX)
                    || eDate.length != DATE_LENGTH) {
        return alertmsg
    }
    return "";
}
function validateColor(name, alertmsg) {
    if (name == "") {
        return alertmsg
    }
    return "";
}
function validatePrice(stock, price, alertmsg) {
    var PRICE_REGEX = /^[0-9]+([,|.]{0,1}[0-9]{2}){0,1}$/;

    if (!stock && (price == "" || !price.match(PRICE_REGEX))
            ) {
        return alertmsg
    }
    return "";
}
function validatePoId(idn) {
    var inputClass = idn.substring(4, 6);
    var obj = $("#" + idn);
    var alertMess;
    var alertMessRet = "";
    switch (inputClass) {
        case"Nm":
        {
            alertMess = $("#alertName").val();
            alertMessRet = validateName(obj.val(), alertMess);
            break;
        }
        case"Pv":
        {
            alertMess = $("#alertProducer").val();
            alertMessRet = validateProducer(obj.val(), alertMess);
            break;
        }
        case"Md":
        {
            alertMess = $("#alertModel").val();
            alertMessRet = validateModel(obj.val(), alertMess);
            break;
        }
        case"Dt":
        {
            alertMess = $("#alertDate").val();
            alertMessRet = validateDate(obj.val(), alertMess);
            break;
        }
        case"Cl":
        {
            alertMess = $("#alertColor").val();
            alertMessRet = validateColor(obj.val(), alertMess);
            break;
        }
        case"Pr":
        {
            var stock;
            if (obj.val() == "true" || obj.val() == "on") {
                stock = true;
            } else {
                stock = false;
            }
            alertMess = $("#alertPrice").val();
            alertMessRet = validatePrice(stock, obj.val(), alertMess);
            break;
        }
        default:
        {

            break;
        }

    }
    return alertMessRet;
}
$(document).ready(function(e) {
    $("#addButton").hide();
    $("#WithoutJsForm").remove();
    $(".unitPrSt:checkbox").each(function() {
        var idn = this.id;
        var check = $(this);
        var sel = check.is(":checked");
        if (sel) {
            var te = $(("#unitPr" + idn));
            te.attr('value', true);
            te.hide();
        } else {
            var te = $("#unitPr" + idn);
            te.show();
        }
    }
    );
    $(".unitPrSt:text").change(function() {
        var idn = this.id;
        var valid = validatePoId(idn);
        var val = $(this).val();
        var property = $(this).attr('name');
        var data = '<input type="hidden" id=\"' + idn + '\" value=\"' + val + '\" name=\"' + property + '\" />';
        var remov = $(("#" + idn), $("#saveForm"));
        remov.remove();
        if (valid == "") {
            $("#saveForm").append(data);
            $(this).css("background", "white");
        } else {
            $(this).attr('value', valid);
            $(this).css("background", "red");
        }
    }
    );


    $(".unitPrSt:checkbox").stockPlugin();
    $("#unitStockBox").change(function(e) {
        var checkboxes = $("#unitStockBox");
        var select = checkboxes.is(":checked");
        if (select) {
            $("#unitPrice").hide();
            $("#unitPrice").attr('value', "");
        } else {
            $("#unitPrice").show();
            $("#unitPrice").attr('value', "");
        }
    });

    $("#validateMessage").ready(function(e) {
        var mess = $("#validateMessage").val();

        if (mess != "" && mess != null) {
            alert(mess);
        }

    });
    $("#addHref").click(function(e) {
        var alertMessage = "";
        alertMessage += validateName($("#editName").val(), $("#alertName").val());
        alertMessage += validateProducer($("#editProducer").val(), $("#alertProducer").val());
        alertMessage += validateModel($("#editModel").val(), $("#alertModel").val());
        alertMessage += validateColor($("#editColor").val(), $("#alertColor").val());
        alertMessage += validatePrice($("#unitStockBox").is(":checked"), $("#editPrice").val(), $("#alertPrice").val());
        alertMessage += validateDate($("#editDate").val(), $("#alertDate").val());

        var eDate = $("#editDate").val();
        if (alertMessage == "") {
            $("#jsCheck").attr('value', true);
            e.preventDefault();
            $("#add").submit();
        } else {
            alert(alertMessage);
            $("#editDate").attr('value', eDate);
            e.preventDefault();
        }

    });
    $("#saveHref").click(function(e) {
        e.preventDefault();
        $("#saveForm").submit();

    });
});