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

    public void addCentreMedicale(CentreMedicale centreMedicale);
    public void updateCentreMedicale(CentreMedicale centreMedicale);
    public void deletCentreMedicale(CentreMedicale centreMedicale);
    public CentreMedicale getCentreMedicale(int id);
    public List<CentreMedicale> getListCentreMedicale();
}
