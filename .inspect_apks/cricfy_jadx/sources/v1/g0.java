package v1;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g0 f12690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12691h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12695m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f12697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f12698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0 f12699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x f12700e;
    public final d0 f;

    static {
        v vVar = new v();
        ua.g0 g0Var = ua.i0.f12341w;
        ua.z0 z0Var = ua.z0.f12413z;
        List list = Collections.EMPTY_LIST;
        ua.z0 z0Var2 = ua.z0.f12413z;
        k2.t tVar = new k2.t();
        f12690g = new g0("", new x(vVar), null, new a0(tVar), j0.K, d0.f12622d);
        f12691h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f12692j = Integer.toString(2, 36);
        f12693k = Integer.toString(3, 36);
        f12694l = Integer.toString(4, 36);
        f12695m = Integer.toString(5, 36);
    }

    public g0(String str, x xVar, c0 c0Var, a0 a0Var, j0 j0Var, d0 d0Var) {
        this.f12696a = str;
        this.f12697b = c0Var;
        this.f12698c = a0Var;
        this.f12699d = j0Var;
        this.f12700e = xVar;
        this.f = d0Var;
    }

    public static g0 a(Bundle bundle) {
        a0 a0Var;
        x xVar;
        d0 d0Var;
        Map mapA;
        z zVar;
        t tVar;
        ua.z0 z0VarG;
        ua.z0 z0VarJ;
        c0 c0Var;
        String string = bundle.getString(f12691h, "");
        string.getClass();
        Bundle bundle2 = bundle.getBundle(i);
        if (bundle2 == null) {
            a0Var = a0.f;
        } else {
            k2.t tVar2 = new k2.t();
            String str = a0.f12567g;
            a0 a0Var2 = a0.f;
            tVar2.f6892a = bundle2.getLong(str, a0Var2.f12571a);
            tVar2.f6893b = bundle2.getLong(a0.f12568h, a0Var2.f12572b);
            tVar2.f6894c = bundle2.getLong(a0.i, a0Var2.f12573c);
            tVar2.f6895d = bundle2.getFloat(a0.f12569j, a0Var2.f12574d);
            tVar2.f6896e = bundle2.getFloat(a0.f12570k, a0Var2.f12575e);
            a0Var = new a0(tVar2);
        }
        a0 a0Var3 = a0Var;
        Bundle bundle3 = bundle.getBundle(f12692j);
        j0 j0VarB = bundle3 == null ? j0.K : j0.b(bundle3);
        Bundle bundle4 = bundle.getBundle(f12693k);
        boolean z10 = false;
        if (bundle4 == null) {
            xVar = x.f13035r;
        } else {
            v vVar = new v();
            String str2 = w.f13020j;
            w wVar = w.i;
            long j4 = wVar.f13028a;
            long j7 = wVar.f13031d;
            long j10 = wVar.f13029b;
            long jO = y1.a0.O(bundle4.getLong(str2, j4));
            boolean z11 = true;
            y1.d.b(jO >= 0);
            vVar.f13001a = jO;
            long jO2 = y1.a0.O(bundle4.getLong(w.f13021k, wVar.f13030c));
            y1.d.b(jO2 == Long.MIN_VALUE || jO2 >= 0);
            vVar.f13002b = jO2;
            vVar.f13003c = bundle4.getBoolean(w.f13022l, wVar.f13032e);
            vVar.f13004d = bundle4.getBoolean(w.f13023m, wVar.f);
            vVar.f13005e = bundle4.getBoolean(w.f13024n, wVar.f13033g);
            vVar.f = bundle4.getBoolean(w.f13027q, wVar.f13034h);
            long j11 = bundle4.getLong(w.f13025o, j10);
            if (j11 != j10) {
                y1.d.b(j11 >= 0);
                vVar.f13001a = j11;
            }
            long j12 = bundle4.getLong(w.f13026p, j7);
            if (j12 != j7) {
                if (j12 != Long.MIN_VALUE && j12 < 0) {
                    z11 = false;
                }
                y1.d.b(z11);
                vVar.f13002b = j12;
            }
            xVar = new x(vVar);
        }
        x xVar2 = xVar;
        Bundle bundle5 = bundle.getBundle(f12694l);
        if (bundle5 == null) {
            d0Var = d0.f12622d;
        } else {
            l7.a aVar = new l7.a(20, z10);
            aVar.f7866w = (Uri) bundle5.getParcelable(d0.f12623e);
            aVar.f7867x = bundle5.getString(d0.f);
            aVar.f7868y = bundle5.getBundle(d0.f12624g);
            d0Var = new d0(aVar);
        }
        d0 d0Var2 = d0Var;
        Bundle bundle6 = bundle.getBundle(f12695m);
        if (bundle6 == null) {
            c0Var = null;
        } else {
            Bundle bundle7 = bundle6.getBundle(c0.f12599k);
            if (bundle7 == null) {
                zVar = null;
            } else {
                String string2 = bundle7.getString(z.i);
                string2.getClass();
                UUID uuidFromString = UUID.fromString(string2);
                Uri uri = (Uri) bundle7.getParcelable(z.f13048j);
                String str3 = z.f13049k;
                Bundle bundle8 = Bundle.EMPTY;
                Bundle bundle9 = bundle7.getBundle(str3);
                if (bundle9 == null) {
                    bundle9 = bundle8;
                }
                if (bundle9 == bundle8) {
                    mapA = ua.e1.B;
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
                    mapA = ua.k0.a(map);
                }
                boolean z12 = bundle7.getBoolean(z.f13050l, false);
                boolean z13 = bundle7.getBoolean(z.f13051m, false);
                boolean z14 = bundle7.getBoolean(z.f13052n, false);
                String str5 = z.f13053o;
                ArrayList<Integer> arrayList = new ArrayList<>();
                ArrayList<Integer> integerArrayList = bundle7.getIntegerArrayList(str5);
                if (integerArrayList != null) {
                    arrayList = integerArrayList;
                }
                ua.i0 i0VarK = ua.i0.k(arrayList);
                byte[] byteArray = bundle7.getByteArray(z.f13054p);
                y yVar = new y(uuidFromString);
                yVar.f13038b = uri;
                yVar.f13039c = ua.k0.a(mapA);
                yVar.f13040d = z12;
                yVar.f = z14;
                yVar.f13041e = z13;
                yVar.f13042g = ua.i0.k(i0VarK);
                yVar.f13043h = byteArray != null ? Arrays.copyOf(byteArray, byteArray.length) : null;
                zVar = new z(yVar);
            }
            Bundle bundle10 = bundle6.getBundle(c0.f12600l);
            if (bundle10 == null) {
                tVar = null;
            } else {
                Uri uri2 = (Uri) bundle10.getParcelable(t.f12991b);
                uri2.getClass();
                r0 r0Var = new r0();
                r0Var.f12977a = uri2;
                tVar = new t(r0Var);
            }
            ArrayList parcelableArrayList = bundle6.getParcelableArrayList(c0.f12601m);
            if (parcelableArrayList == null) {
                ua.g0 g0Var = ua.i0.f12341w;
                z0VarG = ua.z0.f12413z;
            } else {
                ua.f0 f0VarJ = ua.i0.j();
                int i10 = 0;
                while (i10 < parcelableArrayList.size()) {
                    Bundle bundle11 = (Bundle) parcelableArrayList.get(i10);
                    bundle11.getClass();
                    f0VarJ.a(new z0(bundle11.getInt(z0.f13062y, 0), bundle11.getInt(z0.f13063z, 0), bundle11.getInt(z0.A, 0)));
                    i10++;
                    parcelableArrayList = parcelableArrayList;
                }
                z0VarG = f0VarJ.g();
            }
            ua.z0 z0Var = z0VarG;
            ArrayList parcelableArrayList2 = bundle6.getParcelableArrayList(c0.f12603o);
            if (parcelableArrayList2 == null) {
                ua.g0 g0Var2 = ua.i0.f12341w;
                z0VarJ = ua.z0.f12413z;
            } else {
                z0VarJ = y1.d.j(new b0(2), parcelableArrayList2);
            }
            ua.z0 z0Var2 = z0VarJ;
            long j13 = bundle6.getLong(c0.f12604p, -9223372036854775807L);
            Uri uri3 = (Uri) bundle6.getParcelable(c0.i);
            uri3.getClass();
            c0Var = new c0(uri3, bundle6.getString(c0.f12598j), zVar, tVar, z0Var, bundle6.getString(c0.f12602n), z0Var2, j13);
        }
        return new g0(string, xVar2, c0Var, a0Var3, j0VarB, d0Var2);
    }

    public static g0 b(String str) {
        c0 c0Var;
        v vVar = new v();
        y yVar = new y();
        List list = Collections.EMPTY_LIST;
        ua.z0 z0Var = ua.z0.f12413z;
        k2.t tVar = new k2.t();
        d0 d0Var = d0.f12622d;
        Uri uri = str == null ? null : Uri.parse(str);
        y1.d.g(yVar.f13038b == null || yVar.f13037a != null);
        z zVar = null;
        if (uri != null) {
            if (yVar.f13037a != null) {
                zVar = new z(yVar);
            }
            c0Var = new c0(uri, null, zVar, null, list, null, z0Var, -9223372036854775807L);
        } else {
            c0Var = null;
        }
        return new g0("", new x(vVar), c0Var, new a0(tVar), j0.K, d0Var);
    }

    public final Bundle c(boolean z10) {
        c0 c0Var;
        Bundle bundle = new Bundle();
        String str = this.f12696a;
        if (!str.equals("")) {
            bundle.putString(f12691h, str);
        }
        a0 a0Var = a0.f;
        a0 a0Var2 = this.f12698c;
        if (!a0Var2.equals(a0Var)) {
            bundle.putBundle(i, a0Var2.b());
        }
        j0 j0Var = j0.K;
        j0 j0Var2 = this.f12699d;
        if (!j0Var2.equals(j0Var)) {
            bundle.putBundle(f12692j, j0Var2.c());
        }
        w wVar = w.i;
        x xVar = this.f12700e;
        if (!xVar.equals(wVar)) {
            Bundle bundle2 = new Bundle();
            long j4 = xVar.f13028a;
            if (j4 != wVar.f13028a) {
                bundle2.putLong(w.f13020j, j4);
            }
            long j7 = xVar.f13030c;
            if (j7 != wVar.f13030c) {
                bundle2.putLong(w.f13021k, j7);
            }
            long j10 = xVar.f13029b;
            if (j10 != wVar.f13029b) {
                bundle2.putLong(w.f13025o, j10);
            }
            long j11 = xVar.f13031d;
            if (j11 != wVar.f13031d) {
                bundle2.putLong(w.f13026p, j11);
            }
            boolean z11 = xVar.f13032e;
            if (z11 != wVar.f13032e) {
                bundle2.putBoolean(w.f13022l, z11);
            }
            boolean z12 = xVar.f;
            if (z12 != wVar.f) {
                bundle2.putBoolean(w.f13023m, z12);
            }
            boolean z13 = xVar.f13033g;
            if (z13 != wVar.f13033g) {
                bundle2.putBoolean(w.f13024n, z13);
            }
            boolean z14 = xVar.f13034h;
            if (z14 != wVar.f13034h) {
                bundle2.putBoolean(w.f13027q, z14);
            }
            bundle.putBundle(f12693k, bundle2);
        }
        d0 d0Var = d0.f12622d;
        d0 d0Var2 = this.f;
        if (!d0Var2.equals(d0Var)) {
            Bundle bundle3 = new Bundle();
            Uri uri = d0Var2.f12625a;
            if (uri != null) {
                bundle3.putParcelable(d0.f12623e, uri);
            }
            String str2 = d0Var2.f12626b;
            if (str2 != null) {
                bundle3.putString(d0.f, str2);
            }
            Bundle bundle4 = d0Var2.f12627c;
            if (bundle4 != null) {
                bundle3.putBundle(d0.f12624g, bundle4);
            }
            bundle.putBundle(f12694l, bundle3);
        }
        if (z10 && (c0Var = this.f12697b) != null) {
            ua.i0 i0Var = c0Var.f12610g;
            List list = c0Var.f12609e;
            Bundle bundle5 = new Bundle();
            bundle5.putParcelable(c0.i, c0Var.f12605a);
            String str3 = c0Var.f12606b;
            if (str3 != null) {
                bundle5.putString(c0.f12598j, str3);
            }
            z zVar = c0Var.f12607c;
            if (zVar != null) {
                String str4 = c0.f12599k;
                ua.i0 i0Var2 = zVar.f13060g;
                ua.k0 k0Var = zVar.f13057c;
                Bundle bundle6 = new Bundle();
                bundle6.putString(z.i, zVar.f13055a.toString());
                Uri uri2 = zVar.f13056b;
                if (uri2 != null) {
                    bundle6.putParcelable(z.f13048j, uri2);
                }
                if (!k0Var.isEmpty()) {
                    String str5 = z.f13049k;
                    Bundle bundle7 = new Bundle();
                    for (Map.Entry entry : k0Var.entrySet()) {
                        bundle7.putString((String) entry.getKey(), (String) entry.getValue());
                    }
                    bundle6.putBundle(str5, bundle7);
                }
                boolean z15 = zVar.f13058d;
                if (z15) {
                    bundle6.putBoolean(z.f13050l, z15);
                }
                boolean z16 = zVar.f13059e;
                if (z16) {
                    bundle6.putBoolean(z.f13051m, z16);
                }
                boolean z17 = zVar.f;
                if (z17) {
                    bundle6.putBoolean(z.f13052n, z17);
                }
                if (!i0Var2.isEmpty()) {
                    bundle6.putIntegerArrayList(z.f13053o, new ArrayList<>(i0Var2));
                }
                byte[] bArr = zVar.f13061h;
                if (bArr != null) {
                    bundle6.putByteArray(z.f13054p, bArr);
                }
                bundle5.putBundle(str4, bundle6);
            }
            t tVar = c0Var.f12608d;
            if (tVar != null) {
                String str6 = c0.f12600l;
                Bundle bundle8 = new Bundle();
                bundle8.putParcelable(t.f12991b, tVar.f12992a);
                bundle5.putBundle(str6, bundle8);
            }
            if (!list.isEmpty()) {
                bundle5.putParcelableArrayList(c0.f12601m, y1.d.p(list, new b0(0)));
            }
            String str7 = c0Var.f;
            if (str7 != null) {
                bundle5.putString(c0.f12602n, str7);
            }
            if (!i0Var.isEmpty()) {
                bundle5.putParcelableArrayList(c0.f12603o, y1.d.p(i0Var, new b0(1)));
            }
            long j12 = c0Var.f12611h;
            if (j12 != -9223372036854775807L) {
                bundle5.putLong(c0.f12604p, j12);
            }
            bundle.putBundle(f12695m, bundle5);
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
        return Objects.equals(this.f12696a, g0Var.f12696a) && this.f12700e.equals(g0Var.f12700e) && Objects.equals(this.f12697b, g0Var.f12697b) && Objects.equals(this.f12698c, g0Var.f12698c) && Objects.equals(this.f12699d, g0Var.f12699d) && Objects.equals(this.f, g0Var.f);
    }

    public final int hashCode() {
        int iHashCode = this.f12696a.hashCode() * 31;
        c0 c0Var = this.f12697b;
        return this.f.hashCode() + ((this.f12699d.hashCode() + ((this.f12700e.hashCode() + ((this.f12698c.hashCode() + ((iHashCode + (c0Var != null ? c0Var.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }
}
