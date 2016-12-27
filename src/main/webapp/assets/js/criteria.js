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
                if (criteriaVue != null) {
                    criteriaVue.criteria = data.criteria;
                } else {
                    criteriaVue = newCriteriaVue(data.criteria);
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


function newCriteriaVue(criteria){
    return new Vue({
        el: '#criteriaTree',
        data: {
            criteria: criteria
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

function addNewCriteria(name,description,points){
    var ids = $('.li_selected')[0].id.split('_');
    $.ajax({
        type: "POST",
        url: "/criteria/save",
        data: {
            criteriaId: Number(ids[0]),
            name: name,
            description: description,
            points:Number(points),
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