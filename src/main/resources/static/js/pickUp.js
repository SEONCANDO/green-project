function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}

$(function() {
    $("#DatePicker").datepicker({
    });
});

$.datepicker.setDefaults({
    dateFormat: 'yy-mm-dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
});

// $('#DatePicker').on('change', function(){
//     var date = $(this).val();
//     switch(new Date(date).getDay()){
//         case 0 : $("#day").text('일'); break
//         case 1 : $("#day").text('월'); break
//         case 2 : $("#day").text('화'); break
//         case 3 : $("#day").text('수'); break
//         case 4 : $("#day").text('목'); break
//         case 5 : $("#day").text('금'); break
//         case 6 : $("#day").text('토'); break
//
//         // case 0 : $('#day').text('일'); $('[name=weekday]').val('일'); break
//         // case 1 : $('#day').text('월'); $('[name=weekday]').val('월'); break
//         // case 2 : $('#day').text('화'); $('[name=weekday]').val('화'); break
//         // case 3 : $('#day').text('수'); $('[name=weekday]').val('수'); break
//         // case 4 : $('#day').text('목'); $('[name=weekday]').val('목'); break
//         // case 5 : $('#day').text('금'); $('[name=weekday]').val('금'); break
//         // case 6 : $('#day').text('토'); $('[name=weekday]').val('토'); break
//     }
// });

// pickup page2 카테고리 버튼 이벤트
$(document).ready(function(){
    $(".pickup_recycle_btn").each(function(index) {
        $(this).attr('menu-index', index);
    }).click(function(){
        // 클릭된 <div>의 menu-index 값을 index 변수에 할당한다
        const index = $(this).attr('menu-index');
        // 클릭한 <div>에 clicked_menu 클래스 추가
        $('.pickup_recycle_btn[menu-index=' + index + ']').addClass('clicked_menu');
        // 그 외 <div>는 clicked_menu 클래스 삭제
        $('.pickup_recycle_btn[menu-index!=' + index + ']').removeClass('clicked_menu');
    });
});

$(document).ready(function(){
    $(".pickup_recycle_btn2").each(function(index2) {
        $(this).attr('menu-index2', index2);
    }).click(function(){
        // 클릭된 <div>의 menu-index 값을 index 변수에 할당한다
        const index2 = $(this).attr('menu-index2');
        // 클릭한 <div>에 clicked_menu 클래스 추가
        $('.pickup_recycle_btn2[menu-index2=' + index2 + ']').addClass('clicked_menu');
        // 그 외 <div>는 clicked_menu 클래스 삭제
        $('.pickup_recycle_btn2[menu-index2!=' + index2 + ']').removeClass('clicked_menu');
    });
});