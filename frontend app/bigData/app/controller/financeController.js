'use strict';

angular.module('myApp')

    .controller('financeMainCtrl', function ($scope, $route, multiBarChartDataFunc, discBarChartDataFunc, ohlcChartDataFunc, stockPricesdata) {
        // Multi Bar chart configurations
     //   console.log($route.current.originalPath);
        $scope.multiBarChartOptions = {
            chart: {
                type: 'multiBarChart',
                height: 450,
                margin: {
                    top: 40,
                    right: 30,
                    bottom: 40,
                    left: 59,
                },
                duration: 500,
                stacked: false,
                useVoronoi: true,
                clipEdge: true,

                useInteractiveGuideline: true,
                interactive: true,
                tooltips: true,
                xAxis: {
                    axisLabel: 'Companies',
                    showMaxMin: false,
                    tickFormat: function (d) {
                        return d;
                    }

                }, yAxis: {
                    axisLabel: 'Stock Price',
                    showMaxMin: false,
                    tickFormat: function (d) {
                      //  console.log(d);
                        return d3.format('$,.00f')(d);
                    },
                },
                reduceXTicks: false
            }
        };

        // Multi Bar chart dataset
        $scope.multiBarChartData = [];
        var dataSet = multiBarChartDataFunc.query(function (data) {

            $scope.api1.refresh();
            $scope.multiBarChartData = data.multiBarData;
            //  $scope.api1.refresh();
        });
        // Discrete Bar chart
        $scope.discBarChartOptions = {
            chart: {
                type: 'discreteBarChart',
                height: 450,
                margin: {
                    top: 20,
                    right: 20,
                    bottom: 50,
                    left: 55
                },

                showValues: true,
                valueFormat: function (d) {
                    return d3.format(',.2f')(d);
                },
                duration: 500,
                xAxis: {
                    axisLabel: 'Companies'
                },
                yAxis: {
                    axisLabel: 'Change in Percentage',
                    axisLabelDistance: -10,

                }
            }
        };
        // Discrete Bar chart dataset
        $scope.discBarChartData = [];
        var dataSet = discBarChartDataFunc.query(function (data) {
            $scope.api2.refresh();
            $scope.discBarChartData = data.discBarChartData;
        });

        // OHLC Chart chart
        $scope.ohlcChartOptions = {
            chart: {
                type: 'ohlcBarChart',
                height: 450,
                margin: {
                    top: 20,
                    right: 20,
                    bottom: 40,
                    left: 60
                },
                x: function (d) {

                    return d.date;
                },
                y: function (d) { return d.close; },
                duration: 100,

                xAxis: {
                    axisLabel: 'Dates',
                    tickFormat: function (d) {

                        return d3.time.format('%x')(new Date(d));

                    },
                    showMaxMin: false
                },

                yAxis: {
                    axisLabel: 'Stock Price',
                    tickFormat: function (d) {
                        return '$' + d3.format(',.1f')(d);
                    },
                    showMaxMin: false
                },
                zoom: {
                    enabled: true,
                    scaleExtent: [1, 10],
                    useFixedDomain: false,
                    useNiceScale: false,
                    horizontalOff: false,
                    verticalOff: true,
                    unzoomEventType: 'dblclick.zoom'
                }
            }
        };
        //  OHLC Chart dataset
        $scope.ohlcChartData = [];
        var dataSet = ohlcChartDataFunc.query(function (data) {
            $scope.api3.refresh();
            $scope.ohlcChartData = data.ohlcChartData;
        });

        // Tabulature dataset
        $scope.rowCollection = [];
        var dataSet = stockPricesdata.query(function (data) {

            $scope.rowCollection = data;
        });
    })
    .controller('financeDetailCtrl', function ($scope, $route, stackedAreaChartData, MonthlyStockPrice, getStockCompanyDetails, $routeParams) {
      //  console.log($route.current.originalPath);
        $scope.compinfo = "";
        var dataSet = getStockCompanyDetails.get($routeParams).query(function (data) {

            data['rateChange'] = data['rateChange'].toFixed(3);
            $scope.compinfo = data;

        });

        $scope.stackedAreaChartOptions = {
            chart: {
                type: 'multiBarChart',
                height: 450,
                width:0,
                margin: {
                    top: 20,
                    right: 20,
                    bottom: 40,
                    left: 60
                },
                x: function (d) { return d[0]; },
                y: function (d) { return d[1]; },
                useVoronoi: true,
                clipEdge: true,
                duration: 100,
                useInteractiveGuideline: false,
                interactive: true,
                tooltips: true,
          



                xAxis: {
                    axisLabel: 'Date',
                    showMaxMin: false,
                    tickFormat: function (d) {
                        return d3.time.format('%x')(new Date(d))
                    }
                },
                yAxis: {
                      axisLabel: 'Pridicted Price',
                    tickFormat: function (d) {
                        return d3.format('$,f')(d);
                    }
                },
                tooltip: {
                    contentGenerator: function (d) {
                        //  console.log(d, d.data[0], d.data[1], d.data['key']);
                        return "<table><thead><tr><td colspan='3'><strong class='x-value'>" + d3.time.format('%x')(new Date(d.data[0])) + "</strong></td>        </tr>    </thead>                      <tbody>        <tr>            <td class='legend-color-guide'>                <div style='background-color:" + d['color'] + ";'></div> </td><td class='key'>" + d.data['key'] + "</td><td class='value'>$" + d.data[1].toFixed(3) + "</td></tr></tbody></table>";
                    }
                }
            }
        };

        $scope.stackedAreaChartData = [];

        var dataSet = stackedAreaChartData.get($routeParams).query(function (data) {

            $scope.api.refresh();
            $scope.stackedAreaChartData = data.stackedAreaChartData;
            // console.log("stack area data points", $scope.stackedAreaChartData);
        });

        // Tabulature dataset
        $scope.rowCollection = [];
        var dataSet = MonthlyStockPrice.get($routeParams).query(function (data) {
            var row = 0;
            data.forEach(function (item) {
                data[row].rateChange = item['rateChange'].toFixed(3);
                row++;
            });

            $scope.api1.refresh();

            $scope.rowCollection = data;

        });



    })
    .controller('financeHighlightsCtrl', function ($scope, $route, getTickerData) {
        //get Ticker Data
        var slides = $scope.slides = [];
      console.log($route);
 //     if ($scope.$id==1){
        var dataSet = getTickerData.query(function (data) {
            var tick = 0;
            data.forEach(function (item) {
                data[tick].rateChange = item.rateChange.toFixed(3);
                tick++;
            }
            );
            $scope.slides = data;
        });//}
    })

    .controller('financeCompanyCtrl', function ($scope, stockPricesdata, $route) {
        $scope.rowCollection = [];
        var i = 0;
        var dataSet = stockPricesdata.query(function (data) {
            data.forEach(function (item) {
                data[i].stock = item['stock'].toLowerCase();
                data[i].rateChange = item['rateChange'].toFixed(3);
                i++;
            });
            $scope.rowCollection = data;
            $scope.api4.refresh();
        });
    });

