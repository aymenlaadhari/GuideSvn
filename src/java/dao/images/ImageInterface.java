/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.images;


import java.util.List;
import model.Image;
import model.Ville;


/**
 *
 * @author hp
 */
public interface ImageInterface {

    public void save(Image image);

    public Image getVille(long id);

    public List<Image> list();

    public void remove(Image image);

    public void update(Image image);

}
