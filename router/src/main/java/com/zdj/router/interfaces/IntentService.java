package com.zdj.router.interfaces;

import com.zdj.router.annotations.ClassName;
import com.zdj.router.annotations.Key;
import com.zdj.router.annotations.RequestCode;
import com.zdj.router.wrappers.IntentWrapper;

/**
 * Created by zdj on 17-4-8.
 */

public interface IntentService {

    @ClassName("com.zdj.modulea.MainActivity")
    @RequestCode(100)
    void toModuleAActivity(@Key("platform") String platform, @Key("year") int year);

    @ClassName("android.router.literouter.ActivityDemo2")
    IntentWrapper intent2ActivityDemo2Raw(@Key("platform") String platform, @Key("year") int year);
}
