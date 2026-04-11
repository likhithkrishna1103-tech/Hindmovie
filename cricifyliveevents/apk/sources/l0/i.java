package l0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends vf.g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class f7614e;
    public static final Constructor f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Method f7615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Method f7616h;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e9) {
            Log.e("TypefaceCompatApi24Impl", e9.getClass().getName(), e9);
            cls = null;
            method = null;
            method2 = null;
        }
        f = constructor;
        f7614e = cls;
        f7615g = method2;
        f7616h = method;
    }

    public static boolean e0(Object obj, ByteBuffer byteBuffer, int i, int i10, boolean z10) {
        try {
            return ((Boolean) f7615g.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i10), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface f0(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f7614e, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f7616h.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // vf.g
    public final Typeface o(Context context, k0.e eVar, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        MappedByteBuffer map;
        FileInputStream fileInputStream;
        try {
            objNewInstance = f.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            for (k0.f fVar : eVar.f6758a) {
                int i10 = fVar.f;
                File fileJ = w1.d.j(context);
                if (fileJ != null) {
                    try {
                        if (w1.d.c(fileJ, resources, i10)) {
                            try {
                                fileInputStream = new FileInputStream(fileJ);
                            } catch (IOException unused2) {
                                map = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                if (map != null && e0(objNewInstance, map, fVar.f6763e, fVar.f6760b, fVar.f6761c)) {
                                }
                            } finally {
                            }
                        }
                    } finally {
                        fileJ.delete();
                    }
                }
                map = null;
                if (map != null) {
                }
            }
            return f0(objNewInstance);
        }
        return null;
    }

    @Override // vf.g
    public final Typeface p(Context context, q0.i[] iVarArr, int i) {
        Object objNewInstance;
        try {
            objNewInstance = f.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            int i10 = 0;
            v.k kVar = new v.k(0);
            int length = iVarArr.length;
            while (true) {
                if (i10 < length) {
                    q0.i iVar = iVarArr[i10];
                    Uri uri = iVar.f10344a;
                    ByteBuffer byteBufferN = (ByteBuffer) kVar.get(uri);
                    if (byteBufferN == null) {
                        byteBufferN = w1.d.n(context, uri);
                        kVar.put(uri, byteBufferN);
                    }
                    if (byteBufferN == null || !e0(objNewInstance, byteBufferN, iVar.f10345b, iVar.f10346c, iVar.f10347d)) {
                        break;
                    }
                    i10++;
                } else {
                    Typeface typefaceF0 = f0(objNewInstance);
                    if (typefaceF0 != null) {
                        return Typeface.create(typefaceF0, i);
                    }
                }
            }
        }
        return null;
    }
}
