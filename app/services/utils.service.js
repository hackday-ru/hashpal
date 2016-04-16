export default class utilsService {
    constructor($rootScope) {
        this.safeApply = () => {
            var phase = $rootScope.$$phase;
            if (phase == '$apply' || phase == '$digest') {
                $rootScope.$eval();
            }
            else {
                $rootScope.$apply();
            }
        };

    }
}