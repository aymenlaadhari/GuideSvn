/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.monument;

import java.util.List;
import model.Monument;



public interface MonumentInterface {

     public void addMonument(Monument monument);
    public void updateMonument(Monument monument);
    public void deletMonument(Monument monument);
    public Monument getMonument(int id);
    public List<Monument> getListMonument();
         
}
