<?php if(! defined('BASEPATH')) exit('No direct script access allowed');

class User_model extends CI_Model{
	public function __construct()
	{
		parent:: __construct();
		$this->load->database();
		$this->load->helper('string');
	}

	function GetUserInfo($LoggedUsername)
	{
		$this->db->select()->where('Username', $LoggedUsername);
		$this->db->from('user');

		$query = $this->db->get();
		return $query->result();
	}

	function SignUp($Username,$Password){
		$randstring = random_string('alnum', 20);
		$this->db->select_max('ID_User');
		$query = $this->db->get('user');
		foreach ($query->result() as $row)
		{
			$maxid = $row->ID_User+1;
		}
		$data = array(
				'username' => $Username,
				'password' => $Password,
				'api_key' => $randstring.$maxid,
			);

		$this->db->insert('user',$data);
	}

	function Login($Username,$Password){
		$this->db->select('*');
		$this->db->from('user');
		$this->db->where('username',$Username);
		$this->db->where('password',$Password);

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

	function GetTotalLikes($LoggedUsername){
		$this->db->select_sum('Jumlah_Likes');
		$this->db->from('konten_resto');
		$this->db->where('Username',$LoggedUsername);

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
