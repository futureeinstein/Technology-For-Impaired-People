package com.example.tip.processing.preprocessing;

import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;

import com.example.tip.imaging.IFrame;

public interface IFramePreProcessor {

    IFrame preProcess(CvCameraViewFrame inputFrame);

}
