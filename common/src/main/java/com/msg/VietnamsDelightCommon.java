package com.msg;

import com.msg.platform.Services;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class VietnamsDelightCommon {

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    public static void init() {

        VietnamsDelightConstants.LOG.info("Mod {} is runnning on {}! We are currently in a {} environment!",
                            VietnamsDelightConstants.NAME,
                            Services.PLATFORM.getPlatformName(),
                            Services.PLATFORM.getEnvironmentName());
        // the platform specific approach.
        if (Services.PLATFORM.getPlatformName() == "Fabric") {
        }
    }
}