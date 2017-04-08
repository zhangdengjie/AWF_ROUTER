package com.zdj.router.interceptors;

import com.zdj.router.wrappers.IntentWrapper;

/**
 * Created by zdj on 17-4-8.
 */

public interface Interceptor {
    /**
     * return true to intercept executor
     * @param intentWrapper the intent wrapper
     * @return
     */
    boolean intercept(IntentWrapper intentWrapper);
}
