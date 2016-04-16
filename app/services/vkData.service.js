export default class vkDataService {
    constructor($rootScope, networks) {
        VK.init({
            apiId: networks.vk.appId
        });

        this.retrievePostsByGeo = (successCallback, failureCallback) => {
            let geo = navigator.geolocation.getCurrentPosition((geo) => {
                console.log(geo);
                VK.Api.call('newsfeed.search', {
                    latitude: geo.coords.latitude,
                    longetude: geo.coords.longitude,
                    count: 100,
                    v: '5.50',
                    start_time: geo.timestamp - 60000
                }, (r) => {
                    if (r.response) {
                        if (angular.isFunction(successCallback)) {
                            successCallback(r.response);
                        }
                        return;
                    }
                    if (angular.isFunction(failureCallback)) {
                        failureCallback(r.response);
                    }
                });
            }, (error) => {
                console.log('error', error);
                failureCallback(error);
            }, {
                timeout: Infinity,
                enableHighAccuracy: true,
                maximumAge: 0
            });
        };

        this.loginVk = (successCallback, failCallback) => {
            //debugger;
            VK.Auth.getLoginStatus((response) => {
                if (response.session && response.session.user) {
                    //debugger;
                    if (angular.isFunction(successCallback)) {
                        successCallback(response.session.user);
                    }
                    //vkDataFactory.parseAuthRequest(response.session);
                    return;
                }
                VK.Auth.login((response) => {
                    if (!response.session) {
                        if (angular.isFunction(failCallback)) {
                            failCallback(response);
                        }
                        return;
                        //broadcast an error
                    }
                    if (response.session) {
                        successCallback(response.session.user);
                        return response.session;
                    }
                });
            });
        };


        this.addPost = (newPost, successCallback, failureCallback) => {
            VK.Auth.getLoginStatus((response) => {
                if (response.session && response.session.user) {

                    VK.Api.call('wall.post', {
                        owner_id: response.session.user.id,
                        message: newPost.text + ' ' + newPost.tags,
                        //TODO: ATTENTION TO FRIENDS ONLY
                        friends_only: 1
                    }, (r) => {
                        console.log(r);
                        if (r.response) {
                            if (angular.isFunction(successCallback)) {
                                successCallback(r.response);
                            }
                            return;
                        }
                        if (angular.isFunction(failureCallback)) {
                            if (r.error && r.error.error_code == 15) {
                                failureCallback('vkNotAccess');
                            } else {
                                failureCallback();
                            }
                        }
                    });

                } else {
                    //TODO: error dispatch
                    if (angular.isFunction(failureCallback)) {
                        failureCallback('vkNotLogged');
                    }
                }

            });
        };


    }
}