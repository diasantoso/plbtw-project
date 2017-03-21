<?php if(! defined('BASEPATH')) exit('No direct script access allowed');

class User_model extends CI_Model{
	public function __construct()
	{
		parent:: __construct();
		$this->load->database();
	}

	function GetUserInfo($LoggedEmail)
	{
		$this->db->select()->where('Email', $LoggedEmail);
		$this->db->from('user');

		$query = $this->db->get();
		return $query->result();
	}

	function SignUp($Email,$Password){
		$data = array(
				'Email' => $Email,
				'Password' => $Password,
			);

		$this->db->insert('user',$data);
	}

	function Login($Email,$Password){
		$this->db->select('*');
		$this->db->from('user');
		$this->db->where('Email',$Email);
		$this->db->where('Password',$Password);

		$query = $this->db->get();

		if($query ->num_rows()==1)
		{
			return $query->result();
		}
		else
		{
			return false;
		}
	}

	function Authenticate($apikey){
		$this->db->select('*');
		$this->db->from('user');
		$this->db->where('api_key',$apikey);

		$query = $this->db->get();

		if($query ->num_rows()==1)
		{
			$this->db->set('total_request', 'total_request+1', FALSE);
			$this->db->where('api_key', $apikey);
			$this->db->update('user');
			return true;
		}
		else
		{
			return false;
		}
	}

	function GetTotalLikes($LoggedEmail){
		$this->db->select_sum('Jumlah_Likes');
		$this->db->from('konten_resto');
		$this->db->where('Email',$LoggedEmail);

		$query = $this->db->get();

		if($query->num_rows()>0){
			$totalrate = $query->row("Jumlah_Likes");
			return $totalrate;
		}
		else{
			return 0;
		}
	}

}
