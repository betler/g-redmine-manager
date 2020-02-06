import {get, post} from './http-utils.js';
export class GRedmineJsClient {

    constructor(config = {}) {
        if (!config.url) throw new Error('You must specify a url. I cannot guess where your Redmine is.');
        this._config = config;

        this._USERS_URL = '/users';
        this._USERS_CURRENT_URL = `${this._USERS_URL}/current.json`;
    }

    // Adding a method to the constructor
    whoAmI() {
        get(`https://www.altia.es/dedalo${this._USERS_CURRENT_URL}`)
    }
}