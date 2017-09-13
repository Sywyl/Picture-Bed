/**
 * <p>Title: 通用的组件</p>
 * <p>Company: http://www.ymq.io </p>

 * @Describe:
 * @Author: penglei
 * @Email:<a href="admin@souyunku.com"/></a>
 * @CreateDate: 2017/9/9 21:26
 **/

/**
 * /js方法：序列化表单
 * @param form 对象
 * @returns {{}}
 */
function serializeForm(form) {
    var obj = {};
    $.each(form.serializeArray(), function (index) {
        if (obj[this['name']]) {
            obj[this['name']] = obj[this['name']] + ',' + $.trim(this['value']);
        } else {
            obj[this['name']] = $.trim(this['value']);
        }
    });
    return obj;
}

/**
 * Tab的切换功能，切换事件监听等，需要依赖element模块
 */
layui.use('element', function () {
    var $ = layui.jquery, element = layui.element;
});

/**
 * 复制外链
 * @param data 数据
 */
function copylink(data) {

    var  htmlContent ='&lt;img src="' + data.url + '" alt="' + data.name + '" title="' + data.name + '" /&gt; ';

    layer.open({
        type: 1,
        area: ['1000px', '293px'],
        shade: false,
        title: false,
        content: '<input id="copyHtml" type="text" value="'+htmlContent+'" />'
        +'<button style="margin: 10px 10px;" class="layui-btn layui-btn-normal layui-btn-mini" data-clipboard-action="copy" data-clipboard-target="#copyHtml" id="btnCopyHtml" >点击复制：HTML</button>'
    });
}

/**
 * 预览图片
 * @param data 数据
 */
function previewImages(data) {

    var height = $(window).height() - 50;
    var width = $(window).width() - 50;

    if (data.height < height) {
        height = data.height;
    }
    if (data.width < width) {
        width = data.width;
    }
    layer.open({
        type: 1,
        area: [width + "px", (height + 42) + "px"],
        title: "您正在预览：" + data.name,
        shadeClose: true,
        maxmin: true, //开启最大化最小化按钮
        content: '<img  class="vertical-center" src="' + data.url + '" >'
    });
}



