/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.centreMedical;

import java.util.List;
import model.CentreMedicale;


/**
 *
 * @author hp
 */
public interface CentreMedicaleInterface {

    public void save(CentreMedicale centreMedicale);

    public List<CentreMedicale> list();

    public void remove(CentreMedicale centreMedicale);

    public void update(CentreMedicale centreMedicale);

    public CentreMedicale getCentreMedicale(long id);

    //public CentreMedicale findByCentre(CentreMedicale centreMedicale);

}
