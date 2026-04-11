package com.bumptech.glide;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import hb.r;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static final String B(Collection collection) {
        return ne.i.T(sd.j.l0(collection, ",", null, null, null, 62)) + ne.i.T(" }");
    }

    public static final String C(Collection collection) {
        return ne.i.T(sd.j.l0(collection, ",", null, null, null, 62)) + ne.i.T("},");
    }

    public static int D(float f, int i, int i10) {
        return l0.b.b(l0.b.d(i10, Math.round(Color.alpha(i10) * f)), i);
    }

    public static ta.l E(ta.l lVar) {
        return ((lVar instanceof ta.n) || (lVar instanceof ta.m)) ? lVar : lVar instanceof Serializable ? new ta.m(lVar) : new ta.n(lVar);
    }

    public static ke.a G(ke.c cVar, int i) {
        ge.i.e(cVar, "<this>");
        boolean z10 = i > 0;
        Integer numValueOf = Integer.valueOf(i);
        if (!z10) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i10 = cVar.f7418v;
        int i11 = cVar.f7419w;
        if (cVar.f7420x <= 0) {
            i = -i;
        }
        return new ke.a(i10, i11, i);
    }

    public static int H(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static ke.c I(int i, int i10) {
        if (i10 > Integer.MIN_VALUE) {
            return new ke.c(i, i10 - 1, 1);
        }
        ke.c cVar = ke.c.f7425y;
        return ke.c.f7425y;
    }

    public static void L(s5.h hVar, long j4) {
        String str;
        TextView textView = hVar.F;
        long j7 = j4 / 86400000;
        long j10 = (j4 / 3600000) % 24;
        long j11 = (j4 / 60000) % 60;
        if (j7 > 0) {
            str = "Starts in " + j7 + " days";
        } else if (j10 > 0) {
            str = "Starts in " + j10 + " hours";
        } else {
            str = "Starts in " + j11 + " minutes";
        }
        if (str.equals(textView.getText().toString())) {
            return;
        }
        textView.setText(str);
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b8 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b8)));
        }
        return sb.toString();
    }

    public static void d(String str, boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void e(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static byte g(long j4) {
        d.e(j4, "out of range: %s", (j4 >> 8) == 0);
        return (byte) j4;
    }

    public static long h(long j4) {
        if (j4 < -4611686018427387903L) {
            return -4611686018427387903L;
        }
        if (j4 > 4611686018427387903L) {
            return 4611686018427387903L;
        }
        return j4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] i(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    public static final boolean j(String str, String str2) {
        ge.i.e(str, "current");
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i = 0;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i < str.length()) {
                    char cCharAt = str.charAt(i);
                    int i12 = i11 + 1;
                    if (i11 == 0 && cCharAt != '(') {
                        break;
                    }
                    if (cCharAt == '(') {
                        i10++;
                    } else if (cCharAt == ')' && i10 - 1 == 0 && i11 != str.length() - 1) {
                        break;
                    }
                    i++;
                    i11 = i12;
                } else if (i10 == 0) {
                    String strSubstring = str.substring(1, str.length() - 1);
                    ge.i.d(strSubstring, "substring(...)");
                    return ge.i.a(ne.h.t0(strSubstring).toString(), str2);
                }
            }
        }
        return false;
    }

    public static void k(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            hb.b bVar = (hb.b) obj;
            hb.h hVar = new hb.h(bVar);
            for (r rVar : bVar.f5877b) {
                boolean z10 = bVar.f5880e == 0;
                hb.i iVar = new hb.i(rVar, !z10);
                if (!map.containsKey(iVar)) {
                    map.put(iVar, new HashSet());
                }
                Set set = (Set) map.get(iVar);
                if (!set.isEmpty() && z10) {
                    throw new IllegalArgumentException("Multiple components provide " + rVar + ".");
                }
                set.add(hVar);
            }
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            for (hb.h hVar2 : (Set) it.next()) {
                for (hb.j jVar : hVar2.f5890a.f5878c) {
                    if (jVar.f5897c == 0) {
                        Set<hb.h> set2 = (Set) map.get(new hb.i(jVar.f5895a, jVar.f5896b == 2));
                        if (set2 != null) {
                            for (hb.h hVar3 : set2) {
                                hVar2.f5891b.add(hVar3);
                                hVar3.f5892c.add(hVar2);
                            }
                        }
                    }
                }
            }
        }
        HashSet<hb.h> hashSet = new HashSet();
        Iterator it2 = map.values().iterator();
        while (it2.hasNext()) {
            hashSet.addAll((Set) it2.next());
        }
        HashSet hashSet2 = new HashSet();
        for (hb.h hVar4 : hashSet) {
            if (hVar4.f5892c.isEmpty()) {
                hashSet2.add(hVar4);
            }
        }
        while (!hashSet2.isEmpty()) {
            hb.h hVar5 = (hb.h) hashSet2.iterator().next();
            hashSet2.remove(hVar5);
            i++;
            for (hb.h hVar6 : hVar5.f5891b) {
                hVar6.f5892c.remove(hVar5);
                if (hVar6.f5892c.isEmpty()) {
                    hashSet2.add(hVar6);
                }
            }
        }
        if (i == arrayList.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (hb.h hVar7 : hashSet) {
            if (!hVar7.f5892c.isEmpty() && !hVar7.f5891b.isEmpty()) {
                arrayList2.add(hVar7.f5890a);
            }
        }
        throw new hb.k("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
    }

    public static final String l(Collection collection) {
        ge.i.e(collection, "collection");
        if (collection.isEmpty()) {
            return " }";
        }
        return ne.i.T(sd.j.l0(collection, ",\n", "\n", "\n", null, 56)) + "},";
    }

    public static int m(Context context, int i, int i10) {
        Integer numValueOf;
        TypedValue typedValueG = android.support.v4.media.session.b.G(context, i);
        if (typedValueG != null) {
            int i11 = typedValueG.resourceId;
            numValueOf = Integer.valueOf(i11 != 0 ? context.getColor(i11) : typedValueG.data);
        } else {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : i10;
    }

    public static int n(View view, int i) {
        Context context = view.getContext();
        TypedValue typedValueI = android.support.v4.media.session.b.I(i, view.getContext(), view.getClass().getCanonicalName());
        int i10 = typedValueI.resourceId;
        return i10 != 0 ? context.getColor(i10) : typedValueI.data;
    }

    public static long p(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.parse(str + " " + str2).getTime();
    }

    public static boolean x(int i) {
        if (i == 0) {
            return false;
        }
        ThreadLocal threadLocal = l0.b.f7600a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d10 = ((double) iRed) / 255.0d;
        double dPow = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        double d11 = ((double) iGreen) / 255.0d;
        double dPow2 = d11 < 0.04045d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
        double d12 = ((double) iBlue) / 255.0d;
        double dPow3 = d12 < 0.04045d ? d12 / 12.92d : Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
        double d13 = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
        dArr[1] = d13;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
        return d13 / 100.0d > 0.5d;
    }

    public abstract boolean A(float f, float f10);

    public abstract boolean F(View view, float f);

    public abstract void J(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

    public abstract void K(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i10);

    public abstract int b(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float c(int i);

    public abstract int o(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int q();

    public abstract int r();

    public abstract int s();

    public abstract int t();

    public abstract int u(View view);

    public abstract int v(CoordinatorLayout coordinatorLayout);

    public abstract int w();

    public abstract boolean y(float f);

    public abstract boolean z(View view);
}
