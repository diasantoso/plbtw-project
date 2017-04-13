<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class verifylogin extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		$this->load->model('Users','',TRUE);
	}

	public function index()
  {
    $this->load->library('form_validation');

    $this->form_validation->set_rules('username','username','trim|required|xss_clean');
    $this->form_validation->set_rules('password','password','trim|required|xss_clean|callback_check_database');

    if($this->form_validation->run()==FALSE)
    {
      $this->load->view('index');
    }
    else
    {
      redirect('home','refresh');
    }
  }

  public function check_database($password)
  {
    $username = $this->input->post('username');
    $result = $this->Users->login($username, $password);

    if($result)
    {
      $sess_array = array();
      foreach ($result as $row)
      {
        $sess_array = array(
          'username'=>$row->username,
          'password'=>$row->password,
		  		'api_key'=>$row->api_key,
		  		'total_request'=>$row->total_request,
        );
        $this->session->set_userdata('logged_in', $sess_array);
      }
      return TRUE;
    }
    else {
      $this->form_validation->set_message('check_database','Invalid username or password');
      return FALSE;
    }
  }

}
