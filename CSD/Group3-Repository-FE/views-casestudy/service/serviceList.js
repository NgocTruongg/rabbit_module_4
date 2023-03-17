// FIND ALL LIST SERVICE
function service(page, append) {
    let search = document.getElementById("idSearch").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/service?page=${page ? page : "0"}&name=` + search,
        headers: {
            "Content-Type": "application/json",
        },
        success: function (data) {
            renderService(data.content, append);
            renderLoadMoreButton1(data);
        },
        error: function (error) {
            console.log(error);
        },
    });
}

$(document).ready(function () {
    service();
});

function renderService(products, append) {
    let element = "";
    for (let product of products) {
        element += `
            <tr class = "fs-4">
                <td scope="row">${product.id}</td>
                <td>${product.name}</td>
                <td>${product.startDate}</td>
                <td>${product.endDate}</td>
                <td>${product.price}</td>
                <td>${product.serviceTypeDTO.name}</td>
                <td style="width: 150px"><img class="w-100" src="${product.img}" alt=""></td>
                <td></td>
                <td class="text-center" style="width: 80px" >
                <button type="button" onclick="deleteId('${product.id}','${product.name}')" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal1">
                    Xóa
                </button>
                </td>
            </tr>
        `;
    }
    if (append) {
        $("#service").append(element);
    } else {
        $("#service").html(element);
    }
}

function loadMoreService(nextPage) {
    service(nextPage, true);
}

function renderLoadMoreButton1(productPageData) {
    if (productPageData.number < productPageData.totalPages - 1) {
        $("#loadMoreService").html(
            `
            <button type="button" id="loadMore1" style="background: none;border: none" class="text-primary seeMore fs-5"
            onclick="loadMoreService(${productPageData.number + 1})">
            Xem thêm
            </button>            
            `
        );
    } else {
        $("#loadMore1").remove();
    }
}