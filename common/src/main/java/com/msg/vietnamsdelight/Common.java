package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.multiloader_compat.registers.RegistryHelper;
import com.msg.vietnamsdelight.platform.Services;

public class Common {

    public static void init() {

        Constants.LOG.info("Mod {} is runnning on {}! We are currently in a {} environment!",
                                        Constants.NAME,
                                        Services.PLATFORM.getPlatformName(),
                                        Services.PLATFORM.getEnvironmentName());
    }

    public static <T> RegistryHelper<T> registryHelper(){
        return new RegistryHelper<>(Constants.NAMESPACE);
    }
}