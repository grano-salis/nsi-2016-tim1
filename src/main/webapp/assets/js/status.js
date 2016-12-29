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
                var newCvItem = {};
                newCvItem.id = tempObj.id;
                newCvItem.name = tempObj.name;
                newCvItem.description = tempObj.description;
                newCvItem.startDate = tempObj.startDate;
                newCvItem.endDate = tempObj.endDate;
                newCvItem.insertDate = tempObj.insertDate;
                newCvItem.lastUpdateDate = (new Date).getTime();
                newCvItem.criteriaId = tempObj.criteriaId;
                newCvItem.cvId = tempObj.cvId;
                newCvItem.statusId = tempObj.statusId;

                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: "POST",
                    url: "/cvItem/save",
                    data: JSON.stringify(newCvItem),
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
            },
            downloadAttachment: function(attachmentLink) {
                var fileName = attachmentLink.split("_")[1];
                window.open(
                    "/download_cv_item_attachment?fileName=" + fileName,
                    '_blank'
                );
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
