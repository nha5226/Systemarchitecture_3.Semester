package at.fhv.sysarch.lab1.pipeline.filtersLecture;

import at.fhv.sysarch.lab1.obj.Face;

public class ResizeFilter implements IFilter<Face>{

    private Pipe successor = null;

    @Override
    public void setSuccessor(Pipe pipe) {
        this.successor = pipe;
    }

    @Override
    public void write(Face face) {
        Face newFace = new Face(face.getV1().multiply(100), face.getV2().multiply(100), face.getV3().multiply(100), face);
        this.successor.write(newFace);
    }
}
