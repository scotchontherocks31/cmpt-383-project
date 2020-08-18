"use strict";

const myAppObj = new Vue({
    el: "#app",
    data: {
        message: 'Hello!',
        addVar1: '',
        addVar2: '',
        addResult: '',
        subVar1: '',
        subVar2: '',
        subResult: '',
        mulVar1: '',
        mulVar2: '',
        mulResult: '',
        divideVar1: '',
        divideVar2: '',
        divideResult: '',
        sumString: "",
        sumVal: '',
        sinVal: '',
        sinRes: '',
        cosVal: '',
        cosRes: '',
        tanVal: '',
        tanRes: '',
        fibVal: '',
        fibList: "",
        hailVal: '',
        hailList: "",
        tripleVal: '',
        tripleList: "",
        eqn: "",
        xVal: '',
        diffEqn: "",
        diffVal: '',
        authorName: ''
    },
    methods: {
        loadAbout,
        getName,
        getAddValue,
        getSubValue,
        getMulValue,
        getDivideValue,
        getSumValue,
        getFibList,
        getHailList,
        getDiffEqn,
        getDiffVal,
        getTripleList,
        getSinValue,
        getCosValue,
        getTanValue,
    }
});

//Check SpringBoot work initially
$(document).ready(function() {
    loadAbout();
    getName();
});

function loadAbout() {
    axios.get('/api/about', {})
        .then(function(response) {
            console.log("GET About returned:", response);
            myAppObj.message = response.data;
        })
        .catch(function(error) {
            console.log("GET About ERROR:", error);
        });
}

function getName() {
    axios.get('/api/name', {})
        .then(function(response) {
            console.log("GET Name returned:", response);
            myAppObj.authorName = response.data;
        })
        .catch(function(error) {
            console.log("GET Name ERROR:", error);
        });
}

function getAddValue() {
    axios.get('/api/add/' + myAppObj.addVar1 + '/' + myAppObj.addVar2, {})
        .then(function(response) {
            console.log("GET AddValue returned:", response);
            myAppObj.addResult = response.data;
        })
        .catch(function(error) {
            console.log("GET AddValue ERROR:", error);
        });
}

function getSubValue() {
    axios.get('/api/subtract/' + myAppObj.subVar1 + '/' + myAppObj.subVar2, {})
        .then(function(response) {
            console.log("GET SubValue returned:", response);
            myAppObj.subResult = response.data;
        })
        .catch(function(error) {
            console.log("GET SubValue ERROR:", error);
        });
}

function getMulValue() {
    axios.get('/api/multiply/' + myAppObj.mulVar1 + '/' + myAppObj.mulVar2, {})
        .then(function(response) {
            console.log("GET MulValue returned:", response);
            myAppObj.mulResult = response.data;
        })
        .catch(function(error) {
            console.log("GET About ERROR:", error);
        });
}

function getDivideValue() {
    axios.get('/api/divide/' + myAppObj.divideVar1 + '/' + myAppObj.divideVar2, {})
        .then(function(response) {
            console.log("GET DivideValue returned:", response);
            myAppObj.divideResult = response.data;
        })
        .catch(function(error) {
            console.log("GET DivideValue ERROR:", error);
        });
}

function getSumValue() {
    axios.get('/api/sum/' + myAppObj.sumString, {})
        .then(function(response) {
            console.log("GET SumValue returned:", response);
            console.log("GET Initial SumString returned:", myAppObj.sumString);
            myAppObj.sumVal = response.data;
        })
        .catch(function(error) {
            console.log("GET SumValue ERROR:", error);
        });
}

function getFibList() {
    axios.get('/api/fib/' + myAppObj.fibVal, {})
        .then(function(response) {
            console.log("GET FibList returned:", response);
            myAppObj.fibList = response.data;
        })
        .catch(function(error) {
            console.log("GET About ERROR:", error);
        });
}

function getHailList() {
    axios.get('/api/hail/' + myAppObj.hailVal, {})
        .then(function(response) {
            console.log("GET HailList returned:", response);
            myAppObj.hailList = response.data;
        })
        .catch(function(error) {
            console.log("GET About ERROR:", error);
        });
}

function getTripleList() {
    axios.get('/api/triples/' + myAppObj.tripleVal, {})
        .then(function(response) {
            console.log("GET TripleList returned:", response);
            myAppObj.tripleList = response.data;
        })
        .catch(function(error) {
            console.log("GET TripleList ERROR:", error);
        });
}

function getDiffEqn() {
    axios.get('/api/diff/eqn/' + myAppObj.eqn, {})
        .then(function(response) {
            console.log("GET DiffEqn returned:", response);
            myAppObj.diffEqn = response.data;
        })
        .catch(function(error) {
            console.log("GET DiffEqn ERROR:", error);
        });
}

function getDiffVal() {
    axios.get('/api/diff/val' + myAppObj.eqn + '/' + myAppObj.xVal, {})
        .then(function(response) {
            console.log("GET DiffVal returned:", response);
            myAppObj.diffVal = response.data;
        })
        .catch(function(error) {
            console.log("GET DiffVal ERROR:", error);
        });
}

function getSinValue() {
    axios.get('/api/sin/' + myAppObj.sinVal, {})
        .then(function(response) {
            console.log("GET SinValue returned:", response);
            myAppObj.sinRes = response.data;
        })
        .catch(function(error) {
            console.log("GET SinValue ERROR:", error);
        });
}

function getCosValue() {
    axios.get('/api/cos/' + myAppObj.cosVal, {})
        .then(function(response) {
            console.log("GET CosValue returned:", response);
            myAppObj.cosRes = response.data;
        })
        .catch(function(error) {
            console.log("GET CosValue ERROR:", error);
        });
}

function getTanValue() {
    axios.get('/api/tan/' + myAppObj.tanVal, {})
        .then(function(response) {
            console.log("GET TanValue returned:", response);
            myAppObj.tanRes = response.data;
        })
        .catch(function(error) {
            console.log("GET TanValue ERROR:", error);
        });
}