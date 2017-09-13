/**
 * <p>Title: 瀑布流 </p>
 * <p>Company: http://www.ymq.io </p>

 * @Describe:
 * @Author: penglei
 * @Email:<a href="admin@souyunku.com"/></a>
 * @CreateDate: 2017/9/9 21:28
 **/

/**
 * 绑定  瀑布流 form 搜索按钮
 */

$('#submitPForm').click(function () {
    $("li[name='pinterest']").remove();
    $(".layui-flow-more").remove();
    var params = serializeForm($("#pForm"))
    pinterest(params);
});


/**
 * 初始化瀑布流
 */
layui.use('flow', function () {
    pinterest(null);
});

/**
 * 瀑布流入口方法
 * @param params
 */
function pinterest(params) {


    $("#pinterest").css("height", $(window).height() + "px");


    var flow = layui.flow;
    flow.load({
        elem: '#pinterest' //流加载容器
        , scrollElem: '#pinterest'
        , isAuto: true
        , isLazyimg: true
        , done: function (pageNum, next) { //执行下一页的回调

            //数据插入
            $.ajax({
                url: "/ymq/cloudStorage/getImagesList",
                data: {params: JSON.stringify(params), pageNum: pageNum, pageSize: 8},
                type: 'get',
                success: function (data) {
                    if (data.code == "000000") {

                        prependImages(params, pageNum, next, data);

                    } else {
                        layer.msg('查询失败：' + data.msg, {time: 2000,});
                    }
                }, error: function (e) {
                    layer.msg('查询失败：' + e, {time: 2000,});
                }
            });
        }
    });

}

/**
 * 添加标签
 * @param params
 * @param pageNum
 * @param next
 * @param data
 */
function prependImages(params, pageNum, next, data) {

    var listData = [];

    layui.each(data.data, function (index, item) {

        var resData = JSON.stringify(item);

        listData.push(
            '<li name="pinterest"><img src="' + item.url + '" >'
            + '<div  class="layui-btn-group" style="margin-top: -25px" > '


            + '<button value= "' + item.imagesId + '" onclick="methodType(this,1)" class="layui-btn layui-btn-primary layui-btn-mini"><i class="layui-icon">&#xe641;</i>复制外链</button>'
            + '<button value= "' + item.imagesId + '" onclick="p_btn_download(this)"  class="layui-btn layui-btn-primary layui-btn-mini"><i style="color: #01AAED;" class="layui-icon">&#xe601;</i>下载</button>'
            + '<button value= "' + item.imagesId + '" onclick="methodType(this,2)" class="layui-btn layui-btn-primary layui-btn-mini"><i style="color: #5FB878;" class="layui-icon">&#xe64a;</i>预览</button>'

            + '<span id= "' + item.imagesId + '" style="display:none;">' + resData + '</span>'
            + '</div></li>'
        )
    });

    var pageCount = data.count / 8;

    if (pageCount <= 1) {
        pageCount = 1
    }
    if (params != null) {
        $("#pinterest").prepend(listData.join(''));

        next(null, pageNum < pageCount);
    } else {
        next(listData.join(''), pageNum < pageCount);
    }

}


//瀑布流，下载图片
function p_btn_download(event) {
    var url = event.value;

    var data = $("#" + event.value).text();

    layer.msg(data);
}


/**
 * 根据类型调用方法
 * @param obj
 * @param type 1:复制外链，2.预览图片
 */
function methodType(obj, type) {

    var data = JSON.parse($("#" + obj.value).text());

    if (type == 1) {

        copylink(data); //复制外链

    } else if (type == 2) {

        previewImages(data);  //预览图片
    }

}
