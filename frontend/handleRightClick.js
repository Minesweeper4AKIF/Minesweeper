window.ns = {

    init: function(btn, view, row, column) {
        btn.addEventListener('contextmenu', async function(event) {
            // Prevent the default context menu from appearing
            event.preventDefault();
            await view.$server.btnRightClicked(row, column);
        });
    }

}

