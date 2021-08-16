

var current =0
var slide = $('.item').find('.slide')
var count = slide.length

//애니매이션 추가 함수 
function animate(index) {
    $('.item').animate({left: -100*index+'%'},1000,'linear')
    current=index
    updateNav();
    
}


//화살표 좌우 이동 맨 끝일시 지우기 
function updateNav(){
    var prev= $('.arrow').find('.fa-arrow-left')
    var next=$('.arrow').find('.fa-arrow-right')
    if(current==0){
        prev.addClass('disabled')

    }else{
        prev.removeClass('disabled')

    }
    if(current==count-1){
        next.addClass('disabled')

    }else{
        next.removeClass('disabled')
    }
    //버튼 색 채우기 
    $('.btn').find('a').removeClass('active')
    $('.btn').find('a').eq(current).addClass('active')

}
//화살표 좌우 이동
$('.arrow').find('i').click(function(e) {
    if($(this).hasClass('fa-arrow-left')){
        animate(current-1)
    }else{
        animate(current+1)
    }
    
})
// 버튼이동
$('.btn').find('a').click(function (e) { 
    e.preventDefault();
    var idx = $(this).index();
    animate(idx)

    
    
});

updateNav();

setInterval(function(){
    var nexindex=(current+1)%count;
    animate(nexindex);

},5000)

$(window).scroll(function () {
    var scroll_top = $(this).scrollTop();
    console.log(scroll_top)
    if(scroll_top>=490){
        $('.header').css('background-color','black').css("transition","1s");
        $('.icon').css('color','white');
        $('.log-in').css('color','white');
        $('.sign').css('color','white');

        $('.icon').hover(function () {
            $(this).css('color','gray');
            
        }, function () {
            $(this).css('color','white')
        }
    );

        $('.log-in').hover(function () {
            $(this).css('color','gray');
            
        }, function () {
            $(this).css('color','white')
        }
        );

        $('.sign').hover(function () {
            $(this).css('color','gray');
            
        }, function () {
            $(this).css('color','white')
        }
        );
        
    }
    else{
        $('.header').css('background-color','#f0f0f0').css("transition","1s");
        $('.icon').css('color','black');
        $('.log-in').css('color','black');
        $('.sign').css('color','black');

        $('.icon').hover(function () {
                $(this).css('color','white');
                
            }, function () {
                $(this).css('color','black')
            }
        );

        $('.log-in').hover(function () {
            $(this).css('color','white');
            
        }, function () {
            $(this).css('color','black')
        }
        );

        $('.sign').hover(function () {
            $(this).css('color','white');
            
        }, function () {
            $(this).css('color','black')
        }
        );

    }
    
});
