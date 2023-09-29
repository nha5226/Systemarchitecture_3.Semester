package at.fhv.sysarch.lab1.obj;

import java.util.Collections;
import java.util.List;

public class Model {

    //Hier bekommen wir eine Liste von Faces. (Face sind hier unsere Dreiecke) siehe Notion
    private List<Face> faces;

    public Model(List<Face> faces) {
        this.faces = faces;
    }

    public List<Face> getFaces() {
        return Collections.unmodifiableList(this.faces);
    }
}