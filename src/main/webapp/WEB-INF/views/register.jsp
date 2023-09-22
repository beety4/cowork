<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>cowork - Register</title>

    <!-- Custom fonts for this template-->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="/css/custom.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form class="user" action="sign-up.do" method="post" name="register">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="id"
                                            name="id" placeholder="Your ID">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="name"
                                            name="name" placeholder="Your Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user w80fl" id="email"
                                        name="email" placeholder="Email Address">
                                    <input type="button" class="btn btn-primary btn-user btn-block"
                                	value="인증번호 전송" style="width:20%;" onclick="sendKey();">
                                </div>
                                <div class="form-group" style="text-align:center;display:none; color:red;" id="time" name="time"></div>
                                <div class="form-group" id="check" name="check" style="display:none;">
                                    <input type="text" class="form-control form-control-user w80fl" id="authKey"
                                        name="authKey" placeholder="Certification Number">
                                    <input type="button" class="btn btn-primary btn-user btn-block"
                                	value="인증번호 확인" style="width:20%;" onclick="checKey();">
                                </div>
                                
                                <div id="Confirm" style="hidden"></div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                            id="password" name="password" placeholder="Password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="passwordchk" name="passwordchk" placeholder="Repeat Password">
                                    </div>
                                </div>
                                <div class="form-group row">
                                	<div class="col-sm-6">
                                        <input type="date" class="form-control form-control-user"
                                            id="birth" name="birth">
                                    </div>
                                    <div class=" mb-3 mb-sm-0">
                                    	<div style="float:left;margin-left:65px;">
                                        <input type="radio" class="form-control form-control-user"
                                            name="gender" value="M">남자
                                        </div>
                                        <div style="float:left;margin-left:65px;">
                                        <input type="radio" class="form-control form-control-user"
                                            name="gender" value="F">여자
                                        </div>
                                    </div>
                                </div>
                                <input type="button" class="btn btn-primary btn-user btn-block"
                                	value="Register Account" onclick="registercheck();">
                                <hr>
                                <a href="index.html" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/vendor/jquery/jquery.min.js"></script>
    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/js/sb-admin-2.min.js"></script>
    <script src="/js/validate.js"></script>
    <script src="/js/emailAuth.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

</body>

</html>