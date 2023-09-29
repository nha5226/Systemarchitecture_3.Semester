package at.fhv.sysarch.lab1.pipeline;

import at.fhv.sysarch.lab1.animation.AnimationRenderer;
import at.fhv.sysarch.lab1.obj.Face;
import at.fhv.sysarch.lab1.obj.Model;
import at.fhv.sysarch.lab1.pipeline.filtersLecture.Pipe;
import at.fhv.sysarch.lab1.pipeline.filtersLecture.ResizeFilter;
import at.fhv.sysarch.lab1.pipeline.filtersLecture.Sink;
import at.fhv.sysarch.lab1.pipeline.filtersLecture.Source;
import javafx.animation.AnimationTimer;

public class PushPipelineFactory {

    //AnimationTimer = nach gewisser Zeit ruft er eine Methode auf (render)
    public static AnimationTimer createPipeline(PipelineData pd) {

        // Hier haben wir einen neue Source erstellt, die die Faces aus dem Model holt
        Source source = new Source();
        Sink sink = new Sink(pd.getGraphicsContext(), pd.getRenderingMode());
        ResizeFilter filter = new ResizeFilter();

        // und hier haben wir die Pipe erstellt, die die Source mit dem Filter verbindet
        Pipe<Face> connectSourceResize = new Pipe<Face>();
        Pipe<Face> connectResizeSink = new Pipe<Face>();

        source.setSuccessor(connectSourceResize);
        connectSourceResize.setSuccessor(filter);
        filter.setSuccessor(connectResizeSink);
        connectResizeSink.setSuccessor(sink);

        // TODO push from the source (model)
        //Hier sollt die Source sein...


        // TODO 1. perform model-view transformation from model to VIEW SPACE coordinates
        // Hier benötigen wir einen model-view transformation filter für die Push Pipeline, der die Faces aus der Pipe nimmt und diese transformiert

        // TODO 2. perform backface culling in VIEW SPACE

        // TODO 3. perform depth sorting in VIEW SPACE

        // TODO 4. add coloring (space unimportant)

        // lighting can be switched on/off
        if (pd.isPerformLighting()) {
            // 4a. TODO perform lighting in VIEW SPACE
            
            // 5. TODO perform projection transformation on VIEW SPACE coordinates
        } else {
            // 5. TODO perform projection transformation
        }

        // TODO 6. perform perspective division to screen coordinates

        // TODO 7. feed into the sink (renderer)

        // returning an animation renderer which handles clearing of the
        // viewport and computation of the praction
        return new AnimationRenderer(pd) {
            // TODO rotation variable goes in here
            private int pos = (int)(Math.random()*350);


            /** This method is called for every frame from the JavaFX Animation
             * system (using an AnimationTimer, see AnimationRenderer). 
             * @param fraction the time which has passed since the last render call in a fraction of a second
             * @param model    the model to render 
             */
            @Override
            protected void render(float fraction, Model model) {

                //Hier haben wir die Linie erstellt die von oben nach unten läuft
                pd.getGraphicsContext().setStroke(pd.getModelColor());
                pd.getGraphicsContext().strokeLine(pos, pos, 100+pos, 100+pos);
                pos++;

                source.write(model);

                /*
                model.getFaces().forEach(f -> {
                    pd.getGraphicsContext().strokeLine(f.getV1().getX()*100, f.getV1().getY()*100, f.getV2().getX()*100, f.getV2().getY()*100);
                    pd.getGraphicsContext().strokeLine(f.getV2().getX()*100, f.getV2().getY()*100, f.getV3().getX()*100, f.getV3().getY()*100);
                    pd.getGraphicsContext().strokeLine(f.getV3().getX()*100, f.getV3().getY()*100, f.getV1().getX()*100, f.getV1().getY()*100);

                        });*/
            }



                // TODO compute rotation in radians

                // TODO create new model rotation matrix using pd.modelRotAxis

                // TODO compute updated model-view tranformation

                // TODO update model-view filter

                // TODO trigger rendering of the pipeline

        };
    }
}