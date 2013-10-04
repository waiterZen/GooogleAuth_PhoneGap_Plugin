var googleAuth =  {
    authorize: function(username,password, successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'googleAuth', // mapped to our native Java class called "Calendar"
            'start_auth', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "username": username,
                "password": password
            
            }]
        );
    }
}
module.exports = calendar;