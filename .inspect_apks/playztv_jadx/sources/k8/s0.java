package k8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.d5;
import com.google.android.gms.internal.measurement.e9;
import com.google.android.gms.internal.measurement.f9;
import com.google.android.gms.internal.measurement.g5;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.l9;
import com.google.android.gms.internal.measurement.m8;
import com.google.android.gms.internal.measurement.o4;
import com.google.android.gms.internal.measurement.o5;
import com.google.android.gms.internal.measurement.r5;
import com.google.android.gms.internal.measurement.s5;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
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
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s0 extends t3 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f7416y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s0(x3 x3Var, int i) {
        super(x3Var);
        this.f7416y = i;
    }

    public static com.google.android.gms.internal.measurement.i3 C1(com.google.android.gms.internal.measurement.f3 f3Var, String str) {
        for (com.google.android.gms.internal.measurement.i3 i3Var : f3Var.C()) {
            if (i3Var.C().equals(str)) {
                return i3Var;
            }
        }
        return null;
    }

    public static i5 D1(i5 i5Var, byte[] bArr) throws r5 {
        d5 d5VarH;
        d5 d5Var = d5.f2935a;
        if (d5Var == null) {
            synchronized (d5.class) {
                try {
                    d5VarH = d5.f2935a;
                    if (d5VarH == null) {
                        d5VarH = g5.h();
                        d5.f2935a = d5VarH;
                    }
                } finally {
                }
            }
            d5Var = d5VarH;
        }
        if (d5Var != null) {
            i5Var.getClass();
            i5Var.f(bArr, bArr.length, d5Var);
            return i5Var;
        }
        i5Var.getClass();
        i5Var.f(bArr, bArr.length, d5.f2936b);
        return i5Var;
    }

    public static String F1(boolean z2, boolean z10, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        if (z2) {
            sb2.append("Dynamic ");
        }
        if (z10) {
            sb2.append("Sequence ");
        }
        if (z11) {
            sb2.append("Session-Scoped ");
        }
        return sb2.toString();
    }

    public static ArrayList G1(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j5 = 0;
            for (int i10 = 0; i10 < 64; i10++) {
                int i11 = (i << 6) + i10;
                if (i11 < bitSet.length()) {
                    if (bitSet.get(i11)) {
                        j5 |= 1 << i10;
                    }
                }
            }
            arrayList.add(Long.valueOf(j5));
        }
        return arrayList;
    }

    public static HashMap H1(Bundle bundle, boolean z2) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z10 = obj instanceof Parcelable[];
            if (z10 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z2) {
                    ArrayList arrayList = new ArrayList();
                    if (z10) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(H1((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i = 0;
                        while (i < size) {
                            Object obj2 = arrayList2.get(i);
                            i++;
                            if (obj2 instanceof Bundle) {
                                arrayList.add(H1((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(H1((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public static v J1(com.google.android.gms.internal.measurement.c cVar) {
        Object obj;
        Bundle bundleZ1 = z1(cVar.f2910c, true);
        String string = (!bundleZ1.containsKey("_o") || (obj = bundleZ1.get("_o")) == null) ? "app" : obj.toString();
        String strC = c2.c(cVar.f2908a, c2.f7110a, c2.f7112c);
        if (strC == null) {
            strC = cVar.f2908a;
        }
        return new v(strC, new u(bundleZ1), string, cVar.f2909b);
    }

    public static void L1(int i, StringBuilder sb2) {
        for (int i10 = 0; i10 < i; i10++) {
            sb2.append("  ");
        }
    }

    public static void M1(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public static void N1(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                M1(builder, str3, string, set);
            }
        }
    }

    public static void O1(com.google.android.gms.internal.measurement.e3 e3Var, String str, Long l10) {
        List listM = e3Var.m();
        int i = 0;
        while (true) {
            if (i >= listM.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.i3) listM.get(i)).C())) {
                break;
            } else {
                i++;
            }
        }
        com.google.android.gms.internal.measurement.h3 h3VarB = com.google.android.gms.internal.measurement.i3.B();
        h3VarB.h(str);
        if (l4.a.v(l10)) {
            h3VarB.g(l10.longValue());
        }
        if (i < 0) {
            e3Var.g(h3VarB);
        } else {
            e3Var.e();
            com.google.android.gms.internal.measurement.f3.s((com.google.android.gms.internal.measurement.f3) e3Var.f3052v, i, (com.google.android.gms.internal.measurement.i3) h3VarB.c());
        }
    }

    public static void U1(StringBuilder sb2, int i, String str, com.google.android.gms.internal.measurement.a2 a2Var) {
        String str2;
        if (a2Var == null) {
            return;
        }
        L1(i, sb2);
        sb2.append(str);
        sb2.append(" {\n");
        if (a2Var.t()) {
            int iN = a2Var.n();
            if (iN == 1) {
                str2 = "UNKNOWN_COMPARISON_TYPE";
            } else if (iN == 2) {
                str2 = "LESS_THAN";
            } else if (iN == 3) {
                str2 = "GREATER_THAN";
            } else if (iN == 4) {
                str2 = "EQUAL";
            } else {
                if (iN != 5) {
                    throw null;
                }
                str2 = "BETWEEN";
            }
            V1(sb2, i, "comparison_type", str2);
        }
        if (a2Var.v()) {
            V1(sb2, i, "match_as_float", Boolean.valueOf(a2Var.s()));
        }
        if (a2Var.u()) {
            V1(sb2, i, "comparison_value", a2Var.p());
        }
        if (a2Var.x()) {
            V1(sb2, i, "min_comparison_value", a2Var.r());
        }
        if (a2Var.w()) {
            V1(sb2, i, "max_comparison_value", a2Var.q());
        }
        L1(i, sb2);
        sb2.append("}\n");
    }

    public static void V1(StringBuilder sb2, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        L1(i + 1, sb2);
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj);
        sb2.append('\n');
    }

    public static void W1(StringBuilder sb2, String str, com.google.android.gms.internal.measurement.q3 q3Var) {
        if (q3Var == null) {
            return;
        }
        L1(3, sb2);
        sb2.append(str);
        sb2.append(" {\n");
        if (q3Var.q() != 0) {
            L1(4, sb2);
            sb2.append("results: ");
            int i = 0;
            for (Long l10 : q3Var.C()) {
                int i10 = i + 1;
                if (i != 0) {
                    sb2.append(", ");
                }
                sb2.append(l10);
                i = i10;
            }
            sb2.append('\n');
        }
        if (q3Var.w() != 0) {
            L1(4, sb2);
            sb2.append("status: ");
            int i11 = 0;
            for (Long l11 : q3Var.E()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l11);
                i11 = i12;
            }
            sb2.append('\n');
        }
        if (q3Var.n() != 0) {
            L1(4, sb2);
            sb2.append("dynamic_filter_timestamps: {");
            int i13 = 0;
            for (com.google.android.gms.internal.measurement.d3 d3Var : q3Var.B()) {
                int i14 = i13 + 1;
                if (i13 != 0) {
                    sb2.append(", ");
                }
                sb2.append(d3Var.t() ? Integer.valueOf(d3Var.n()) : null);
                sb2.append(":");
                sb2.append(d3Var.s() ? Long.valueOf(d3Var.q()) : null);
                i13 = i14;
            }
            sb2.append("}\n");
        }
        if (q3Var.t() != 0) {
            L1(4, sb2);
            sb2.append("sequence_filter_timestamps: {");
            int i15 = 0;
            for (com.google.android.gms.internal.measurement.s3 s3Var : q3Var.D()) {
                int i16 = i15 + 1;
                if (i15 != 0) {
                    sb2.append(", ");
                }
                sb2.append(s3Var.u() ? Integer.valueOf(s3Var.r()) : null);
                sb2.append(": [");
                Iterator it = s3Var.t().iterator();
                int i17 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i18 = i17 + 1;
                    if (i17 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(jLongValue);
                    i17 = i18;
                }
                sb2.append("]");
                i15 = i16;
            }
            sb2.append("}\n");
        }
        L1(3, sb2);
        sb2.append("}\n");
    }

    public static boolean Y1(o5 o5Var, int i) {
        if (i < (o5Var.size() << 6)) {
            return ((1 << (i % 64)) & ((Long) o5Var.get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    public static byte[] Z1(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [android.os.Bundle[], java.io.Serializable] */
    public static Serializable a2(com.google.android.gms.internal.measurement.f3 f3Var, String str) {
        com.google.android.gms.internal.measurement.i3 i3VarC1 = C1(f3Var, str);
        if (i3VarC1 == null) {
            return null;
        }
        if (i3VarC1.J()) {
            return i3VarC1.D();
        }
        if (i3VarC1.H()) {
            return Long.valueOf(i3VarC1.z());
        }
        if (i3VarC1.F()) {
            return Double.valueOf(i3VarC1.n());
        }
        if (i3VarC1.x() > 0) {
            return d2((s5) i3VarC1.E());
        }
        return null;
    }

    public static boolean b2(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static Bundle[] d2(s5 s5Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = s5Var.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.i3 i3Var = (com.google.android.gms.internal.measurement.i3) it.next();
            if (i3Var != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.i3 i3Var2 : i3Var.E()) {
                    if (i3Var2.J()) {
                        bundle.putString(i3Var2.C(), i3Var2.D());
                    } else if (i3Var2.H()) {
                        bundle.putLong(i3Var2.C(), i3Var2.z());
                    } else if (i3Var2.F()) {
                        bundle.putDouble(i3Var2.C(), i3Var2.n());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static int w1(com.google.android.gms.internal.measurement.m3 m3Var, String str) {
        for (int i = 0; i < ((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).r1(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).c0(i).A())) {
                return i;
            }
        }
        return -1;
    }

    public static Bundle y1(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.i3 i3Var = (com.google.android.gms.internal.measurement.i3) it.next();
            String strC = i3Var.C();
            if (i3Var.F()) {
                bundle.putDouble(strC, i3Var.n());
            } else if (i3Var.G()) {
                bundle.putFloat(strC, i3Var.u());
            } else if (i3Var.J()) {
                bundle.putString(strC, i3Var.D());
            } else if (i3Var.H()) {
                bundle.putLong(strC, i3Var.z());
            }
        }
        return bundle;
    }

    public static Bundle z1(Map map, boolean z2) {
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
            } else if (z2) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    arrayList2.add(z1((Map) obj2, false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public Parcelable A1(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(parcelObtain);
        } catch (u7.b unused) {
            g().A.d("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public com.google.android.gms.internal.measurement.f3 B1(d2.i iVar) {
        com.google.android.gms.internal.measurement.e3 e3VarA = com.google.android.gms.internal.measurement.f3.A();
        long j5 = iVar.f3730c;
        String str = (String) iVar.f;
        e3VarA.e();
        com.google.android.gms.internal.measurement.f3.q(j5, (com.google.android.gms.internal.measurement.f3) e3VarA.f3052v);
        u uVar = (u) iVar.f3733g;
        uVar.getClass();
        Bundle bundle = uVar.f7434u;
        for (String str2 : bundle.keySet()) {
            com.google.android.gms.internal.measurement.h3 h3VarB = com.google.android.gms.internal.measurement.i3.B();
            h3VarB.h(str2);
            Object obj = bundle.get(str2);
            t7.v.h(obj);
            P1(h3VarB, obj);
            e3VarA.g(h3VarB);
        }
        if (((k1) this.f2454v).A.A1(null, w.f7486i1) && !TextUtils.isEmpty(str) && bundle.get("_o") == null) {
            com.google.android.gms.internal.measurement.h3 h3VarB2 = com.google.android.gms.internal.measurement.i3.B();
            h3VarB2.h("_o");
            h3VarB2.i(str);
            e3VarA.h((com.google.android.gms.internal.measurement.i3) h3VarB2.c());
        }
        return (com.google.android.gms.internal.measurement.f3) e3VarA.c();
    }

    public String E1(com.google.android.gms.internal.measurement.l3 l3Var) {
        com.google.android.gms.internal.measurement.z2 z2VarZ1;
        k1 k1Var = (k1) this.f2454v;
        if (l3Var == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nbatch {\n");
        l9.a();
        e eVar = k1Var.A;
        l0 l0Var = k1Var.G;
        e eVar2 = k1Var.A;
        if (eVar.A1(null, w.f7518x0) && l3Var.n() > 0) {
            o1();
            if (h4.s2(l3Var.p().c2())) {
                if (l3Var.A()) {
                    V1(sb2, 0, "upload_subdomain", l3Var.x());
                }
                if (l3Var.z()) {
                    V1(sb2, 0, "sgtm_join_id", l3Var.w());
                }
            }
        }
        for (com.google.android.gms.internal.measurement.n3 n3Var : l3Var.y()) {
            if (n3Var != null) {
                L1(1, sb2);
                sb2.append("bundle {\n");
                if (n3Var.y0()) {
                    V1(sb2, 1, "protocol_version", Integer.valueOf(n3Var.c1()));
                }
                f9.f2975v.get();
                if (eVar2.A1(n3Var.c2(), w.f7516w0) && n3Var.B0()) {
                    V1(sb2, 1, "session_stitching_token", n3Var.P());
                }
                V1(sb2, 1, "platform", n3Var.N());
                if (n3Var.t0()) {
                    V1(sb2, 1, "gmp_version", Long.valueOf(n3Var.L1()));
                }
                if (n3Var.G0()) {
                    V1(sb2, 1, "uploading_gmp_version", Long.valueOf(n3Var.X1()));
                }
                if (n3Var.r0()) {
                    V1(sb2, 1, "dynamite_version", Long.valueOf(n3Var.E1()));
                }
                if (n3Var.k0()) {
                    V1(sb2, 1, "config_version", Long.valueOf(n3Var.w1()));
                }
                V1(sb2, 1, "gmp_app_id", n3Var.K());
                V1(sb2, 1, "admob_app_id", n3Var.b2());
                V1(sb2, 1, "app_id", n3Var.c2());
                V1(sb2, 1, "app_version", n3Var.D());
                if (n3Var.Z()) {
                    V1(sb2, 1, "app_version_major", Integer.valueOf(n3Var.b0()));
                }
                V1(sb2, 1, "firebase_instance_id", n3Var.J());
                if (n3Var.p0()) {
                    V1(sb2, 1, "dev_cert_hash", Long.valueOf(n3Var.A1()));
                }
                V1(sb2, 1, "app_store", n3Var.C());
                if (n3Var.F0()) {
                    V1(sb2, 1, "upload_timestamp_millis", Long.valueOf(n3Var.V1()));
                }
                if (n3Var.C0()) {
                    V1(sb2, 1, "start_timestamp_millis", Long.valueOf(n3Var.R1()));
                }
                if (n3Var.s0()) {
                    V1(sb2, 1, "end_timestamp_millis", Long.valueOf(n3Var.I1()));
                }
                if (n3Var.x0()) {
                    V1(sb2, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(n3Var.P1()));
                }
                if (n3Var.w0()) {
                    V1(sb2, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(n3Var.N1()));
                }
                V1(sb2, 1, "app_instance_id", n3Var.B());
                V1(sb2, 1, "resettable_device_id", n3Var.O());
                V1(sb2, 1, "ds_id", n3Var.I());
                if (n3Var.v0()) {
                    V1(sb2, 1, "limited_ad_tracking", Boolean.valueOf(n3Var.W()));
                }
                V1(sb2, 1, "os_version", n3Var.M());
                V1(sb2, 1, "device_model", n3Var.H());
                V1(sb2, 1, "user_default_language", n3Var.Q());
                if (n3Var.E0()) {
                    V1(sb2, 1, "time_zone_offset_minutes", Integer.valueOf(n3Var.m1()));
                }
                if (n3Var.j0()) {
                    V1(sb2, 1, "bundle_sequential_index", Integer.valueOf(n3Var.H0()));
                }
                l9.a();
                o1();
                if (h4.s2(n3Var.c2()) && eVar2.A1(null, w.f7518x0) && n3Var.o0()) {
                    V1(sb2, 1, "delivery_index", Integer.valueOf(n3Var.Q0()));
                }
                if (n3Var.A0()) {
                    V1(sb2, 1, "service_upload", Boolean.valueOf(n3Var.X()));
                }
                V1(sb2, 1, "health_monitor", n3Var.L());
                if (n3Var.z0()) {
                    V1(sb2, 1, "retry_counter", Integer.valueOf(n3Var.h1()));
                }
                if (n3Var.m0()) {
                    V1(sb2, 1, "consent_signals", n3Var.F());
                }
                if (n3Var.u0()) {
                    V1(sb2, 1, "is_dma_region", Boolean.valueOf(n3Var.V()));
                }
                if (n3Var.n0()) {
                    V1(sb2, 1, "core_platform_services", n3Var.G());
                }
                if (n3Var.l0()) {
                    V1(sb2, 1, "consent_diagnostics", n3Var.E());
                }
                if (n3Var.D0()) {
                    V1(sb2, 1, "target_os_version", Long.valueOf(n3Var.T1()));
                }
                e9.a();
                if (eVar2.A1(n3Var.c2(), w.H0)) {
                    V1(sb2, 1, "ad_services_version", Integer.valueOf(n3Var.n()));
                    if (n3Var.a0() && (z2VarZ1 = n3Var.Z1()) != null) {
                        L1(2, sb2);
                        sb2.append("attribution_eligibility_status {\n");
                        V1(sb2, 2, "eligible", Boolean.valueOf(z2VarZ1.x()));
                        V1(sb2, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(z2VarZ1.A()));
                        V1(sb2, 2, "pre_r", Boolean.valueOf(z2VarZ1.B()));
                        V1(sb2, 2, "r_extensions_too_old", Boolean.valueOf(z2VarZ1.C()));
                        V1(sb2, 2, "adservices_extension_too_old", Boolean.valueOf(z2VarZ1.v()));
                        V1(sb2, 2, "ad_storage_not_allowed", Boolean.valueOf(z2VarZ1.t()));
                        V1(sb2, 2, "measurement_manager_disabled", Boolean.valueOf(z2VarZ1.z()));
                        L1(2, sb2);
                        sb2.append("}\n");
                    }
                }
                m8.a();
                if (eVar2.A1(null, w.U0) && n3Var.Y()) {
                    com.google.android.gms.internal.measurement.w2 w2VarY1 = n3Var.Y1();
                    L1(2, sb2);
                    sb2.append("ad_campaign_info {\n");
                    if (w2VarY1.N()) {
                        V1(sb2, 2, "deep_link_gclid", w2VarY1.H());
                    }
                    if (w2VarY1.M()) {
                        V1(sb2, 2, "deep_link_gbraid", w2VarY1.G());
                    }
                    if (w2VarY1.L()) {
                        V1(sb2, 2, "deep_link_gad_source", w2VarY1.D());
                    }
                    if (w2VarY1.O()) {
                        V1(sb2, 2, "deep_link_session_millis", Long.valueOf(w2VarY1.n()));
                    }
                    if (w2VarY1.S()) {
                        V1(sb2, 2, "market_referrer_gclid", w2VarY1.K());
                    }
                    if (w2VarY1.R()) {
                        V1(sb2, 2, "market_referrer_gbraid", w2VarY1.J());
                    }
                    if (w2VarY1.Q()) {
                        V1(sb2, 2, "market_referrer_gad_source", w2VarY1.I());
                    }
                    if (w2VarY1.P()) {
                        V1(sb2, 2, "market_referrer_click_millis", Long.valueOf(w2VarY1.r()));
                    }
                    L1(2, sb2);
                    sb2.append("}\n");
                }
                s5<com.google.android.gms.internal.measurement.u3> s5VarT = n3Var.T();
                if (s5VarT != null) {
                    for (com.google.android.gms.internal.measurement.u3 u3Var : s5VarT) {
                        if (u3Var != null) {
                            L1(2, sb2);
                            sb2.append("user_property {\n");
                            V1(sb2, 2, "set_timestamp_millis", u3Var.F() ? Long.valueOf(u3Var.y()) : null);
                            V1(sb2, 2, "name", l0Var.g(u3Var.A()));
                            V1(sb2, 2, "string_value", u3Var.B());
                            V1(sb2, 2, "int_value", u3Var.E() ? Long.valueOf(u3Var.w()) : null);
                            V1(sb2, 2, "double_value", u3Var.C() ? Double.valueOf(u3Var.n()) : null);
                            L1(2, sb2);
                            sb2.append("}\n");
                        }
                    }
                }
                s5<com.google.android.gms.internal.measurement.b3> s5VarR = n3Var.R();
                if (s5VarR != null) {
                    for (com.google.android.gms.internal.measurement.b3 b3Var : s5VarR) {
                        if (b3Var != null) {
                            L1(2, sb2);
                            sb2.append("audience_membership {\n");
                            if (b3Var.w()) {
                                V1(sb2, 2, "audience_id", Integer.valueOf(b3Var.n()));
                            }
                            if (b3Var.x()) {
                                V1(sb2, 2, "new_audience", Boolean.valueOf(b3Var.v()));
                            }
                            W1(sb2, "current_data", b3Var.t());
                            if (b3Var.y()) {
                                W1(sb2, "previous_data", b3Var.u());
                            }
                            L1(2, sb2);
                            sb2.append("}\n");
                        }
                    }
                }
                s5<com.google.android.gms.internal.measurement.f3> s5VarS = n3Var.S();
                if (s5VarS != null) {
                    for (com.google.android.gms.internal.measurement.f3 f3Var : s5VarS) {
                        if (f3Var != null) {
                            L1(2, sb2);
                            sb2.append("event {\n");
                            V1(sb2, 2, "name", l0Var.b(f3Var.B()));
                            if (f3Var.F()) {
                                V1(sb2, 2, "timestamp_millis", Long.valueOf(f3Var.z()));
                            }
                            if (f3Var.E()) {
                                V1(sb2, 2, "previous_timestamp_millis", Long.valueOf(f3Var.y()));
                            }
                            if (f3Var.D()) {
                                V1(sb2, 2, "count", Integer.valueOf(f3Var.n()));
                            }
                            if (f3Var.w() != 0) {
                                T1(sb2, 2, f3Var.C());
                            }
                            L1(2, sb2);
                            sb2.append("}\n");
                        }
                    }
                }
                L1(1, sb2);
                sb2.append("}\n");
            }
        }
        sb2.append("} // End-of-batch\n");
        return sb2.toString();
    }

    public List I1(o5 o5Var, List list) {
        int i;
        ArrayList arrayList = new ArrayList(o5Var);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                g().D.c(num, "Ignoring negative bit index to be cleared");
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    g().D.b(num, Integer.valueOf(arrayList.size()), "Ignoring bit index greater than bitSet size");
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

    public r3 K1(String str, com.google.android.gms.internal.measurement.m3 m3Var, com.google.android.gms.internal.measurement.e3 e3Var, String str2) {
        int iIndexOf;
        e9.a();
        k1 k1Var = (k1) this.f2454v;
        e eVar = k1Var.A;
        e eVar2 = k1Var.A;
        if (!eVar.A1(str, w.H0)) {
            return null;
        }
        k1Var.H.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArrSplit = eVar2.x1(str, w.f7483h0).split(",");
        HashSet hashSet = new HashSet(strArrSplit.length);
        for (String str3 : strArrSplit) {
            Objects.requireNonNull(str3);
            if (!hashSet.add(str3)) {
                throw new IllegalArgumentException("duplicate element: " + ((Object) str3));
            }
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        v3 v3Var = this.f7443w.D;
        d1 d1VarS1 = v3Var.s1();
        k1 k1Var2 = (k1) v3Var.f2454v;
        String strK1 = d1VarS1.K1(str);
        Uri.Builder builder = new Uri.Builder();
        e eVar3 = k1Var2.A;
        e eVar4 = k1Var2.A;
        builder.scheme(eVar3.x1(str, w.f7464a0));
        if (TextUtils.isEmpty(strK1)) {
            builder.authority(eVar4.x1(str, w.f7466b0));
        } else {
            builder.authority(strK1 + "." + eVar4.x1(str, w.f7466b0));
        }
        builder.path(eVar4.x1(str, w.f7469c0));
        M1(builder, "gmp_app_id", ((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).K(), setUnmodifiableSet);
        M1(builder, "gmp_version", "106000", setUnmodifiableSet);
        String strB = ((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).B();
        f0 f0Var = w.K0;
        if (eVar2.A1(str, f0Var) && s1().L1(str)) {
            strB = "";
        }
        M1(builder, "app_instance_id", strB, setUnmodifiableSet);
        M1(builder, "rdid", ((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).O(), setUnmodifiableSet);
        M1(builder, "bundle_id", m3Var.V(), setUnmodifiableSet);
        String strL = e3Var.l();
        String strC = c2.c(strL, c2.f7112c, c2.f7110a);
        if (!TextUtils.isEmpty(strC)) {
            strL = strC;
        }
        M1(builder, "app_event_name", strL, setUnmodifiableSet);
        M1(builder, "app_version", String.valueOf(((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).b0()), setUnmodifiableSet);
        String strM = ((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).M();
        if (eVar2.A1(str, f0Var) && s1().M1(str) && !TextUtils.isEmpty(strM) && (iIndexOf = strM.indexOf(".")) != -1) {
            strM = strM.substring(0, iIndexOf);
        }
        M1(builder, "os_version", strM, setUnmodifiableSet);
        M1(builder, "timestamp", String.valueOf(e3Var.k()), setUnmodifiableSet);
        if (((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).W()) {
            M1(builder, "lat", "1", setUnmodifiableSet);
        }
        M1(builder, "privacy_sandbox_version", String.valueOf(((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).n()), setUnmodifiableSet);
        M1(builder, "trigger_uri_source", "1", setUnmodifiableSet);
        M1(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setUnmodifiableSet);
        M1(builder, "request_uuid", str2, setUnmodifiableSet);
        List<com.google.android.gms.internal.measurement.i3> listM = e3Var.m();
        Bundle bundle = new Bundle();
        for (com.google.android.gms.internal.measurement.i3 i3Var : listM) {
            String strC2 = i3Var.C();
            if (i3Var.F()) {
                bundle.putString(strC2, String.valueOf(i3Var.n()));
            } else if (i3Var.G()) {
                bundle.putString(strC2, String.valueOf(i3Var.u()));
            } else if (i3Var.J()) {
                bundle.putString(strC2, i3Var.D());
            } else if (i3Var.H()) {
                bundle.putString(strC2, String.valueOf(i3Var.z()));
            }
        }
        N1(builder, eVar2.x1(str, w.f7480g0).split("\\|"), bundle, setUnmodifiableSet);
        List<com.google.android.gms.internal.measurement.u3> listUnmodifiableList = Collections.unmodifiableList(((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).T());
        Bundle bundle2 = new Bundle();
        for (com.google.android.gms.internal.measurement.u3 u3Var : listUnmodifiableList) {
            String strA = u3Var.A();
            if (u3Var.C()) {
                bundle2.putString(strA, String.valueOf(u3Var.n()));
            } else if (u3Var.D()) {
                bundle2.putString(strA, String.valueOf(u3Var.s()));
            } else if (u3Var.G()) {
                bundle2.putString(strA, u3Var.B());
            } else if (u3Var.E()) {
                bundle2.putString(strA, String.valueOf(u3Var.w()));
            }
        }
        N1(builder, eVar2.x1(str, w.f7477f0).split("\\|"), bundle2, setUnmodifiableSet);
        M1(builder, "dma", ((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).V() ? "1" : "0", setUnmodifiableSet);
        if (!((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).G().isEmpty()) {
            M1(builder, "dma_cps", ((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).G(), setUnmodifiableSet);
        }
        if (eVar2.A1(null, w.M0) && ((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).Y()) {
            com.google.android.gms.internal.measurement.w2 w2VarY1 = ((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).Y1();
            if (!w2VarY1.H().isEmpty()) {
                M1(builder, "dl_gclid", w2VarY1.H(), setUnmodifiableSet);
            }
            if (!w2VarY1.G().isEmpty()) {
                M1(builder, "dl_gbraid", w2VarY1.G(), setUnmodifiableSet);
            }
            if (!w2VarY1.D().isEmpty()) {
                M1(builder, "dl_gs", w2VarY1.D(), setUnmodifiableSet);
            }
            if (w2VarY1.n() > 0) {
                M1(builder, "dl_ss_ts", String.valueOf(w2VarY1.n()), setUnmodifiableSet);
            }
            if (!w2VarY1.K().isEmpty()) {
                M1(builder, "mr_gclid", w2VarY1.K(), setUnmodifiableSet);
            }
            if (!w2VarY1.J().isEmpty()) {
                M1(builder, "mr_gbraid", w2VarY1.J(), setUnmodifiableSet);
            }
            if (!w2VarY1.I().isEmpty()) {
                M1(builder, "mr_gs", w2VarY1.I(), setUnmodifiableSet);
            }
            if (w2VarY1.r() > 0) {
                M1(builder, "mr_click_ts", String.valueOf(w2VarY1.r()), setUnmodifiableSet);
            }
        }
        return new r3(1, jCurrentTimeMillis, builder.build().toString());
    }

    public void P1(com.google.android.gms.internal.measurement.h3 h3Var, Object obj) {
        h3Var.e();
        com.google.android.gms.internal.measurement.i3.A((com.google.android.gms.internal.measurement.i3) h3Var.f3052v);
        h3Var.e();
        com.google.android.gms.internal.measurement.i3.v((com.google.android.gms.internal.measurement.i3) h3Var.f3052v);
        h3Var.e();
        com.google.android.gms.internal.measurement.i3.t((com.google.android.gms.internal.measurement.i3) h3Var.f3052v);
        h3Var.e();
        com.google.android.gms.internal.measurement.i3.y((com.google.android.gms.internal.measurement.i3) h3Var.f3052v);
        if (obj instanceof String) {
            h3Var.i((String) obj);
            return;
        }
        if (obj instanceof Long) {
            h3Var.g(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            h3Var.e();
            com.google.android.gms.internal.measurement.i3.o((com.google.android.gms.internal.measurement.i3) h3Var.f3052v, dDoubleValue);
            return;
        }
        if (!(obj instanceof Bundle[])) {
            g().A.c(obj, "Ignoring invalid (type) event param value");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.h3 h3VarB = com.google.android.gms.internal.measurement.i3.B();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.h3 h3VarB2 = com.google.android.gms.internal.measurement.i3.B();
                    h3VarB2.h(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        h3VarB2.g(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        h3VarB2.i((String) obj2);
                    } else if (obj2 instanceof Double) {
                        double dDoubleValue2 = ((Double) obj2).doubleValue();
                        h3VarB2.e();
                        com.google.android.gms.internal.measurement.i3.o((com.google.android.gms.internal.measurement.i3) h3VarB2.f3052v, dDoubleValue2);
                    }
                    h3VarB.e();
                    com.google.android.gms.internal.measurement.i3.q((com.google.android.gms.internal.measurement.i3) h3VarB.f3052v, (com.google.android.gms.internal.measurement.i3) h3VarB2.c());
                }
                if (((com.google.android.gms.internal.measurement.i3) h3VarB.f3052v).x() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.i3) h3VarB.c());
                }
            }
        }
        h3Var.e();
        com.google.android.gms.internal.measurement.i3.s((com.google.android.gms.internal.measurement.i3) h3Var.f3052v, arrayList);
    }

    public void Q1(com.google.android.gms.internal.measurement.t3 t3Var, Object obj) {
        t7.v.h(obj);
        t3Var.e();
        com.google.android.gms.internal.measurement.u3.x((com.google.android.gms.internal.measurement.u3) t3Var.f3052v);
        t3Var.e();
        com.google.android.gms.internal.measurement.u3.t((com.google.android.gms.internal.measurement.u3) t3Var.f3052v);
        t3Var.e();
        com.google.android.gms.internal.measurement.u3.r((com.google.android.gms.internal.measurement.u3) t3Var.f3052v);
        if (obj instanceof String) {
            t3Var.e();
            com.google.android.gms.internal.measurement.u3.v((com.google.android.gms.internal.measurement.u3) t3Var.f3052v, (String) obj);
        } else if (obj instanceof Long) {
            long jLongValue = ((Long) obj).longValue();
            t3Var.e();
            com.google.android.gms.internal.measurement.u3.p((com.google.android.gms.internal.measurement.u3) t3Var.f3052v, jLongValue);
        } else {
            if (!(obj instanceof Double)) {
                g().A.c(obj, "Ignoring invalid (type) user attribute value");
                return;
            }
            double dDoubleValue = ((Double) obj).doubleValue();
            t3Var.e();
            com.google.android.gms.internal.measurement.u3.o((com.google.android.gms.internal.measurement.u3) t3Var.f3052v, dDoubleValue);
        }
    }

    public void R1(String str, y3 y3Var, com.google.android.gms.internal.measurement.l3 l3Var, u0 u0Var) {
        String str2;
        URL url;
        byte[] bArrC;
        h1 h1VarX;
        Map map;
        String str3 = y3Var.f7562a;
        p1();
        t1();
        try {
            url = new URI(str3).toURL();
            q1();
            bArrC = l3Var.c();
            h1VarX = x();
            map = y3Var.f7563b;
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            str2 = str;
        }
        try {
            h1VarX.w1(new v0(this, str2, url, bArrC, map, u0Var));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            g().A.b(p0.v1(str2), str3, "Failed to parse URL. Not uploading MeasurementBatch. appId");
        }
    }

    public void S1(StringBuilder sb2, int i, com.google.android.gms.internal.measurement.y1 y1Var) {
        String str;
        if (y1Var == null) {
            return;
        }
        L1(i, sb2);
        sb2.append("filter {\n");
        if (y1Var.t()) {
            V1(sb2, i, "complement", Boolean.valueOf(y1Var.s()));
        }
        if (y1Var.v()) {
            V1(sb2, i, "param_name", ((k1) this.f2454v).G.f(y1Var.r()));
        }
        if (y1Var.w()) {
            int i10 = i + 1;
            com.google.android.gms.internal.measurement.d2 d2VarQ = y1Var.q();
            if (d2VarQ != null) {
                L1(i10, sb2);
                sb2.append("string_filter");
                sb2.append(" {\n");
                if (d2VarQ.v()) {
                    switch (d2VarQ.o()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            str = "ENDS_WITH";
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            str = "PARTIAL";
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            str = "EXACT";
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            str = "IN_LIST";
                            break;
                        default:
                            throw null;
                    }
                    V1(sb2, i10, "match_type", str);
                }
                if (d2VarQ.u()) {
                    V1(sb2, i10, "expression", d2VarQ.q());
                }
                if (d2VarQ.t()) {
                    V1(sb2, i10, "case_sensitive", Boolean.valueOf(d2VarQ.s()));
                }
                if (d2VarQ.n() > 0) {
                    L1(i + 2, sb2);
                    sb2.append("expression_list {\n");
                    for (String str2 : d2VarQ.r()) {
                        L1(i + 3, sb2);
                        sb2.append(str2);
                        sb2.append("\n");
                    }
                    sb2.append("}\n");
                }
                L1(i10, sb2);
                sb2.append("}\n");
            }
        }
        if (y1Var.u()) {
            U1(sb2, i + 1, "number_filter", y1Var.p());
        }
        L1(i, sb2);
        sb2.append("}\n");
    }

    public void T1(StringBuilder sb2, int i, s5 s5Var) {
        if (s5Var == null) {
            return;
        }
        int i10 = i + 1;
        Iterator it = s5Var.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.i3 i3Var = (com.google.android.gms.internal.measurement.i3) it.next();
            if (i3Var != null) {
                L1(i10, sb2);
                sb2.append("param {\n");
                V1(sb2, i10, "name", i3Var.I() ? ((k1) this.f2454v).G.f(i3Var.C()) : null);
                V1(sb2, i10, "string_value", i3Var.J() ? i3Var.D() : null);
                V1(sb2, i10, "int_value", i3Var.H() ? Long.valueOf(i3Var.z()) : null);
                V1(sb2, i10, "double_value", i3Var.F() ? Double.valueOf(i3Var.n()) : null);
                if (i3Var.x() > 0) {
                    T1(sb2, i10, (s5) i3Var.E());
                }
                L1(i10, sb2);
                sb2.append("}\n");
            }
        }
    }

    public boolean X1(long j5, long j8) {
        if (j5 == 0 || j8 <= 0) {
            return true;
        }
        ((k1) this.f2454v).H.getClass();
        return Math.abs(System.currentTimeMillis() - j5) > j8;
    }

    public byte[] c2(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            g().A.c(e10, "Failed to gzip content");
            throw e10;
        }
    }

    public byte[] e2(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i = gZIPInputStream.read(bArr2);
                if (i <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (IOException e10) {
            g().A.c(e10, "Failed to ungzip content");
            throw e10;
        }
    }

    public ArrayList f2() {
        Context context = this.f7443w.F.f7282u;
        List list = w.f7463a;
        com.google.android.gms.internal.measurement.g4 g4VarA = com.google.android.gms.internal.measurement.g4.a(context.getContentResolver(), o4.a("com.google.android.gms.measurement"), new androidx.emoji2.text.o(2));
        Map mapB = g4VarA == null ? Collections.EMPTY_MAP : g4VarA.b();
        if (mapB != null && !mapB.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int iIntValue = ((Integer) w.S.a(null)).intValue();
            for (Map.Entry entry : mapB.entrySet()) {
                if (((String) entry.getKey()).startsWith("measurement.id.")) {
                    try {
                        int i = Integer.parseInt((String) entry.getValue());
                        if (i != 0) {
                            arrayList.add(Integer.valueOf(i));
                            if (arrayList.size() >= iIntValue) {
                                g().D.c(Integer.valueOf(arrayList.size()), "Too many experiment IDs. Number of IDs");
                                break;
                            }
                            continue;
                        } else {
                            continue;
                        }
                    } catch (NumberFormatException e10) {
                        g().D.c(e10, "Experiment ID NumberFormatException");
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return null;
    }

    public boolean g2() {
        t1();
        ConnectivityManager connectivityManager = (ConnectivityManager) ((k1) this.f2454v).f7282u.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // k8.t3
    public final boolean v1() {
        switch (this.f7416y) {
        }
        return false;
    }

    public long x1(byte[] bArr) {
        t7.v.h(bArr);
        o1().p1();
        MessageDigest messageDigestC2 = h4.C2();
        if (messageDigestC2 != null) {
            return h4.x1(messageDigestC2.digest(bArr));
        }
        g().A.d("Failed to get MD5");
        return 0L;
    }
}
