<!DOCTYPE html>
<html lang="en-US">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width" />
      <title>Restopedia - Developer Portal</title>
      <link rel="icon" href="<?php echo base_url(); ?>/assets/img/icon-restopedia.png"/>
      <link href="<?php echo base_url(); ?>/assets/css/components.css" rel="stylesheet">
      <link href="<?php echo base_url(); ?>/assets/css/responsee.css" rel="stylesheet">
      <link href="<?php echo base_url(); ?>/assets/owl-carousel/owl.carousel.css" rel="stylesheet">
      <link href="<?php echo base_url(); ?>/assets/owl-carousel/owl.theme.css" rel="stylesheet">
      <link href="<?php echo base_url(); ?>/assets/css/templatemo-style.css" rel="stylesheet">
      <!-- CUSTOM STYLE -->
      <link href="<?php echo base_url(); ?>/assets/css/template-style.css" rel="stylesheet">
      <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
      <script type="text/javascript" src="<?php echo base_url(); ?>/assets/js/jquery-1.8.3.min.js"></script>
      <script type="text/javascript" src="<?php echo base_url(); ?>/assets/js/jquery-ui.min.js"></script>
      <script type="text/javascript" src="<?php echo base_url(); ?>/assets/js/modernizr.js"></script>
      <script type="text/javascript" src="<?php echo base_url(); ?>/assets/js/responsee.js"></script>
      <!--[if lt IE 9]>
	      <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
      <![endif]-->
   </head>
   <body class="size-1140">
      <!-- TOP NAV WITH LOGO -->
      <header>
         <nav>
            <div class="line">
               <div class="top-nav">
                  <div class="logo hide-l">
                    <?php if($this->session->userdata('username')!="") {?>
                      <a href="<?php echo site_url('welcome/dasboard')?>">RESTO<br/><strong>PEDIA</strong></a>
                    <?php } ?>
                    <?php if($this->session->userdata('username')=="") { ?>
                      <a href="<?php echo site_url('welcome/dasboard')?>">RESTO<br/><strong>PEDIA</strong></a>
                    <?php } ?>
                  </div>
                  <p class="nav-text">Options</p>
                  <div class="top-nav s-12 l-5">
                     <ul class="right top-ul chevron">
                       <?php if($this->session->userdata('username')!="") {?>
                         <li><a href="<?php echo site_url('welcome/dasboard')?>">Home</a></li>
                       <?php } ?>
                       <?php if($this->session->userdata('username')=="") { ?>
                         <li><a href="<?php echo site_url('welcome/index')?>">Home</a></li>
                       <?php } ?>
                        <li><a href="<?php echo site_url('welcome/about')?>">About</a></li>
                     </ul>
                  </div>
                  <ul class="s-12 l-2">
                     <li class="logo hide-s hide-m">
                        <?php if($this->session->userdata('username')!="") {?>
                          <a href="<?php echo site_url('welcome/dasboard')?>">RESTO<br/><strong>PEDIA</strong></a>
                        <?php } ?>
                        <?php if($this->session->userdata('username')=="") { ?>
                          <a href="<?php echo site_url('welcome/dasboard')?>">RESTO<br/><strong>PEDIA</strong></a>
                        <?php } ?>
                     </li>
                  </ul>
                  <div class="top-nav s-12 l-5">
                     <ul class="top-ul chevron">
                       <?php if($this->session->userdata('username')!="") {?>
                         <li><a href="<?php echo site_url('welcome/dasboard')?>"><?php echo $this->session->userdata('username')?></a></li>
                         <li><a href="<?php echo site_url('welcome/logout')?>">Sign Out</a></li>
                       <?php } ?>
                       <?php if($this->session->userdata('username')=="") { ?>
                         <li><a href="<?php echo site_url('welcome/signup')?>">Sign Up</a></li>
                         <li><a href="<?php echo site_url('welcome/login')?>">Sign In</a></li>
                       <?php } ?>
                     </ul>
                  </div>
               </div>
            </div>
         </nav>
      </header>
      <section>
         <!-- CAROUSEL -->
         <div id="carousel">
            <div id="owl-demo" class="owl-carousel owl-theme">
               <div class="item">
                  <img src="<?php echo base_url(); ?>/assets/img/resto1.jpg" alt="">
                  <div class="carousel-text">
                     <div class="line">
                        <div class="s-12 l-9">
                           <h2>WHO A<strong>RE WE ?</strong></h2>
                        </div>
                        <div class="s-12 l-9">
                           <p>Whe are students from Atma Jaya Yogyakarta University <br>
                              which made this API to complete final task from Web-based Development Services.
                           </p>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="<?php echo base_url(); ?>/assets/img/resto2.jpg" alt="">
                  <div class="carousel-text">
                     <div class="line">
                        <div class="s-12 l-9">
                           <h2>OUR T<strong>EAM ?</strong></h2>
                        </div>
                        <div class="s-12 l-9">
                          <p>Mikhael Diastama Santoso <br>
                             Heryatmo Benediktus Sembiring <br>
                             Eric Simahan <br>
                             Vincentius Andri Setiawan <br>
                             Sandi Prado Saragih <br>
                             Agatha Santoso <br>
                          </p>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!-- FOOTER -->
      <footer>
         <div class="line">
            <div class="s-12 l-6">
               <p>Copyright &copy; 2017 Restopedia
               </p>
            </div>
            <div class="s-12 l-6">
               <p class="right">
                  <a class="right" href="http://www.myresponsee.com" title="Responsee - lightweight responsive framework">| Designed by Babarsari Corp</a>
               </p>
            </div>
         </div>
      </footer>
      <script type="text/javascript" src="<?php echo base_url(); ?>/assets/owl-carousel/owl.carousel.js"></script>
      <script type="text/javascript">
         jQuery(document).ready(function($) {
           $("#owl-demo").owlCarousel({
         	slideSpeed : 300,
         	autoPlay : true,
         	navigation : false,
         	pagination : false,
         	singleItem:true
           });
           $("#owl-demo2").owlCarousel({
         	slideSpeed : 300,
         	autoPlay : true,
         	navigation : false,
         	pagination : true,
         	singleItem:true
           });
         });

      </script>
   </body>
</html>
