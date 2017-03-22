<?php 
if ( ! defined('BASEPATH')) exit('No direct script access allowed');
//we need to call PHP's session object to access it through CI

class Home extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		if($this->session->userdata('username')=="")
		{
			redirect('Welcome');
		}
		$this->load->model('Users');
	}
	
	public function index()
	{
		
			$this->load->view('dasboard');
		
	}
		
	
}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */