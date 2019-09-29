
$( document ).ready(function() {
    checkSelectedCheckBoxes();
});

$('#sendSelectedCategory').on('click', function () {
    $.ajax({
        method: 'POST',
        url: '/admin/edit',
        data: {
            tankId: $_GET('id'),
            itemType: $_GET('item'),
            ids: JSON.stringify(getSelectedIds())
        },
        success: function(response){
            console.log('succes')
        },
        error: function (e) {
            console.log(e);
        }
    });
});

function getSelectedIds() {
    var values = [];
    $('input[type="checkbox"]:checked').each(function() {
        values.push($(this).val());
    });
    return values;
}
var selected;
$('#clicker').on('click', function () {
    var values = [];
    $('input[type="checkbox"]:checked').each(function() {
        values.push($(this).val());
    });
    console.log(values);
});

function $_GET(key) {
    var p = window.location.search;
    p = p.match(new RegExp(key + '=([^&=]+)'));
    return p ? p[1] : false;
}

function checkSelectedCheckBoxes() {
    var tankId = parseInt(getTankId());
    var categoriesId = getSelectedCategoryes(tankId);

    $('.editor').each(function() {
        var checkBox = $(this);
        var checkBoxVal = $(this).val();

        for (var i in categoriesId) {
            if (categoriesId[i] == checkBoxVal) {
                checkBox.prop('checked', true);
            }
        }
    });
}

function getSelectedCategoryes(tankId) {
    var categoryes = [];

    $.ajax({
        method: 'GET',
        url: '/admin/get-all-category?tankId=' + tankId,
        async: false,
        success: function(response){
            for (var i in response) {
                categoryes.push(response[i][0]);
            }
        },
        error: function (e) {
            console.log(e);
        }
    });

    return categoryes;
}

function getTankId() {
    var url_string = window.location.href;
    var url = new URL(url_string);
    return url.searchParams.get("id");
}