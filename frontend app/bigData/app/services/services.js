'use strict';
var url = "http://localhost:8080/hadoopRest/rest";
var health = "http://192.168.1.109:8080/HiveRest/rest";
angular.module('myApp').
    factory('multiBarChartDataFunc', ['$resource',
        function ($resource) {
            return $resource(url + "/getAllNextDayStockPrice", {}, {
                query: {
                    method: 'GET',
                    isArray: false
                }

            });
        }
    ])
    .factory('getTickerData', ['$resource',
        function ($resource) {
            return $resource(url + "/getTickerData", {}, {
                query: {
                    method: 'GET',
                    isArray: true
                }

            });
        }
    ])
    .factory('discBarChartDataFunc', ['$resource',
        function ($resource) {
            return $resource(url + "/getAllCompaniesNextDayPredictedChange", {}, {
                query: {
                    method: 'GET',
                    isArray: false
                }
            });
        }
    ])
    .factory('ohlcChartDataFunc', ['$resource',
        function ($resource) {
            return $resource(url + "/getAllHistoricalData", {}, {
                query: {
                    method: 'GET',
                    isArray: false
                }
            });
        }
    ])
    .factory('stockPricesdata', ['$resource',
        function ($resource) {
            return $resource(url + "/getAllNextStockPriceWithPercentChange", {}, {
                query: {
                    method: 'GET',
                    isArray: true
                }
            });
        }
    ])
    .factory('stackedAreaChartData', ['$resource',
        function ($resource) {
            return {
                get: function (params) {
                    var a = params.cname;
                    a = a.toLowerCase();
                    return $resource(url + "/getMonthlyPredictionsByStockName/" + a, {}, {
                        query: {
                            method: 'GET',
                            isArray: false
                        }
                    });
                }
            }

        }
    ])
    .factory('MonthlyStockPrice', ['$resource',
        function ($resource) {
            return {
                get: function (params) {
                    var a = params.cname;
                    a = a.toLowerCase();
                    return $resource(url + "/getMonthlyStockPriceWithPercentChange/" + a, {}, {
                        query: {
                            method: 'GET',
                            isArray: true
                        }
                    });
                }
            }

        }
    ])
    .factory('getStockCompanyDetails', ['$resource',
        function ($resource) {

            return {
                get: function (params) {
                    var a = params.cname;
                    a = a.toLowerCase();
                    return $resource(url + "/getStockCompanyDetails/" + a, {}, {
                        reload: true,
                        query: {
                            method: 'GET',
                            isArray: false
                        }
                    });
                }
            }

        }
    ])
    .factory('getLimittedPatientDataRecs', ['$resource',
        function ($resource) {
            return $resource(health + "/getLimittedPatientDataRecs", {}, {
                query: {
                    method: 'GET',
                    isArray: true
                }
            });
        }
    ])
    .factory('getPatientDataByCriteria', ['$resource',
        function ($resource) {

            return {
                get: function (params) {
                    var queryString = health + "/getPatientDataByCriteria/name/" + params.name + "/age/" + params.age + "/contactno/" + params.contact;
                    console.log("query string", queryString);
                    return $resource(queryString, {}, {
                        reload: true,
                        query: {
                            method: 'GET',
                            isArray: true
                        }
                    });
                }
            }
        }
    ])
    .factory('getPatientDataById', ['$resource',
        function ($resource) {
            return {
                get: function (params) {
                    return $resource(health + "/getPatientDataById/" + params.patientid, {}, {
                        reload: true,
                        query: {
                            method: 'GET',
                            isArray: false
                        }
                    });
                }
            }

        }
    ])
    .factory('getLabResultsByPatientId', ['$resource',
        function ($resource) {
            return {
                get: function (params) {
                    return $resource(health + "/getLabResultsByPatientId/" + params.patientid, {}, {
                        reload: true,
                        query: {
                            method: 'GET',
                            isArray: true
                        }
                    });
                }
            }

        }
    ])
    .factory('getPatientBMIDataById', ['$resource',
        function ($resource) {
            return {
                get: function (params) {
                    return $resource(health + "/getPatientBMIDataById/" + params.patientid, {}, {
                        query: {
                            method: 'GET',
                            isArray: false
                        }


                    });
                }
            }
        }
    ])
    .factory('getBodyTemp', ['$resource',
        function ($resource) {
            return {
                get: function (params) {
                    return $resource(health + "/getPatientBodyTempDataById/" + params, {}, {
                        //          return $resource("BodyTemp.json", {}, {
                        query: {
                            method: 'GET',
                            isArray: false
                        }

                    });
                }
            }
        }
    ])
    .factory('getBloodPressure', ['$resource',
        function ($resource) {
            return {
                get: function (params) {
                 //   return $resource(health + "/getPatientBloodPressureDataById/" + params, {}, {
                         return $resource("Bloodpressure.json", {}, {
                        query: {
                            method: 'GET',
                            isArray: false
                        }

                    });
                }
            }
        }
    ])
    .factory('getPulse', ['$resource',
        function ($resource) {
            return {
                get: function (params) {
                    return $resource(health + "/getPatientPulseDataById/" + params, {}, {
                        //  return $resource("pulse.json", {}, {
                        query: {
                            method: 'GET',
                            isArray: false
                        }
                    });
                }
            }

        }
    ])
    .factory('getHeight', ['$resource',
        function ($resource) {
            return {
                get: function (params) {
                    return $resource(health + "/getPatientHeightDataById/" + params, {}, {
                        //    return $resource("height.json", {}, {
                        query: {
                            method: 'GET',
                            isArray: false
                        }
                    });
                }
            }
        }
    ])
    .factory('getWeight', ['$resource',
        function ($resource) {
            return {
                get: function (params) {
                    return $resource(health + "/getPatientWeightDataById/" + params, {}, {
                        //         return $resource('wieght.json', {}, {
                        query: {
                            method: 'GET',
                            isArray: false
                        }
                    });
                }
            }
        }
    ])
    .factory('SavePatientInfo', ['$resource',
        function ($resource) {
            return {
                post: function (PatientDataJSONDTO) {
                    var PatientDataDT = $resource(health + "/saveOrUpdatePatientData");
                    return PatientDataDT.save(PatientDataJSONDTO, function (res) {
                           console.log("In service SavePatientInfo responseCode",res);
                        return res;
                    });
                }
            }

        }
    ])
    .factory('saveAddmissionData', ['$resource',
        function ($resource) {
            return {
                post: function (PatientDataJSONDTO) {
                    var PatientDataDT = $resource(health + "/saveAddmissionData");
                    return PatientDataDT.save(PatientDataJSONDTO, function (res) {
                           console.log("In service saveAddmissionData responseCode",res);
                        return res;
                    });

                }
            }

        }
    ])
    .factory('saveDiagnosisData', ['$resource',
        function ($resource) {
            return {
                post: function (PatientDataJSONDTO) {
                    var PatientDataDT = $resource(health + "/saveDiagnosisData");
                    return PatientDataDT.save(PatientDataJSONDTO, function (res) {
                        console.log("In service saveDiagnosisData responseCode", res.responseCode)
                    });

                }
            }

        }
    ])
    .factory('savePatientVitalsData', ['$resource',
        function ($resource) {
            return {
                post: function (PatientDataJSONDTO) {
                    var PatientDataDT = $resource(health + "/savePatientVitalsData");
                    return PatientDataDT.save(PatientDataJSONDTO, function (res) {
                        console.log("In service savePatientVitalsData responseCode", res.responseCode)
                    });

                }
            }

        }
    ])
    .factory('saveLabData', ['$resource',
        function ($resource) {
            return {
                post: function (PatientDataJSONDTO) {
                    var PatientDataDT = $resource(health + "/saveLabData");
                    return PatientDataDT.save(PatientDataJSONDTO, function (res) {
                        console.log("In service saveLabData responseCode", res.responseCode)
                    });

                }
            }

        }
    ]);


