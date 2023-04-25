/*
let header = document.querySelector('.top-header-area');

window.addEventListener('scroll', () => {
    if (window.scrollY > 0) {
        header.style.backgroundColor = '#fff'; // 배경색 변경
        header.style.color = '#333'; // 폰트 컬러 변경
        header.style.opacity = '0.9'; // 투명도 조절
    } else {
        header.style.backgroundColor = 'transparent';
        header.style.color = '#fff';
        header.style.opacity = '1';
    }
});*/

let header = document.querySelector('.top-header-area');

window.addEventListener('scroll', () => {
    if (window.scrollY > 0) {
        header.style.backgroundColor = '#fff'; // 배경색 변경
        header.querySelectorAll('a').forEach(a => {
            a.style.color = '#333'; // a 요소의 폰트 컬러 변경
        });
        header.style.opacity = '0.9'; // 투명도 조절
    } else {
        header.style.backgroundColor = 'transparent';
        header.querySelectorAll('a').forEach(a => {
            a.style.color = '#fff'; // a 요소의 폰트 컬러 변경
        });
        header.style.opacity = '1';
    }
});

