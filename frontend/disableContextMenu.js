document.addEventListener('contextmenu', function(event) {
    console.log("> prevent default for right click", event);
    event.preventDefault();
});

