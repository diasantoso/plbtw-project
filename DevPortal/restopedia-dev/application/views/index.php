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
                     <a href="<?php echo site_url('welcome/index')?>">RESTO<br /><strong>PEDIA</strong></a>
                  </div>
                  <p class="nav-text">Options</p>
                  <div class="top-nav s-12 l-5">
                     <ul class="right top-ul chevron">
                        <li><a href="<?php echo site_url('welcome/index')?>">Home</a></li>
                        <li><a href="<?php echo site_url('welcome/about')?>">About</a></li>
                     </ul>
                  </div>
                  <ul class="s-12 l-2">
                     <li class="logo hide-s hide-m">
                        <a href="<?php echo site_url('welcome/index')?>">RESTO<br/><strong>PEDIA</strong></a>
                     </li>
                  </ul>
                  <div class="top-nav s-12 l-5">
                     <ul class="top-ul chevron">
                        <li><a href="<?php echo site_url('welcome/signup')?>">Sign Up</a>
                        </li>
                        <li><a href="<?php echo site_url('welcome/login')?>">Sign In</a>
                        </li>
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
                           <h2>RESTO<strong>PEDIA</strong></h2>
                        </div>
                        <div class="s-12 l-9">
                           <p>Restaurant API Provider
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
                           <h2>WIT<strong>H US</strong></h2>
                        </div>
                        <div class="s-12 l-9">
                           <p>Popularize Indonesian Culinary
                           </p>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="item">
                  <img src="<?php echo base_url(); ?>/assets/img/resto3.jpg" alt="">
                  <div class="carousel-text">
                     <div class="line">
                        <div class="s-12 l-9">
                           <h2>INDONESIAN RES<strong>TAURANT API</strong></h2>
                        </div>
                        <div class="s-12 l-9">
                           <p>Sign Up Now
                           </p>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <!-- FIRST BLOCK -->
         <div id="fourth-block">
            <div class="line">
               <div id="owl-demo2" class="owl-carousel owl-theme">
                  <div class="item">
                     <h2>Restopedia API</h2>
                     <p class="s-12 m-12 l-8 center">Restopedia provides REST API which can use to get data of Indonesian restaurant.
                     </p>
                  </div>
                  <div class="item">
                     <h2>API Data</h2>
                     <p class="s-12 m-12 l-8 center">Data of restaurant collected collaboratively together using Android Application Restopedia.
                       Data validation can be viewed by using the existing votes in the Application's featues.
                     </p>
                  </div>
                  <div class="item">
                     <h2>Output JSON</h2>
                     <p class="s-12 m-12 l-8 center">The data will be given to you openly in JSON format.
                     </p>
                  </div>
               </div>
            </div>
         </div>
         <!-- GALLERY -->
         <div id="third-block">
            <div class="line">
               <h2>Spesification</h2>
               <p class="subtitile">After registering, each user will be given a unique API Key as the password used to get data from API Restopedia. <br><br>
                    Put the key into URL to get the data :<br>
                <a href="http://restopedia.890m.com/restopedia-rest/index.php/API/restopedia/METHOD_NAME?api_key=YOUR_API_KEY">http://restopedia.890m.com/restopedia-rest/index.php/API/restopedia/METHOD_NAME?api_key=YOUR_API_KEY</a>
               </p>
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
