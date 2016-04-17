export default class fbDataService {
    constructor() {
        FB.init({
            appId      : '226661761033677',
            xfbml      : true,
            version    : 'v2.6'
        });

        this.addPost = (msg, img) => {
            if (img) {
                FB.api()
            }
            FB.api('/me/feed', 'post', {message: msg},
                {scope: 'publish_actions'});
        };

        // this.retrievePostsByGeo = () => {
        //     FB.api(
        //         "?fields={fieldname_of_type_Location}",
        //         function (response) {
        //             if (response && !response.error) {
        //                 /* handle the result */
        //             }
        //         }
        //     );
        // };

        this.getUserName = (userId, callback) => {
            FB.api(
                "/" + userId, (response) => {
                    if (response && !response.error) {
                        if (angular.isFunction(callback)) {
                            callback(response.name);
                        }
                    }
                    //TODO: handle error
                }
            );
        };

        this.getUserPic = (userID, callback) => {
            FB.api("/" + userID + '/picture', (response) => {
                    if (response && !response.error) {
                        if (angular.isFunction(callback))
                            callback(response.data.url);
                    }
                }
            );
        };

        this.fbLogin = (callback) => {
            FB.getLoginStatus(function(response) {
                if (response.status === 'connected') {
                    console.log('Logged in.');
                    if (angular.isFunction(callback)) {
                        callback(response);
                    }
                }
                else {
                    FB.login((response) => {
                        // debugger;
                        if (response.status === 'connected') {
                            if (angular.isFunction(callback)) {
                                callback(response);
                            }
                        }
                        // console.log(response);
                    });
                }
            });
        }
    }
}