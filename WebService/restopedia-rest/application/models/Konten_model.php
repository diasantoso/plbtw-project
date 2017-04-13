<?php if(! defined('BASEPATH')) exit('No direct script access allowed');

class Konten_model extends CI_Model{
	public function __construct()
	{
		parent:: __construct();
		$this->load->database();
	}

	function AddKonten($Username, $Nama_Resto, $Detail_Resto, $Alamat, $Kota, $Gambar, $Nama_Gambar)
	{
		$konten = array(
			'Username' => $Username,
			'Nama_Resto' => $Nama_Resto,
			'Detail_Resto' => $Detail_Resto,
			'Alamat' => $Alamat,
			'Kota' => $Kota,
			'Gambar' => 'http://restopedia.890m.com/restopedia-doc/'.$Nama_Gambar
		);

	        $imsrc = base64_decode($Gambar);
	        $fp = fopen($_SERVER['DOCUMENT_ROOT'].'/restopedia-doc/'.$Nama_Gambar.'', 'w');
	        fwrite($fp, $imsrc);

		$this->db->insert('konten_resto',$konten);
	}

	function GetKonten($LoggedUsername)
	{
		$this->db->select();
		$this->db->from('konten_resto')->order_by('Created_at', 'DESC');

		$query = $this->db->get();

		$result =array();

		foreach($query->result() as $row) {

			$this->db->select('flag')->where('Username', $LoggedUsername)->where('ID_Resto', $row->ID_Resto);
			$this->db->from('user_likes');
			$flagquery = $this->db->get();

			$result[] = array(
			'ID_Resto' => $row->ID_Resto,
			'Username' => $row->Username,
			'Nama_Resto' => $row->Nama_Resto,
			'Detail_Resto' => $row->Detail_Resto,
			'Alamat' => $row->Alamat,
			'Kota' => $row->Kota,
			'Gambar' => $row->Gambar,
			'Jumlah_Likes' => $this->db->where('flag', "2")->where('ID_Resto', $row->ID_Resto)->from('user_likes')->count_all_results(),
			'Created_at' => $row->Created_at,
			'Flag'=> $flagquery->result()
			);
		}
		return $result;
	}

	function GetKontenHot($LoggedUsername)
	{
		$this->db->select();
		$this->db->from('konten_resto')->order_by('Jumlah_Likes', 'DESC');

		$query = $this->db->get();

		$result =array();

		foreach($query->result() as $row) {

			$this->db->select('flag')->where('Username', $LoggedUsername)->where('ID_Resto', $row->ID_Resto);
			$this->db->from('user_likes');
			$flagquery = $this->db->get();

			$result[] = array(
			'ID_Resto' => $row->ID_Resto,
			'Username' => $row->Username,
			'Nama_Resto' => $row->Nama_Resto,
			'Detail_Resto' => $row->Detail_Resto,
			'Alamat' => $row->Alamat,
			'Kota' => $row->Kota,
			'Gambar' => $row->Gambar,
			'Jumlah_Likes' => $this->db->where('flag', "2")->where('ID_Resto', $row->ID_Resto)->from('user_likes')->count_all_results(),
			'Created_at' => $row->Created_at,
			'Flag'=> $flagquery->result()
			);
		}
		return $result;
	}

	function GetKontenPublic()
	{
		$this->db->select();
		$this->db->from('konten_resto')->order_by('Jumlah_Likes', 'DESC');

		$query = $this->db->get();

		$result =array();

		foreach($query->result() as $row) {

			$result[] = array(
			'Nama_Resto' => $row->Nama_Resto,
			'Detail_Resto' => $row->Detail_Resto,
			'Alamat' => $row->Alamat,
			'Kota' => $row->Kota,
			'Gambar' => $row->Gambar,
			'Jumlah_Likes' => $this->db->where('flag', "2")->where('ID_Resto', $row->ID_Resto)->from('user_likes')->count_all_results(),
			);
		}
		return $result;
	}


	function GetKontenPublicKota($kota)
	{
		$this->db->select();
		$this->db->from('konten_resto')->like('Kota',$kota);

		$query = $this->db->get();

		$result =array();

		foreach($query->result() as $row) {

			$result[] = array(
			'Nama_Resto' => $row->Nama_Resto,
			'Detail_Resto' => $row->Detail_Resto,
			'Alamat' => $row->Alamat,
			'Kota' => $row->Kota,
			'Gambar' => $row->Gambar,
			'Jumlah_Likes' => $this->db->where('flag', "2")->where('ID_Resto', $row->ID_Resto)->from('user_likes')->count_all_results(),
			);
		}
		return $result;
	}

}
