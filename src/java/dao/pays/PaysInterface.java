/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pays;

import java.util.List;
import model.Pay;


/**
 *
 * @author hp
 */
public interface PaysInterface {

    public void save(Pay pays);

    public Pay getPays(int id);

    public List<Pay> getListPays();

    public void remove(Pay pays);

    public void update(Pay pays);

}
