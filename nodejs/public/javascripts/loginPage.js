/**
 * Created by mingzhao on 2017/5/4.
 */
$(document).ready(function () {
    console.log("document ready");

    $("#login-btn").on('click', function () {
        console.log("start click.......");
        var user_name = $("#user-input").val();
        var user_passwd = $("#passwd-input").val();

        var data = {
            account: user_name,
            passwd: user_passwd
        };
        console.log(data);
        $.ajax({
            url: "/interface/login",
            async: true,
            data: data,
            method:"post",
            dataType: "json",
            success: function (data) {
                console.log("type:"+ (typeof data));
                // var ob = JSON.parse(data);
                console.log("status:"+data.status+">>>>data.message:"+data.message);
            },
            error: function (xhr, data, error) {
                console.log("error>>>"+error);
            }
        })
    });
});
