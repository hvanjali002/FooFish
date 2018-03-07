package com.Foofish.model;

public class SetupDeviceConfigRequestModel {

    int motorInterval;
    int cameraScreenshotInterval;

    public SetupDeviceConfigRequestModel() {

    }

    /**
     * @return the motorInterval
     */
    public int getMotorInterval() {
        return motorInterval;
    }

    /**
     * @param motorInterval the motorInterval to set
     */
    public void setMotorInterval(int motorInterval) {
        this.motorInterval = motorInterval;
    }

    /**
     * @return the cameraScreenshotInterval
     */
    public int getCameraScreenshotInterval() {
        return cameraScreenshotInterval;
    }

    /**
     * @param cameraScreenshotInterval the cameraScreenshotInterval to set
     */
    public void setCameraScreenshotInterval(int cameraScreenshotInterval) {
        this.cameraScreenshotInterval = cameraScreenshotInterval;
    }

}
