<?php

defined('BASEPATH') OR exit('No direct script access allowed');

// This can be removed if you use __autoload() in config.php OR use Modular Extensions
require APPPATH . '/libraries/REST_Controller.php';

/**
 * This is an example of a few basic user interaction methods you could use
 * all done with a hardcoded array
 *
 * @package         CodeIgniter
 * @subpackage      Rest Server
 * @category        Controller
 * @author          Phil Sturgeon, Chris Kacerguis
 * @license         MIT
 * @link            https://github.com/chriskacerguis/codeigniter-restserver
 */
class Restopedia extends REST_Controller {

    function __construct()
    {
        // Construct the parent class
        parent::__construct();

		$this->load->model('User_model');
		$this->load->model('Like_model');
		$this->load->model('Konten_model');
    }

	public function signUp_post(){
		$message = [
			'status'=>1,
			'message'=>'Added User',
		];
		$email=$this->post('email');
		$password=$this->post('password');

		$this->User_model->SignUp($email,$password);
		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

	public function login_post(){
		$email=$this->post('email');
		$password=$this->post('password');

		$userData = $this->User_model->Login($email,$password);

		if($userData != NULL){
			$message = [
				'userData' => $userData,
				'status' => 1,
				'message' => 'Login Succeed',
			];
		}else{
			$message = [
				'userData' => 'User not Found',
				'status' => 0,
				'message' => 'Login Not Succeed',
			];
		}

		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

	public function userInfo_get(){
		$email=$this->get('email');

		$userData = $this->User_model->GetUserInfo($email);

		if($userData != NULL){
			$message = [
				'userData' => $userData,
				'status' => 1,
				'message' => 'All User Data Received',
			];
		}else{
			$message = [
				'userData' => 'User not Found',
				'status' => 0,
				'message' => 'User Data Retrieve Failed',
			];
		}

		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

	public function totalLikes_get()
    {
        $email = $this->get('email');

		if($email != NULL){
			$totalVotes = $this->User_model->GetTotalLikes($email);

			if($totalVotes == NULL){
				$message = [
					'totalLikes' => 0,
					'status' => 0,
					'message' => 'Get Total Likes Succeed',
				];
			}else{
				$message = [
					'totalLikes' => $totalVotes,
					'status' => 1,
					'message' => 'Get Total Likes Succeed',
				];
			}
			$this->set_response($message, REST_Controller::HTTP_CREATED);
		}
    }

	public function likeUp_post(){
		$email = $this->post('email');
		$id_resto = $this->post('id_resto');

		$message = [
			'status'=>1,
			'message'=>'Like Up Success',
		];

		$this->Like_model->LikeUp($email,$id_resto);
		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

	public function likeNormal_post(){
		$email = $this->post('email');
		$id_resto = $this->post('id_resto');

		$message = [
			'status'=>1,
			'message'=>'Like to Normal Success',
		];

		$this->Votes_model->VoteNormal($email,$id_resto);
		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

	public function addKonten_post(){
		$message = [
			'status'=>1,
			'message'=>'Added Konten',
		];
		$email=$this->post('email');
		$nama=$this->post('nama');
		$detail=$this->post('detail');
		$alamat=$this->post('alamat');
    $kota=$this->post('kota');
		$gambar=$this->post('gambar');
		$namagambar=$this->post('namagambar');

		$this->Konten_model->AddKonten($email,$nama,$detail,$alamat,$kota,$gambar,$namagambar);
		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

	public function kontenAll_get(){
		$email=$this->get('email');
    $apikey=$this->get('api_key');

		$kontenData = $this->Konten_model->GetKonten($email);

    if($this->User_model->Authenticate($apikey)){
  		if($kontenData != NULL){
  			$message = [
  				'status' => 200,
  				'message' => 'All Konten Data Received',
          'kontenData' => $kontenData,
  			];
  		}else{
  			$message = [
  				'status' => 101,
  				'message' => 'Konten Data Retrieve Failed',
          'kontenData' => 'Konten not Found',
  			];
  		}
    }else{
			$message = [
				'status' => 101,
				'message' => 'Gagal',
        'kontenData' => 'Akses tidak valid',
			];
		}

		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

	public function kontenHot_get(){
		$email=$this->get('email');
    $apikey=$this->get('api_key');

		$kontenData = $this->Konten_model->GetKontenHot($email);

    if($this->User_model->Authenticate($apikey)){
  		if($kontenData != NULL){
  			$message = [
  				'status' => 200,
  				'message' => 'All Konten Data Received',
          'kontenData' => $kontenData,
  			];
  		}else{
  			$message = [
  				'status' => 101,
  				'message' => 'Konten Data Retrieve Failed',
    			'kontenData' => 'Konten not Found',
  			];
  		}
    }else{
      $message = [
        'status' => 101,
        'message' => 'Gagal',
        'kontenData' => 'Akses tidak valid',
      ];
    }

		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

}
