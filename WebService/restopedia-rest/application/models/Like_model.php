<?php if(! defined('BASEPATH')) exit('No direct script access allowed');

class Like_model extends CI_Model{
	public function __construct()
	{
		parent:: __construct();
		$this->load->database();
	}

	function LikeUp($Email,$ID_Resto){

		$this->db->select('*');
		$this->db->from('user_likes');
		$this->db->where('Email',$Email);
		$this->db->where('ID_Resto',$ID_Resto);

		$query = $this->db->get();

		$this->db->select('Jumlah_Likes');
		$this->db->from('konten_resto');
		$this->db->where('ID_Resto',$ID_Resto);

		if($query ->num_rows()==0)
		{
			$data = array(
				'Email' => $Email,
				'ID_Resto' => $ID_Resto,
				'Flag' => 2,
			);

			$this->db->insert('user_likes',$data);
		}
		else
		{
			$data=array(
				'Flag' => 2,
			);

			$this->db->update('user_likes',$data,array('Email'	=> $Email,'ID_Resto' => $ID_Resto));
		}

		$datacount=array(
				'Jumlah_Likes' => $this->db->where('flag', "2")->where('ID_Resto', $ID_Resto)->from('user_likes')->count_all_results(),
		);
		$this->db->update('konten_wisata',$datacount,array('ID_Resto' => $ID_Resto));

		$this->db->update('konten_wisata',$addTotalRate,array('ID_Resto' => $ID_Resto));
	}

	function LikeNormal($Email,$ID_Resto){

		$this->db->select('*');
		$this->db->from('user_likes');
		$this->db->where('Email',$Email);
		$this->db->where('ID_Resto',$ID_Resto);

		$query = $this->db->get();

		$this->db->select('Flag');
		$this->db->from('user_likes');
		$this->db->where('Email',$Email);
		$this->db->where('ID_Resto',$ID_Resto);

		$flag_rate_res = $this->db->get();
		$flag_rate_result = $flag_rate_res->row("Flag");

		if($flag_rate_result == 1){
			$flagcondition = 1;
		}else if($flag_rate_result == 2){
			$flagcondition = -1;
		}

		$this->db->select('Jumlah_Likes');
		$this->db->from('konten_resto');
		$this->db->where('ID_Resto',$ID_Resto);


		if($query ->num_rows()==0)
		{
			$data = array(
				'Email' => $Email,
				'ID_Resto' => $ID_Resto,
				'Flag' => 0,
			);

			$this->db->insert('rate',$data);
		}
		else
		{
			$data=array(
				'Flag' => 0,
			);

			$this->db->update('user_likes',$data,array('Email'	=> $Email,'ID_Resto' => $ID_Resto));
		}

				$datacount=array(
				'Jumlah_Likes' => $this->db->where('flag', "2")->where('ID_Resto', $ID_Resto)->from('user_likes')->count_all_results(),
		);
		$this->db->update('konten_resto',$datacount,array('ID_Resto' => $ID_Resto));

		$this->db->update('konten_resto',$addTotalRate,array('ID_Resto' => $ID_Resto));
	}

}
