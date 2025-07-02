var imgs = document.getElementsByTagName("img");
var btns = document.getElementsByTagName("span");
var ul = document.getElementsByTagName("ul");
var lis = document.getElementsByTagName("li");
var len = imgs.length;
var current = 0;
let flag = true;
var timer;

function wrapper() {
    frount();
    bind();
    getLi();
    btnClick();
    showLis();
    autoplay();
};
wrapper();

// 图片移动
function frount() {
    var mlen = Math.floor(len / 2);
    var limg, rimg;
    for (var i = 0; i < mlen; i++) {
        limg = len + current - i - 1;
        rimg = current + i + 1;
        if (limg >= len) {
            limg -= len;
        }
        if (rimg >= len) {
            rimg -= len;
        }
        imgs[limg].style.transform = `translateX(` + (150) * (i + 1) + `px) translateZ(` + (200 - i * 100) + `px) rotateY(-30deg)`;
        imgs[rimg].style.transform = `translateX(` + (-150) * (i + 1) + `px) translateZ(` + (200 - i * 100) + `px) rotateY(30deg)`;
    }
    imgs[current].style.transform = `translateZ(300px)`;

};

// 点击图片
// 点击任意图片会将其切换到中心位置，悬停图片时暂停自动轮播
function bind() {
    for (var i = 0; i < len; i++) {
        (function (i) {
            imgs[i].onclick = function () {
                current = i;
                frount();
                autoLi();
            }
        })(i);
        imgs[i].onmouseenter = function () {
            clearInterval(timer);
        }
        imgs[i].onmouseout = function () {
            autoplay();
        }
    }
};

// 自动更换图片
function autoplay() {
    timer = setInterval(function () {
        if (current >= len - 1) {
            current = 0;
        } else {
            current++;
        }
        frount();
        autoLi();
    }, 2000)
}

// 点击左右按钮
function btnClick() {
    for (var i = 0; i < btns.length; i++) {
        (function (i) {
            btns[i].onclick = function () {
                if (!flag) { return; }
                flag = false;
                // 左按钮
                if(i==0){
                    if (current <= 0) {
                        current = len - 1;
                    } else {
                        current--;
                    }
                }
                // 右按钮
                if(i==1){
                    if (current >= len - 1) {
                        current = 0;
                    } else {
                        current++;
                    }

                }
                setTimeout(() => { //防抖
                    flag = true;
                }, 800);
                frount();
                autoLi();
            }
        })(i);
        btns[i].onmouseenter = function () {
            clearInterval(timer);
        }
        btns[i].onmouseout = function () {
            autoplay();
        }
    }
};

// 点击小圆圈
function getLi (){
    for(var i = 0; i < len; i++){
        (function (i) {
                ul[0].innerHTML +="<li></li>"
            }
        )(i);
    }
    lis[0].classList.add("current")
}

function showLis() {
    for (var i = 0; i < len; i++) {
        (function (i) {
            lis[i].onclick = function () {
                // 排他思想
                for (var k = 0; k < len; k++) {
                    lis[k].classList.remove("current")
                }
                this.classList.add("current")
                current = i;
                frount();
            }
        })(i);
        lis[i].onmouseenter = function () {
            clearInterval(timer);
        }
        lis[i].onmouseout = function () {
            autoplay();
        }
    }
}
function autoLi() {
    for (var i = 0; i < len; i++) {
        if (i == current) {
            lis[i].classList.add("current")
        } else {
            lis[i].className = '';
        }
    }
}
