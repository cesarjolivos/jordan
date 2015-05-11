/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.fbAsyncInit = function () {
    FB.init({
        appId: '637246319742937',
        xfbml: true,
        version: 'v2.3'
    });
};

(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {
        return;
    }
    js = d.createElement(s);
    js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function publicaMensaje(message,loc) {
    FB.login(function () {
        FB.api('/me/feed', 'post',
                {message: 'En '+loc+': '+message+' - Visitanos en: http://jordan-sooftw.rhcloud.com/jordan-1/'});
    }, {scope: 'publish_actions'}
    );
}

function redireccionar(message,nombreLocal) {
    var pagina="https://twitter.com/intent/tweet?text=";
    var url = pagina.concat('En '+nombreLocal+': '+message+' - Visitanos en: http://jordan-sooftw.rhcloud.com/jordan-1/');
    location.href=url;
} 