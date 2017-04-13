<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Users extends CI_Model {

	public function __construct()
	{
		parent::__construct();
		$this->load->database();
		$this->load->helper('string');
	}

  function login($username, $password)
  {
     $this->db->where('username', $username);
		 $this->db->where('password', $password);
		 $this->db->limit(1);

		 $query = $this->db->get('user');
		 if($query->num_rows()==1)
		 {
			 return $query->result();
		 }
		 else
		 {
			 return false;
		 }
  }

  function signup($username, $password)
  {
		$randstring = random_string('alnum', 20);
		$this->db->select_max('ID_User');
		$query = $this->db->get('user');
		foreach ($query->result() as $row)
		{
			$maxid = $row->ID_User+1;
		}
		$data = array(
				'username' => $username,
				'password' => $password,
				'api_key' => $randstring.$maxid,
			);

		$this->db->insert('user',$data);
  }

}
