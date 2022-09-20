$(document).ready(function () {
    $('.alert .close').on('click', function (e) {
        var self = $(this)
        self.closest('div').slideUp(200, function (e) {
            self.closest('div').remove()
        });
    });
    if (typeof ($.datepicker) != 'undefined') {
        $.datepicker.setDefaults({
            dateFormat: 'yy-mm-dd',
            prevText: '이전 달',
            nextText: '다음 달',
            monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
            dayNames: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
            showMonthAfterYear: true,
            yearSuffix: '년'
        });
    }
});

function settingDatePicker(arr, form) {
    if (arr.length > 0) {
        let $form = $('form[name="' + form + '"]');
        if (arr.length == 1) {
            $form.find('input[name="' + arr[0] + '"]').datepicker();
        } else if (arr.length == 2) {
            $form.find('input[name="' + arr[0] + '"]').datepicker();
            $form.find('input[name="' + arr[0] + '"]').datepicker('option', 'maxDate', $form.find('input[name="' + arr[1] + '"]').val());
            $form.find('input[name="' + arr[0] + '"]').datepicker('option', 'onClose', function (selected) {
                $form.find('input[name="' + arr[1] + '"]').datepicker('option', 'minDate', selected);
            });
            $form.find('input[name="' + arr[1] + '"]').datepicker();
            $form.find('input[name="' + arr[1] + '"]').datepicker('option', 'minDate', $form.find('input[name="' + arr[0] + '"]').val());
            $form.find('input[name="' + arr[1] + '"]').datepicker('option', 'onClose', function (selected) {
                $form.find('input[name="' + arr[0] + '"]').datepicker("option", "maxDate", selected);
            });
        }
    }
}

function settingMonthPicker(tagName) {
    let nowDate = new Date();
    let year = nowDate.getFullYear();
    options = {
        pattern: 'yyyy-mm',
        selectedYear: year,
        startYear: year - 5,
        finalYear: year + 5,
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
    };
    $('input[name="' + tagName + '"]').monthpicker(options);
}

/**
 * 다음 주소 찾기
 * @param arr
 * @param form
 * @param flag
 */
function getAddressSearch(arr, form, flag) {
    new daum.Postcode({
        oncomplete: function (data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if (data.userSelectedType === 'R') {
                //법정동명이 있을 경우 추가한다.
                if (data.bname !== '') {
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if (data.buildingName !== '') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
            }

            var $target_form = $("form[name='" + form + "']");
            $target_form.find("input[name='" + arr[0] + "']").val(data.zonecode);
            $target_form.find("input[name='" + arr[1] + "']").val(fullAddr);
            $target_form.find("input[name='" + arr[2] + "']").focus();

            if (typeof (flag) != 'undefined') {
                if (flag) {
                    // 주소로 상세 정보를 검색
                    geocoder.addressSearch(data.address, function (results, status) {
                        // 정상적으로 검색이 완료됐으면
                        if (status === daum.maps.services.Status.OK) {

                            var result = results[0]; //첫번째 결과의 값을 활용

                            $target_form.find('input[name="x"]').val(result.x);
                            $target_form.find('input[name="y"]').val(result.y);

                            // 해당 주소에 대한 좌표를 받아서
                            var coords = new daum.maps.LatLng(result.y, result.x);

                            // 지도를 보여준다.
                            mapContainer.style.display = "block";
                            map.relayout();

                            // 지도 중심을 변경한다.
                            map.setCenter(coords);

                            // 마커를 결과값으로 받은 위치로 옮긴다.
                            marker.setPosition(coords)
                        }
                    });
                }
            }
        }
    }).open();
}

function option(width, height) {
    if (width == '') width = 700
    if (height == '') height = 660

    var left = (screen.availWidth - width) / 2
    var top = (screen.availHeight - height) / 2
    var specs = 'width=' + width
    specs += ',height=' + height
    specs += ',left=' + left
    specs += ',top=' + top

    return specs
}

/**
 * 랜덤 코드 (접두사 + 랜덤코드 + 시간)
 * @param prefix
 * @param len
 * @returns {string}
 */
function makeRandomCode(prefix, len) {
    let code = '';
    const characters = '123456789';
    const charactersLength = characters.length;

    for (var i = 0; i < len; i++) {
        code += characters.charAt(Math.floor(Math.random() * charactersLength));
    }

    return prefix + code;
}

function makeOrderCode(prefix, orderDate) {
    let time = new Date().getTime();

    return prefix + orderDate + "_" + time;
}

function purchaseAccountListPopup(value) {
    window.open(
        '/popup/PurchaseAccountList.do?value='+value,
        'popup_PurchaseAccount_list',
        option(1100, 700) + ', toolbar=no,menubar=no,status=no,scrollbar=no,resizable=no'
    );
}

function salesAccountListPopup(value) {
    window.open(
        '/popup/SalesAccountList.do?value='+value,
        'popup_SalesAccount_list',
        option(1100, 700) + ', toolbar=no,menubar=no,status=no,scrollbar=no,resizable=no'
    );
}

function materialListPopup(name) {
    window.open(
        '/popup/MaterialList.do?name='+name,
        'popup_material_list',
        option(1100, 700) + ', toolbar=no,menubar=no,status=no,scrollbar=no,resizable=no'
    );
}

function productListPopup(name) {
    window.open(
        '/popup/ProductList.do?name='+name,
        'popup_product_list',
        option(1100, 800) + ', toolbar=no,menubar=no,status=no,scrollbar=no,resizable=no'
    )
}


function materialIncomeListPopup() {
    window.open(
        '/popup/MaterialIncomeList.do',
        'popup_materialIncome_list',
        option(1100, 700) + ', toolbar=no,menubar=no,status=no,scrollbar=no,resizable=no'
    );
}

function passwordValidationCheck(password){
    console.log(password)
    const passwordRegExp = /^(?=.*[!@#$%^&*()-])(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,16}$/;
    if (passwordRegExp.test(password)){
        return true
    }
    return false;
}

function materialStockPopup(){
    window.open(
        '/popup/materialStockList.do',
        'material_stock_list',
        option(1300, 700) + ', toolbar=no,menubar=no,status=no,scrollbar=no,resizable=no'
    );
}