package at.fhv.sysarch.lab1.pipeline.pushFilters;

import at.fhv.sysarch.lab1.pipeline.filtersLecture.Pipe;

public interface IFilterPush {

    public void write(Pipe pipe);

    public void setSuccessor(IFilterPush filter);




}

