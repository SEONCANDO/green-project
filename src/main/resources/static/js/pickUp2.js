
// 카테고리 버튼 이벤트
$(document).ready(function(){
    $(".btn_recycleCategory_1st").each(function(index) {
        $(this).attr('menu-index', index);
    }).click(function(){
        // 클릭된 <div>의 menu-index 값을 index 변수에 할당한다
        const index = $(this).attr('menu-index');
        // 클릭한 <div>에 clicked_menu 클래스 추가
        $('.btn_recycleCategory_1st[menu-index=' + index + ']').addClass('clicked_menu');
        // 그 외 <div>는 clicked_menu 클래스 삭제
        $('.btn_recycleCategory_1st[menu-index!=' + index + ']').removeClass('clicked_menu');
    });
});

$(document).ready(function(){
    $(".btn_recycleCategory_2st").each(function(index2) {
        $(this).attr('menu-index2', index2);
    }).click(function(){
        // 클릭된 <div>의 menu-index 값을 index 변수에 할당한다
        const index2 = $(this).attr('menu-index2');
        // 클릭한 <div>에 clicked_menu 클래스 추가
        $('.btn_recycleCategory_2st[menu-index2=' + index2 + ']').addClass('clicked_menu');
        // 그 외 <div>는 clicked_menu 클래스 삭제
        $('.btn_recycleCategory_2st[menu-index2!=' + index2 + ']').removeClass('clicked_menu');
    });
});