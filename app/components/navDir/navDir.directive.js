import './navDir.template.html';

export default class navDir {
    constructor() {
        return {
            name: 'nav',
            restrict: 'E',
            replace: true,
            templateUrl: './components/navDir/navDir.template.html',
            link: ($scope) => {
                //console.log($scope);
            },
            controller: navDirController,
            controllerAs: "navCtrl"
        }
    }
}

class navDirController {
    constructor($rootScope, $state, utilsService) {

        this.tag = 'skyporn';

        $rootScope.$on("puttaginnavbar", (event, tag)=> {
            tag = tag.split(" ")[0].replace("#", "");
            this.tag = tag;
            utilsService.safeApply();
            //$rooScope.broadcast();
            $state.go("home.search").then(()=> {
                $rootScope.$emit("searchtag", "#" + tag);
            });
        });


        this.searchTag = () => {
            this.tag = this.tag.split(" ")[0].replace("#", "");
            //$rooScope.broadcast();
            $state.go("home.search").then(()=> {
                $rootScope.$emit("searchtag", "#" + this.tag);
            });
        }
    }
}
