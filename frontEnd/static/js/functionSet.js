
/**
 *
 * @param preNode:需要在他后面添加兄弟元素
 * @returns {HTMLParagraphElement}
 */
function addBroNode(preNode) {
  let checkInfo = preNode.parentElement.appendChild(document.createElement("p"));
  checkInfo.className = "confirm";
  return checkInfo;
}

/**
 * 用来验证两次输入是否一致
 * @param firstInput:ID选择器得到的第一次输入元素的对象
 * @param secondInput:ID选择器得到的第二次输入元素的对象
 * @param checkInfo:第二个节点的后一个兄弟节点
 */
function checkTwice(firstInput, secondInput, checkInfo) {
  setInterval(function () {
    if (firstInput.value !== "") {
      switch (firstInput.value !== secondInput.value) {
        case true:
          checkInfo.innerText = "wrong";
          break;
        case false:
          checkInfo.innerText = "right";
          break;
      }
    } else {
      checkInfo.innerText = "input the prior one first";
    }
  }, 1000)
}


/**
 *用来判断输入框中的内容是否符合输入的规范
 * @param reg:输入条例的正则表达式
 * @param inputInfo:使用jquery ID选择器选择到的元素对象
 * @param broNode
 */
function checkInput(reg, inputInfo, broNode) {
  setInterval(function () {
    let info = reg.test(inputInfo.value);
    if (info) {
      broNode.innerText="legal";
    } else {
      broNode.innerText="illegal";
    }
  }, 1000)
  console.log("1111")
}

/**
 *
 * @param arr:checkInfo数组,用来存储输入是否合法的结果
 * @returns {boolean}:阻止默认事件
 */
function checkSubmit(arr) {
  if (arr.includes(false)) {
    alert("correct your input");
    return false;
  }
}


/**
 *
 * @param password:第一次输入密码框的ID
 * @param password_reput:确认密码框的ID
 */
function twiceCheck(password, password_reput) {
  passwordNode = document.getElementById(password);
  password_reputNode = document.getElementById(password_reput);
  password_reputNode.pattern = passwordNode.value;
  console.log(password + ".value:" + passwordNode.value);
  console.log(password_reput + ".pattern:" + password_reputNode.pattern);
}
