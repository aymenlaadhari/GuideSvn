/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.application;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author hp
 */
@ManagedBean
public class ThemeChoices {
public static final String[] POSSIBLE_THEMES =
{ "afterdark","aristo", 
"bootstrap","casablanca","cupertino", "dark-hive",
 "delta","excite-bike","glass-x","redmond","start"};
public String[] getThemes() {
return(POSSIBLE_THEMES);
}
}