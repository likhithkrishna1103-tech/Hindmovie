package f9;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.c5;
import com.google.android.gms.internal.measurement.g6;
import com.google.android.gms.internal.measurement.h5;
import com.google.android.gms.internal.measurement.n5;
import com.google.android.gms.internal.measurement.o5;
import com.google.android.gms.internal.measurement.q8;
import com.google.android.gms.internal.measurement.v5;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends l4 {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f4000z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(q4 q4Var, int i) {
        super(q4Var);
        this.f4000z = i;
    }

    public static final String A1(boolean z10, boolean z11, boolean z12) {
        StringBuilder sb = new StringBuilder();
        if (z10) {
            sb.append("Dynamic ");
        }
        if (z11) {
            sb.append("Sequence ");
        }
        if (z12) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Bundle[], java.io.Serializable] */
    public static final Serializable B1(com.google.android.gms.internal.measurement.e3 e3Var) {
        if (e3Var.r()) {
            return e3Var.s();
        }
        if (e3Var.t()) {
            return Long.valueOf(e3Var.u());
        }
        if (e3Var.x()) {
            return Double.valueOf(e3Var.y());
        }
        if (e3Var.A() > 0) {
            return b2((o5) e3Var.z());
        }
        return null;
    }

    public static final void C1(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                z1(builder, str3, string, set);
            }
        }
    }

    public static final void D1(StringBuilder sb, String str, com.google.android.gms.internal.measurement.m3 m3Var) {
        if (m3Var == null) {
            return;
        }
        y1(3, sb);
        sb.append(str);
        sb.append(" {\n");
        if (m3Var.s() != 0) {
            y1(4, sb);
            sb.append("results: ");
            int i = 0;
            for (Long l10 : m3Var.r()) {
                int i10 = i + 1;
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(l10);
                i = i10;
            }
            sb.append('\n');
        }
        if (m3Var.q() != 0) {
            y1(4, sb);
            sb.append("status: ");
            int i11 = 0;
            for (Long l11 : m3Var.p()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb.append(", ");
                }
                sb.append(l11);
                i11 = i12;
            }
            sb.append('\n');
        }
        if (m3Var.u() != 0) {
            y1(4, sb);
            sb.append("dynamic_filter_timestamps: {");
            int i13 = 0;
            for (com.google.android.gms.internal.measurement.z2 z2Var : m3Var.t()) {
                int i14 = i13 + 1;
                if (i13 != 0) {
                    sb.append(", ");
                }
                sb.append(z2Var.p() ? Integer.valueOf(z2Var.q()) : null);
                sb.append(":");
                sb.append(z2Var.r() ? Long.valueOf(z2Var.s()) : null);
                i13 = i14;
            }
            sb.append("}\n");
        }
        if (m3Var.w() != 0) {
            y1(4, sb);
            sb.append("sequence_filter_timestamps: {");
            int i15 = 0;
            for (com.google.android.gms.internal.measurement.o3 o3Var : m3Var.v()) {
                int i16 = i15 + 1;
                if (i15 != 0) {
                    sb.append(", ");
                }
                sb.append(o3Var.p() ? Integer.valueOf(o3Var.q()) : null);
                sb.append(": [");
                Iterator it = o3Var.r().iterator();
                int i17 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i18 = i17 + 1;
                    if (i17 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i17 = i18;
                }
                sb.append("]");
                i15 = i16;
            }
            sb.append("}\n");
        }
        y1(3, sb);
        sb.append("}\n");
    }

    public static final void E1(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        y1(i + 1, sb);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public static final void F1(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.t1 t1Var) {
        if (t1Var == null) {
            return;
        }
        y1(i, sb);
        sb.append(str);
        sb.append(" {\n");
        if (t1Var.p()) {
            int iZ = t1Var.z();
            E1(sb, i, "comparison_type", iZ != 1 ? iZ != 2 ? iZ != 3 ? iZ != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (t1Var.q()) {
            E1(sb, i, "match_as_float", Boolean.valueOf(t1Var.r()));
        }
        if (t1Var.s()) {
            E1(sb, i, "comparison_value", t1Var.t());
        }
        if (t1Var.u()) {
            E1(sb, i, "min_comparison_value", t1Var.v());
        }
        if (t1Var.w()) {
            E1(sb, i, "max_comparison_value", t1Var.x());
        }
        y1(i, sb);
        sb.append("}\n");
    }

    public static boolean S1(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean T1(n5 n5Var, int i) {
        if (i < ((v5) n5Var).f2665x * 64) {
            return ((1 << (i % 64)) & ((Long) ((v5) n5Var).get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    public static ArrayList U1(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j4 = 0;
            for (int i10 = 0; i10 < 64; i10++) {
                int i11 = (i * 64) + i10;
                if (i11 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i11)) {
                    j4 |= 1 << i10;
                }
            }
            arrayList.add(Long.valueOf(j4));
        }
        return arrayList;
    }

    public static h5 Z1(h5 h5Var, byte[] bArr) {
        c5 c5VarI;
        c5 c5Var = c5.f2342a;
        if (c5Var == null) {
            synchronized (c5.class) {
                try {
                    c5VarI = c5.f2342a;
                    if (c5VarI == null) {
                        g6 g6Var = g6.f2460c;
                        c5VarI = sd.i.I();
                        c5.f2342a = c5VarI;
                    }
                } finally {
                }
            }
            c5Var = c5VarI;
        }
        if (c5Var != null) {
            h5Var.getClass();
            h5Var.g(bArr, bArr.length, c5Var);
            return h5Var;
        }
        h5Var.getClass();
        int length = bArr.length;
        c5 c5Var2 = c5.f2342a;
        g6 g6Var2 = g6.f2460c;
        h5Var.g(bArr, length, c5.f2343b);
        return h5Var;
    }

    public static int a2(com.google.android.gms.internal.measurement.i3 i3Var, String str) {
        for (int i = 0; i < ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).V1(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).W1(i).r())) {
                return i;
            }
        }
        return -1;
    }

    public static Bundle[] b2(o5 o5Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = o5Var.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.e3 e3Var = (com.google.android.gms.internal.measurement.e3) it.next();
            if (e3Var != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.e3 e3Var2 : e3Var.z()) {
                    if (e3Var2.r()) {
                        bundle.putString(e3Var2.q(), e3Var2.s());
                    } else if (e3Var2.t()) {
                        bundle.putLong(e3Var2.q(), e3Var2.u());
                    } else if (e3Var2.x()) {
                        bundle.putDouble(e3Var2.q(), e3Var2.y());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static HashMap c2(Bundle bundle, boolean z10) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z11 = obj instanceof Parcelable[];
            if (z11 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z10) {
                    ArrayList arrayList = new ArrayList();
                    if (z11) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(c2((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i = 0; i < size; i++) {
                            Object obj2 = arrayList2.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(c2((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(c2((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public static v q1(com.google.android.gms.internal.measurement.b bVar) {
        Object obj;
        Bundle bundleR1 = r1(bVar.f2325c, true);
        String string = (!bundleR1.containsKey("_o") || (obj = bundleR1.get("_o")) == null) ? "app" : obj.toString();
        String strG = h2.g(bVar.f2323a, h2.f4204a, h2.f4206c);
        if (strG == null) {
            strG = bVar.f2323a;
        }
        return new v(strG, new u(bundleR1), string, bVar.f2324b);
    }

    public static Bundle r1(Map map, boolean z10) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z10) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(r1((Map) arrayList.get(i), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public static final void s1(com.google.android.gms.internal.measurement.a3 a3Var, String str, Long l10) {
        List listH = a3Var.h();
        int i = 0;
        while (true) {
            if (i >= listH.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.e3) listH.get(i)).q())) {
                break;
            } else {
                i++;
            }
        }
        com.google.android.gms.internal.measurement.d3 d3VarB = com.google.android.gms.internal.measurement.e3.B();
        d3VarB.h(str);
        d3VarB.j(l10.longValue());
        if (i < 0) {
            a3Var.l(d3VarB);
        } else {
            a3Var.b();
            ((com.google.android.gms.internal.measurement.b3) a3Var.f2470w).A(i, (com.google.android.gms.internal.measurement.e3) d3VarB.e());
        }
    }

    public static final Bundle t1(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.e3 e3Var = (com.google.android.gms.internal.measurement.e3) it.next();
            String strQ = e3Var.q();
            if (e3Var.x()) {
                bundle.putDouble(strQ, e3Var.y());
            } else if (e3Var.v()) {
                bundle.putFloat(strQ, e3Var.w());
            } else if (e3Var.r()) {
                bundle.putString(strQ, e3Var.s());
            } else if (e3Var.t()) {
                bundle.putLong(strQ, e3Var.u());
            }
        }
        return bundle;
    }

    public static final com.google.android.gms.internal.measurement.e3 u1(com.google.android.gms.internal.measurement.b3 b3Var, String str) {
        for (com.google.android.gms.internal.measurement.e3 e3Var : b3Var.p()) {
            if (e3Var.q().equals(str)) {
                return e3Var;
            }
        }
        return null;
    }

    public static final Serializable v1(com.google.android.gms.internal.measurement.b3 b3Var, String str) {
        com.google.android.gms.internal.measurement.e3 e3VarU1 = u1(b3Var, str);
        if (e3VarU1 == null) {
            return null;
        }
        return B1(e3VarU1);
    }

    public static final void y1(int i, StringBuilder sb) {
        for (int i10 = 0; i10 < i; i10++) {
            sb.append("  ");
        }
    }

    public static final void z1(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public boolean G1() {
        n1();
        ConnectivityManager connectivityManager = (ConnectivityManager) ((r1) this.f307w).f4363v.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void K1(com.google.android.gms.internal.measurement.r3 r3Var, Object obj) {
        o8.u.g(obj);
        r3Var.b();
        ((com.google.android.gms.internal.measurement.s3) r3Var.f2470w).E();
        r3Var.b();
        ((com.google.android.gms.internal.measurement.s3) r3Var.f2470w).G();
        r3Var.b();
        ((com.google.android.gms.internal.measurement.s3) r3Var.f2470w).I();
        if (obj instanceof String) {
            r3Var.b();
            ((com.google.android.gms.internal.measurement.s3) r3Var.f2470w).D((String) obj);
        } else if (obj instanceof Long) {
            long jLongValue = ((Long) obj).longValue();
            r3Var.b();
            ((com.google.android.gms.internal.measurement.s3) r3Var.f2470w).F(jLongValue);
        } else if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            r3Var.b();
            ((com.google.android.gms.internal.measurement.s3) r3Var.f2470w).H(dDoubleValue);
        } else {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.B.b(obj, "Ignoring invalid (type) user attribute value");
        }
    }

    public void L1(String str, m4 m4Var, com.google.android.gms.internal.measurement.h3 h3Var, y0 y0Var) {
        String str2;
        URL url;
        byte[] bArrA;
        p1 p1Var;
        Map map;
        String str3 = m4Var.f4274a;
        r1 r1Var = (r1) this.f307w;
        m1();
        n1();
        try {
            url = new URI(str3).toURL();
            this.f4215x.g0();
            bArrA = h3Var.a();
            p1Var = r1Var.B;
            r1.g(p1Var);
            map = m4Var.f4275b;
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            str2 = str;
        }
        try {
            p1Var.y1(new z0(this, str2, url, bArrA, map, y0Var));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.c(w0.u1(str2), str3, "Failed to parse URL. Not uploading MeasurementBatch. appId");
        }
    }

    public void M1(com.google.android.gms.internal.measurement.d3 d3Var, Object obj) {
        d3Var.b();
        ((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).E();
        d3Var.b();
        ((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).G();
        d3Var.b();
        ((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).I();
        d3Var.b();
        ((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).L();
        if (obj instanceof String) {
            d3Var.i((String) obj);
            return;
        }
        if (obj instanceof Long) {
            d3Var.j(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            d3Var.b();
            ((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).H(dDoubleValue);
            return;
        }
        if (!(obj instanceof Bundle[])) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.B.b(obj, "Ignoring invalid (type) event param value");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.d3 d3VarB = com.google.android.gms.internal.measurement.e3.B();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.d3 d3VarB2 = com.google.android.gms.internal.measurement.e3.B();
                    d3VarB2.h(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        d3VarB2.j(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        d3VarB2.i((String) obj2);
                    } else if (obj2 instanceof Double) {
                        double dDoubleValue2 = ((Double) obj2).doubleValue();
                        d3VarB2.b();
                        ((com.google.android.gms.internal.measurement.e3) d3VarB2.f2470w).H(dDoubleValue2);
                    }
                    d3VarB.b();
                    ((com.google.android.gms.internal.measurement.e3) d3VarB.f2470w).J((com.google.android.gms.internal.measurement.e3) d3VarB2.e());
                }
                if (((com.google.android.gms.internal.measurement.e3) d3VarB.f2470w).A() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.e3) d3VarB.e());
                }
            }
        }
        d3Var.b();
        ((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).K(arrayList);
    }

    public f4 N1(String str, com.google.android.gms.internal.measurement.i3 i3Var, com.google.android.gms.internal.measurement.a3 a3Var, String str2) {
        int iIndexOf;
        q8.a();
        r1 r1Var = (r1) this.f307w;
        g gVar = r1Var.f4366y;
        if (!gVar.w1(str, f0.Q0)) {
            return null;
        }
        r1Var.F.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArrSplit = gVar.s1(str, f0.f4159v0).split(",");
        HashSet hashSet = new HashSet(strArrSplit.length);
        for (String str3 : strArrSplit) {
            Objects.requireNonNull(str3);
            if (!hashSet.add(str3)) {
                throw new IllegalArgumentException("duplicate element: " + ((Object) str3));
            }
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        q4 q4Var = this.f4215x;
        n4 n4Var = q4Var.E;
        l1 l1Var = q4Var.f4353v;
        l1 l1Var2 = n4Var.f4215x.f4353v;
        q4.P(l1Var2);
        String strZ1 = l1Var2.z1(str);
        Uri.Builder builder = new Uri.Builder();
        g gVar2 = ((r1) n4Var.f307w).f4366y;
        builder.scheme(gVar2.s1(str, f0.o0));
        if (TextUtils.isEmpty(strZ1)) {
            builder.authority(gVar2.s1(str, f0.f4147p0));
        } else {
            String strS1 = gVar2.s1(str, f0.f4147p0);
            StringBuilder sb = new StringBuilder(String.valueOf(strZ1).length() + 1 + String.valueOf(strS1).length());
            sb.append(strZ1);
            sb.append(".");
            sb.append(strS1);
            builder.authority(sb.toString());
        }
        builder.path(gVar2.s1(str, f0.f4149q0));
        z1(builder, "gmp_app_id", ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).E(), setUnmodifiableSet);
        gVar.r1();
        z1(builder, "gmp_version", String.valueOf(133005L), setUnmodifiableSet);
        String strY = ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).y();
        e0 e0Var = f0.T0;
        if (gVar.w1(str, e0Var)) {
            q4.P(l1Var);
            if (l1Var.F1(str)) {
                strY = "";
            }
        }
        z1(builder, "app_instance_id", strY, setUnmodifiableSet);
        z1(builder, "rdid", ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).v(), setUnmodifiableSet);
        z1(builder, "bundle_id", i3Var.o(), setUnmodifiableSet);
        String strN = a3Var.n();
        String strG = h2.g(strN, h2.f4206c, h2.f4204a);
        if (true != TextUtils.isEmpty(strG)) {
            strN = strG;
        }
        z1(builder, "app_event_name", strN, setUnmodifiableSet);
        z1(builder, "app_version", String.valueOf(((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).K()), setUnmodifiableSet);
        String strI2 = ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).i2();
        if (gVar.w1(str, e0Var)) {
            q4.P(l1Var);
            if (l1Var.E1(str) && !TextUtils.isEmpty(strI2) && (iIndexOf = strI2.indexOf(".")) != -1) {
                strI2 = strI2.substring(0, iIndexOf);
            }
        }
        z1(builder, "os_version", strI2, setUnmodifiableSet);
        z1(builder, "timestamp", String.valueOf(a3Var.o()), setUnmodifiableSet);
        if (((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).x()) {
            z1(builder, "lat", "1", setUnmodifiableSet);
        }
        z1(builder, "privacy_sandbox_version", String.valueOf(((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).G0()), setUnmodifiableSet);
        z1(builder, "trigger_uri_source", "1", setUnmodifiableSet);
        z1(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setUnmodifiableSet);
        z1(builder, "request_uuid", str2, setUnmodifiableSet);
        List<com.google.android.gms.internal.measurement.e3> listH = a3Var.h();
        Bundle bundle = new Bundle();
        for (com.google.android.gms.internal.measurement.e3 e3Var : listH) {
            String strQ = e3Var.q();
            if (e3Var.x()) {
                bundle.putString(strQ, String.valueOf(e3Var.y()));
            } else if (e3Var.v()) {
                bundle.putString(strQ, String.valueOf(e3Var.w()));
            } else if (e3Var.r()) {
                bundle.putString(strQ, e3Var.s());
            } else if (e3Var.t()) {
                bundle.putString(strQ, String.valueOf(e3Var.u()));
            }
        }
        C1(builder, gVar.s1(str, f0.f4157u0).split("\\|"), bundle, setUnmodifiableSet);
        List<com.google.android.gms.internal.measurement.s3> listUnmodifiableList = Collections.unmodifiableList(((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).U1());
        Bundle bundle2 = new Bundle();
        for (com.google.android.gms.internal.measurement.s3 s3Var : listUnmodifiableList) {
            String strR = s3Var.r();
            if (s3Var.y()) {
                bundle2.putString(strR, String.valueOf(s3Var.z()));
            } else if (s3Var.w()) {
                bundle2.putString(strR, String.valueOf(s3Var.x()));
            } else if (s3Var.s()) {
                bundle2.putString(strR, s3Var.t());
            } else if (s3Var.u()) {
                bundle2.putString(strR, String.valueOf(s3Var.v()));
            }
        }
        C1(builder, gVar.s1(str, f0.f4155t0).split("\\|"), bundle2, setUnmodifiableSet);
        z1(builder, "dma", true != ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).D0() ? "0" : "1", setUnmodifiableSet);
        if (!((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).F0().isEmpty()) {
            z1(builder, "dma_cps", ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).F0(), setUnmodifiableSet);
        }
        if (((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).L0()) {
            com.google.android.gms.internal.measurement.o2 o2VarM0 = ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).M0();
            if (!o2VarM0.z().isEmpty()) {
                z1(builder, "dl_gclid", o2VarM0.z(), setUnmodifiableSet);
            }
            if (!o2VarM0.B().isEmpty()) {
                z1(builder, "dl_gbraid", o2VarM0.B(), setUnmodifiableSet);
            }
            if (!o2VarM0.D().isEmpty()) {
                z1(builder, "dl_gs", o2VarM0.D(), setUnmodifiableSet);
            }
            if (o2VarM0.F() > 0) {
                z1(builder, "dl_ss_ts", String.valueOf(o2VarM0.F()), setUnmodifiableSet);
            }
            if (!o2VarM0.H().isEmpty()) {
                z1(builder, "mr_gclid", o2VarM0.H(), setUnmodifiableSet);
            }
            if (!o2VarM0.J().isEmpty()) {
                z1(builder, "mr_gbraid", o2VarM0.J(), setUnmodifiableSet);
            }
            if (!o2VarM0.L().isEmpty()) {
                z1(builder, "mr_gs", o2VarM0.L(), setUnmodifiableSet);
            }
            if (o2VarM0.N() > 0) {
                z1(builder, "mr_click_ts", String.valueOf(o2VarM0.N()), setUnmodifiableSet);
            }
        }
        return new f4(1, jCurrentTimeMillis, builder.build().toString());
    }

    public com.google.android.gms.internal.measurement.b3 O1(r rVar) {
        com.google.android.gms.internal.measurement.a3 a3VarZ = com.google.android.gms.internal.measurement.b3.z();
        long j4 = rVar.f4360x;
        a3VarZ.b();
        ((com.google.android.gms.internal.measurement.b3) a3VarZ.f2470w).H(j4);
        u uVar = (u) rVar.B;
        Objects.requireNonNull(uVar);
        Bundle bundle = uVar.f4426v;
        for (String str : bundle.keySet()) {
            com.google.android.gms.internal.measurement.d3 d3VarB = com.google.android.gms.internal.measurement.e3.B();
            d3VarB.h(str);
            Object obj = bundle.get(str);
            o8.u.g(obj);
            M1(d3VarB, obj);
            a3VarZ.l(d3VarB);
        }
        String str2 = (String) rVar.A;
        if (!TextUtils.isEmpty(str2) && bundle.get("_o") == null) {
            com.google.android.gms.internal.measurement.d3 d3VarB2 = com.google.android.gms.internal.measurement.e3.B();
            d3VarB2.h("_o");
            d3VarB2.i(str2);
            a3VarZ.k((com.google.android.gms.internal.measurement.e3) d3VarB2.e());
        }
        return (com.google.android.gms.internal.measurement.b3) a3VarZ.e();
    }

    public String P1(com.google.android.gms.internal.measurement.h3 h3Var) {
        com.google.android.gms.internal.measurement.r2 r2VarI0;
        StringBuilder sbB = y.e.b("\nbatch {\n");
        if (h3Var.u()) {
            E1(sbB, 0, "upload_subdomain", h3Var.v());
        }
        if (h3Var.s()) {
            E1(sbB, 0, "sgtm_join_id", h3Var.t());
        }
        for (com.google.android.gms.internal.measurement.j3 j3Var : h3Var.p()) {
            if (j3Var != null) {
                y1(1, sbB);
                sbB.append("bundle {\n");
                if (j3Var.P()) {
                    E1(sbB, 1, "protocol_version", Integer.valueOf(j3Var.P0()));
                }
                r1 r1Var = (r1) this.f307w;
                g gVar = r1Var.f4366y;
                q0 q0Var = r1Var.E;
                if (gVar.w1(j3Var.p(), f0.N0) && j3Var.v0()) {
                    E1(sbB, 1, "session_stitching_token", j3Var.w0());
                }
                E1(sbB, 1, "platform", j3Var.h2());
                if (j3Var.r()) {
                    E1(sbB, 1, "gmp_version", Long.valueOf(j3Var.s()));
                }
                if (j3Var.t()) {
                    E1(sbB, 1, "uploading_gmp_version", Long.valueOf(j3Var.u()));
                }
                if (j3Var.r0()) {
                    E1(sbB, 1, "dynamite_version", Long.valueOf(j3Var.s0()));
                }
                if (j3Var.L()) {
                    E1(sbB, 1, "config_version", Long.valueOf(j3Var.M()));
                }
                E1(sbB, 1, "gmp_app_id", j3Var.E());
                E1(sbB, 1, "app_id", j3Var.p());
                E1(sbB, 1, "app_version", j3Var.q());
                if (j3Var.J()) {
                    E1(sbB, 1, "app_version_major", Integer.valueOf(j3Var.K()));
                }
                E1(sbB, 1, "firebase_instance_id", j3Var.I());
                if (j3Var.z()) {
                    E1(sbB, 1, "dev_cert_hash", Long.valueOf(j3Var.A()));
                }
                E1(sbB, 1, "app_store", j3Var.n2());
                if (j3Var.X1()) {
                    E1(sbB, 1, "upload_timestamp_millis", Long.valueOf(j3Var.Y1()));
                }
                if (j3Var.Z1()) {
                    E1(sbB, 1, "start_timestamp_millis", Long.valueOf(j3Var.a2()));
                }
                if (j3Var.b2()) {
                    E1(sbB, 1, "end_timestamp_millis", Long.valueOf(j3Var.c2()));
                }
                if (j3Var.d2()) {
                    E1(sbB, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(j3Var.e2()));
                }
                if (j3Var.f2()) {
                    E1(sbB, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(j3Var.g2()));
                }
                E1(sbB, 1, "app_instance_id", j3Var.y());
                E1(sbB, 1, "resettable_device_id", j3Var.v());
                E1(sbB, 1, "ds_id", j3Var.O());
                if (j3Var.w()) {
                    E1(sbB, 1, "limited_ad_tracking", Boolean.valueOf(j3Var.x()));
                }
                E1(sbB, 1, "os_version", j3Var.i2());
                E1(sbB, 1, "device_model", j3Var.j2());
                E1(sbB, 1, "user_default_language", j3Var.k2());
                if (j3Var.l2()) {
                    E1(sbB, 1, "time_zone_offset_minutes", Integer.valueOf(j3Var.m2()));
                }
                if (j3Var.B()) {
                    E1(sbB, 1, "bundle_sequential_index", Integer.valueOf(j3Var.C()));
                }
                if (j3Var.J0()) {
                    E1(sbB, 1, "delivery_index", Integer.valueOf(j3Var.K0()));
                }
                if (j3Var.F()) {
                    E1(sbB, 1, "service_upload", Boolean.valueOf(j3Var.G()));
                }
                E1(sbB, 1, "health_monitor", j3Var.D());
                if (j3Var.p0()) {
                    E1(sbB, 1, "retry_counter", Integer.valueOf(j3Var.q0()));
                }
                if (j3Var.t0()) {
                    E1(sbB, 1, "consent_signals", j3Var.u0());
                }
                if (j3Var.C0()) {
                    E1(sbB, 1, "is_dma_region", Boolean.valueOf(j3Var.D0()));
                }
                if (j3Var.E0()) {
                    E1(sbB, 1, "core_platform_services", j3Var.F0());
                }
                if (j3Var.A0()) {
                    E1(sbB, 1, "consent_diagnostics", j3Var.B0());
                }
                if (j3Var.x0()) {
                    E1(sbB, 1, "target_os_version", Long.valueOf(j3Var.y0()));
                }
                q8.a();
                if (r1Var.f4366y.w1(j3Var.p(), f0.Q0)) {
                    E1(sbB, 1, "ad_services_version", Integer.valueOf(j3Var.G0()));
                    if (j3Var.H0() && (r2VarI0 = j3Var.I0()) != null) {
                        y1(2, sbB);
                        sbB.append("attribution_eligibility_status {\n");
                        E1(sbB, 2, "eligible", Boolean.valueOf(r2VarI0.p()));
                        E1(sbB, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(r2VarI0.q()));
                        E1(sbB, 2, "pre_r", Boolean.valueOf(r2VarI0.r()));
                        E1(sbB, 2, "r_extensions_too_old", Boolean.valueOf(r2VarI0.s()));
                        E1(sbB, 2, "adservices_extension_too_old", Boolean.valueOf(r2VarI0.t()));
                        E1(sbB, 2, "ad_storage_not_allowed", Boolean.valueOf(r2VarI0.u()));
                        E1(sbB, 2, "measurement_manager_disabled", Boolean.valueOf(r2VarI0.v()));
                        y1(2, sbB);
                        sbB.append("}\n");
                    }
                }
                if (j3Var.L0()) {
                    com.google.android.gms.internal.measurement.o2 o2VarM0 = j3Var.M0();
                    y1(2, sbB);
                    sbB.append("ad_campaign_info {\n");
                    if (o2VarM0.y()) {
                        E1(sbB, 2, "deep_link_gclid", o2VarM0.z());
                    }
                    if (o2VarM0.A()) {
                        E1(sbB, 2, "deep_link_gbraid", o2VarM0.B());
                    }
                    if (o2VarM0.C()) {
                        E1(sbB, 2, "deep_link_gad_source", o2VarM0.D());
                    }
                    if (o2VarM0.E()) {
                        E1(sbB, 2, "deep_link_session_millis", Long.valueOf(o2VarM0.F()));
                    }
                    if (o2VarM0.G()) {
                        E1(sbB, 2, "market_referrer_gclid", o2VarM0.H());
                    }
                    if (o2VarM0.I()) {
                        E1(sbB, 2, "market_referrer_gbraid", o2VarM0.J());
                    }
                    if (o2VarM0.K()) {
                        E1(sbB, 2, "market_referrer_gad_source", o2VarM0.L());
                    }
                    if (o2VarM0.M()) {
                        E1(sbB, 2, "market_referrer_click_millis", Long.valueOf(o2VarM0.N()));
                    }
                    y1(2, sbB);
                    sbB.append("}\n");
                }
                if (j3Var.Q()) {
                    E1(sbB, 1, "batching_timestamp_millis", Long.valueOf(j3Var.R()));
                }
                if (j3Var.N0()) {
                    com.google.android.gms.internal.measurement.q3 q3VarO0 = j3Var.O0();
                    y1(2, sbB);
                    sbB.append("sgtm_diagnostics {\n");
                    int iT = q3VarO0.t();
                    E1(sbB, 2, "upload_type", iT != 1 ? iT != 2 ? iT != 3 ? iT != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    E1(sbB, 2, "client_upload_eligibility", q4.a.x(q3VarO0.p()));
                    int iU = q3VarO0.u();
                    E1(sbB, 2, "service_upload_eligibility", iU != 1 ? iU != 2 ? iU != 3 ? iU != 4 ? iU != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    y1(2, sbB);
                    sbB.append("}\n");
                }
                if (j3Var.S()) {
                    com.google.android.gms.internal.measurement.x2 x2VarT = j3Var.T();
                    y1(2, sbB);
                    sbB.append("consent_info_extra {\n");
                    for (com.google.android.gms.internal.measurement.w2 w2Var : x2VarT.p()) {
                        y1(3, sbB);
                        sbB.append("limited_data_modes {\n");
                        int iQ = w2Var.q();
                        E1(sbB, 3, "type", iQ != 1 ? iQ != 2 ? iQ != 3 ? iQ != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE" : "CONSENT_TYPE_UNSPECIFIED");
                        int iR = w2Var.r();
                        E1(sbB, 3, "mode", iR != 1 ? iR != 2 ? "NO_DATA_MODE" : "LIMITED_MODE" : "NOT_LIMITED");
                        y1(3, sbB);
                        sbB.append("}\n");
                    }
                    y1(2, sbB);
                    sbB.append("}\n");
                }
                o5<com.google.android.gms.internal.measurement.s3> o5VarU1 = j3Var.U1();
                if (o5VarU1 != null) {
                    for (com.google.android.gms.internal.measurement.s3 s3Var : o5VarU1) {
                        if (s3Var != null) {
                            y1(2, sbB);
                            sbB.append("user_property {\n");
                            E1(sbB, 2, "set_timestamp_millis", s3Var.p() ? Long.valueOf(s3Var.q()) : null);
                            E1(sbB, 2, "name", q0Var.c(s3Var.r()));
                            E1(sbB, 2, "string_value", s3Var.t());
                            E1(sbB, 2, "int_value", s3Var.u() ? Long.valueOf(s3Var.v()) : null);
                            E1(sbB, 2, "double_value", s3Var.y() ? Double.valueOf(s3Var.z()) : null);
                            y1(2, sbB);
                            sbB.append("}\n");
                        }
                    }
                }
                o5<com.google.android.gms.internal.measurement.t2> o5VarH = j3Var.H();
                if (o5VarH != null) {
                    for (com.google.android.gms.internal.measurement.t2 t2Var : o5VarH) {
                        if (t2Var != null) {
                            y1(2, sbB);
                            sbB.append("audience_membership {\n");
                            if (t2Var.p()) {
                                E1(sbB, 2, "audience_id", Integer.valueOf(t2Var.q()));
                            }
                            if (t2Var.u()) {
                                E1(sbB, 2, "new_audience", Boolean.valueOf(t2Var.v()));
                            }
                            D1(sbB, "current_data", t2Var.r());
                            if (t2Var.s()) {
                                D1(sbB, "previous_data", t2Var.t());
                            }
                            y1(2, sbB);
                            sbB.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.b3> listP1 = j3Var.P1();
                if (listP1 != null) {
                    for (com.google.android.gms.internal.measurement.b3 b3Var : listP1) {
                        if (b3Var != null) {
                            y1(2, sbB);
                            sbB.append("event {\n");
                            E1(sbB, 2, "name", q0Var.a(b3Var.s()));
                            if (b3Var.t()) {
                                E1(sbB, 2, "timestamp_millis", Long.valueOf(b3Var.u()));
                            }
                            if (b3Var.v()) {
                                E1(sbB, 2, "previous_timestamp_millis", Long.valueOf(b3Var.w()));
                            }
                            if (b3Var.x()) {
                                E1(sbB, 2, "count", Integer.valueOf(b3Var.y()));
                            }
                            if (b3Var.q() != 0) {
                                w1(sbB, 2, (o5) b3Var.p());
                            }
                            y1(2, sbB);
                            sbB.append("}\n");
                        }
                    }
                }
                y1(1, sbB);
                sbB.append("}\n");
            }
        }
        sbB.append("} // End-of-batch\n");
        return sbB.toString();
    }

    public String Q1(com.google.android.gms.internal.measurement.v1 v1Var) {
        StringBuilder sbB = y.e.b("\nproperty_filter {\n");
        if (v1Var.p()) {
            E1(sbB, 0, "filter_id", Integer.valueOf(v1Var.q()));
        }
        E1(sbB, 0, "property_name", ((r1) this.f307w).E.c(v1Var.r()));
        String strA1 = A1(v1Var.t(), v1Var.u(), v1Var.w());
        if (!strA1.isEmpty()) {
            E1(sbB, 0, "filter_type", strA1);
        }
        x1(sbB, 1, v1Var.s());
        sbB.append("}\n");
        return sbB.toString();
    }

    public Parcelable R1(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(parcelObtain);
            } catch (p8.b unused) {
                w0 w0Var = ((r1) this.f307w).A;
                r1.g(w0Var);
                w0Var.B.a("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            parcelObtain.recycle();
        }
    }

    public List V1(n5 n5Var, List list) {
        int i;
        r1 r1Var = (r1) this.f307w;
        ArrayList arrayList = new ArrayList(n5Var);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                w0Var.E.b(num, "Ignoring negative bit index to be cleared");
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    w0 w0Var2 = r1Var.A;
                    r1.g(w0Var2);
                    w0Var2.E.c(num, Integer.valueOf(arrayList.size()), "Ignoring bit index greater than bitSet size");
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i10 = size2;
            i = size;
            size = i10;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    public boolean W1(long j4, long j7) {
        if (j4 == 0 || j7 <= 0) {
            return true;
        }
        ((r1) this.f307w).F.getClass();
        return Math.abs(System.currentTimeMillis() - j4) > j7;
    }

    public long X1(byte[] bArr) {
        o8.u.g(bArr);
        r1 r1Var = (r1) this.f307w;
        u4 u4Var = r1Var.D;
        r1.e(u4Var);
        u4Var.m1();
        MessageDigest messageDigestD1 = u4.D1();
        if (messageDigestD1 != null) {
            return u4.E1(messageDigestD1.digest(bArr));
        }
        w0 w0Var = r1Var.A;
        r1.g(w0Var);
        w0Var.B.a("Failed to get MD5");
        return 0L;
    }

    public byte[] Y1(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.B.b(e9, "Failed to gzip content");
            throw e9;
        }
    }

    @Override // f9.l4
    public final void p1() {
        int i = this.f4000z;
    }

    public void w1(StringBuilder sb, int i, o5 o5Var) {
        if (o5Var == null) {
            return;
        }
        int i10 = i + 1;
        Iterator it = o5Var.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.e3 e3Var = (com.google.android.gms.internal.measurement.e3) it.next();
            if (e3Var != null) {
                y1(i10, sb);
                sb.append("param {\n");
                E1(sb, i10, "name", e3Var.p() ? ((r1) this.f307w).E.b(e3Var.q()) : null);
                E1(sb, i10, "string_value", e3Var.r() ? e3Var.s() : null);
                E1(sb, i10, "int_value", e3Var.t() ? Long.valueOf(e3Var.u()) : null);
                E1(sb, i10, "double_value", e3Var.x() ? Double.valueOf(e3Var.y()) : null);
                if (e3Var.A() > 0) {
                    w1(sb, i10, (o5) e3Var.z());
                }
                y1(i10, sb);
                sb.append("}\n");
            }
        }
    }

    public void x1(StringBuilder sb, int i, com.google.android.gms.internal.measurement.q1 q1Var) {
        String str;
        if (q1Var == null) {
            return;
        }
        y1(i, sb);
        sb.append("filter {\n");
        if (q1Var.t()) {
            E1(sb, i, "complement", Boolean.valueOf(q1Var.u()));
        }
        if (q1Var.v()) {
            E1(sb, i, "param_name", ((r1) this.f307w).E.b(q1Var.w()));
        }
        if (q1Var.p()) {
            int i10 = i + 1;
            com.google.android.gms.internal.measurement.w1 w1VarQ = q1Var.q();
            if (w1VarQ != null) {
                y1(i10, sb);
                sb.append("string_filter {\n");
                if (w1VarQ.p()) {
                    switch (w1VarQ.x()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            str = "ENDS_WITH";
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            str = "PARTIAL";
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    E1(sb, i10, "match_type", str);
                }
                if (w1VarQ.q()) {
                    E1(sb, i10, "expression", w1VarQ.r());
                }
                if (w1VarQ.s()) {
                    E1(sb, i10, "case_sensitive", Boolean.valueOf(w1VarQ.t()));
                }
                if (w1VarQ.v() > 0) {
                    y1(i + 2, sb);
                    sb.append("expression_list {\n");
                    for (String str2 : w1VarQ.u()) {
                        y1(i + 3, sb);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                y1(i10, sb);
                sb.append("}\n");
            }
        }
        if (q1Var.r()) {
            F1(sb, i + 1, "number_filter", q1Var.s());
        }
        y1(i, sb);
        sb.append("}\n");
    }

    private final void H1() {
    }

    private final void I1() {
    }

    private final void J1() {
    }
}
