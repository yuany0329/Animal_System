//自动轮播

let currentSlide = 0; // 当前显示的slide索引
const slides = document.querySelectorAll('.carousel-slide'); // 获取所有轮播项
const totalSlides = slides.length; // 轮播项总数

function showSlide(index) {
    // 确保索引在有效范围内
    if (index >= totalSlides) { currentSlide = 0; }
    if (index < 0) { currentSlide = totalSlides - 1; }
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none"; // 先隐藏所有slide
    }
    slides[currentSlide].style.display = "flex"; // 显示当前slide
    // 可以在这里添加更新指示器或分页点的逻辑
}

function changeSlide(n) {
    showSlide(currentSlide += n); // 更新并显示slide
}

// 可选：添加自动播放功能
setInterval(function() {
    changeSlide(1); // 每3秒切换到下一张slide
}, 3000);

// 初始化时显示第一张slide
showSlide(currentSlide);