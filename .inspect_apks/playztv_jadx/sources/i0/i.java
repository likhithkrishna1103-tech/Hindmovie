package i0;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends i5.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Class f6175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Constructor f6176k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Method f6177l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Method f6178m;

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
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi24Impl", e10.getClass().getName(), e10);
            cls = null;
            method = null;
            method2 = null;
        }
        f6176k = constructor;
        f6175j = cls;
        f6177l = method2;
        f6178m = method;
    }

    public static boolean T(Object obj, ByteBuffer byteBuffer, int i, int i10, boolean z2) {
        try {
            return ((Boolean) f6177l.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i10), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface U(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f6175j, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f6178m.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // i5.a
    public final Typeface i(Context context, h0.e eVar, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        MappedByteBuffer map;
        FileInputStream fileInputStream;
        try {
            objNewInstance = f6176k.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            for (h0.f fVar : eVar.f5583a) {
                int i10 = fVar.f;
                File fileD = q1.c.D(context);
                if (fileD != null) {
                    try {
                        if (q1.c.q(fileD, resources, i10)) {
                            try {
                                fileInputStream = new FileInputStream(fileD);
                            } catch (IOException unused2) {
                                map = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                if (map != null && T(objNewInstance, map, fVar.f5588e, fVar.f5585b, fVar.f5586c)) {
                                }
                            } finally {
                            }
                        }
                    } finally {
                        fileD.delete();
                    }
                }
                map = null;
                if (map != null) {
                }
            }
            return U(objNewInstance);
        }
        return null;
    }

    @Override // i5.a
    public final Typeface j(Context context, n0.i[] iVarArr, int i) {
        Object objNewInstance;
        try {
            objNewInstance = f6176k.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            int i10 = 0;
            s.i iVar = new s.i(0);
            int length = iVarArr.length;
            while (true) {
                if (i10 < length) {
                    n0.i iVar2 = iVarArr[i10];
                    Uri uri = iVar2.f8629a;
                    ByteBuffer byteBufferG = (ByteBuffer) iVar.get(uri);
                    if (byteBufferG == null) {
                        byteBufferG = q1.c.G(context, uri);
                        iVar.put(uri, byteBufferG);
                    }
                    if (byteBufferG == null || !T(objNewInstance, byteBufferG, iVar2.f8630b, iVar2.f8631c, iVar2.f8632d)) {
                        break;
                    }
                    i10++;
                } else {
                    Typeface typefaceU = U(objNewInstance);
                    if (typefaceU != null) {
                        return Typeface.create(typefaceU, i);
                    }
                }
            }
        }
        return null;
    }
}
