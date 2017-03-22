<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Restopedia - Sign Up</title>
        <link href='{{ URL::asset('assets/img/logo.png') }}' rel='shortcut icon'>

        <!-- CSS -->
        <link href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500" rel="stylesheet">
        <link href="<?php echo base_url(); ?>/assets-login/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="<?php echo base_url(); ?>/assets-login/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="<?php echo base_url(); ?>/assets-login/css/form-elements.css" rel="stylesheet">
        <link href="<?php echo base_url(); ?>/assets-login/css/style.css" rel="stylesheet">

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="<?php echo base_url(); ?>/assets-login/ico/favicon.png" rel="stylesheet">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<?php echo base_url(); ?>/assets-login/ico/apple-touch-icon-144-precomposed.png" rel="stylesheet">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<?php echo base_url(); ?>/assets-login/ico/apple-touch-icon-114-precomposed.png" rel="stylesheet">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<?php echo base_url(); ?>/assets-login/ico/apple-touch-icon-72-precomposed.png" rel="stylesheet">
        <link rel="apple-touch-icon-precomposed" href="<?php echo base_url(); ?>/assets-login/ico/apple-touch-icon-57-precomposed.png" rel="stylesheet">

    </head>

    <body>
        <!-- Top content -->
        <div class="top-content headertext">
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                          <h1><strong>Restopedia</strong> | Sign Up</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Sign up to Restopedia Developer Portal</h3>
                            		<p>Enter your username and password to sign up :</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
                        <?php echo form_open('Welcome/daftar'); ?>
			                    <form method="post" enctype="multipart/form-data">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="username" placeholder="Username..." class="form-username form-control" id="username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="password">
			                        </div>
			                        <button type="submit" name="submit" value="Daftar" class="btn">Sign Up!</button>
			                    </form>
                        <?php echo form_close(); ?>
		                    </div>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <div class="description">
                            	<p>
	                            	 Copyright © 2017 Restopedia | Design by Babarsari Corp
                            	</p>
                            </div>
                        </div>
                       </div>
                </div>
            </div>
        </div>
        </body>
        <!-- Javascript -->
        <script type="text/javascript" src="<?php echo base_url(); ?>/assets-login/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="<?php echo base_url(); ?>/assets-login/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="<?php echo base_url(); ?>/assets-login/js/jquery.backstretch.min.js"></script>
        <script type="text/javascript" src="<?php echo base_url(); ?>/assets-login/js/scripts.js"></script>
</html>
