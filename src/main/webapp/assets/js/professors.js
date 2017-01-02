/**
 * Created by ekusundzija on 07/12/16.
 */

var professorsVue;

$(function () {
    getAllProfessos();

});

function getAllProfessos(){
    $.ajax('/professors/all', {
        headers: {
            Accept : "application/json; charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        success: function(data) {
            if((data.professors != undefined)) {
                if (professorsVue != null) {
                    professorsVue.professors = data.professors;
                } else {
                    professorsVue = newProfessorsVue(data.professors);
                }
            }
        }
    });
}



function newProfessorsVue(professors){
    return new Vue({
        el: '#three',
        data: {
            professors: professors
        },
        methods: {
            hide: function(){
                this.errorMessage = "";
            }
        }
    })
}