package ch.guggisberg.stefan.groupfitness.check;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ch.guggisberg.stefan.groupfitness.services.DataManager;

@ManagedBean
public class Hello {
// Bean Aufruf via xhtml: http://localhost:8080/Groupfitness/beanhello.xhtml
    final String world = "Hello World!";

    @Inject
    DataManager dm;
    
    public String getworld() {
        dm.save();
    	return world;
    }
}
