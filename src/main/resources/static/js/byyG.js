let currentIndex = 0; // 通常从 0 开始索引
const contents = document.querySelectorAll('.content'); // 获取所有内容块

if (contents.length > 0) {
    // 如果有内容，则设置第一个为激活状态
    contents[currentIndex].classList.add('active');
}

window.addEventListener('wheel', function(event) {
    event.preventDefault(); // 阻止默认滚动行为

    // 判断滚轮方向
    if (event.deltaY > 0) {
        // 向下滚动
        if (currentIndex < contents.length - 1) { // 确保不会超出最后一个元素
            currentIndex++;
        }
    } else {
        if (currentIndex > 0) { // 确保不会变成负数
            currentIndex--;
        }
    }

    // 隐藏所有内容
    contents.forEach(content => {
        content.classList.remove('active');
    });

    // 显示当前内容
    if (currentIndex >= 0 && currentIndex < contents.length) { // 确保索引有效
        contents[currentIndex].classList.add('active');
    }
});