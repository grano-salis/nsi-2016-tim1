/**
 * Created by ekusundzija on 07/12/16.
 */

var cvItemsVue;

$(function () {
    getAllStatuses();

});

function getAllStatuses(){
    $.ajax('/status/all', {
        headers: {
            Accept : "application/json; charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        success: function(data) {
            if((data.status != undefined)) {
                if (cvItemsVue != null) {
                    cvItemsVue.cvItems = data.status;
                } else {
                    cvItemsVue = newCvItemsVue(data.status);
                }
            }
        }
    });
}


function newCvItemsVue(status){
    return new Vue({
        el: '#three',
        data: {
            cvItems: status
        },
        methods: {
            hide: function(){
                this.errorMessage = "";
            }
        }
    })
}