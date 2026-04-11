package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {
    public static final Class[] f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f1159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f1160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f1161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b5.d f1162e;

    public h0(HashMap map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f1158a = linkedHashMap;
        this.f1159b = new LinkedHashMap();
        this.f1160c = new LinkedHashMap();
        this.f1161d = new LinkedHashMap();
        this.f1162e = new androidx.fragment.app.h0(1, this);
        linkedHashMap.putAll(map);
    }

    public static Bundle a(h0 h0Var) {
        LinkedHashMap linkedHashMap = h0Var.f1158a;
        Iterator it = sd.s.C(h0Var.f1159b).entrySet().iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                Set<String> setKeySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(setKeySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : setKeySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap.get(str));
                }
                rd.f[] fVarArr = {new rd.f("keys", arrayList), new rd.f("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                while (i < 2) {
                    rd.f fVar = fVarArr[i];
                    String str2 = (String) fVar.f10993v;
                    Object obj = fVar.f10994w;
                    if (obj == null) {
                        bundle.putString(str2, null);
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Byte) {
                        bundle.putByte(str2, ((Number) obj).byteValue());
                    } else if (obj instanceof Character) {
                        bundle.putChar(str2, ((Character) obj).charValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str2, ((Number) obj).doubleValue());
                    } else if (obj instanceof Float) {
                        bundle.putFloat(str2, ((Number) obj).floatValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str2, ((Number) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str2, ((Number) obj).longValue());
                    } else if (obj instanceof Short) {
                        bundle.putShort(str2, ((Number) obj).shortValue());
                    } else if (obj instanceof Bundle) {
                        bundle.putBundle(str2, (Bundle) obj);
                    } else if (obj instanceof CharSequence) {
                        bundle.putCharSequence(str2, (CharSequence) obj);
                    } else if (obj instanceof Parcelable) {
                        bundle.putParcelable(str2, (Parcelable) obj);
                    } else if (obj instanceof boolean[]) {
                        bundle.putBooleanArray(str2, (boolean[]) obj);
                    } else if (obj instanceof byte[]) {
                        bundle.putByteArray(str2, (byte[]) obj);
                    } else if (obj instanceof char[]) {
                        bundle.putCharArray(str2, (char[]) obj);
                    } else if (obj instanceof double[]) {
                        bundle.putDoubleArray(str2, (double[]) obj);
                    } else if (obj instanceof float[]) {
                        bundle.putFloatArray(str2, (float[]) obj);
                    } else if (obj instanceof int[]) {
                        bundle.putIntArray(str2, (int[]) obj);
                    } else if (obj instanceof long[]) {
                        bundle.putLongArray(str2, (long[]) obj);
                    } else if (obj instanceof short[]) {
                        bundle.putShortArray(str2, (short[]) obj);
                    } else if (obj instanceof Object[]) {
                        Class<?> componentType = obj.getClass().getComponentType();
                        ge.i.b(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str2, (Parcelable[]) obj);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str2, (String[]) obj);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str2, (CharSequence[]) obj);
                        } else {
                            if (!Serializable.class.isAssignableFrom(componentType)) {
                                throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str2 + '\"');
                            }
                            bundle.putSerializable(str2, (Serializable) obj);
                        }
                    } else if (obj instanceof Serializable) {
                        bundle.putSerializable(str2, (Serializable) obj);
                    } else if (obj instanceof IBinder) {
                        bundle.putBinder(str2, (IBinder) obj);
                    } else if (obj instanceof Size) {
                        bundle.putSize(str2, (Size) obj);
                    } else {
                        if (!(obj instanceof SizeF)) {
                            throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str2 + '\"');
                        }
                        bundle.putSizeF(str2, (SizeF) obj);
                    }
                    i++;
                }
                return bundle;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str3 = (String) entry.getKey();
            Object objA = ((b5.d) entry.getValue()).a();
            ge.i.e(str3, "key");
            if (objA != null) {
                while (i < 29) {
                    Class cls = f[i];
                    ge.i.b(cls);
                    if (!cls.isInstance(objA)) {
                        i++;
                    }
                }
                throw new IllegalArgumentException("Can't put value with type " + objA.getClass() + " into saved state");
            }
            Object obj2 = h0Var.f1160c.get(str3);
            y yVar = obj2 instanceof y ? (y) obj2 : null;
            if (yVar != null) {
                yVar.e(objA);
            } else {
                linkedHashMap.put(str3, objA);
            }
            se.u uVar = (se.u) h0Var.f1161d.get(str3);
            if (uVar != null) {
                se.x xVar = (se.x) uVar;
                if (objA == null) {
                    objA = te.c.f12021b;
                }
                xVar.e(null, objA);
            }
        }
    }

    public h0() {
        this.f1158a = new LinkedHashMap();
        this.f1159b = new LinkedHashMap();
        this.f1160c = new LinkedHashMap();
        this.f1161d = new LinkedHashMap();
        this.f1162e = new androidx.fragment.app.h0(1, this);
    }
}
