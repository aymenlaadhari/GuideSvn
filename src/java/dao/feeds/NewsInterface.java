/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.feeds;

import java.util.List;
import model.Feeds;

/**
 *
 * @author hp
 */
public interface NewsInterface{
   public void save(Feeds feeds);
    public void update(Feeds feeds);
    public void remove(Feeds feeds);
    public List<Feeds> getListFeeds();//valide
    public Feeds getFeeds(int idFeed);
    
    
}
