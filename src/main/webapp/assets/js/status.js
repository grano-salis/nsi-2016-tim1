/**
 * Created by ekusundzija on 07/12/16.
 */

var pendingItemsVue;
var approvedItemsVue;
var rejectedItemsVue;

var statusApproved = "APPROVED";
var statusRejected = "REJECTED";
var statusPending = "PENDING";

$(function () {
    getAllStatuses();
});

function getAllStatuses() {
    getAllPendingStatuses();
    getAllRejectedStatuses();
    getAllApprovedStatuses();
}

function getAllPendingStatuses(){
    $.ajax('/status/bystatus?status=' + statusPending, {
        headers: {
            Accept : "application/json; charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        success: function(data) {
            if((data.status != undefined)) {
                if (pendingItemsVue != null) {
                    pendingItemsVue.pendingItems = data.status;
                } else {
                    pendingItemsVue = newPendingItemsVue(data.status);
                }
            }
        }
    });
}


function newPendingItemsVue(status){
    return new Vue({
        el: '#Pending',
        data: {
            pendingItems: status
        },
        methods: {
            hide: function(){
                this.errorMessage = "";
            },
            changeStatus: function(object, statusToChange) {
                //object.status_id = 1;
                tempObj = JSON.parse(JSON.stringify(object));
                tempObj.statusId = statusToChange;
                console.log(tempObj);
                var newObj = '{'
                    + '"id":' + tempObj.id +','
                    + '"name":"' + tempObj.name +'",'
                    + '"description":"' + tempObj.description +'",'
                    + '"startDate":' + tempObj.startDate +','
                    + '"endDate":' + tempObj.endDate +','
                    + '"insertDate":' + tempObj.insertDate +','
                    + '"lastUpdateDate":' + (new Date).getTime() +','
                    + '"cvItemId":' + tempObj.cvItemId +','
                    + '"criteriaId":' + tempObj.criteriaId +','
                    + '"cvId":' + tempObj.cvId +','
                    + '"statusId":' + tempObj.statusId
                    +'}';

                console.log(newObj);

                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: "POST",
                    url: "/cvItem/save",
                    data: newObj,
                    success: function(data) {
                        console.log(data.status);
                        getAllStatuses();
                    },
                    dataType: "json"
                });
            },
            reject: function(message) {
                alert (message)

            },
            convertDate: function(epochDate) {
                tempDate =  new Date(epochDate);
                return tempDate.getFullYear().toString() + "/" + (tempDate.getMonth() + 1).toString() + "/" + tempDate.getDate();
            }
        }
    })
}

function getAllApprovedStatuses(){
    $.ajax('/status/bystatus?status=' + statusApproved, {
        headers: {
            Accept : "application/json; charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        success: function(data) {
            if((data.status != undefined)) {
                if (approvedItemsVue != null) {
                    approvedItemsVue.approvedItems = data.status;
                } else {
                    approvedItemsVue = newApprovedItemsVue(data.status);
                }
            }
        }
    });
}


function newApprovedItemsVue(status){
    return new Vue({
        el: '#Approved',
        data: {
            approvedItems: status
        },
        methods: {
            hide: function(){
                this.errorMessage = "";
            },
            convertDate: function(epochDate) {
                tempDate =  new Date(epochDate);
                return tempDate.getFullYear().toString() + "/" + (tempDate.getMonth() + 1).toString() + "/" + tempDate.getDate();
            }
        }
    })
}

function getAllRejectedStatuses(){
    $.ajax('/status/bystatus?status=' + statusRejected, {
        headers: {
            Accept : "application/json; charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        success: function(data) {
            if((data.status != undefined)) {
                if (rejectedItemsVue != null) {
                    rejectedItemsVue.rejectedItems = data.status;
                } else {
                    rejectedItemsVue = newRejectedItemsVue(data.status);
                }
            }
        }
    });
}

function newRejectedItemsVue(status){
    return new Vue({
        el: '#Rejected',
        data: {
            rejectedItems: status
        },
        methods: {
            hide: function(){
                this.errorMessage = "";
            },
            convertDate: function(epochDate) {
                tempDate =  new Date(epochDate);
                return tempDate.getFullYear().toString() + "/" + (tempDate.getMonth() + 1).toString() + "/" + tempDate.getDate();
            }
        }
    })
}