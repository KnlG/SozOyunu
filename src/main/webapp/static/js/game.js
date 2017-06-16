/**
 * Created by Konul Gurbanli on 6/6/2017.
 */

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
    // ev.target.style.backgroundColor="white";
}

function drop(ev, el) {
    ev.preventDefault();
    var t = el.innerHTML;
    var data = ev.dataTransfer.getData("text");
    var first = document.getElementById(data);
    el.innerHTML = first.innerHTML;
    first.innerHTML=t;
    // first.style.backgroundColor="violet";
}

function getWord(){
    var word='';
    $('.letter').each(function(){
        word+=$(this).find("span").text().trim();
    });
    console.log(word.trim());
    return word.trim().toLowerCase();
}

// $(window).resize(function(){
//
//     $('#container').css({
//         position:'absolute',
//         left: ($(window).width() - $('#container').outerWidth())/2,
//         top: ($(window).height() - $('#container').outerHeight())/2
//     });
//
// });
