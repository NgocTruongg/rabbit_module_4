function movieDetail(id,append){
    debugger
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/movie/detail?id=${id ?? sessionStorage.getItem("selectedId")}` ,
        headers: {
            "Content-Type": "application/json",
        },
        success: function(data){
            debugger
            product = data
            let elements = "";
                elements = `
                <div class="col-12">
                  <div class="col-3 float-start" style="width: 300px;">
                      <img style="width: 100%;" src="${product.img}" alt="">
                  </div>
                  <div class="col-6 float-start">
                      <table class="table " >
                              <tr>
                                  <th colspan="2" class="fs-1">${product.name}</th>
                              </tr>
                              <tr>
                                  <th style="width:150px">Diễn Viên</th>
                                  <td>${product.actor}</td>
                              </tr>
                              <tr>
                                  <th>Đạo Diễn</th>
                                  <td>${product.director}</td>
                              </tr>
                              <tr>
                                  <th>Thể Loại</th>
                                  <td>${product.movieTypeDTO.name}</td>
                              </tr>
                              <tr>
                                  <th>Ngày Khởi Chiếu</th>
                                  <td>${product.startDay}</td>
                              </tr>
                              <tr>
                                  <th>Thời gian</th>
                                  <td>${product.time}</td>
                              </tr>
                              <tr>
                                  <th>Quốc Gia</th>
                                  <td>${product.country}</td>
                              </tr>
                              <tr>
                                  <th>Nội Dung</th>
                                  <td>${product.content}</td>
                              </tr>
                      </table>
                  </div>
              </div>
                `;
            if(append){
                $("#movieDetail").append(elements);
            }else{
                $("#movieDetail").html(elements);
            }
            
        },
        error: function(error){
            console.log(error);
        },
    });
  }
  $(document).ready(function(){
    movieDetail();
    }); 
 