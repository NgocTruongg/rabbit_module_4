$("#deleteService").submit(function(event){
    event.preventDefault();
    let id = $("#deleteId").val()
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/service/?id=${id}`,
        success: function (data) {
            alert("Xóa thành công");
            service();
        },
        error: function (error) {
            console.log("Xóa thất bại");
        },
    });
})
function deleteId(id,name){
    debugger
    document.getElementById("deleteId").value=id;
    document.getElementById("deleteName").innerHTML=name;
}
