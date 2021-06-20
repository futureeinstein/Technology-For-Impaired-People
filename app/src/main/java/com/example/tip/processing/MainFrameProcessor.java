package com.example.tip.processing;

import java.util.ArrayList;

import com.example.tip.imaging.IFrame;

import org.opencv.android.CameraBridgeViewBase;

public class MainFrameProcessor implements IFrameProcessor {

    private ArrayList<IFrameProcessor> processors = new ArrayList<>();

    public MainFrameProcessor(DetectionMethod method) {
        setProcessors(method);
    }

    @Override
    public IFrame process(IFrame inputFrame) {

        for (IFrameProcessor processor : processors){
            processor.process(inputFrame);
        }

        return inputFrame;

    }


    private void setProcessors(DetectionMethod method) {
        processors.clear();
        processors.add(new ColourThresholdFrameProcessor(method));
        processors.add(new ContourMaskProcessor());
        processors.add(new CroppingFrameProcessor(method));
        processors.add(new NormalisingFrameProcessor(method));
        switch (method){
            case CANNY_EDGES:
                processors.add(new CannyEdgeFrameProcessor());
                break;
            case CONTOUR_MASK:
                // Just use the contour mask
                break;
            case SKELETON:
                processors.add(new SkeletonFrameProcessor());
                break;
            default:
                break;
        }
        processors.add(new FeatureFrameProcessor(method));
    }

}
