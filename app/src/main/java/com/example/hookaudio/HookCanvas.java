package com.example.hookaudio;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author dongjianye on 1/8/21
 */
class HookCanvas {

     static void hookCanvas(XC_LoadPackage.LoadPackageParam lpparam, final String inputName) {
        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawText",
                CharSequence.class, int.class, int.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            try {
                                if ("Q".equals(param.args[0])) {
                                    Log.d("dongjianye", Log.getStackTraceString(new Throwable()));
                                }
                            } catch (Throwable e) {
                            }


                            Log.d("dongjianye", String.format("%s:Canvas:draw(%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawText",
                String.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            try {
                                if ("Q".equals(param.args[0])) {
                                    Log.d("dongjianye", Log.getStackTraceString(new Throwable()));
                                }
                            } catch (Throwable e) {
                            }
                            Log.d("dongjianye", String.format("%s:Canvas:draw(%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawText",
                String.class, int.class, int.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            try {
                                if ("Q".equals(param.args[0])) {
                                    Log.d("dongjianye", Log.getStackTraceString(new Throwable()));
                                }
                            } catch (Throwable e) {
                            }
                            Log.d("dongjianye", String.format("%s:Canvas:draw(%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawText",
                char[].class, int.class, int.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:draw(%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawBitmap",
                Bitmap.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawBitmap()[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawBitmap",
                Bitmap.class, Rect.class, RectF.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawBitmap()[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawBitmap",
                Bitmap.class, Rect.class, Rect.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawBitmap()[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawPatch",
                NinePatch.class, Rect.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawPatch(Rect:%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[1],
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawPatch",
                NinePatch.class, RectF.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawPatch(Rect:%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[1],
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawRect",
                RectF.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawRect(Rect:%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawRect",
                RectF.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawRect(RectF:%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawRect",
                float.class, float.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawRect(left:%f, top:%f, right:%f, bottom:%f)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[0], param.args[1], param.args[2], param.args[3],
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawRoundRect",
                RectF.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawRect(Rect:%s, rx:%f, ry:%f)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[0], param.args[1], param.args[2],
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawRoundRect",
                float.class, float.class, float.class, float.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawRect(left:%f, top:%f, right:%f, bottom:%f, rx:%f, ry:%f)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[0], param.args[1], param.args[2], param.args[3], param.args[4], param.args[5],
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawPath",
                Path.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawPath()[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.drawable.NinePatchDrawable", lpparam.classLoader,
                "draw",
                Canvas.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:NinePatchDrawable:draw()[Thread:(id:%d, name:%s)]",
                                    inputName,
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