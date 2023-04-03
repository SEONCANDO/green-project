$(document).ready(function () {
    var tmp = parseInt($("#test_obj").css('top'));

    $(window).scroll(function () {
        var scrollTop = $(window).scrollTop();
        var obj_position = scrollTop + tmp + "px";

        $(".floating").stop().animate({
            "top": obj_position
        }, 500);

    }).scroll();
});