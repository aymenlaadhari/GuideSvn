package convertor;


import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Pay;
import model.Ville;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
 // @FacesConverter(forClass = model.Ville.class,value="villeConvertor")
  @FacesConverter("villeConvertor")
public class ConvertorVille implements Converter {
	/*public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return new Pay();
	}*/

	/*public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		          Pay person = (Pay) value;
		return person.getNom();
	}*/
        
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        Ville ret = null;
        UIComponent src = arg1;
        if (src != null) {
            List<UIComponent> childs = src.getChildren();
            UISelectItems itens = null;
            if (childs != null) {
                for (UIComponent ui : childs) {
                    if (ui instanceof UISelectItems) {
                        itens = (UISelectItems) ui;
                        break;
                    } else if (ui instanceof UISelectItem) {
                        UISelectItem item = (UISelectItem) ui;
                        try {
                            System.err.println("getAsObjectConvertorVille value"+item.getValue());
                            System.err.println("getAsObjectConvertorVille value"+item.getItemValue());
                            System.err.println("getAsObjectConvertorVille label"+item.getItemLabel());
                            if(item.getValue()!=null)
                            {
                                Ville val = (Ville) item.getItemValue();
                                if (arg2.equals("" + val.getNom())) {
                                    ret = val;
                                    break;
                                }
                            }
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            if (itens != null) {
                List<Ville> values = (List<Ville>) itens.getValue();
                if (values != null) {
                    for (Ville val : values) {
                        if (arg2.equals("" + val.getNom())) {
                            ret = val;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        String ret = "getAsStringConvertorVille";
        if (arg2 != null && arg2 instanceof Ville) {
            System.err.println("getAsStringConvertorVilleConvertorVilleConvertorVille");
            
            System.err.println("getAsStringConvertorVilleConvertorVille "+arg2);
            System.err.println();
            Ville m = (Ville) arg2;
            if (m != null) {
                String id = m.getNom();
                if (id != null) {
                    ret = id.toString();
                }
            }
        }
        return ret;
    }
}