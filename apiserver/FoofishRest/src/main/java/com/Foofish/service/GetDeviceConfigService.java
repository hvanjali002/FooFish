package com.Foofish.service;

import com.Foofish.model.ConfigurationPersistentState;
import com.Foofish.model.SetupDeviceConfigRequestModel;



public class GetDeviceConfigService {

    public SetupDeviceConfigRequestModel getDeviceConfig() {

        SetupDeviceConfigRequestModel setupDeviceConfigRequestModel = new SetupDeviceConfigRequestModel();
        setupDeviceConfigRequestModel.setCameraScreenshotInterval(ConfigurationPersistentState.cameraInterval);
        setupDeviceConfigRequestModel.setMotorInterval(ConfigurationPersistentState.motorInterval);
        return setupDeviceConfigRequestModel;
    }

}
