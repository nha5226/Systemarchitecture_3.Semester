package at.fhv.sysarch.lab1.pipeline.filtersLecture;

public interface IFilter<T> {
    public void setSuccessor(Pipe pipe);

    public void write(T input);

}
