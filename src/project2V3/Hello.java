package project2V3;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import services.DataManager;

@ManagedBean
public class Hello {
// Bean Aufruf via xhtml: http://localhost:8080/Groupfitness/beanhello.xhtml
    final String world = "Hello World!";

    @EJB
    DataManager dm;
    
    public String getworld() {
        dm.save();
    	return world;
    }
}
