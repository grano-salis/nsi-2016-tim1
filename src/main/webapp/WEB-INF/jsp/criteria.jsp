<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>jQuery Easy Tree Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/easyTree.css">
    <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="src/easyTree.js"></script>
<style>
body {
background: #eee;
}
</style>
</head>
<body>
<%--<div id="jquery-script-menu">
<div class="jquery-script-center">
&lt;%&ndash;<div class="jquery-script-ads"><script type="text/javascript"><!--
/*google_ad_client = "ca-pub-2783044520727903";
/!* jQuery_demo *!/
google_ad_slot = "2780937993";
google_ad_width = 728;
google_ad_height = 90;*/
//-->
</script>
&lt;%&ndash;<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script>&ndash;%&gt;</div>&ndash;%&gt;
<div class="jquery-script-clear"></div>
</div>
</div>--%>
<div class="col-md-3" style="margin-top:150px;">
<h3 class="text-success">Easy Tree Example</h3>
<div id="criteriaTree" class="easy-tree">
    <ul>
        <li v-bind:id='buildId(criterij_lvl1.id,criterij_lvl1.criteriaLevel)' v-for="criterij_lvl1 in criteria1">{{criterij_lvl1.name}}

            <ul  v-if="criteria_level(2,criterij_lvl1) != '' ">
                <li  v-bind:id='buildId(criterij_lvl2.id,criterij_lvl2.criteriaLevel)' v-for="criterij_lvl2 in criteria_level(2,criterij_lvl1)">{{criterij_lvl2.name}}

                    <ul v-if="criteria_level(3,criterij_lvl2) != '' ">
                        <li v-bind:id='buildId(criterij_lvl3.id,criterij_lvl3.criteriaLevel)' v-for="criterij_lvl3 in criteria_level(3,criterij_lvl2)">{{criterij_lvl3.name}}

                            <ul v-if="criteria_level(4,criterij_lvl3) != '' ">
                                <li v-bind:id='buildId(criterij_lvl4.id,criterij_lvl4.criteriaLevel)' v-for="criterij_lvl4 in criteria_level(4,criterij_lvl3)">{{criterij_lvl4.name}}

                                    <ul v-if="criteria_level(5,criterij_lvl4) != '' ">
                                        <li v-bind:id='buildId(criterij_lvl5.id,criterij_lvl5.criteriaLevel)' v-for="criterij_lvl5 in criteria_level(5,criterij_lvl4)">{{criterij_lvl5.name}}

                                            <ul v-if="criteria_level(6,criterij_lvl5) != '' ">
                                                <li v-bind:id='buildId(criterij_lvl6.id,criterij_lvl6.criteriaLevel)' v-for="criterij_lvl6 in criteria_level(6,criterij_lvl5)">{{criterij_lvl6.name}}

                                                    <ul v-if="criteria_level(7,criterij_lvl6) != '' ">
                                                        <li v-bind:id='buildId(criterij_lvl7.id,criterij_lvl7.criteriaLevel)' v-for="criterij_lvl7 in criteria_level(7,criterij_lvl6)">{{criterij_lvl7.name}}

                                                            <ul v-if="criteria_level(8,criterij_lvl7) != '' ">
                                                                <li v-bind:id='buildId(criterij_lvl8.id,criterij_lvl8.criteriaLevel)' v-for="criterij_lvl8 in criteria_level(8,criterij_lvl7)">{{criterij_lvl8.name}}


                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
</div>
</div>
<script>
//    (function ($) {
//        function init() {
//            $('.easy-tree').EasyTree({
//                addable: true,
//                editable: true,
//                deletable: true
//            });
//        }
//
//        window.onload = init();
//    })(jQuery)
</script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
<script src="assets/js/criteria.js"></script>
<script src="assets/js/vue.js"></script>
<script src="assets/js/jquery.min.js"></script>
<script src="src/easyTree.js"></script>



</body>
</html>
