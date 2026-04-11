package i0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class h extends i5.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Class f6170j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Constructor f6171k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Method f6172l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Method f6173m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f6174n = false;

    public static boolean T(Object obj, String str, int i, boolean z2) throws NoSuchMethodException {
        U();
        try {
            try {
                return ((Boolean) f6172l.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z2))).booleanValue();
            } catch (InvocationTargetException e10) {
                e = e10;
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InvocationTargetException e11) {
            e = e11;
        }
    }

    public static void U() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f6174n) {
            return;
        }
        f6174n = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi21Impl", e10.getClass().getName(), e10);
            method = null;
            cls = null;
            method2 = null;
        }
        f6171k = constructor;
        f6170j = cls;
        f6172l = method2;
        f6173m = method;
    }

    @Override // i5.a
    public Typeface i(Context context, h0.e eVar, Resources resources, int i) throws NoSuchMethodException {
        U();
        try {
            Object objNewInstance = f6171k.newInstance(null);
            for (h0.f fVar : eVar.f5583a) {
                File fileD = q1.c.D(context);
                if (fileD == null) {
                    return null;
                }
                try {
                    if (!q1.c.q(fileD, resources, fVar.f)) {
                        return null;
                    }
                    if (!T(objNewInstance, fileD.getPath(), fVar.f5585b, fVar.f5586c)) {
                        return null;
                    }
                    fileD.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileD.delete();
                }
            }
            U();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) f6170j, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) f6173m.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e10) {
                throw new RuntimeException(e10);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // i5.a
    public Typeface j(Context context, n0.i[] iVarArr, int i) {
        String str;
        if (iVarArr.length >= 1) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(p(iVarArr, i).f8629a, "r", null);
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        try {
                            str = Os.readlink("/proc/self/fd/" + parcelFileDescriptorOpenFileDescriptor.getFd());
                        } finally {
                        }
                    } catch (ErrnoException unused) {
                    }
                    File file = OsConstants.S_ISREG(Os.stat(str).st_mode) ? new File(str) : null;
                    if (file != null && file.canRead()) {
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceCreateFromFile;
                    }
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        Typeface typefaceL = l(context, fileInputStream);
                        fileInputStream.close();
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceL;
                    } finally {
                    }
                }
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return null;
                }
            } catch (IOException unused2) {
            }
        }
        return null;
    }
}
