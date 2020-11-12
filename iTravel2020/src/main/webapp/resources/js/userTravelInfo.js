window.onload = function(){
    getCurrentUser();
}
function getCurrentUser() {
    console.log('call getCurrentUser');
    $.post("GetCurrentUserInfoServlet")
        .done(function (user){
            console.log(user);
            displayUserInfo(user);

        })
        .fail(function(error){
            console.error(error);
        });
}
function displayUserInfo(user){
    $('#name').html(user.fullName);
    $('#id').html(user.id);
    $('#gender').html(user.gender);
    $('#year').html(user.birthYear);
    $('#email').html(user.email);
    $('#address').html(user.street +", " + user.city+ ","+user.state);

}