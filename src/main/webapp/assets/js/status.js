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
    getAllPendingStatuses();
    getAllRejectedStatuses();
    getAllApprovedStatuses();
});

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
            }
        }
    })
}