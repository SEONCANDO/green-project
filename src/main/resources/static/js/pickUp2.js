// jQuery 불러오기
$(function loadJQuery() {
    var oScript = document.createElement("script");
    oScript.type = "text/javascript";
    oScript.charset = "utf-8";
    oScript.src = "http://code.jquery.com/jquery-1.6.2.min.js";
    document.getElementsByTagName("head")[0].appendChild(oScript);
})


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

const firstCategoryButtons = document.querySelectorAll(".btn_recycleCategory_1st");

firstCategoryButtons.forEach(button => {
    button.addEventListener('click', () => {
        const id = button.id;
        console.log(id); // 클릭된 버튼의 id 값을 콘솔에 출력
        let options;
        const secondCategoryButtons = document.querySelectorAll(".btn_recycleCategory_2st");
        if(id ==='img_washing') {
            options = `
                <input type="button" class="btn_recycleCategory_2st" value="일반세탁기">
                <input type="button" class="btn_recycleCategory_2st" value="드럼세탁기">
                <input type="button" class="btn_recycleCategory_2st" value="탈수기">
            `;
            $("#btn_recycleCategory").html(options);
        } else if (id === 'img_refrigerator') {
            options = `
                <input type="button" class="btn_recycleCategory_2st" value="가정용냉장고">
                <input type="button" class="btn_recycleCategory_2st" value="김치냉장고">
                <input type="button" class="btn_recycleCategory_2st" value="와인냉장고">
                <input type="button" class="btn_recycleCategory_2st" value="업소용냉장고">
            `;
            $("#btn_recycleCategory").html(options);
        } else if (id === 'img_television') {
            options = `
                <input type="button" class="btn_recycleCategory_2st" value="텔레비전(CRT)">
                <input type="button" class="btn_recycleCategory_2st" value="텔레비전(LCD,PDP)">
                <input type="button" class="btn_recycleCategory_2st" value="프로젝션 TV">
            `;
            $("#btn_recycleCategory").html(options);
        } else if (id === 'img_airConditioner') {
            options = `
                <input type="button" class="btn_recycleCategory_2st" value="에어컨실내기">
                <input type="button" class="btn_recycleCategory_2st" value="에어컨실외기">
                <input type="button" class="btn_recycleCategory_2st" value="일체형에어컨">
            `;
            $("#btn_recycleCategory").html(options);
        } else if (id === 'img_solar') {
            options = `
                <input type="button" class="btn_recycleCategory_2st" value="태양광패널">
            `;
            $("#btn_recycleCategory").html(options);
        } else if (id === 'img_etc') {
            options = `
                <input type="button" class="btn_recycleCategory_2st" value="전자레인지">
                <input type="button" class="btn_recycleCategory_2st" value="오븐">
            `;
            $("#btn_recycleCategory").html(options);
        } else if (id === 'img_computer') {
            options = `
                <input type="button" class="btn_recycleCategory_2st" value="컴퓨터본체">
            `;
            $("#btn_recycleCategory").html(options);
        }
        const recycleCategoryButtons = document.querySelectorAll(".btn_recycleCategory_2st");

        recycleCategoryButtons.forEach((button, index2) => {
            button.setAttribute('menu-index2', index2);
            button.addEventListener('click', () => {
                const index2 = button.getAttribute('menu-index2');
                $('.btn_recycleCategory_2st[menu-index2=' + index2 + ']').addClass('clicked_menu');
                $('.btn_recycleCategory_2st[menu-index2!=' + index2 + ']').removeClass('clicked_menu');
            });
        });

        // 추가 버튼 클릭 시 실행될 함수
        function addItem() {
            // const secondVal = selectedSecondCategoryButton.value;
            // const categoryNo = document.querySelector('#category
            secondCategoryButtons.forEach(button => {
                button.addEventListener('click', () => {
                    const secondVal = button.value;
                    const newButtonHtml = `
                      <tr style="height: 65px;">
                        <td class="col-3" style="border-right: 2px solid #d5d2d2; font-family: NanumBarunGothic, serif;">
                          <div class="text_mainCategory_preview">${id}</div>
                        </td>
                        <td class="col-3" style="border-right: 2px solid #d5d2d2; font-family: NanumBarunGothic, serif;">
                          <div class="text_detailCategory_preview" id="category_no">${secondVal}</div>
                        </td>
                        <td class="col-3" style="border-right: 2px solid #d5d2d2; text-align: center; font-family: NanumBarunGothic, serif;">
                          <button type="button" class="minus" onclick="fnCalcCnt('minus');">
                            <div style="width: 100%; height: 100%; position: absolute; top: -20px;">-</div>
                          </button>
                          <input type="text" class="count_category" name="item_cnt" title="수량 입력" value="1" maxlength="1">
                          <button type="button" class="plus" onclick="fnCalcCnt('plus');">
                            <div style="width: 100%; height: 100%; position: absolute; top: -20px;">+</div>
                          </button>
                        </td>
                        <td class="col-3">
                          <div class="button_inputCategory_delete">
                            <input type="button" value="X" style="color: red; border: none; font-size: 28px;">
                          </div>
                        </td>
                      </tr>
                    `;
                    const preview_row = document.querySelector('#preview_row');
                    const newTr = document.createElement('tr');
                    newTr.innerHTML = newButtonHtml;
                    preview_row.parentNode.insertBefore(newTr, preview_row.nextSibling);
                });
            });

        // secondCategoryButtons.forEach(button => {
        //     button.addEventListener('click', (buttonValue) => {
        //         const secondVal = button.val();
        //         // 추가할 버튼의 HTML
        //         const newButtonHtml = `
        //         <tr style="height: 65px;">
        //             <td class="col-3" style="border-right: 2px solid #d5d2d2; font-family: NanumBarunGothic, serif;">
        //               <div class="text_mainCategory_preview">${secondVal}</div>
        //             </td>
        //             <td class="col-3" style="border-right: 2px solid #d5d2d2; font-family: NanumBarunGothic, serif;">
        //               <div class="text_detailCategory_preview" id="category_no">${buttonValue}</div>
        //             </td>
        //             <td class="col-3" style="border-right: 2px solid #d5d2d2; text-align: center; font-family: NanumBarunGothic, serif;">
        //               <button type="button" class="minus" onclick="fnCalcCnt('minus');">
        //                 <div style="width: 100%; height: 100%; position: absolute; top: -20px;">-</div>
        //               </button>
        //               <input type="text" class="count_category" name="item_cnt" title="수량 입력" value="1" maxlength="1">
        //               <button type="button" class="plus" onclick="fnCalcCnt('plus');">
        //                 <div style="width: 100%; height: 100%; position: absolute; top: -20px;">+</div>
        //               </button>
        //             </td>
        //             <td class="col-3">
        //               <div class="button_inputCategory_delete">
        //                 <input type="button" value="X" style="color: red; border: none; font-size: 28px;">
        //               </div>
        //             </td>
        //         </tr>
        //       `;
        //
        //         // 추가할 위치의 tr 태그 선택
        //         const preview_row = document.querySelector('#preview_row');
        //
        //         // 새로운 tr 태그 생성 및 추가할 버튼 HTML 추가
        //         const newTr = document.createElement('tr');
        //         newTr.innerHTML = newButtonHtml;
        //
        //         // tr 태그를 추가할 위치에 추가
        //         preview_row.parentNode.insertBefore(newTr, preview_row.nextSibling);
        //     });
        }
    });
});


//gpt 답변. 텍스트 길이에 따라 버튼 사이즈 조절

//     var myButton = document.getElementById("myButton"); // 버튼 요소 가져오기
//     var buttonWidth = myButton.offsetWidth; // 버튼의 초기 너비 저장
//
//     // 버튼의 텍스트 내용이 변경될 때마다 실행되는 함수
//     function adjustButtonWidth() {
//     var buttonValue = myButton.value; // 버튼의 텍스트 내용 가져오기
//     var textWidth = getTextWidth(buttonValue); // 버튼의 텍스트 길이 측정하기
//     var newWidth = Math.max(textWidth, buttonWidth); // 버튼의 너비 결정하기
//
//     myButton.style.width = newWidth + "px"; // 버튼의 너비 설정하기
// }
//
//     // 텍스트 길이를 측정하는 함수
//     function getTextWidth(text) {
//     var span = document.createElement("span"); // 측정용 span 요소 생성
//     span.style.visibility = "hidden"; // span 요소를 화면에서 숨김
//     span.style.whiteSpace = "nowrap"; // span 요소를 한 줄로 고정
//     span.innerHTML = text; // span 요소의 텍스트 내용 설정
//
//     document.body.appendChild(span); // span 요소를 body에 추가
//
//     var width = span.offsetWidth; // span 요소의 너비 측정
//
//     document.body.removeChild(span); // span 요소를 body에서 제거
//
//     return width;
// }
//
//     // 버튼의 텍스트 내용이 변경될 때 adjustButtonWidth 함수를 실행하도록 이벤트 리스너 등록
//     myButton.addEventListener("input", adjustButtonWidth);
