$("#addService").submit(function (event) {
    event.preventDefault()
    let name = $("#name").val();
    let startDate = $("#startDate").val();
    let endDate = $("#endDate").val();
    let price = $("#price").val();
    let serviceType = $("#selectService").val();
    let img = $("#img").val();
    createService(name, startDate, endDate, price, serviceType, img);
})

function createService(name, startDate, endDate, price, serviceType, img) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/service",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: JSON.stringify({
            name: name,
            startDate: startDate,
            endDate: endDate,
            price: price,
            serviceTypeDTO: {id:serviceType},
            img: img
        }),
        success: function (data) {
            alert("Thêm mới thành công")
            // window.location.replace("/serviceList.html");
        },
        error: function () {
            alert("Thêm mới sản phẩm không thành công!");
        },
    })
}

function selectService() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/service-type`,
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            serviceOption(data);
        },
        error: function (error) {
            console.log(error);
        },
    });
}

function serviceOption(products) {
    let element = "";
    element += `<select class="form-control" id="selectService">`
    for (let product of products.content) {
        element += `<option value="${product.id}">${product.name}</option>`
    }
    `</select>`;
    $("#serviceType").html(element);
}

$(document).ready(function () {
    selectService();
})