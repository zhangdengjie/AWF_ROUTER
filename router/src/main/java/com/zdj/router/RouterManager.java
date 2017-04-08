package com.zdj.router;

import android.app.Activity;
import android.content.Context;

import com.zdj.router.interceptors.Interceptor;
import com.zdj.router.interfaces.IntentService;
import com.zdj.router.wrappers.IntentWrapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 路由
 * Created by zdj on 17-4-8.
 */

public class RouterManager {


    private Interceptor interceptor;

    RouterManager(Interceptor interceptor) {
        this.interceptor = interceptor;
    }


    public IntentService create(Class serviceClass, final Activity activity) {
        return (IntentService) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class[]{serviceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                IntentWrapper intentWrapper = loadIntentWrapper(activity, method, args);

                Class returnTYpe = method.getReturnType();
                if (returnTYpe == void.class) {
                    if (interceptor == null || !interceptor.intercept(intentWrapper)) {
                        intentWrapper.start();
                    }
                    return null;
                } else if (returnTYpe == IntentWrapper.class) {
                    return intentWrapper;
                }
                throw new RuntimeException("method return type only support 'void' or 'IntentWrapper'");
            }
        });
    }

    IntentWrapper loadIntentWrapper(Context context, Method method, Object... args) {
        return new IntentWrapper.Builder(context, method, args).build();
    }

    public static final class Builder {
        private Interceptor interceptor;

        public Builder interceptor(Interceptor interceptor) {
            this.interceptor = interceptor;
            return this;
        }

        public RouterManager build() {
            return new RouterManager(interceptor);
        }
    }
}
