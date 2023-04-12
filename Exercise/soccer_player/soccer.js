// Phân trang
function movePage(page) {
    loadSoccer(page);
}

function renderPage(soccerPlayerList) {
    let pageable = "";
    if (
        soccerPlayerList.number <= soccerPlayerList.totalPages - 1 &&
        soccerPlayerList.number > 0
    ) {
        pageable += `
    <button class="page-item btn btn-dark btn-sm" 
    onclick="movePage(${soccerPlayerList.number - 1})">
    Previous
    </button>
    `;
    }
    for (let i = 1; i <= soccerPlayerList.totalPages; i++) {
        let pageItem = $(`<button class="page-item number btn btn-dark btn-sm"
                      onclick="movePage(${i - 1})">
                      ${i}
                      </button>`);
        if (i === soccerPlayerList.number + 1) {
            pageItem.addClass("active1");
        } else {
            pageItem.removeClass("active1");
        }
        pageable += pageItem.prop("outerHTML");
    }

    if (soccerPlayerList.number >= 0 && soccerPlayerList.number < soccerPlayerList.totalPages - 1) {
        pageable += `
    <button class="page-item btn btn-dark btn-sm" 
    onclick="movePage(${soccerPlayerList.number + 1})">
    Next
    </button>
    `;
    }
    $("#pagination").html(pageable);
}

// Danh sách
function loadSoccer(page) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/soccer-player?page=${page ? page : "0"}`,
        Headers: {
            "Conten-Type": "aplication/json"
        },
        success: function (data) {
            renderSoccer(data.content);
            debugger
            renderPage(data);
        },
        eroor: function (eroor) {
            console.log(eroor);
        }
    });
}

$(document).ready(function () {
    loadSoccer();
});

function renderSoccer(soccerPlayers, append) {
    let element = "";
    debugger
    for (let soccerPlayer of soccerPlayers) {
        element +=
            `
            <tr>
                <td> ${soccerPlayer.code}</td>
                <td>${soccerPlayer.name}</td>
                <td> ${soccerPlayer.dateOfBirth}</td>
                <td> ${soccerPlayer.experience}</td>
                <td> ${soccerPlayer.location}</td>
                <td> ${soccerPlayer.footballTeam?.name}</td> 
                <td>
                <img style="width: 150px;height: 150px;" src="${soccerPlayer.img}" alt="">
                </td>
            </tr>    
            `;
    } if (append) {
        $("listSoccer").append(element);
    } else {
        $("#listSoccer").html(element);
    }
}

// Thêm mới

$("#add-soccer-player").click(function (event) {
    let code = $("#code").val();
    let name = $("#name").val();
    let dateOfBirth = $("#dateOfBirth").val();
    let experience = $("#experience").val();
    let location = $("#location").val();
    let soccerPlayerDTO = $("#footballTeam.name").val();
    addSoccerPlayer(code, name, dateOfBirth, experience, location, soccerPlayerDTO)
});

function addSoccerPlayer(code, name, dateOfBirth, experience, location, soccerPlayerDTO) {
    $.ajax({
        headers: {
            "Accept" : "application/json",
            "Content-Type": "application/json"
        },
        url: `http://localhost:8080/api/soccer-player`,
        type: "post",
        data: JSON.stringify({
            code : code,
            name : name,
            dateOfBirth : dateOfBirth,
            experience : experience,
            location : location,
            soccerPlayerDTO : {id: footballTeam.name}
        }),
        success: function(data){
            alert("Thêm mới thành công")
        }, eroor: function(data){
            alert("Thêm mới thất bại");
        }
    });
}

function getSelectFootballTeam() {
    $.ajax({
      type: "GET",
      url: `http://localhost:8080/soccer-player/create}`,
      headers: {
        "Content-Type": "application/json",
      },
      success: function (data) {
        showFootballTeam(data);
      },
      error: function (error) {
        console.log(error);
      },
    });
  }


function showFootballTeam(footballTeams){
    let element ="";
    element += `
    <select class="form-control" id="footballTeam.name" name="footballTeam.name">`;
    debugger
    for (let footballTeam of footballTeams) {
      element += `<option value="${footballTeam.id}">`;
      element += footballTeam.name;
      `</option>`;
    }
  
    `</select>`;
    $("#footballTeam").html(element);
  }
  
  $(document).ready(function () {
    showFootballTeam();
  });