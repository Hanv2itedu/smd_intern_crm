window.onload = function () {
    var selItemStatus = sessionStorage.getItem("SelItemStatus");
    $('#select-filters-status').val(selItemStatus);
    var selItemProductType = sessionStorage.getItem("SelItemProductType");
    $('#select-filters-product').val(selItemProductType);
}

function listCustomerByFilters() {

    var status = $("#select-filters").val();
    var productType = "";
    jQuery.ajax({
        type: "GET",
        url: window.location.href + "-filter" + "?statusId=" + $("#select-filters").val() + "&productType=0",
        dataType: 'JSON',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            display(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#result').html(json);
        },
        done: function (e) {
            console.log("DONE");
        }
    });

}

function display(data) {
    var html = "<tr>";
    for (var i = 0; i < data.length; i++) {
        html += "<td>" + data[i].name + "</td>";
        html += "<td>" + data[i].age + "</td>";
        html += "<td>" + data[i].phone + "</td>";
        html += "<td>" + data[i].phone + "</td>";
        html += "<td>" + data[i].phone + "</td>";
        html += "<td>" + data[i].phone + "</td>";
        html += "<td>" + data[i].phone + "</td>";
        // html+= data[i].name+ " - "+ data[i].age + " - " + data[i].phone
    }
    html += "</tr>";
    $('#listCus-body').html(html);
}

function listCusByFilters() {
    var selValStatus = $("#select-filters-status").val()!=null ?  $("#select-filters-status").val():0 ;
    sessionStorage.setItem("SelItemStatus", selValStatus);
    var selValProductType = $("#select-filters-product").val()!=null?  $("#select-filters-product").val():0;
    sessionStorage.setItem("SelItemProductType", selValProductType);

    window.location.href = window.location.pathname + "?statusId=" + selValStatus + "&productType=" + selValProductType;
}