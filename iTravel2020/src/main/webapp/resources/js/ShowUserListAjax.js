$(document).ready(function () {
    console.log("Document is ready!!!");
    onLoadInitData();
    $('#add').click(onAdd);
    $('#upd').click(onUpd);
    $('#del').click(onDel);
    $('#toexcel').click(ExportToExcel);
    $('.deactiveUser').click(onUpdStatus);
    $('#showDeactiveUser').click(onDisplyShowDeactiveUser);
    // Search local
    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("AdminServlet",
        {cmdType: $cmdType},//没有action的名字，就直接到post方法，通过验证，再选择执行哪个
        onDisplyShowDeactiveUser
    );
}

function onAdd() {
    // Prepare parameters
    let $cmdType = "add";//定义一个字符串叫“add”
    let $id = $("#id").val();//从用户界面输入的东西
    let $gender = $("#title").val();
    let $author = $("#author").val();
    let $subject = $("#subject").val();
    let $isbn = $("#isbn").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, id:$id, title:$title, author:$author, subject:$subject, isbn:$isbn},
        dispBookList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    let $id = $("#id").val();
    let $activType = $("#title").val();

    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, id:$id, activType:$activType},
        displayDeactiveUser);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, id:$id},
        dispBookList);
}

function checkValidate() {
    // Prepare parameters
    let $id = $("#id").val();
    // Check validate
    if ($id.trim().length == 0) {
        alert("ID is required!");
        $("#id").focus();
        $('#isValid').val("false");
        return;
    }
    $('#isValid').val("true");
}

function dispBookList(respJson) {
    // Remove old Data
    //let $table = $('#books');
    //$table.find($('.book')).remove();
    // Update new data
    $.each(respJson, function(i, book){
        // New Row
        // let $aCheckOut = "<a href=bookCheckout.jsp?bookId=" + book.id + ">Checkout</a>";
        // let $aCheckOut = "<input type ='button' value=" + book.id + ">Checkout</a>";
        // let $aCheckOut = "<input type ='button' value=" + book.id + ">Checkout</a>";
        let $book = "<tr class=\"book\"><td>" + book.id + "</td><td>" + book.title + "</td><td>" + book.author + "</td><td>" + book.subject + "</td><td>" + book.isbn + "</td><td>" + $aCheckOut + "</td></tr>";
        $("#books").append($book);
    });
}

function ExportToExcel(mytblId){
    var htmltable= document.getElementById('books');
    var html = htmltable.outerHTML;
    window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
}


function onDisplyShowDeactiveUser() {
     alert("return value：");
    let $cmdType = "showDeactiveUser";

    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType},
        displayDeactiveUser);
}

function displayDeactiveUser(data){

    alert("return value：" + data);
    //Remove old Data
    let $table = $('#books');
    $table.find($('.book')).remove();
    //Update new data
    alert("before loop");
    $.each(data, function(i, user){
        // let $aStatus = '<input type="button" class="deactiveUser"  name=" deactive"  value= ' +user.id+'>';
        //let $aStatus = '<input type="button" class="deactiveUser"  value="deactive">';
        let $aStatus = '<button class="deactiveUser" value="+user.id+">deactive</button>';
        $aStatus + "</td></tr>";
        let $user = "<tr class=\"book\">"
            + "<td>" + user.id + "</td>"
            + "<td>" + "user.fullName" +"</td>"
            + "<td>" + "user.email" +"</td>"
            + "<td>" + user.userType +"</td>"
            + "<td>" + $aStatus +"</td>"
            + "</tr>";
        $("#books").append($user);

    });

    /*像在jsp文件中写了这些行
    <table id="myTable">
                    <tr class="book">
                        <td>ID1</td>
                        <td>TIT444LE</td>
                        <td>AUTHORyyy</td>
                        <td>SUBJEuuuuCT</td>
                        <td>ISBjjjjN</td>
                        <td></td>
                    </tr>
                </table>
     */
}
function onUpdStatus(){
    alert("this");
    // Prepare parameters
    let $cmdType = "upd";
    let $id = this.val();
    alert(this);
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, id:$id},
        displayDeactiveUser);
}