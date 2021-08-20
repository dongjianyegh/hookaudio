package com.example.hookaudio;

import android.os.Message;
import android.util.Log;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnectionWrapper;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author dongjianye on 1/8/21
 */
class HookInputConnection {

    static void hookInputConnection(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("com.android.internal.view.InputConnectionWrapper",
                lpparam.classLoader,
                "getTextBeforeCursor",
                int.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("getTextBeforeCursor:(%d, %d)[Thread:(id:%d, name:%s)]",
                                    param.args[0], param.args[1],
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("getTextBeforeCursor:result(%s)[Thread:(id:%d, name:%s)]",
                                    param.getResult(),
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }
                });

        XposedHelpers.findAndHookMethod("com.android.internal.view.InputConnectionWrapper",
                lpparam.classLoader,
                "getTextAfterCursor",
                int.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("getTextAfterCursor:(%d, %d)[Thread:(id:%d, name:%s)]",
                                    param.args[0], param.args[1],
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("getTextAfterCursor:result(%s)[Thread:(id:%d, name:%s)]",
                                    param.getResult(),
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }
                });

        XposedHelpers.findAndHookMethod("com.android.internal.view.InputConnectionWrapper",
                lpparam.classLoader,
                "getExtractedText",
                ExtractedTextRequest.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("getExtractedText:(%d)[Thread:(id:%d, name:%s)]",
                                    param.args[1],
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        try {
                            ExtractedText result = (ExtractedText) param.getResult();
                            if (result != null) {
                                StringBuilder builder = new StringBuilder();

                                builder.append("text:").append(result.text);
                            }

                            Log.d("dongjianye", String.format("getExtractedText:result(%s)[Thread:(id:%d, name:%s)]",
                                    result.toString(),
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }
                });

        XposedHelpers.findAndHookMethod("com.android.internal.view.InputConnectionWrapper",
                lpparam.classLoader,
                "commitText",
                CharSequence.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("commitText:(%s)[Thread:(id:%d, name:%s)]",
                                    param.args[0],
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

        XposedHelpers.findAndHookMethod("com.android.internal.view.InputConnectionWrapper",
                lpparam.classLoader,
                "setComposingText",
                CharSequence.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("setComposingText:(%s)[Thread:(id:%d, name:%s)]",
                                    param.args[0],
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                            Log.d("dongjianye", Log.getStackTraceString(new Throwable()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

//        XposedHelpers.findAndHookMethod("app.fpo",
//                lpparam.classLoader,
//                "handleMessage",
//                Message.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//
//                        try {
//                            Log.d("dongjianye", String.format("app.fpo:handleMessage(%d)[Thread:(id:%d, name:%s)]",
//                                    ((Message) param.args[0]).what,
//                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
//                        } catch (Throwable ignored) {
//                            ignored.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                    }
//                });
    }
}