    // Get the button:
/*    let topbtn = document.getElementById("top_btn");

    // When the user scrolls down 20px from the top of the document, show the button
    window.onscroll = function() {scrollFunction()};

    function scrollFunction() {
    if (document.body.scrollTop > 10 || document.documentElement.scrollTop > 10) {
    topbtn.style.display = "block";
} else {
    topbtn.style.display = "none";
}
}*/

    // When the user clicks on the button, scroll to the top of the document
    function topFunction() {
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}

/* 스크롤 */
    $(document).ready(function($) {

        $(".scroll_move").click(function(event){

            event.preventDefault();

            $('html,body').animate({scrollTop:$(this.hash).offset().top}, 500);

        });

    });

