package com.Foofish.service;

import com.Foofish.model.ConfigurationPersistentState;
import com.Foofish.model.SetupDeviceConfigRequestModel;


public class SetDeviceConfigService {
    public String setDeviceConfig(SetupDeviceConfigRequestModel setupDeviceConfigRequestModel) {
        ConfigurationPersistentState.motorInterval = setupDeviceConfigRequestModel.getMotorInterval();
        ConfigurationPersistentState.cameraInterval = setupDeviceConfigRequestModel.getCameraScreenshotInterval();

        return "{\"status\":\"0\"}";
    }

}
