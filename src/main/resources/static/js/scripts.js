window.addEventListener('DOMContentLoaded', event => {
    const listHoursArray = document.body.querySelectorAll('.list-hours li');
    listHoursArray[new Date().getDay()].classList.add(('today'));
})
// Custom scripts for your theme
document.addEventListener('DOMContentLoaded', function() {
    console.log("Custom script loaded.");
});

