package com.example.hookaudio;

import android.content.Context;
import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author dongjianye on 1/8/21
 */
class HookIFlyVibratorUtil {

    static void hookIFlyVibratorUtil(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.common.util.ThirdVibratorUtil", lpparam.classLoader,
                "isThirdVibratorType",
                Context.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("ThirdVibratorUtil.isThirdVibratorType()[Thread:(id:%d, name:%s)][class:%s]",
                                    Thread.currentThread().getId(), Thread.currentThread().getName(), param.thisObject.getClass().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
    }
}