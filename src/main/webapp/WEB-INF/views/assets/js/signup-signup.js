//
//$('#txtDate').datepicker();
//
//$(function() {
//    $.validator.addMethod("kor", function(value, element) {
//        return this.optional(element) || /^[ㄱ-ㅎ가-힣]*$/.test(value);
//    });
//
//    $("#join_form").validate({
//        rules: {
//
//            email: {
//                required: true,
//                email: true
//                remote: {
//                    url: ROOT_URL + '/rest/signup/email_unique_check_jquery',
//                    type: 'post',
//                    data: {
//                        email: function() {
//                            return $("#email").val();
//                        }
//                    }
//                }
//            },
//            user_pw: {
//                required: true,
//                minlength: 4,
//                maxlength: 20
//            },
//            user_pw_re: {
//                required: true,
//                equalTo: "#user_pw"
//            },
//            user_name: {
//                //kor:true,
//                required: true
//            },
//
//            txtDate: {
//                required: true,
//                minlength: 4,
//                maxlength: 4
//            },
//            /*  year : {
//                    required : true,
//                    minlength : 4,
//                    maxlength : 4,
//                    range : [ 1900, 2020 ]
//                },
//                month : {
//                    required : true,
//
//                },
//                day : {
//                    required : true,
//                    minlength : 1,
//                    maxlength : 2,
//                    min : 1,
//                    max : 31
//                },
//                */
//
//            num_gogo: {
//                required: true
//            }
//        },
//        messages: {
//            email: {
//                required: "이메일을 입력해 주세요.",
//                email: "이메일 형식에 맞지 않습니다"
//                remote: '이미 사용중인 이메일 입니다.'
//            },
//            user_pw: {
//                required: "비밀번호를 입력해 주세요.",
//                minlength: "4~20자로 입력해주세요.",
//                maxlength: "4~20자로 입력해주세요."
//            },
//            user_pw_re: {
//                required: "비밀번호를 재입력 해 주세요.",
//                equalTo: "재입력한 비밀번호가 일치하지  않습니다."
//            },
//
//            txtDate: {
//                required: "클릭하여 생년월일을 선택해 주세요.",
//                minlength: "생년월일을 다시한번 확인해주세요.",
//                maxlength: "생년월일을 다시한번 확인해주세요."
//            },
//            user_name: {
//                //kor:"한글만 입력가능합니다.",
//                required: "이름을 입력해주세요."
//            }
//
//
//        }
//    });
//
//    $("#email-unique-check").click(function(e) {
//        const email = $("#email").val();
//
//        if (!email) {
//            swal('알림', '이메일을 입력하세요.', 'warning');
//            return;
//        }
//        $.post(ROOT_URL + '/rest/signup/email_unique_check', {
//            email: email
//        }, function(json) {
//            swal('확인', '사용가능한 이메일 입니다.', 'success');
//        });
//    });
//
//});
//$(function() {
//    $("#ok").click(function() {
//        if ($(form).valid()) {
//            alert("회원가입완");
//
//        } else {
//            alert("회원가입완료");
//        }
//    });
//});