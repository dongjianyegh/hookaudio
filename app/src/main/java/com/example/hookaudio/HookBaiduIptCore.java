package com.example.hookaudio;

import android.util.Log;

import org.json.JSONObject;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author: dongjianye
 * @date: 2021/9/13
 */
public class HookBaiduIptCore {

    private static void printIptCloudStream(JSONObject builder, Object obj) {
        try {
            builder.put("url", XposedHelpers.getObjectField(obj, "url"));
            builder.put("port", XposedHelpers.getIntField(obj, "port"));
            builder.put("protocol", XposedHelpers.getIntField(obj, "protocol"));
            builder.put("timeOut", XposedHelpers.getIntField(obj, "timeOut"));
            builder.put("maxRecvLen", XposedHelpers.getIntField(obj, "maxRecvLen"));

        } catch (Exception e) {}
    }

    private static String printByteArray(byte[] value) {
        if (value == null) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            for (byte v : value) {
                builder.append(v).append(",");
            }
            return builder.toString();
        }
    }

    static void hookSpeechResult(XC_LoadPackage.LoadPackageParam lpparam) {
        XC_MethodHook.Unhook unhook = XposedHelpers.findAndHookMethod("com.baidu.iptcore.net.IptCloudStream",lpparam.classLoader,
                "send", int.class, byte[].class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("IptCloudStream:send(%d, %s)[Thread:(id:%d, name:%s)]",
                                    (int) param.args[0], printByteArray((byte[]) param.args[1]),
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                            JSONObject object = new JSONObject();
                            printIptCloudStream(object, param.thisObject);
                            Log.d("dongjianye", object.toString());
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        Class clazz = null;
        try {
            clazz = lpparam.classLoader.loadClass("com.baidu.iptcore.net.IptCloudStream");
            Log.d("dongjianye", "hook IptCloudStream " + clazz);
        } catch (Exception e) {
            Log.d("dongjianye", "hook IptCloudStream " + clazz);
        }
        if (null != clazz) {
            Log.d("dongjianye", "start hook com.baidu.iptcore$a " + clazz);
            unhook = XposedHelpers.findAndHookMethod("com.baidu.iptcore.IptCoreNetMan$a", lpparam.classLoader,
                    "a", clazz, int.class, byte[].class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);

                            try {
                                Log.d("dongjianye", String.format("IptCoreNetMan$a:a(%s, %d, %s)[Thread:(id:%d, name:%s)]",
                                        param.args[0].toString(), (int) param.args[1], printByteArray((byte[]) param.args[2]),
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

        XposedHelpers.findAndHookMethod("com.baidu.iptcore.info.IptCoreCandInfo", lpparam.classLoader,
                "setData", int.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("IptCoreCandInfo:setData()[Thread:(id:%d, name:%s)]",
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Log.d("dongjianye", param.thisObject.toString());
                    }
                });
    }
}
