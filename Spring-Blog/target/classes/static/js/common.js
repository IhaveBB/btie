$(document).ajaxSend(function (e, xhr, opt) {
    var user_token = localStorage.getItem("user_token");
    xhr.setRequestHeader("user_token_header", user_token);
});

function getUserInfo(url) {
    $.ajax({
        type: "get",
        url: url,
        success: function (result) {
            if (result.code == 200 && result.data != null) {
                $(".left .card h3").text(result.data.userName);
                $(".left .card a").attr("href", result.data.githubUrl);
            }
        }
    });
}
function logout(){
    localStorage.removeItem("user_token");
    location.href = "blog_login.html";
}