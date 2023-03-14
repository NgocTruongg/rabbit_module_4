
function renderBlog(blogs, append){
    let element=`
    <thead>
        <tr>
            <th> Tên tác giả</th>
            <th> Tiêu đề</th>
            <th> Nội dung</th>
            <th> Danh mục</th>
        </tr>
      </thead>
      <tbody>;
    `
    for(let blog of blogs){
      element += 
      `
      <tr>
        <td>${blog.name}</td>
        <td>${blog.title}</td>
        <td>${blog.content}</td>
        <td>${blog.categoryDTO.name}</td>
      </tr>
      `;
      
    }
    element += "</tbody>"; 
      if(append){
        $("#listBlogs").append(element);
      } else{
        $("#listBlogs").html(element);
      }
}

function loadMore(nextPage){
  loadBlog(nextPage, true);
}

function renderLoadMoreButton(blogPageData){
  if(blogPageData.number < blogPageData.totalPages - 1){
    $("loadMoreContainer").html(
      `
      <button type="button" class="btn btn-secondary" onclick="loadMore(${blogPageData.number +1})">
      Load More
      </button>
      `
    );
  }else{
    $("#loadMoreContainer").remove();
  }
}

  
function loadBlog(page,append){
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/blog=${page ? page : "0 "}`,
        Headers: {
            "Content-Type": "aplication/json",
        },
        success: function(data){
            renderBlog(data.content, append);
            renderLoadMoreButton(data);
        },
        error : function(error){
            console.log(error);
        },
    });
}
$(document).ready(function(){
    loadBlog();
})


