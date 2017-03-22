<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Welcome extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		$this->load->model('Users');
	}

	public function verifylogin()
	{
		$username = $this->input->post('username');
		$password = $this->input->post('password');
		$hasil = $this->Users->login($username, $password);

		if(hasil)
		{
		  foreach ($hasil as $sess)
		  {
			  $sess_data['logged_in']='Logged in';
			  $sess_data['username']=$sess->username;
			  $sess_data['password']=$sess->password;
			  $sess_data['api_key']=$sess->api_key;
			  $sess_data['total_request']=$sess->total_request;
			  $this->session->set_userdata($sess_data);
		  }
		  redirect('home');
		}
		else
		{
			echo "<script>alert('gagal Login');history.go(-1);</script>";
		}
	}

	public function logout()
	{
		session_destroy();
		redirect('/');
	}

	public function afterlogin()
	{
		$this->load->view('dasboard');
	}

	public function index()
	{
		$this->load->view('index');
	}

	public function dasboard()
	{
		$this->load->view('dasboard');
	}

	public function login()
	{
		$this->load->view('login');
	}

	public function signup()
	{
		$this->load->view('signup');
	}

	public function daftar()
	{
		$username = $this->input->post('username');
		$password = $this->input->post('password');
		$this->Users->signup($username, $password);
		$this->load->view('index');
	}

}
