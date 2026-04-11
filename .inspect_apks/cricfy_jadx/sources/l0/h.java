package l0;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class h extends vf.g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class f7611e = null;
    public static Constructor f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f7612g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Method f7613h = null;
    public static boolean i = false;

    public static boolean e0(Object obj, String str, int i10, boolean z10) throws NoSuchMethodException {
        f0();
        try {
            try {
                return ((Boolean) f7612g.invoke(obj, str, Integer.valueOf(i10), Boolean.valueOf(z10))).booleanValue();
            } catch (InvocationTargetException e9) {
                e = e9;
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InvocationTargetException e10) {
            e = e10;
        }
    }

    public static void f0() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (i) {
            return;
        }
        i = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e9) {
            Log.e("TypefaceCompatApi21Impl", e9.getClass().getName(), e9);
            method = null;
            cls = null;
            method2 = null;
        }
        f = constructor;
        f7611e = cls;
        f7612g = method2;
        f7613h = method;
    }

    @Override // vf.g
    public Typeface o(Context context, k0.e eVar, Resources resources, int i10) throws NoSuchMethodException {
        f0();
        try {
            Object objNewInstance = f.newInstance(null);
            for (k0.f fVar : eVar.f6758a) {
                File fileJ = w1.d.j(context);
                if (fileJ == null) {
                    return null;
                }
                try {
                    if (!w1.d.c(fileJ, resources, fVar.f)) {
                        return null;
                    }
                    if (!e0(objNewInstance, fileJ.getPath(), fVar.f6760b, fVar.f6761c)) {
                        return null;
                    }
                    fileJ.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileJ.delete();
                }
            }
            f0();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) f7611e, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) f7613h.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e9) {
                throw new RuntimeException(e9);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // vf.g
    public Typeface p(Context context, q0.i[] iVarArr, int i10) {
        String str;
        if (iVarArr.length >= 1) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(y(iVarArr, i10).f10344a, "r", null);
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
                        Typeface typefaceR = r(context, fileInputStream);
                        fileInputStream.close();
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceR;
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
