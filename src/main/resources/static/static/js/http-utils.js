function put(data, destUrl, successCallback, errorCallback, alwaysCallback) {
    _ajax(data, destUrl, 'PUT', successCallback, errorCallback, alwaysCallback);
}

function get(destUrl, successCallback, errorCallback, alwaysCallback) {
    _ajax(null, destUrl, 'GET', successCallback, errorCallback, alwaysCallback);
}

function post(data, destUrl, successCallback, errorCallback, alwaysCallback) {
    _ajax(data, destUrl, 'POST', successCallback, errorCallback, alwaysCallback);
}

function delet(destUrl, successCallback, errorCallback, alwaysCallback) {
    _ajax(null, destUrl, 'DELETE', successCallback, errorCallback, alwaysCallback);
}

function _ajax(data, destUrl, verb, successCallback, errorCallback, alwaysCallback) {
    var jqxhr = $.ajax({
        url: destUrl,
        type: verb,
        contentType: "application/json",
        data: data,
        beforeSend: function (request) {
            _setApiKeyHeader(request);
        }
    }).done(function (data, textStatus, jqXHR) {
        console.log(data);
        if (successCallback) {
            successCallback(data, textStatus, jqXHR);
        }
    }).fail(function (jqXHR, textStatus, errorThrown) {
        console.log(data);
        if (errorCallback) {
            errorCallback(jqXHR, textStatus, errorThrown);
        } else {
            genericErrorCallback(jqXHR, textStatus, errorThrown);
        }
    }).always(function () {
        if (alwaysCallback) {
            alwaysCallback(); // TODO parámetros
        }
    });
}

function _setApiKeyHeader(request){
    request.setRequestHeader("X-CSRF-TOKEN", "cb1ff7f6bbd56b9eedaaf1987251e856694ae5c2");
}

export {
    get,
    post,
    put,
    delet
}; // a list of exported variables