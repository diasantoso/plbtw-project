<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class Rest_server extends CI_Controller {

    public function index()
    {
        $this->load->helper('url');
        $this->load->model('User_model');

	$data['userData'] = $this->User_model->GetUserInfo('mikhaelmds@gmail.com');
        $this->load->view('rest_server',$data);
    }
}
