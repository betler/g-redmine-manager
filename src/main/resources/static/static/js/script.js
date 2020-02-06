import * as RedmineClient from './g-redmine-js-client.js';

$(function() {
    
    let rmClient = new RedmineClient.GRedmineJsClient({
        "url" : "https://redmine/"
    });

    // Turn aplicable combos into select2
    $('#projectsCombo').select2();
    rmClient.whoAmI();

    //$('#loginModal').modal('show');
});