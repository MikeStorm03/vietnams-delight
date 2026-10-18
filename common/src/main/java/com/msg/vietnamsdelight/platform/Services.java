package com.msg.vietnamsdelight.platform;

import com.msg.vietnamsdelight.Constants;
import com.msg.vietnamsdelight.platform.farmers_delight.FD_Effects;
import com.msg.vietnamsdelight.platform.farmers_delight.FD_Items;
import com.msg.vietnamsdelight.platform.services.CustomBrew;
import com.msg.vietnamsdelight.platform.services.IPlatformHelper;
import com.msg.vietnamsdelight.platform.services.ModBuilders;

import java.util.ServiceLoader;

public class Services {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final CustomBrew CUSTOM_BREWING_RECIPE = load(CustomBrew.class);
    public static final ModBuilders BUILDERS = load(ModBuilders.class);

    public static final FD_Effects FD_EFFECTS = load(FD_Effects.class);
    public static final FD_Items FD_ITEMS = load(FD_Items.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Constants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}