/** 
* ��̬������JS  by xcl 
* ��Ŀ��ַ��https://github.com/xucongli1989/dynamicCon 
* ʹ�ã� 
* ����jquery��ʱ���ڽ���������֧��live�󶨣���ʹ�ý��°汾�� 
* $.DynamicCon(); 
* ��ǰ�汾��v1.3 
* �������ڣ�2015-05-05 
* �������ݣ� 
* 1�����options�¼�����ӻ�ɾ����֮ǰ���¼�beforeAddOrDel�� 
* 2�����options�¼������������л�����о���overflowMsg�� 
* 3���޸��°�jquery��ʹ��on�󶨵�bug 
* 4�����$.DynamicCon.GetOptions("");���� 
* 5����options.container������Ķ����У��������"dynamicCon-sumRows"����ʾ��ǰ���������� 
*/  
(function ($) {  
    var defaults = {  
        container: ".dynamicCon", //����������class  
        temp: ".temp", //ģ���class  
        items: ".items", //������class  
        minCount: 1, //�����е���С����   
        maxCount: 50, //�����е��������  
        addBtn: ".addBtn", //��Ӱ�ťclass  
        delBtn: ".delBtn", //ɾ����ťclass  
        indexClass: ".dynamicCon-Index",//��ʾ��ŵ�class���磺<span class="dynamicCon-Index"></span>  
        autoCreateIdIndexClass: ".dynamicCon-autoCreateIdIndex",//�Զ�����id������class�����磬Ԫ��A��id='txt'�������ΪA��id='txt1','txt2','txt3'...  
        beforeAddOrDel: function (handleType) { return true; },//handleType����������  ����Ӻ��ɾ��ǰ�¼�,���е�thisΪ��ť�����������false������ֹ���ӻ�ɾ���С�  
        afterAddOrDel: function (handleType) { },//handleType����������  ����Ӻ��ɾ�����¼�,���е�thisΪ��ť����  
        overflowMsg: function (msg) { alert(msg); return false; }//msg����ʾ�����֡� ������С���������������Χ��ʾ���������е�thisΪ��ť�����������false������ֹ���ӻ�ɾ���С�  
    };  
  
    //�洢���������Ĳ��ѡ��  
    var _optionsObject = {};  
  
    $.extend({  
        DynamicCon: function (options) {  
            var _this=this;  
            options = $.extend({}, defaults, options || {});  
            _optionsObject[options.container] = options;  
            var $conAll = $(options.container);  
            $conAll.each(function (i) {  
                //��ǰ��������Ӧ������øò���������  
                var $con = $(this);  
  
                //��ǰ�����е�ģ����  
                var $temp = $con.find(options.temp);  
  
                //����ģ���е�classΪ�����е�class  
                $temp.removeClass(options.temp.substring(1, options.temp.length)).addClass(options.items.substring(1, options.items.length)).wrap("<div style='display:none'></div>");  
  
                //��ģ���html�ַ�������ڱ�����  
                var tempHtml = $temp.parent().html();  
  
                //ɾ��ģ��dom  
                $temp.parent().remove();  
  
                //�����к�  
                var updateLineNumber = function () {  
                    var $conItems=$con.find(options.items);  
                    $conItems.each(function (index,n) {  
                        var idx = index + 1;  
                        $(n).find(options.indexClass).text(idx);  
                        $(n).attr({ "dynamicCon-index": idx });  
                        $(n).find(options.autoCreateIdIndexClass).filter("[id]").each(function () {  
                            var oldId = $(this).attr("dynamicCon-oldId"), id = $(this).attr("id");  
                            if (oldId) {  
                                $(this).attr({ "id": oldId + "" + idx.toString() });  
                            } else {  
                                $(this).attr({ "dynamicCon-oldId": id });  
                                $(this).attr({ "id": id + "" + idx.toString() });  
                            }  
                        });  
                    });  
                    $con.attr({ "dynamicCon-sumRows": $conItems.length });  
                };  
                updateLineNumber();  
  
  
                //������¼� �����Ƴ��󶨵��¼�����Ҫ�Ǳ���ʹ��jsģ��Ȳ����̬��������ʱ���ظ������⡣��  
                $con.off("click", options.addBtn).on("click", options.addBtn, function () {  
                    if (!options.beforeAddOrDel.call(this, _this.DynamicCon.HandleTypeEnum.Add)) return false;  
  
                    var $conThis = $($conAll[i]);  
                    if ($conThis.find(options.items).length == options.maxCount) {  
                        if (!options.overflowMsg.call(this, "���ֻ�����" + options.maxCount + "�У�")) {  
                            return false;  
                        }  
                    }  
                    $(this).closest(options.items).after(tempHtml);  
                    updateLineNumber();  
  
                    options.afterAddOrDel.call(this, _this.DynamicCon.HandleTypeEnum.Add);  
                });  
  
                //ɾ�����¼�  
                $con.off("click", options.delBtn).on("click", options.delBtn, function () {  
                    if (!options.beforeAddOrDel.call(this, _this.DynamicCon.HandleTypeEnum.Del)) return false;  
  
                    var $conThis = $($conAll[i]);  
                    if ($conThis.find(options.items).length == options.minCount) {  
                        if (!options.overflowMsg.call(this, "����Ҫ��" + options.minCount + "�У�")) {  
                            return false;  
                        }  
                    }  
                    $(this).closest(options.items).remove();  
                    updateLineNumber();  
  
                    options.afterAddOrDel.call(this, _this.DynamicCon.HandleTypeEnum.Del);  
                });  
  
            });  
        }  
    });  
  
    /** 
    * �������� 
    */  
    $.DynamicCon.HandleTypeEnum = {  
        //���  
        Add: "Add",  
        //ɾ��  
        Del:"Del"  
    };  
  
    /** 
    * ��ȡѡ�� 
    */  
    $.DynamicCon.GetOptions = function (container) {  
        return _optionsObject[container || defaults.container] || null;  
    };  
  
})(jQuery);