/**
 * Created by ekusundzija on 20/12/16.
 */


var criteriaVue;

$(function () {
    getAllCriteria();

});

function getAllCriteria(){
    $.ajax('/criteria/all', {
        headers: {
            Accept : "application/json; charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        success: function(data) {
            if((data.criteria != undefined)) {
                var maxLevel = calculateMaxLevel(data.criteria);
                if (criteriaVue != null) {
                    criteriaVue.criteria = data.criteria;
                    criteriaVue.maxLevel = maxLevel;
                } else {
                    criteriaVue = newcriteriaVue(data.criteria,maxLevel);
                }
            }
            $('.easy-tree').EasyTree({
                addable: true,
                //editable: true,
                deletable: true
            });
        }
    });
}


function newcriteriaVue(criteria,maxLevel){
    return new Vue({
        el: '#criteriaTree',
        data: {
            criteria: criteria,
            maxLevel: maxLevel
        },
        computed: {
            criteria1: function () {
                var self = this;
                return this.criteria.filter( function(item){
                    return item.criteriaLevel == 1;
                })
            }

        },
        methods: {
            hide: function(){
                this.errorMessage = "";
            },
            criteria_level: function (level, parent) {
                var self = this;
                return this.criteria.filter( function(item){
                    return item.criteriaLevel == level && item.criteriaId == parent.id;
                })
            },
            buildId: function(id,level){
                return id + "_" + level;
            }
        }
    })
}

function calculateMaxLevel(criteria){
    maxLevel = 0;
    for(i = 0;i<criteria.length;i++){
        if(criteria[i].criteriaLevel > maxLevel){
            maxLevel = criteria[i].criteriaLevel;
        }
    }
    return maxLevel = new Array(maxLevel);
}

function addNewCriteria(name,description){
    var ids = $('.li_selected')[0].id.split('_');
    $.ajax({
        type: "POST",
        url: "/criteria/save",
        data: {
            criteriaId: Number(ids[0]),
            name: name,
            description: description,
            points: 3,
            level: Number(ids[1]) + 1
        },
        success: function(data) {

        }
    });
}

function removeCriteria(){
    var ids = $('.li_selected')[0].id.split('_');
    $.ajax({
        type: "DELETE",
        url: "/criteria/" + ids[0],
        success: function(data) {

        }
    });
}