export default class homeController {
    constructor($rootScope, vkDataService, utilsService) {
        console.log('mainCtrl');
        this.user = {
            firstName: '',
            lastName: '',
            photoSrc: ''
        };
        this.sidePanelOpened = false;

        // if (VK.Auth.getSession()) {
        //     //https://vk.com/dev/wall.get
        //    VK.Api.call('wall.get', {owner_id: VK.Auth.getSession().mid, count: 100, v: 5.50}, function (r) {
        //        if (r.response) {
        //            console.log(r);
        //            $scope.count = r.response.count;
        //            $scope.posts = r.response.items;
        //            $scope.$apply();
        //        }
        //    });
        // }
    }
}
