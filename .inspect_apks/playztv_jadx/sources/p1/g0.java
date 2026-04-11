package p1;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g0 f9750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9751h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9754l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9755m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f9757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f9758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0 f9759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y f9760e;
    public final d0 f;

    static {
        w wVar = new w();
        aa.h0 h0Var = aa.j0.f690v;
        aa.c1 c1Var = aa.c1.f650y;
        List list = Collections.EMPTY_LIST;
        aa.c1 c1Var2 = aa.c1.f650y;
        e2.t tVar = new e2.t();
        f9750g = new g0("", new y(wVar), null, new b0(tVar), j0.K, d0.f9694d);
        f9751h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f9752j = Integer.toString(2, 36);
        f9753k = Integer.toString(3, 36);
        f9754l = Integer.toString(4, 36);
        f9755m = Integer.toString(5, 36);
    }

    public g0(String str, y yVar, c0 c0Var, b0 b0Var, j0 j0Var, d0 d0Var) {
        this.f9756a = str;
        this.f9757b = c0Var;
        this.f9758c = b0Var;
        this.f9759d = j0Var;
        this.f9760e = yVar;
        this.f = d0Var;
    }

    public static g0 a(Bundle bundle) {
        b0 b0Var;
        y yVar;
        d0 d0Var;
        Map mapA;
        a0 a0Var;
        u uVar;
        aa.c1 c1VarG;
        aa.c1 c1VarJ;
        c0 c0Var;
        String string = bundle.getString(f9751h, "");
        string.getClass();
        Bundle bundle2 = bundle.getBundle(i);
        if (bundle2 == null) {
            b0Var = b0.f;
        } else {
            e2.t tVar = new e2.t();
            String str = b0.f9649g;
            b0 b0Var2 = b0.f;
            tVar.f4363a = bundle2.getLong(str, b0Var2.f9653a);
            tVar.f4364b = bundle2.getLong(b0.f9650h, b0Var2.f9654b);
            tVar.f4365c = bundle2.getLong(b0.i, b0Var2.f9655c);
            tVar.f4366d = bundle2.getFloat(b0.f9651j, b0Var2.f9656d);
            tVar.f4367e = bundle2.getFloat(b0.f9652k, b0Var2.f9657e);
            b0Var = new b0(tVar);
        }
        b0 b0Var3 = b0Var;
        Bundle bundle3 = bundle.getBundle(f9752j);
        j0 j0VarB = bundle3 == null ? j0.K : j0.b(bundle3);
        Bundle bundle4 = bundle.getBundle(f9753k);
        if (bundle4 == null) {
            yVar = y.f10108r;
        } else {
            w wVar = new w();
            String str2 = x.f10092j;
            x xVar = x.i;
            long j5 = xVar.f10100a;
            long j8 = xVar.f10103d;
            long j10 = xVar.f10101b;
            long jO = s1.b0.O(bundle4.getLong(str2, j5));
            boolean z2 = true;
            s1.d.b(jO >= 0);
            wVar.f10087a = jO;
            long jO2 = s1.b0.O(bundle4.getLong(x.f10093k, xVar.f10102c));
            s1.d.b(jO2 == Long.MIN_VALUE || jO2 >= 0);
            wVar.f10088b = jO2;
            wVar.f10089c = bundle4.getBoolean(x.f10094l, xVar.f10104e);
            wVar.f10090d = bundle4.getBoolean(x.f10095m, xVar.f);
            wVar.f10091e = bundle4.getBoolean(x.f10096n, xVar.f10105g);
            wVar.f = bundle4.getBoolean(x.f10099q, xVar.f10106h);
            long j11 = bundle4.getLong(x.f10097o, j10);
            if (j11 != j10) {
                s1.d.b(j11 >= 0);
                wVar.f10087a = j11;
            }
            long j12 = bundle4.getLong(x.f10098p, j8);
            if (j12 != j8) {
                if (j12 != Long.MIN_VALUE && j12 < 0) {
                    z2 = false;
                }
                s1.d.b(z2);
                wVar.f10088b = j12;
            }
            yVar = new y(wVar);
        }
        y yVar2 = yVar;
        Bundle bundle5 = bundle.getBundle(f9754l);
        if (bundle5 == null) {
            d0Var = d0.f9694d;
        } else {
            kc.b bVar = new kc.b(9);
            bVar.f7620v = (Uri) bundle5.getParcelable(d0.f9695e);
            bVar.f7621w = bundle5.getString(d0.f);
            bVar.f7622x = bundle5.getBundle(d0.f9696g);
            d0Var = new d0(bVar);
        }
        d0 d0Var2 = d0Var;
        Bundle bundle6 = bundle.getBundle(f9755m);
        if (bundle6 == null) {
            c0Var = null;
        } else {
            Bundle bundle7 = bundle6.getBundle(c0.f9659k);
            if (bundle7 == null) {
                a0Var = null;
            } else {
                String string2 = bundle7.getString(a0.i);
                string2.getClass();
                UUID uuidFromString = UUID.fromString(string2);
                Uri uri = (Uri) bundle7.getParcelable(a0.f9626j);
                String str3 = a0.f9627k;
                Bundle bundle8 = Bundle.EMPTY;
                Bundle bundle9 = bundle7.getBundle(str3);
                if (bundle9 == null) {
                    bundle9 = bundle8;
                }
                if (bundle9 == bundle8) {
                    mapA = aa.h1.A;
                } else {
                    HashMap map = new HashMap();
                    if (bundle9 != bundle8) {
                        for (String str4 : bundle9.keySet()) {
                            String string3 = bundle9.getString(str4);
                            if (string3 != null) {
                                map.put(str4, string3);
                            }
                        }
                    }
                    mapA = aa.m0.a(map);
                }
                boolean z10 = bundle7.getBoolean(a0.f9628l, false);
                boolean z11 = bundle7.getBoolean(a0.f9629m, false);
                boolean z12 = bundle7.getBoolean(a0.f9630n, false);
                String str5 = a0.f9631o;
                ArrayList<Integer> arrayList = new ArrayList<>();
                ArrayList<Integer> integerArrayList = bundle7.getIntegerArrayList(str5);
                if (integerArrayList != null) {
                    arrayList = integerArrayList;
                }
                aa.j0 j0VarR = aa.j0.r(arrayList);
                byte[] byteArray = bundle7.getByteArray(a0.f9632p);
                z zVar = new z(uuidFromString);
                zVar.f10114b = uri;
                zVar.f10115c = aa.m0.a(mapA);
                zVar.f10116d = z10;
                zVar.f = z12;
                zVar.f10117e = z11;
                zVar.f10118g = aa.j0.r(j0VarR);
                zVar.f10119h = byteArray != null ? Arrays.copyOf(byteArray, byteArray.length) : null;
                a0Var = new a0(zVar);
            }
            Bundle bundle10 = bundle6.getBundle(c0.f9660l);
            if (bundle10 == null) {
                uVar = null;
            } else {
                Uri uri2 = (Uri) bundle10.getParcelable(u.f10064b);
                uri2.getClass();
                r0 r0Var = new r0();
                r0Var.f10045a = uri2;
                uVar = new u(r0Var);
            }
            ArrayList parcelableArrayList = bundle6.getParcelableArrayList(c0.f9661m);
            if (parcelableArrayList == null) {
                aa.h0 h0Var = aa.j0.f690v;
                c1VarG = aa.c1.f650y;
            } else {
                aa.g0 g0VarN = aa.j0.n();
                int i10 = 0;
                while (i10 < parcelableArrayList.size()) {
                    Bundle bundle11 = (Bundle) parcelableArrayList.get(i10);
                    bundle11.getClass();
                    g0VarN.a(new z0(bundle11.getInt(z0.f10120x, 0), bundle11.getInt(z0.f10121y, 0), bundle11.getInt(z0.f10122z, 0)));
                    i10++;
                    parcelableArrayList = parcelableArrayList;
                }
                c1VarG = g0VarN.g();
            }
            aa.c1 c1Var = c1VarG;
            ArrayList parcelableArrayList2 = bundle6.getParcelableArrayList(c0.f9663o);
            if (parcelableArrayList2 == null) {
                aa.h0 h0Var2 = aa.j0.f690v;
                c1VarJ = aa.c1.f650y;
            } else {
                c1VarJ = s1.d.j(new ia.b(17), parcelableArrayList2);
            }
            aa.c1 c1Var2 = c1VarJ;
            long j13 = bundle6.getLong(c0.f9664p, -9223372036854775807L);
            Uri uri3 = (Uri) bundle6.getParcelable(c0.i);
            uri3.getClass();
            c0Var = new c0(uri3, bundle6.getString(c0.f9658j), a0Var, uVar, c1Var, bundle6.getString(c0.f9662n), c1Var2, j13);
        }
        return new g0(string, yVar2, c0Var, b0Var3, j0VarB, d0Var2);
    }

    public static g0 b(String str) {
        c0 c0Var;
        w wVar = new w();
        z zVar = new z();
        List list = Collections.EMPTY_LIST;
        aa.c1 c1Var = aa.c1.f650y;
        e2.t tVar = new e2.t();
        d0 d0Var = d0.f9694d;
        Uri uri = str == null ? null : Uri.parse(str);
        s1.d.g(zVar.f10114b == null || zVar.f10113a != null);
        a0 a0Var = null;
        if (uri != null) {
            if (zVar.f10113a != null) {
                a0Var = new a0(zVar);
            }
            c0Var = new c0(uri, null, a0Var, null, list, null, c1Var, -9223372036854775807L);
        } else {
            c0Var = null;
        }
        return new g0("", new y(wVar), c0Var, new b0(tVar), j0.K, d0Var);
    }

    public final Bundle c(boolean z2) {
        c0 c0Var;
        Bundle bundle = new Bundle();
        String str = this.f9756a;
        if (!str.equals("")) {
            bundle.putString(f9751h, str);
        }
        b0 b0Var = b0.f;
        b0 b0Var2 = this.f9758c;
        if (!b0Var2.equals(b0Var)) {
            bundle.putBundle(i, b0Var2.b());
        }
        j0 j0Var = j0.K;
        j0 j0Var2 = this.f9759d;
        if (!j0Var2.equals(j0Var)) {
            bundle.putBundle(f9752j, j0Var2.c());
        }
        x xVar = x.i;
        y yVar = this.f9760e;
        if (!yVar.equals(xVar)) {
            Bundle bundle2 = new Bundle();
            long j5 = yVar.f10100a;
            if (j5 != xVar.f10100a) {
                bundle2.putLong(x.f10092j, j5);
            }
            long j8 = yVar.f10102c;
            if (j8 != xVar.f10102c) {
                bundle2.putLong(x.f10093k, j8);
            }
            long j10 = yVar.f10101b;
            if (j10 != xVar.f10101b) {
                bundle2.putLong(x.f10097o, j10);
            }
            long j11 = yVar.f10103d;
            if (j11 != xVar.f10103d) {
                bundle2.putLong(x.f10098p, j11);
            }
            boolean z10 = yVar.f10104e;
            if (z10 != xVar.f10104e) {
                bundle2.putBoolean(x.f10094l, z10);
            }
            boolean z11 = yVar.f;
            if (z11 != xVar.f) {
                bundle2.putBoolean(x.f10095m, z11);
            }
            boolean z12 = yVar.f10105g;
            if (z12 != xVar.f10105g) {
                bundle2.putBoolean(x.f10096n, z12);
            }
            boolean z13 = yVar.f10106h;
            if (z13 != xVar.f10106h) {
                bundle2.putBoolean(x.f10099q, z13);
            }
            bundle.putBundle(f9753k, bundle2);
        }
        d0 d0Var = d0.f9694d;
        d0 d0Var2 = this.f;
        if (!d0Var2.equals(d0Var)) {
            Bundle bundle3 = new Bundle();
            Uri uri = d0Var2.f9697a;
            if (uri != null) {
                bundle3.putParcelable(d0.f9695e, uri);
            }
            String str2 = d0Var2.f9698b;
            if (str2 != null) {
                bundle3.putString(d0.f, str2);
            }
            Bundle bundle4 = d0Var2.f9699c;
            if (bundle4 != null) {
                bundle3.putBundle(d0.f9696g, bundle4);
            }
            bundle.putBundle(f9754l, bundle3);
        }
        if (z2 && (c0Var = this.f9757b) != null) {
            aa.j0 j0Var3 = c0Var.f9670g;
            List list = c0Var.f9669e;
            Bundle bundle5 = new Bundle();
            bundle5.putParcelable(c0.i, c0Var.f9665a);
            String str3 = c0Var.f9666b;
            if (str3 != null) {
                bundle5.putString(c0.f9658j, str3);
            }
            a0 a0Var = c0Var.f9667c;
            if (a0Var != null) {
                String str4 = c0.f9659k;
                aa.j0 j0Var4 = a0Var.f9638g;
                aa.m0 m0Var = a0Var.f9635c;
                Bundle bundle6 = new Bundle();
                bundle6.putString(a0.i, a0Var.f9633a.toString());
                Uri uri2 = a0Var.f9634b;
                if (uri2 != null) {
                    bundle6.putParcelable(a0.f9626j, uri2);
                }
                if (!m0Var.isEmpty()) {
                    String str5 = a0.f9627k;
                    Bundle bundle7 = new Bundle();
                    for (Map.Entry entry : m0Var.entrySet()) {
                        bundle7.putString((String) entry.getKey(), (String) entry.getValue());
                    }
                    bundle6.putBundle(str5, bundle7);
                }
                boolean z14 = a0Var.f9636d;
                if (z14) {
                    bundle6.putBoolean(a0.f9628l, z14);
                }
                boolean z15 = a0Var.f9637e;
                if (z15) {
                    bundle6.putBoolean(a0.f9629m, z15);
                }
                boolean z16 = a0Var.f;
                if (z16) {
                    bundle6.putBoolean(a0.f9630n, z16);
                }
                if (!j0Var4.isEmpty()) {
                    bundle6.putIntegerArrayList(a0.f9631o, new ArrayList<>(j0Var4));
                }
                byte[] bArr = a0Var.f9639h;
                if (bArr != null) {
                    bundle6.putByteArray(a0.f9632p, bArr);
                }
                bundle5.putBundle(str4, bundle6);
            }
            u uVar = c0Var.f9668d;
            if (uVar != null) {
                String str6 = c0.f9660l;
                Bundle bundle8 = new Bundle();
                bundle8.putParcelable(u.f10064b, uVar.f10065a);
                bundle5.putBundle(str6, bundle8);
            }
            if (!list.isEmpty()) {
                bundle5.putParcelableArrayList(c0.f9661m, s1.d.p(list, new ia.b(15)));
            }
            String str7 = c0Var.f;
            if (str7 != null) {
                bundle5.putString(c0.f9662n, str7);
            }
            if (!j0Var3.isEmpty()) {
                bundle5.putParcelableArrayList(c0.f9663o, s1.d.p(j0Var3, new ia.b(16)));
            }
            long j12 = c0Var.f9671h;
            if (j12 != -9223372036854775807L) {
                bundle5.putLong(c0.f9664p, j12);
            }
            bundle.putBundle(f9755m, bundle5);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return Objects.equals(this.f9756a, g0Var.f9756a) && this.f9760e.equals(g0Var.f9760e) && Objects.equals(this.f9757b, g0Var.f9757b) && Objects.equals(this.f9758c, g0Var.f9758c) && Objects.equals(this.f9759d, g0Var.f9759d) && Objects.equals(this.f, g0Var.f);
    }

    public final int hashCode() {
        int iHashCode = this.f9756a.hashCode() * 31;
        c0 c0Var = this.f9757b;
        return this.f.hashCode() + ((this.f9759d.hashCode() + ((this.f9760e.hashCode() + ((this.f9758c.hashCode() + ((iHashCode + (c0Var != null ? c0Var.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }
}
