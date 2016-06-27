/**
 *
 */

$("#beginYear, #beginMonth, #beginDay").datepicker({
    dateFormat : "yy/mm/dd",
    dayNamesMin : [ '日', '月', '火', '水', '木', '金', '土' ],
    onSelect : function(dateText, inst) {
        const beginOrderDate = dateText.split('/');
        $("#beginYear").val(beginOrderDate[0]);
        $("#beginMonth").val(beginOrderDate[1]);
        $("#beginDay").val(beginOrderDate[2]);
    }
});

$("#endYear, #endMonth, #endDay").datepicker({
    dateFormat : "yy/mm/dd",
    dayNamesMin : [ '日', '月', '火', '水', '木', '金', '土' ],
    onSelect : function(dateText, inst) {
        const endOrderDate = dateText.split('/');
        $("#endYear").val(endOrderDate[0]);
        $("#endMonth").val(endOrderDate[1]);
        $("#endDay").val(endOrderDate[2]);
    }
});