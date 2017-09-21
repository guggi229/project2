package project2V3;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Hello {
// Bean Aufruf via xhtml: http://localhost:8080/Groupfitness/beanhello.xhtml
    final String world = "Hello World!";

    public String getworld() {
        return world;
    }
}
