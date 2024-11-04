// 获取页面中id为'switch-cnt'的元素
let switchCtn = document.querySelector("#switch-cnt");

// 获取页面中id为'switch-c1'的元素
let switchC1 = document.querySelector("#switch-c1");

// 获取页面中id为'switch-c2'的元素
let switchC2 = document.querySelector("#switch-c2");

// 获取页面中所有类名为'switch_circle'的元素
let switchCircle = document.querySelectorAll(".switch_circle");

// 获取页面中所有类名为'switch-btn'的元素
let switchBtn = document.querySelectorAll(".switch-btn");

// 获取页面中id为'a-container'的元素
let aContainer = document.querySelector("#a-container");

// 获取页面中id为'b-container'的元素
let bContainer = document.querySelector("#b-container");

// 获取页面中所有类名为'submit'的元素
let allButtons = document.querySelectorAll(".submit");

// 定义一个函数，用于阻止表单的默认提交行为
let getButtons = (e) => e.preventDefault();

// 定义一个函数，用于切换表单和相关元素的样式
let changeForm = (e) => {
    // 添加类名'is-gx'，并设置定时器在1500毫秒后移除该类名
    switchCtn.classList.add("is-gx");
    setTimeout(function () {
        switchCtn.classList.remove("is-gx");
    }, 1500);

    // 切换类名'is-txr'
    switchCtn.classList.toggle("is-txr");
    switchCircle[0].classList.toggle("is-txr");
    switchCircle[1].classList.toggle("is-txr");

    // 切换类名'is-hidden'
    switchC1.classList.toggle("is-hidden");
    switchC2.classList.toggle("is-hidden");

    // 切换类名'is-txl'和'is-z'
    aContainer.classList.toggle("is-txl");
    bContainer.classList.toggle("is-txl");
    bContainer.classList.toggle("is-z");
};

// 定义一个函数，用于为所有按钮添加点击事件监听器
let shell = (e) => {
    // 遍历所有类名为'submit'的元素，为它们添加点击事件监听器，调用getButtons函数
    for (var i = 0; i < allButtons.length; i++) {
        allButtons[i].addEventListener("click", getButtons);
    }

    // 遍历所有类名为'switch-btn'的元素，为它们添加点击事件监听器，调用changeForm函数
    for (var i = 0; i < switchBtn.length; i++) {
        switchBtn[i].addEventListener("click", changeForm);
    }
};

// 当窗口加载完成后，调用shell函数
window.addEventListener("load", shell);

// 获取登录按钮元素
let loginButton = document.querySelector(".submit");

// 为登录按钮添加点击事件监听器
loginButton.addEventListener("click", function (event) {
    event.preventDefault(); // 阻止表单默认提交行为

    // 在这里处理登录逻辑，例如发送 AJAX 请求到服务器验证用户凭据
    // 示例代码：
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "login.do", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // 处理服务器返回的响应，例如根据返回的状态码或消息显示登录成功或失败的提示
            console.log(xhr.responseText);
        }
    };
    xhr.send("username=" +
        encodeURIComponent(document.querySelector(".form_input").value) + "&password=" + encodeURIComponent(document.querySelector(".form_input").value));
});