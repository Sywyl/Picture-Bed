/**
 * <p>Title: 首页</p>
 * <p>Company: http://www.ymq.io </p>

 * @Describe:
 * @Author: penglei
 * @Email:<a href="admin@souyunku.com"/></a>
 * @CreateDate: 2017/9/9 21:26

 感谢开原作者：krajee

 http://plugins.krajee.com/file-input-ajax-demo/1

 https://github.com/kartik-v/bootstrap-fileinput/

 **/


$("#file").fileinput({
    uploadUrl: 'ymq/cloudStorage/upload',
    allowedFileExtensions: ['jpeg', 'jpg', 'png', 'gif', 'bmp'],
    overwriteInitial: false,
    maxFileSize: 12120,
    maxFilesNum: 10,
    maxFileCount: 10,
    language: 'zh',

});


$('#file').on('fileuploaded', function (event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra, response = data.response, filenames = data.filenames,reader = data.reader;
    if (response.retCode == '000000') {
        if ($("showurl").css("display")) {
            $('#html').append("&lt;img src=\"" + response.result.url + "\" alt=\"" + files[index].name + "\" title=\"" + files[index].name + "\" /&gt;" + "\n");
            $('#markdown').append("![" + files[index].name + "](" + response.result.url + ")" + "\n");
            $('#markdownlink').append("[![" + files[index].name + "](" + response.result.url + ")]" + "(" + response.result.url + ")" + "\n");
            $('#url').append(response.data.url + "\n");

        } else if (response.result.url) {
            $("#showurl").show();
            $('#html').append("&lt;img src=\"" + response.result.url + "\" alt=\"" + files[index].name + "\" title=\"" + files[index].name + "\" /&gt;" + "\n");
            $('#markdown').append("![" + files[index].name + "](" + response.result.url + ")" + "\n");
            $('#markdownlink').append("[![" + files[index].name + "](" + response.result.url + ")]" + "(" + response.result.url + ")" + "\n");
            $('#url').append(response.result.url + "\n");

        }
    }
});