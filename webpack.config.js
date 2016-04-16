var path = require("path");
module.exports = {
    devtool: 'source-map',
    entry: path.resolve(__dirname + '/app/app.js'),
    context: path.resolve(__dirname + '/app'),
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname + '/app/build'),
        publicPath: path.resolve(__dirname + '/app/')
    },
    module: {
        loaders: [{
            test: /\.html$/,
            loader: "html"
        }, {
            test: /\.less$/,
            loader: 'style!css!less'
        }, {
            test: /\.js$/,
            loader: 'babel-loader',
            exclude: ['node_modules'],
            query: {
                presets: ['es2015']
            }
        }
        ]
    },
    watch: true,
    watchOptions: {
        aggregateTimeoit: 100
    }
};

//webpack-dev-server --content-base app -d