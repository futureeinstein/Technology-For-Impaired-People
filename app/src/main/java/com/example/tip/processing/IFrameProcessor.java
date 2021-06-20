package com.example.tip.processing;

import com.example.tip.imaging.IFrame;

import org.opencv.android.CameraBridgeViewBase;

public interface IFrameProcessor {

    IFrame process(IFrame inputFrame);

}
