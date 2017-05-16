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
		$this->load->model('Konten_model');
  }

	public function signUp_post(){
    $username=$this->post('username');
    $password=$this->post('password');
    $apikey=$this->post('api_key');

    if($this->User_model->Authenticate($apikey)){
      $message = [
  			'status'=>1,
  			'message'=>'Added User',
  		];

  		$this->User_model->SignUp($username,$password);
    }else{
      $message = [
        'status' => 101,
        'message' => 'Gagal',
      ];
    }

		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

	public function login_post(){
  	$username=$this->post('username');
  	$password=$this->post('password');
    $apikey=$this->post('api_key');

    $userData = $this->User_model->Login($username,$password);

    if($this->User_model->Authenticate($apikey)){
  		if($userData != NULL){
  			$message = [
  				'status' => 200,
  				'message' => 'Login Succeed',
    			'userData' => $userData,
  			];
  		}else{
  			$message = [
  				'status' => 201,
  				'message' => 'Login Not Succeed',
    			'userData' => 'User not Found',
  			];
  		}
    }else{
      $message = [
        'status' => 101,
        'message' => 'Gagal',
        'userData' => 'Akses tidak valid',
      ];
    }

		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

	public function addKonten_post(){
    $apikey=$this->post('api_key');
    $username=$this->post('username');
    $nama=$this->post('nama');
    $detail=$this->post('detail');
    $alamat=$this->post('alamat');
    $kota=$this->post('kota');
    $gambar=$this->post('gambar');
    $namagambar=$this->post('namagambar');

    if($this->User_model->Authenticate($apikey)){
  		$message = [
  			'status'=>1,
  			'message'=>'Added Konten',
  		];

  		$this->Konten_model->AddKonten($username,$nama,$detail,$alamat,$kota,$gambar,$namagambar);
    }else{
      $message = [
        'status' => 101,
        'message' => 'Gagal',
      ];
    }

		$this->set_response($message, REST_Controller::HTTP_CREATED);
	}

  public function deleteKonten_delete(){
    $apikey=$this->delete('api_key');
    $idresto=$this->delete('id_resto');

    if($this->User_model->Authenticate($apikey)){
      $message = [
        'status'=>1,
        'message'=>'Deleted Konten',
      ];

      $this->Konten_model->DeleteKonten($idresto);
    }else{
      $message = [
        'status' => 101,
        'message' => 'Gagal',
      ];
    }

    $this->set_response($message, REST_Controller::HTTP_CREATED);
  }

  public function delKonten_post(){
    $apikey=$this->post('api_key');
    $idresto=$this->post('id_resto');

    if($this->User_model->Authenticate($apikey)){
      $message = [
        'status'=>1,
        'message'=>'Deleted Konten',
      ];

      $this->Konten_model->DeleteKonten($idresto);
    }else{
      $message = [
        'status' => 101,
        'message' => 'Gagal',
      ];
    }

    $this->set_response($message, REST_Controller::HTTP_CREATED);
  }

	public function getAllKonten_get(){
    $apikey=$this->get('api_key');

		$kontenData = $this->Konten_model->GetKonten();

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

	public function getMyKonten_get(){
		$username=$this->get('username');
    $apikey=$this->get('api_key');

		$kontenData = $this->Konten_model->GetMyKonten($username);

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
