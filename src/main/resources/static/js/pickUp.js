// jQuery 불러오기
$(function loadJQuery() {
    var oScript = document.createElement("script");
    oScript.type = "text/javascript";
    oScript.charset = "utf-8";
    oScript.src = "http://code.jquery.com/jquery-1.6.2.min.js";
    document.getElementsByTagName("head")[0].appendChild(oScript);
})


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


// flatpicker 요일 지정하기
flatpickr("#myDateInput", {
    disable: [
        // 주말 제외 (토, 일)
        function(date) {
            // return true to disable
            return (date.getDay() === 0 || date.getDay() === 6);
        }
    ],
    dateFormat: "Y-m-d" // 날짜 형식 설정
});

// myDateInput의 값이 변경되었을 때 처리할 함수
document.getElementById("myDateInput").addEventListener("change", function() {
    var dateInput = document.getElementById("myDateInput").value; // myDateInput의 값 가져오기
    var date = new Date(dateInput); // 입력된 날짜를 JavaScript의 Date 객체로 변환
    var daysOfWeek = ["일", "월", "화", "수", "목", "금", "토"]; // 요일 배열
    var dayOfWeek = daysOfWeek[date.getDay()]; // Date 객체에서 요일 값을 가져와서 배열에서 해당 요일을 찾음
    document.getElementById("text_insertDayOfWeek").textContent = "(" + dayOfWeek + ")"; // 요일 값을 text_insertDayOfWeek에 출력
});


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



// 입력정보 저장
function pickupSave() {
    const user_id = $("#pickup_userID").val();
    const pu_name = $("#pickup_name").val();
    const pu_tel = $("#pickup_tel").val();
    const pu_zip = $("#pickup_zip_code").val();
    const pu_address1 = $("#pickup_address1").val();
    const pu_address2 = $("#pickup_address2").val();
    const pu_address3 = $("#pickup_address3").val();
    const pu_address4 = $("#pickup_address4").val();
    const house_no = $("#pickup_house").val();
    const pu_elevator = $("#pickup_elevator").val();
    const pu_day = $("#myDateInput").val();
    let pu_img;
    if ($("#img_pickup_upload").val() != null) {
        pu_img = "Y";
    } else {
        pu_img = "N";
    }
    const text_memo = $(".text_memo").val();

    $.ajax({
        url:"pickupSave.do",
        type:"post",
        data:{"user_id":user_id, "pu_name":pu_name, "pu_tel":pu_tel,
        "pu_zip":pu_zip,"pu_address1":pu_address1,"pu_address2":pu_address2,
        "pu_address3":pu_address3,"pu_address4":pu_address4,"house_no":house_no,"pu_elevator":pu_elevator,
        "pu_day":pu_day, "pu_img":pu_img, "text_memo":text_memo},
        success: "",
        error: function() {
            alert('error')
        }
    })
}




