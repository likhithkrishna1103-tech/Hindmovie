package l0;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class j extends h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Class f7617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Constructor f7618k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Method f7619l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Method f7620m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Method f7621n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Method f7622o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Method f7623p;

    public j() throws NoSuchMethodException {
        Method methodK0;
        Constructor<?> constructor;
        Method methodJ0;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodJ0 = j0(cls2);
            Class<?> cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodK0 = k0(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e9) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e9.getClass().getName()), e9);
            methodK0 = null;
            constructor = null;
            methodJ0 = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.f7617j = cls;
        this.f7618k = constructor;
        this.f7619l = methodJ0;
        this.f7620m = method;
        this.f7621n = method2;
        this.f7622o = method3;
        this.f7623p = methodK0;
    }

    public static Method j0(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final boolean g0(Context context, Object obj, String str, int i, int i10, int i11, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f7619l.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i10), Integer.valueOf(i11), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface h0(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f7617j, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f7623p.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean i0(Object obj) {
        try {
            return ((Boolean) this.f7621n.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method k0(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // l0.h, vf.g
    public final Typeface o(Context context, k0.e eVar, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.f7619l;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.o(context, eVar, resources, i);
        }
        try {
            objNewInstance = this.f7618k.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            k0.f[] fVarArr = eVar.f6758a;
            int length = fVarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    k0.f fVar = fVarArr[i10];
                    Context context2 = context;
                    if (g0(context2, objNewInstance, fVar.f6759a, fVar.f6763e, fVar.f6760b, fVar.f6761c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fVar.f6762d))) {
                        i10++;
                        context = context2;
                    } else {
                        try {
                            this.f7622o.invoke(objNewInstance, null);
                            break;
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                } else if (i0(objNewInstance)) {
                    return h0(objNewInstance);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    @Override // l0.h, vf.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Typeface p(android.content.Context r18, q0.i[] r19, int r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.j.p(android.content.Context, q0.i[], int):android.graphics.Typeface");
    }

    @Override // vf.g
    public final Typeface s(Context context, Resources resources, int i, String str, int i10) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.f7619l;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.s(context, resources, i, str, i10);
        }
        try {
            objNewInstance = this.f7618k.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            if (!g0(context, objNewInstance, str, 0, -1, -1, null)) {
                try {
                    this.f7622o.invoke(objNewInstance, null);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            } else if (i0(objNewInstance)) {
                return h0(objNewInstance);
            }
        }
        return null;
    }
}
