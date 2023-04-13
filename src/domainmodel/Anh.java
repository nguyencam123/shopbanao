/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author Admin
 */
public class Anh {

    private String id;
    private String urlImage;
    private String ten;

    public Anh() {
    }

    public Anh(String id, String urlImage, String ten) {
        this.id = id;
        this.urlImage = urlImage;
        this.ten = ten;
    }

    public Anh(String urlImage, String ten) {
        this.urlImage = urlImage;
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    
    

    

}
