
package com.restopedia_team.restopedia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KontenDatum {

    @SerializedName("ID_Resto")
    @Expose
    private String iDResto;
    @SerializedName("Username")
    @Expose
    private String username;
    @SerializedName("Nama_Resto")
    @Expose
    private String namaResto;
    @SerializedName("Detail_Resto")
    @Expose
    private String detailResto;
    @SerializedName("Alamat")
    @Expose
    private String alamat;
    @SerializedName("Kota")
    @Expose
    private String kota;
    @SerializedName("Gambar")
    @Expose
    private String gambar;
    @SerializedName("Jumlah_Likes")
    @Expose
    private int jumlahLikes;
    @SerializedName("Created_at")
    @Expose
    private String createdAt;
    @SerializedName("Flag")
    @Expose
    private List<Flag> flag = null;

    public String getIDResto() {
        return iDResto;
    }

    public void setIDResto(String iDResto) {
        this.iDResto = iDResto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamaResto() {
        return namaResto;
    }

    public void setNamaResto(String namaResto) {
        this.namaResto = namaResto;
    }

    public String getDetailResto() {
        return detailResto;
    }

    public void setDetailResto(String detailResto) {
        this.detailResto = detailResto;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getJumlahLikes() {
        return jumlahLikes;
    }

    public void setJumlahLikes(int jumlahLikes) {
        this.jumlahLikes = jumlahLikes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Flag> getFlag() {
        return flag;
    }

    public void setFlag(List<Flag> flag) {
        this.flag = flag;
    }

}
