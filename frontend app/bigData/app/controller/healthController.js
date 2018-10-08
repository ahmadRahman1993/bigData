'use strict';

angular.module('myApp')
    .controller('healthMainCtrl', function ($q, $scope, getLimittedPatientDataRecs, getPatientDataByCriteria, $route) {
        $scope.patients = [];
        $scope.searchParamenters = {};
        $scope.searchParamenters.name = '';
        $scope.searchParamenters.age = '';
        $scope.searchParamenters.contact = '';
        var d = new Date();
        var n = d.getFullYear();
        var datay;
        var ddy;
        var str = null;
        var arr = null;
        //callback method
        $scope.firstName;
        $scope.secondName;
        $scope.search = function () {
            if ($scope.searchParamenters.name == '' || $scope.searchParamenters.name == null) { $scope.searchParamenters.name = "0"; }
            if ($scope.searchParamenters.age == '' || $scope.searchParamenters.age == null) { $scope.searchParamenters.age = "0"; }
            if ($scope.searchParamenters.contact == '' || $scope.searchParamenters.contact == null) { $scope.searchParamenters.contact = "0"; }
            var dataSet = getPatientDataByCriteria.get($scope.searchParamenters).query(function (data) {

                data.forEach(function (item) {
                    item.firstName = null;
                    item.lastName = null;
                    str = item.personName;
                    arr = str.split(" ");
                    item.personName = arr[0];
                    item.firstName = arr[0];
                    item.lastName = arr[1];
                })
                $scope.patients = data;

            });
            $scope.searchParamenters.name = null;
            $scope.searchParamenters.age = null;
            $scope.searchParamenters.contact = null;
        }
        var dataSet = getLimittedPatientDataRecs.query(function (data) {

            $scope.patients = data;
            data.forEach(function (item) {
                item.firstName = null;
                item.lastName = null;
                str = item.personName;
                arr = str.split(" ");
                item.personName = arr[0];
                item.firstName = arr[0];
                item.lastName = arr[1];
            })

        });

    })

    .controller('healthPatient', function ($scope, $route, $window, $timeout, SavePatientInfo) {
        var response = {};
        $scope.patient = {};
        $scope.data = {
            availableOptions: [
                { name: 'Male' },
                { name: 'Female' }
            ]
        };
        $scope.patient.info = {};
        $scope.patient.info.personId="0";
        $scope.patient.info.age;
        $scope.patient.info.contact;
        $scope.patient.info.dob = new Date();
        $scope.patient.info.gender;
        $scope.patient.info.maritalStatus;
        $scope.patient.info.pLanguage;
        $scope.patient.info.pPercent;
        $scope.patient.info.personName;
        $scope.patient.info.race;
        var a = new Date();
        $scope.today = function () {
            a = new Date();
            console.log(a);
        };
        $scope.today();

        $scope.clear = function () {
            a = null;
        };

        $scope.inlineOptions = {
            //  customClass: getDayClass,
            minDate: new Date(),
            showWeeks: true
        };

        $scope.dateOptions = {
            formatYear: 'yyyy',
            format: 'yyyy-mm-dd',
            maxDate: new Date(2020, 12, 30),
            minDate: new Date(),
            startingDay: 1
        };
        $scope.toggleMin = function () {
            $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
            $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
        };

        $scope.toggleMin();

        $scope.open1 = function () {
            $scope.popup1.opened = true;
        };
        $scope.setDate = function (year, month, day) {
            console.log(a, 'ASasS ' + year, ' - ', month, ' - ', day);
            a = new Date(year, month, day);
        };

        $scope.formats = ['yyyy-mm-dd'];
        $scope.format = $scope.formats[0];
        $scope.popup1 = {
            opened: false
        };
        $scope.updateInfo = function () {
            $scope.varngshow = true;
            a = $scope.patient.info.dob;
            $scope.patient.info.dob = a.getFullYear() + '-' + (a.getMonth() + 1) + '-' + a.getDate();
            console.log("save", $scope.patient.info);
            SavePatientInfo.post($scope.patient.info).$promise.then(function (item) {
                console.log($scope.patient.info);
                $scope.varngshow = false;
                $scope.patient.info.dob = a.getFullYear() + '-' + (a.getMonth() + 1) + '-' + a.getDate();
                if (item.responseCode.localeCompare("201") == 0) {
                    // $scope.patient.info.dob = a.getFullYear() + '-' + (a.getMonth() + 1) + '-' + a.getDate();
                    console.log("In response check true", item.responseCode);
                    window.location.href = '#!/health';
                    $scope.showGreeting = false;
                    $scope.msg = "Patient added successfully";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);

                }
                else {
                    console.log("In response check false ", item);
                    $scope.showGreeting = false;
                    $scope.msg = "Failed to save Patient information";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);
                }
            });
            //  $scope.patient.info.dob = a;
        }
        $scope.clearInfo = function () {
            $scope.patient.info.personId = 0;
            $scope.patient.info.age = null;
            $scope.patient.info.contact = null;
            $scope.patient.info.dob = null;
            $scope.patient.info.gender = null;
            $scope.patient.info.maritalStatus = null;
            $scope.patient.info.pLanguage = null;
            $scope.patient.info.pPercent = null;
            $scope.patient.info.personName = null;
            $scope.patient.info.race = null;
        }
    })
    .controller('healthDetail', function ($scope, getPatientDataById, getPatientBMIDataById, getLabResultsByPatientId, getBloodPressure, getBodyTemp, getHeight, getPulse, getWeight, $route, $routeParams) {
        $scope.patient = {};
        $scope.patientid = '';
        $scope.patientid = $routeParams;
        var d = new Date();
        var n = d.getFullYear();

        var dataSet = getPatientDataById.get($routeParams).query(function (data) {
            $scope.patient = data;
        });
        // Lab Results Table
        $scope.rowCollection = [];
        $scope.itemsByPage = 15;
        $scope.getResults1 = function () {
            var dataSet = getLabResultsByPatientId.get($routeParams).query(function (data) {
                $scope.rowCollection = data;

            });

        }
        //bmi DATA
        $scope.bmiDATA = {};
        var dataSet = getPatientBMIDataById.get($routeParams).query(function (data) {
            $scope.bmiDATA = data;
        });





        // Blood Pressure line chart
        $scope.BloodPressureOptions = {
            chart: {
                type: 'lineChart',
                height: 450,
                width: 0,
                showControls: false,
                margin: {
                    top: 20,
                    right: 20,
                    bottom: 40,
                    left: 60
                },
                //   x: function (d) { return d.x; },
                //   y: function (d) { return d.y; },
                useVoronoi: false,
                clipEdge: false,
                duration: 100,
                useInteractiveGuideline: true,
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
                    axisLabel: 'Blood Pressure',
                    showMaxMin: false,
                    tickFormat: function (d) {
                        return d3.format('f')(d);
                    }
                },
            }
        };
        $scope.BloodPressure = [];
        $scope.getResultsBlood = function () {
            var dataSet = getBloodPressure.get($routeParams.patientid).query(function (data) {

                var dataSets = data.singleBarData;
                $scope.BloodPressure = data.singleBarData;
                $scope.api3.refresh();
            });
        }
        // Body Temperature Bar chart
        $scope.BodyTempOptions = {
            chart: {
                type: 'multiBarChart',
                height: 450,
                width: 0,
                showControls: false,
                margin: {
                    top: 20,
                    right: 20,
                    bottom: 40,
                    left: 60
                },
                x: function (d) { return d.x; },
                y: function (d) { return d.y; },
                useVoronoi: false,
                clipEdge: false,
                duration: 100,
                useInteractiveGuideline: true,
                interactive: true,
                tooltips: true,

                xAxis: {
                    axisLabel: 'Date',
                    showMaxMin: false,
                    tickFormat: function (d) {
                        return d3.time.format('%x')(new Date(d));
                    }
                },
                yAxis: {
                    axisLabel: 'Body Temperature',
                    showMaxMin: false,
                    tickFormat: function (d) {
                        return d3.format('C,f')(d);
                    }
                },

            }
        };

        $scope.BodyTemp = [];


        var dataSet = getBodyTemp.get($routeParams.patientid).query(function (data) {


            $scope.BodyTemp = data.singleBarData;
            $scope.api3.refresh();
        });



        // Height Bar chart
        $scope.HeightOptions = {
            chart: {
                type: 'multiBarChart',
                height: 450,
                width: 0,
                showControls: false,
                margin: {
                    top: 20,
                    right: 20,
                    bottom: 40,
                    left: 60
                },
                x: function (d) { return d.x; },
                y: function (d) { return d.y; },
                useVoronoi: false,
                clipEdge: false,
                duration: 100,
                useInteractiveGuideline: true,
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
                    axisLabel: 'Height',
                    showMaxMin: false,
                    tickFormat: function (d) {
                        return d3.format('C,f')(d);
                    }
                },
            }
        };

        $scope.Height = [];
        var dataSet = getHeight.get($routeParams.patientid).query(function (data) {
            $scope.api4.refresh();
            $scope.Height = data.singleBarData;
            //    console.log("getHeight", data.singleBarData)
        });
        // Pulse Bar chart
        $scope.PulseOptions = {
            chart: {
                type: 'lineChart',
                height: 450,
                width: 0,
                showControls: false,
                margin: {
                    top: 20,
                    right: 20,
                    bottom: 40,
                    left: 60
                },
                x: function (d) { return d.x; },
                y: function (d) { return d.y; },
                useVoronoi: false,
                clipEdge: false,
                duration: 100,
                useInteractiveGuideline: true,
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
                    axisLabel: 'Pulse',
                    showMaxMin: false,
                    tickFormat: function (d) {
                        return d3.format('C,f')(d);
                    }
                },
            }
        };

        $scope.Pulse = [];
        var dataSet = getPulse.get($routeParams.patientid).query(function (data) {
            $scope.Pulse = data.singleBarData;
            //      console.log("getPulse", data.singleBarData)
            $scope.api5.refresh();
        });


        // Weight  chart
        $scope.WeightOptions = {
            chart: {
                type: 'lineChart',
                height: 450,
                width: 0,
                showControls: false,
                margin: {
                    top: 20,
                    right: 20,
                    bottom: 40,
                    left: 60
                },
                x: function (d) { return d.x; },
                y: function (d) { return d.y; },
                useVoronoi: true,
                clipEdge: true,
                duration: 500,
                useInteractiveGuideline: true,
                interactive: true,
                tooltips: true,
                 reduceXTicks: true,


                xAxis: {
                    axisLabel: 'Date',
                    showMaxMin: false,
                    tickFormat: function (d) {
                        return d3.time.format('%x')(new Date(d))
                        //            return d;
                    }
                },
                yAxis: {
                    axisLabel: 'Weight',
                    showMaxMin: false,
                    tickFormat: function (d) {
                        return d3.format('f')(d);
                    }
                },
            }
        };

        $scope.Weight = [];
        var dataSet = getWeight.get($routeParams.patientid).query(function (data) {
            $scope.Weight = data.singleBarData;
            //     console.log("getWeight", data.singleBarData)
            $scope.api6.refresh();
        });

    })
    .controller('healthEdit', function ($scope, getLimittedPatientDataRecs, $window, $timeout, saveLabData, getPatientDataById, SavePatientInfo, saveDiagnosisData, saveAddmissionData, $routeParams, savePatientVitalsData) {
        var a = new Date();
        var b = new Date();
        $scope.today = function () {
            a = new Date();
            b = new Date();
        };
        $scope.today();

        $scope.clear = function () {
            a = null;
            b = null;
        };

        $scope.inlineOptions = {
            minDate: new Date(),
            showWeeks: true
        };

        $scope.dateOptions = {
            //   formatYear: 'yyyy',
            //    format: 'yyyy-mm-dd',
            //     maxDate: new Date(2020, 5, 22),
            //    minDate: new Date(),
            // startingDay: 1
        };
        $scope.toggleMin = function () {
            $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
            $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
        };

        $scope.toggleMin();

        $scope.open1 = function () {
            $scope.popup1.opened = true;
        };

        $scope.open2 = function () {
            $scope.popup2.opened = true;
        };

        $scope.setDate = function (year, month, day) {
            a = new Date(year, month, day);
            b = new Date(year, month, day);
        };

        $scope.formats = ['yyyy-mm-dd'];
        //    $scope.format = $scope.formats[0];

        $scope.popup1 = {
            opened: false
        };

        $scope.popup2 = {
            opened: false
        };


        $scope.data = {
            availableOptions: [
                { name: 'Male' },
                { name: 'Female' }
            ]
        };
        $scope.patient = {};
        $scope.patient.info = {};
        $scope.patient.info.personId = $routeParams;
        $scope.patient.info.age = null;
        $scope.patient.info.contact = null;
        $scope.patient.info.dob;
        $scope.patient.info.gender = null;
        $scope.patient.info.maritalStatus = null;
        $scope.patient.info.pLanguage = null;
        $scope.patient.info.pPercent = null;
        $scope.patient.info.personName = null;
        $scope.patient.info.race = null;

        $scope.patient.info.patientid = $routeParams;
        //get date from api to populate fields for update
        $scope.getPatientdata = function () {
            var dataSet = getPatientDataById.get($routeParams).query(function (data) {
                $scope.patient.info = data;
                $scope.patient.info.dob = new Date(data.dob);
            });
        }
        $scope.updatePatientInfo = function () {
            console.log("updatePatientInfo EDIT", $scope.patient.info.dob);
            $scope.varngshow = true;

            $scope.patient.info.dob = $scope.patient.info.dob.getFullYear() + '-' + ($scope.patient.info.dob.getMonth() + 1) + '-' + $scope.patient.info.dob.getDate();
            SavePatientInfo.post($scope.patient.info).$promise.then(function (item) {
                $scope.varngshow = false;
                if (item.responseCode.localeCompare("200") == 0) {
                    //   window.location.href = '#!/health';
                    console.log("In Response check", item);
                    $scope.showGreeting = false;
                    $scope.msg = "Patient information added successfully";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);
                }
                else {
                    console.log("In response check false ", item);
                    $scope.showGreeting = false;
                    $scope.msg = "Failed to save Patient information";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);

                }
            });
        }
        $scope.clearPatientInfo = function () {
            var dataSet = getPatientDataById.get($routeParams).query(function (data) {
                $scope.patient.info = data;
                $scope.patient.info.dob = new Date(data.dob);
            });
        }
        $scope.patient.admission = {};
        $scope.patient.admission.personId = $routeParams.patientid;
        $scope.patient.admission.addmissionId = null;
        $scope.patient.admission.startDate = new Date();
        $scope.patient.admission.endDate = new Date();

        $scope.updateAdmission = function () {
            $scope.varngshow = true;
            $scope.patient.admission.startDate = $scope.patient.admission.startDate.getFullYear() + '-' + ($scope.patient.admission.startDate.getMonth() + 1) + '-' + $scope.patient.admission.startDate.getDate();
            $scope.patient.admission.endDate = $scope.patient.admission.endDate.getFullYear() + '-' + ($scope.patient.admission.endDate.getMonth() + 1) + '-' + $scope.patient.admission.endDate.getDate();
            saveAddmissionData.post($scope.patient.admission).$promise.then(function (item) {
                $scope.varngshow = false;
                if (item.responseCode.localeCompare("201") == 0) {
                    //    window.location.href = '#!/health';
                    console.log("In Response check");
                    $scope.showGreeting = false;
                    $scope.msg = "Patient information added successfully";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);
                }
                else {
                    console.log("In response check false ", item);
                    $scope.showGreeting = false;
                    $scope.msg = "Failed to save Patient information";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);

                }
            });
            $scope.patient.admission.startDate = a;
            $scope.patient.admission.endDate = b;
        }
        $scope.clearAdmission = function () {
            $scope.patient.admission.addmissionId = null;
            $scope.patient.admission.startDate = new Date();
            $scope.patient.admission.endDate = new Date();
        }
        $scope.patient.diagnosis = {};
        $scope.patient.diagnosis.personId = $routeParams.patientid;
        $scope.patient.diagnosis.addmissionId = null;
        $scope.patient.diagnosis.dcode = null;
        $scope.patient.diagnosis.diagnosis = null;

        $scope.updateDiagnosis = function () {
            $scope.varngshow = true;
            console.log($scope.patient.diagnosis);
            saveDiagnosisData.post($scope.patient.diagnosis).$promise.then(function (item) {
                $scope.varngshow = false;
                if (item.responseCode.localeCompare("201") == 0) {
                    //    window.location.href = '#!/health';
                    console.log("In Response check");
                    $scope.showGreeting = false;
                    $scope.msg = "Patient information added successfully";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);
                }
                else {
                    console.log("In response check false ", item);
                    $scope.showGreeting = false;
                    $scope.msg = "Failed to save Patient information";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);

                }
            });
        }
        $scope.clearDiagnosis = function () {
            $scope.patient.diagnosis.addmissionId = null;
            $scope.patient.diagnosis.dcode = null;
            $scope.patient.diagnosis.diagnosis = null;
        }
        $scope.patient.vitals = {};
        $scope.patient.vitals.personId = $routeParams.patientid;
        $scope.patient.vitals.height = null;
        $scope.patient.vitals.weight = null;
        $scope.patient.vitals.pulse = null;
        $scope.patient.vitals.bpresu = null;
        $scope.patient.vitals.bpresd = null;
        $scope.patient.vitals.btemp = null;
        $scope.patient.vitals.vdate;
        $scope.updateVitals = function () {
            $scope.varngshow = true;
            $scope.patient.vitals.vdate = a;
            $scope.patient.vitals.vdate = $scope.patient.vitals.vdate.getFullYear() + '-' + ($scope.patient.vitals.vdate.getMonth() + 1) + '-' + $scope.patient.vitals.vdate.getDate();
            console.log("savePatientVitalsData", $scope.patient.vitals);
            savePatientVitalsData.post($scope.patient.vitals).$promise.then(function (item) {
                $scope.varngshow = false;
                if (item.responseCode.localeCompare("201") == 0) {
                    console.log("In Response check");
                    $scope.showGreeting = false;
                    $scope.msg = "Patient information added successfully";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);
                }
                else {
                    console.log("In response check false ", item);
                    $scope.showGreeting = false;
                    $scope.msg = "Failed to save Patient information";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);

                }
            });
        }
        $scope.clearVitals = function () {
            $scope.patient.vitals.height = null;
            $scope.patient.vitals.weight = null;
            $scope.patient.vitals.pulse = null;
            $scope.patient.vitals.bpresu = null;
            $scope.patient.vitals.bpresd = null;
            $scope.patient.vitals.btemp = null;
        }

        $scope.patient.labdata = {};
        $scope.patient.labdata.personId = $routeParams.patientid;
        $scope.patient.labdata.addmissionId = null;
        $scope.patient.labdata.labName = null;
        $scope.patient.labdata.labValue = null;
        $scope.patient.labdata.labUnits = null;
        $scope.patient.labdata.lDate;
        $scope.updateLabs = function () {
            $scope.varngshow = true;
            $scope.patient.labdata.lDate = a;
            $scope.patient.labdata.lDate = $scope.patient.labdata.lDate.getFullYear() + '-' + ($scope.patient.labdata.lDate.getMonth() + 1) + '-' + $scope.patient.labdata.lDate.getDate();
            saveLabData.post($scope.patient.labdata).$promise.then(function (item) {
                $scope.varngshow = false;
                if (item.responseCode.localeCompare("201") == 0) {
                    console.log("In Response check");
                    $scope.showGreeting = false;
                    $scope.msg = "Patient information added successfully";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);
                }
                else {
                    console.log("In response check false ", item);
                    $scope.showGreeting = false;
                    $scope.msg = "Failed to save Patient information";
                    $scope.showGreeting = true;
                    $timeout(function () {
                        $scope.showGreeting = false;
                    }, 5000);

                }
            });
        }
        $scope.resetLabs = function () {
            $scope.patient.labdata.addmissionId = null;
            $scope.patient.labdata.labName = null;
            $scope.patient.labdata.labValue = null;
            $scope.patient.labdata.labUnits = null;
        }
    });