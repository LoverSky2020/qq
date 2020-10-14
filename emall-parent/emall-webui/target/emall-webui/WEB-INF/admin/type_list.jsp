<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>类目列表</title>
    <meta charset="utf-8"/>

</head>
<body>
<div class="container">

    <%@include file="header.jsp" %>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
    <script src="admin/js/jquery.js"></script>

    <script src="admin/js/layer/layer.js"></script>
    <div class="text-right"><a class="btn btn-warning" href="admin/type/save/page">添加类目</a></div>

    <br>

    <table id="type" class="table table-bordered table-hover">

        <tr>
            <th width="5%">ID</th>
            <th width="10%">名称</th>
            <th width="5%">序号</th>
            <th width="10%">操作</th>
        </tr>


    </table>

</div>
</body>

<script>
    $(function () {

        init();




        })

        // 删除
        $(document).on("click", ".btn-danger", function () {
            var id = $(this).parent("td").find("input:eq(0)").val()

            //询问框

            layer.confirm('确认删除吗？', {
                btn: ['确认', '取消'] //按钮
            }, function () {
                // layer.msg('的确很重要', {icon: 1});
                $.ajax({
                    url: "admin/type/" + id,
                    type: "post",
                    data: {_method: "DELETE"},
                    success: function (response) {
                        layer.msg("删除成功！")
                        init();
                    },
                    error: function () {
                        layer.msg("删除成功！")
                        init();
                    }
                })
            }, function () {
                layer.msg('已取消');
            });



    })

    function init() {
        $("#type").empty();
        $.ajax({
            url: "admin/type/list",
            "type": "get",
            success: function (response) {
                console.log(response)
                let data = response.data;

                for (let i = 0; i < data.length; i++) {
                    let tr = '<tr><td>' + data[i].id + '</td>';
                    let editBtn = '<a class="btn btn-primary" href="admin/type/edit/'+data[i].id+'">修改</a>';
                    let delBtn = '<button class="btn btn-danger">删除</button>';
                    tr += '<td>' + data[i].name + '</td>'
                    tr += '<td>' + data[i].num + '</td>'
                    tr += '<td> ' + editBtn + delBtn + '<input type="hidden" value=' + data[i].id + '/>' + ' </td>'
                    $("#type").append(tr)
                }
            }
        })
    }

</script>
</html>