/**
 * An easy tree view plugin for jQuery and Bootstrap
 * @Copyright yuez.me 2014
 * @Author yuez
 * @Version 0.1
 */
(function ($) {
    $.fn.EasyTree = function (options) {
        var defaults = {
            selectable: true,
            deletable: false,
            editable: false,
            addable: false,
            i18n: {
                deleteNull: 'Select a node to delete',
                deleteMultiple: 'Only one node can be deleted at one time',
                deleteConfirmation: 'Delete this node?',
                confirmButtonLabel: 'Confirm',
                editNull: 'Select a node to edit',
                editMultiple: 'Only one node can be edited at one time',
                addMultiple: 'Select a node to add a new node',
                collapseTip: 'Collapse',
                expandTip: 'Expand',
                selectTip: 'Select',
                unselectTip: 'Unselect',
                editTip: 'Edit',
                addTip: 'Add',
                deleteTip: 'Delete',
                cancelButtonLabel: 'Cancel'
            }
        };

        var warningAlert = $('<div class="alert alert-warning alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true" style="height: 40px">&times;</button><strong></strong><span class="alert-content"></span> </div> ');
        var dangerAlert = $('<div class="alert alert-danger alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><strong></strong><span class="alert-content"></span> </div> ');

        var createInput = $('<div style="margin-left: 30%"> <input placeholder="Name.." type="text" class="form-control name" style="background-color: rgba(75, 75, 93, 0.85);color:whitesmoke;border-radius: 10px;margin-left: 2%;width: 50%;"><input placeholder="Points.." type="number" class="form-control points" style="font-weight: 800;background-color: rgba(75, 75, 93, 0.85); color:whitesmoke;width: 50%;margin-left: 2%"> <textarea class="form-control" placeholder="Description.." style="font-weight: 800;background-color: rgba(75, 75, 93, 0.85);color:whitesmoke;width: 50%;margin-left: 2%" rows="4"></textarea></div><br><div class="input-group"> <span class="input-group-btn"><button style="margin-left: 300px" type="button" class="btn btn-default btn-success confirm"></button></span><span class="input-group-btn"><button style="margin-left: -135px" type="button" class="btn btn-default cancel"></button></span></div>');

        options = $.extend(defaults, options);

        this.each(function () {
            var easyTree = $(this);
            $.each($(easyTree).find('ul > li'), function() {
                var text;
                if($(this).is('li:has(ul)')) {
                    var children = $(this).find(' > ul');
                    $(children).remove();
                    text = $(this).text();
                    $(this).html('<span><span class="glyphicon"></span><a href="javascript: void(0);"></a> </span>');
                    $(this).find(' > span > span').addClass('glyphicon-file');
                    $(this).find(' > span > a').text(text);
                    $(this).append(children);
                }
                else {
                    text = $(this).text();
                    $(this).html('<span><span class="glyphicon"></span><a href="javascript: void(0);"></a> </span>');
                    $(this).find(' > span > span').addClass('glyphicon glyphicon-list-alt');
                    $(this).find(' > span > a').text(text);
                }
            });

            $(easyTree).find('li:has(ul)').addClass('parent_li').find(' > span').attr('title', options.i18n.collapseTip);

            // add easy tree toolbar dom
            if (options.deletable || options.editable || options.addable) {
                $(easyTree).prepend('<div class="easy-tree-toolbar"></div> ');
            }
            
            // collapse or expand
            $(easyTree).delegate('li.parent_li > span', 'click', function (e) {
                var children = $(this).parent('li.parent_li').find(' > ul > li');
                if (children.is(':visible')) {
                    children.hide('fast');
                    $(this).attr('title', options.i18n.expandTip)
                        .find(' > span.glyphicon')
                        .addClass('glyphicon-folder-close')
                        .removeClass('glyphicon-file');
                } else {
                    children.show('fast');
                    $(this).attr('title', options.i18n.collapseTip)
                        .find(' > span.glyphicon')
                        .addClass('glyphicon-file')
                        .removeClass('glyphicon-folder-close');
                }
                e.stopPropagation();
            });

            // selectable, only single select
            if (options.selectable) {
                $(easyTree).find('li > span > a').attr('title', options.i18n.selectTip);
                $(easyTree).find('li > span > a').click(function (e) {
                    var li = $(this).parent().parent();
                    if (li.hasClass('li_selected')) {
                        $(this).attr('title', options.i18n.selectTip);
                        $(li).removeClass('li_selected');
                    }
                    else {
                        $(easyTree).find('li.li_selected').removeClass('li_selected');
                        $(this).attr('title', options.i18n.unselectTip);
                        $(li).addClass('li_selected');
                    }

                    if (options.deletable || options.editable || options.addable) {
                        var selected = getSelectedItems();
                        if (options.editable) {
                            if (selected.length <= 0 || selected.length > 1)
                                $(easyTree).find('.easy-tree-toolbar .edit > button').addClass('disabled');
                            else
                                $(easyTree).find('.easy-tree-toolbar .edit > button').removeClass('disabled');
                        }

                        if (options.deletable) {
                            if (selected.length <= 0 || selected.length > 1)
                                $(easyTree).find('.easy-tree-toolbar .remove > button').addClass('disabled');
                            else
                                $(easyTree).find('.easy-tree-toolbar .remove > button').removeClass('disabled');
                        }
                        if (options.addable) {
                            if (selected.length <= 0 || selected.length > 1)
                                $(easyTree).find('.easy-tree-toolbar .create > button').addClass('disabled');
                            else
                                $(easyTree).find('.easy-tree-toolbar .create > button').removeClass('disabled');
                        }

                    }

                    e.stopPropagation();

                });
            }

            // Get selected items
            var getSelectedItems = function () {
                return $(easyTree).find('li.li_selected');
            };
        });
    };
})(jQuery);
