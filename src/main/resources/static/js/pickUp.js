
// 주소 검색기능
jQuery.noConflict(
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
)


// 요일 선택시 메소드 실행
$(function() {
    $("#DatePicker").datepicker({
    });
});

// $(document).ready(function() {
//     // Your code here
//     $("#DatePicker").datepicker();
// });




// 요일 선택 포멧 설정
// $.datepicker.setDefaults({
//     dateFormat: 'yy-mm-dd',
//     prevText: '이전 달',
//     nextText: '다음 달',
//     monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
//     monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
//     dayNames: ['일', '월', '화', '수', '목', '금', '토'],
//     dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
//     dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
//     showMonthAfterYear: true,
//     yearSuffix: '년'
// });

// 이미지 첨부
const upload = document.querySelector('#img_pickup_upload');
upload.addEventListener('change', getImageFiles);

function getImageFiles(e) {
    const uploadFiles = [];
    const files = e.currentTarget.files;
    const imagePreview = document.querySelector('#img_pickup_preview');
    const docFrag = new DocumentFragment();

    if ([...files].length >= 7) {
        alert('이미지는 최대 6개 까지 업로드가 가능합니다.');
        return;
    }

    // 파일 타입 검사
    [...files].forEach(file => {
        if (!file.type.match("image/.*")) {
            alert('이미지 파일만 업로드가 가능합니다.');
            return
        }

        // 파일 갯수 검사
        if ([...files].length < 7) {
            uploadFiles.push(file);
            const reader = new FileReader();
            reader.onload = (e) => {
                const preview = createElement(e, file);
                imagePreview.appendChild(preview);
            };
            reader.readAsDataURL(file);
        }
    });
}

// 첨부 이미지 preview
function createElement(e, file) {
    const delBtn = document.createElement("input");
    const li = document.createElement('li');
    const img = document.createElement('img');

    img.setAttribute('src', e.target.result);
    img.setAttribute('data-file', file.name);
    li.appendChild(img);
    delBtn.className = 'delBtn';
    delBtn.type = "button";
    delBtn.value = "X";
    li.id = "img_list";
    li.appendChild(delBtn);

    $(document).ready(function() {
        $(delBtn).click(function () {
            $(li).remove();
        })
    });
    return li;
}


let result = '';

// 약관 동의 체크값
function getCheckboxValue() {
    if($("#checkBox_colPersonInfo").prop("checked")) {
        result = $("#checkBox_colPersonInfo").val(1);
        console.log(result);
    }
}

// 다음페이지 이동시, 입력값 빈칸 확인
function chBox() {
    if (result == null) {
        alert("약관에 동의해주세요");
        $("#checkBox_colPersonInfo").focus();
        return false;
    } else {
        return true;
    }
}



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



