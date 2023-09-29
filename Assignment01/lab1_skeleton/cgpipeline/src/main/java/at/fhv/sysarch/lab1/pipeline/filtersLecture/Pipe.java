package at.fhv.sysarch.lab1.pipeline.filtersLecture;

public class Pipe<T> {

    public IFilter<T> outgoing = null;

    public void write(T input){
        this.outgoing.write(input);
    }

    public void setSuccessor(IFilter<T> filter){
        this.outgoing = filter;
    }
}
