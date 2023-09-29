package at.fhv.sysarch.lab1.pipeline.filtersLecture;

import at.fhv.sysarch.lab1.obj.Face;
import at.fhv.sysarch.lab1.rendering.RenderingMode;
import javafx.scene.canvas.GraphicsContext;

public class Sink implements IFilter<Face> {
    private GraphicsContext context = null;
    private RenderingMode rm = null;

    public Sink(GraphicsContext context, RenderingMode rm) {
        this.context = context;
        this.rm = rm;
    }

    @Override
    public void setSuccessor(Pipe pipe) {
        // TODO Auto-generated method stub

    }

    public void write(Face f) {
        switch (this.rm) {
            case POINT -> context.strokeOval(f.getV1().getX(), f.getV1().getY(), 5, 5);

            case WIREFRAME -> {
                context.strokeLine(f.getV1().getX(), f.getV1().getY(), f.getV2().getX(), f.getV2().getY());
                context.strokeLine(f.getV2().getX(), f.getV2().getY(), f.getV3().getX(), f.getV3().getY());
                context.strokeLine(f.getV3().getX(), f.getV3().getY(), f.getV1().getX(), f.getV1().getY());

            }
        }
    }


}
