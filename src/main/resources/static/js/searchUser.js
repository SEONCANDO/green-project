function checkUserId() {
    let userName = $('#id_name').val();
    let userEmail = $('#id_email').val();
    $.ajax({
        url: "/checkUserId",
        type: "POST",
        data: {user_name: userName, user_email: userEmail},
        success: function (response) {
            if (response && response.user_id) {
                $('#idCheckMessage').text("회원님의 아이디는 " + response.user_id + "입니다.");
            } else {
                $('#idCheckMessage').text("해당 사용자의 아이디가 존재하지 않습니다.");
            }
        },
        error: function () {
            $('#idCheckMessage').text("요청에 실패하였습니다.");
        }
    });
}