/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author kriaa
 */
public class Transformation {
    private int IdImage;
    private String TitreImage;
    private String DescreptionImage;
    private String ImageAvant;
    private String ImageApres;
    private int IdUser;

    public Transformation(int IdImage, String TitreImage, String DescreptionImage, String ImageAvant, String ImageApres, int IdUser) {
        this.IdImage = IdImage;
        this.TitreImage = TitreImage;
        this.DescreptionImage = DescreptionImage;
        this.ImageAvant = ImageAvant;
        this.ImageApres = ImageApres;
        this.IdUser = IdUser;
    }

    public Transformation(String TitreImage, String DescreptionImage, String ImageAvant, String ImageApres, int IdUser) {
        this.TitreImage = TitreImage;
        this.DescreptionImage = DescreptionImage;
        this.ImageAvant = ImageAvant;
        this.ImageApres = ImageApres;
        this.IdUser = IdUser;
    }
    

    public Transformation() {
    }

    public int getIdImage() {
        return IdImage;
    }

    public String getTitreImage() {
        return TitreImage;
    }

    public String getDescreptionImage() {
        return DescreptionImage;
    }

    public String getImageAvant() {
        return ImageAvant;
    }

    public String getImageApres() {
        return ImageApres;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdImage(int IdImage) {
        this.IdImage = IdImage;
    }

    public void setTitreImage(String TitreImage) {
        this.TitreImage = TitreImage;
    }

    public void setDescreptionImage(String DescreptionImage) {
        this.DescreptionImage = DescreptionImage;
    }

    public void setImageAvant(String ImageAvant) {
        this.ImageAvant = ImageAvant;
    }

    public void setImageApres(String ImageApres) {
        this.ImageApres = ImageApres;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    @Override
    public String toString() {
        return "Transformation{" + "IdImage=" + IdImage + ", TitreImage=" + TitreImage + ", DescreptionImage=" + DescreptionImage + ", ImageAvant=" + ImageAvant + ", ImageApres=" + ImageApres + ", IdUser=" + IdUser + '}';
    }
    
}

