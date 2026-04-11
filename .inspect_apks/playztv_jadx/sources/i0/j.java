package i0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class j extends h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Class f6179o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Constructor f6180p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Method f6181q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Method f6182r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Method f6183s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Method f6184t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Method f6185u;

    public j() throws NoSuchMethodException {
        Method methodZ;
        Constructor<?> constructor;
        Method methodY;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodY = Y(cls2);
            Class<?> cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodZ = Z(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e10.getClass().getName()), e10);
            methodZ = null;
            constructor = null;
            methodY = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.f6179o = cls;
        this.f6180p = constructor;
        this.f6181q = methodY;
        this.f6182r = method;
        this.f6183s = method2;
        this.f6184t = method3;
        this.f6185u = methodZ;
    }

    public static Method Y(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final boolean V(Context context, Object obj, String str, int i, int i10, int i11, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f6181q.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i10), Integer.valueOf(i11), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface W(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f6179o, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f6185u.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean X(Object obj) {
        try {
            return ((Boolean) this.f6183s.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method Z(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // i0.h, i5.a
    public final Typeface i(Context context, h0.e eVar, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.f6181q;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.i(context, eVar, resources, i);
        }
        try {
            objNewInstance = this.f6180p.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            h0.f[] fVarArr = eVar.f5583a;
            int length = fVarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    h0.f fVar = fVarArr[i10];
                    Context context2 = context;
                    if (V(context2, objNewInstance, fVar.f5584a, fVar.f5588e, fVar.f5585b, fVar.f5586c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fVar.f5587d))) {
                        i10++;
                        context = context2;
                    } else {
                        try {
                            this.f6184t.invoke(objNewInstance, null);
                            break;
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                } else if (X(objNewInstance)) {
                    return W(objNewInstance);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    @Override // i0.h, i5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Typeface j(android.content.Context r18, n0.i[] r19, int r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.j.j(android.content.Context, n0.i[], int):android.graphics.Typeface");
    }

    @Override // i5.a
    public final Typeface m(Context context, Resources resources, int i, String str, int i10) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.f6181q;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.m(context, resources, i, str, i10);
        }
        try {
            objNewInstance = this.f6180p.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            if (!V(context, objNewInstance, str, 0, -1, -1, null)) {
                try {
                    this.f6184t.invoke(objNewInstance, null);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            } else if (X(objNewInstance)) {
                return W(objNewInstance);
            }
        }
        return null;
    }
}
