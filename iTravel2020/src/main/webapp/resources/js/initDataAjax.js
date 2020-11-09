// alert("");
$(document).ready(function () {
    // console.log("Document is ready!!!");
    onLoadInitData();
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("initDataServlet",
        {cmdType: $cmdType},
        function () {alert("data loaded...!");});
}

