/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.monument;

import java.util.List;
import model.Monument;



public interface MonumentInterface {

    public void save(Monument monument);

    public List<Monument> list();

    public void remove(Monument monument);

    public void update(Monument monument);

    public Monument getMonument(long idMonument);

    
}
