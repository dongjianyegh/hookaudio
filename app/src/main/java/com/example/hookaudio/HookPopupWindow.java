package com.example.hookaudio;

import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author dongjianye on 1/8/21
 */
class HookPopupWindow {

    static void hookPopupWindow(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(PopupWindow.class,
                "showAtLocation",
                View.class, int.class, int.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("PopupWindow:show()[Thread:(id:%d, name:%s)]",
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
    }
}