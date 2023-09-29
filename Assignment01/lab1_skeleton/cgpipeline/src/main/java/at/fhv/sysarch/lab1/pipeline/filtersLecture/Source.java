package at.fhv.sysarch.lab1.pipeline.filtersLecture;

import at.fhv.sysarch.lab1.obj.Model;

public class Source implements IFilter<Model>{

    private Pipe successor = null;

    public void setSuccessor(Pipe pipe) {
        this.successor = pipe;
    }

    public void write(Model model){
        model.getFaces().forEach(f -> this.successor.write(f));
    }
}
