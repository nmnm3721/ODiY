<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


 <div class="container">
        <div>
            <h2 align="center">회원가입</h2>
            <hr />
        </div>
        <div>
            <!--아이디시작-->
            <form>
                <div class="form-group input-id">
                    <label for="exampleInputEmail1">아이디</label>
                    <div><input type="email" class="form-control" placeholder="문자를 입력하세요" aria-describedby="emailHelp">
                    </div>
                    <small id="emailHelp" class="form-text text-muted">
                        <font color="#0067a3">
                            5~20자의 영문 소문자,숫자와 특수기호(_),(-)만 사용가능합니다.</font>
                    </small>
                    <!--**아이디 끝-->
                </div>
                <div class="form-group input-pw">
                    <!--비밀번호 시작-->
                    <label for="inputPassword5">비밀번호</label>
                    <input type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock" placeholder="비밀번호를 정해주세요">
                    <small id="passwordHelpBlock" class="form-text text-muted">
                        <font color="#0067a3">
                            4~16자 영문 대 소문자,숫자,특수문자를 사용하세요.
                        </font>
                    </small>
                    <!--**비밀번호 끝-->
                </div>
                <div class="form-group input-pw2">
                    <!--비밀번호 재확인 시작-->
                    <label for="inputPassword5">비밀번호 재확인</label>
                    <input type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock" placeholder="정한 비밀번호를 입력하세요">
                    <small id="passwordHelpBlock" class="form-text text-muted">
                        <font color="#0067a3">
                            비밀번호가 일치하지 않습니다.</font>
                    </small>
                    <!--**비밀번호 재확인 끝-->
                </div>
                <div class="form-group input-name">
                    <!--이름 시작-->
                    <label for="inputPassword5">이름</label>
                    <div>
                        <input type="text" class="form-control" placeholder="문자를 입력하세요">
                    </div>
                    <small id="passwordHelpBlock" class="form-text text-muted">
                        <font color="#0067a3">
                            5~20자의 영문 소문자,숫자와 특수기호(_),(-)만 사용가능합니다.</font>
                    </small>
                    <!--**이름 끝-->
                </div>
                <!--**이름 끝-->
                <div class="form-row input-birth">
                    <div class="col-3 ">
                        <label for="validationCustom03">년</label>
                        <input type="text" class="form-control" id="validationCustom03" required>
                        <div class="invalid-feedback">
                            Please provide a valid city.
                        </div>
                    </div>
                    <div class="col-6 ">
                        <label for="validationCustom04">월</label>
                        <select class="custom-select" id="validationCustom04" required>
                            <option selected disabled value="">월을 골라주세요</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                            <option>11</option>
                            <option>12</option>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid state.
                        </div>
                    </div>
                    <div class="col-3 ">
                        <label for="validationCustom05">일</label>
                        <input type="text" class="form-control" id="validationCustom05" required>
                        <div class="invalid-feedback">
                            Please provide a valid zip.
                        </div>
                    </div>
                </div>
                <div class="form-group input-seibetu">
                    <!--성별 시작-->
                    <label for="inputPassword5">성별</label>
                    <form class="seibetu">
                        <!---->
                        <!---->
                        <select class="custom-select my-3 mr-sm-2 seibetu2 id=" inlineFormCustomSelectPref">
                            <option selected>성별을 선택하세요</option>
                            <option value="1">남자</option>
                            <option value="2">여자</option>
                        </select>
                    </form>
                    <!--**성별 끝-->
                </div>
                <div class="form-group input-email">
                    <!--이메일 시작-->
                    <!--새롭게-->
                    <label for="inputPassword5">이메일</label>
                    <div class="form-group">
                        <input type="email" class="form-control" id="exampleInputEmail2" placeholder="ODiY@example.com">
                    </div>
                    <input type="text" class="birth" placeholder="인증번호(4자)">
                    <button class="btn btn-primary" type="submit">인증번호전송</button>
                    <p><small id="passwordHelpBlock" class="form-text text-muted">
                            <font color="#0067a3">
                                인증번호를 입력해주세요</font>
                        </small></p>
                    <button type="button" class="btn btn-primary btn-lg btn-block">회원가입</button>
                </div>
            </form>
        </div>
    </div>
    <!--**이메일 끝-->