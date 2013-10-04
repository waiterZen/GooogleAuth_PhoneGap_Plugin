cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/com.waiter.phonegap.oauth2Plugins/www/googleAuth.js",
        "id": "com.waiter.phonegap.oauth2Plugins.googleAuth",
        "clobbers": [
            "window.googleAuth"
        ]
    }
]
});