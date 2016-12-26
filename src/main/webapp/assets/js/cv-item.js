/**
 * Created by edenasevic on 12/19/16.
 */

var cvItem;

var uploadCvItemAttachment = function() {
    var completed, percent, status, submitButton, cvItemFileUploadForm;
    percent = $("#fileUploadPercents");
    status = $('#uploadStatus');
    submitButton = $('#uploadFile');
    cvItemFileUploadForm = $('#cvItemFileUploadForm');
    completed = '0%';
    $(cvItemFileUploadForm).ajaxSubmit({
        beforeSend: function() {
            status.addClass('alert alert-info');
            status.show();
            status.html('<strong>Uploading, please wait...</strong>');
            submitButton.addClass('disabled');
            percent.html(completed);
        },
        uploadProgress: function(event, position, total, percentComplete) {
            percent.html(percentComplete + '%');
            if (percentComplete < 50) {
                percent.css('color', 'red');
            }
            if (percentComplete > 50 && percentComplete < 100) {
                percent.css('color', 'orange');
            }
            if (percentComplete === 100) {
                status.html('<div class="spinner spinner-color">' +
                    '<strong>Uploading to FTP please wait...</strong></div>');
                percent.css('color', 'green');
            }
        },
        complete: function(response) {
            status.removeClass('alert alert-info');
            submitButton.removeClass('disabled');
            if (response.status === 200) {
                status.html('<div class="alert alert-success">' +
                    '<strong>File uploaded successfully</strong>' +
                    '\u000d\n<a href="#" class="close text-right" data-dismiss="alert" aria-label="close"></a>' +
                    '</div>');
            } else if (response.status === 400) {
                status.html('<div class="alert alert-danger">' +
                    '<strong>File upload failed due to empty file</strong>' +
                    '\u000d\n<a href="#" class="close text-right" data-dismiss="alert" aria-label="close"></a>' +
                    '</div>');
                cvItemFileUploadForm.resetForm();
                percent.html('0%');
                percent.css('color', 'black');
            } else {
                status.html('<div class="alert alert-danger">' +
                    '<strong>File upload failed</strong>' +
                    '\u000d\n<a href="#" class="close text-right" data-dismiss="alert" aria-label="close"></a>' +
                    '</div>');
            }
        }
    });
};

var deleteUpload = function() {
    console.log("Radi funkcija!")
};