// -----CODE SLIDE-----
function rotate() {
    var lastChild = $('.slider div:last-child').clone();
    /*$('#test').html(lastChild)*/
    $('.slider div').removeClass('firstSlide')
    $('.slider div:last-child').remove();
    $('.slider').prepend(lastChild)
    $(lastChild).addClass('firstSlide')
  }
  window.setInterval(function(){
    rotate()
  }, 4000);
// -----Show List Up Coming Movie-----
  function upComingMovie(page,append){
    let search= document.getElementById("idSearch").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/movie/up-coming?page=${page ? page : "0"}&name=` + search,
        headers: {
            "Content-Type": "application/json",
        },
        success: function(data){
            renderUpComingMovie(data.content,append);
            renderLoadMoreButton2(data);
        },
        error: function(error){
            console.log(error);
        },
    });

  }
  $(document).ready(function(){
  upComingMovie();
  }); 
  function renderUpComingMovie(products,append){
    let elements = "";
    for(let product of products){
        elements += `
        <div class="col-3">
                    <div class="card-group" >
                        <div class="card img-black">
                            <a href="" >
                                <img src="${product.img}"
                                    height="400px" class="card-img-top" alt="...">
                                    <div class="btn-outline-primary detail" href="">Chi tiết</div>
                            </a>
                        </div>
                    </div>
                    <a href="">
                        <h5 class="text-center pt-2">${product.name}</h5>
                        <h6 class="text-center">Khởi chiếu ngày ${product.startDay}</h6>
                    </a>
                </div>
        `;
    }
    if(append){
        $("#upcomingMovie").append(elements);
    }else{
        $("#upcomingMovie").html(elements);
    }
}

    function loadMoreUpComing(nextPage){
    upComingMovie(nextPage,true);
  }
  function renderLoadMoreButton2(productPageData){
  if(productPageData.number < productPageData.totalPages-1){
      $("#loadMoreContainerUpComing").html(
          `
          <button type="button" id="loadMore2" style="background:none; border:none" class="text-primary seeMore fs-5"
           onclick="loadMoreUpComing(${productPageData.number + 1})">
           Xem thêm...</button>
           `
      );
  }else{
      $("#loadMore2").remove();
  }
  }
  
// function loadMore(nextPage){
//   upComingMovie(nextPage,true);
// }
// -----Show List Moving-----
  function listMoving(page,append){
    let search= document.getElementById("idSearch").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/movie/moving?page=${page ? page : "0"}&name=` + search,
        headers: {
            "Content-Type": "application/json",
        },
        success: function(data){
            renderMoving(data.content,append);
            renderLoadMoreButton(data);
        },
        error: function(error){
            console.log(error);
        },
    });

}
function setSelectedId(id) {
    setSelectedIdToSessionStorage(id)
}

$(document).ready(function(){
  listMoving();
}); 
function renderMoving(products,append){
    let elements = "";
    for(let product of products){
        elements += `
        <div class="col-3">
                    <div class="card-group" >
                        <div class="card img-black">
                            <div>
                                <img src="${product.img}" height="400px" class="card-img-top" alt="...">
                                    <a class="btn-outline-primary ticket" >Đặt Vé</a>
                                    <a class="btn-outline-primary detail" href="/detail.html" onclick="setSelectedId(${product.id})" >Chi Tiết</a>
                            </div>
                        </div>
                    </div>
                    <a href="">
                        <h5 class="text-center pt-2">${product.name}</h5>
                        <h6 class="text-center">Khởi chiếu ngày ${product.startDay}</h6>
                    </a>
                </div>
        `;
    }
    if(append){
        $("#listMovie").append(elements);
    }else{
        $("#listMovie").html(elements);
    }
}
function loadMore(nextPage){
  listMoving(nextPage,true);
}
function renderLoadMoreButton(productPageData){
if(productPageData.number < productPageData.totalPages-1){
    $("#loadMoreContainer").html(
        `
        <button type="button" id="loadMore1" style="background:none; border:none" class="text-primary seeMore fs-5"
         onclick="loadMore(${productPageData.number + 1})">
         Xem thêm...</button>
         `
    );
}else{
    $("#loadMore1").remove();
}
// ----SHOW AND HIDE MOVIE----
}
$(document).ready(function(){
    $(".film-button-1").click(function(){
        $("#listComingMovie").show();
        $("#listMoving").hide();
    });
});
$(document).ready(function(){
    $(".film-button").click(function(){
        $("#listComingMovie").hide();
        $("#listMoving").show();
    });
});
// -----FIND ALL LIST-----
function movie(page,append){
    let search= document.getElementById("idSearch").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/movie?page=${page ? page : "0"}&name=` + search,
        headers: {
            "Content-Type": "application/json",
        },
        success: function(data){
            renderMovie(data.content,append);
            renderLoadMoreButton3(data);
        },
        error: function(error){
            console.log(error);
        },
    });

  }
  $(document).ready(function(){
    movie();
  }); 
  function renderMovie(products,append){
    let elements = "";
    for(let product of products){
        elements += `
            <tr class="fs-4">
                <td scope="row" >${product.id}</td>
                <td>${product.name}</td>
                <td>${product.movieTypeDTO.name}</td>
                <td>${product.actor}</td>
                <td>${product.director}</td>
                <td>${product.time}</td>
                <td>${product.country}</td>
                <td>${product.startDay}</td>
                <td>${product.endDay}</td>
                <td style="width:150px;"><img class="w-100" src="${product.img}" alt=""></td>
                <td></td>
                <td></td>
            </tr>  
        `;
    }
    if(append){
        $("#movie").append(elements);
    }else{
        $("#movie").html(elements);
    }
}