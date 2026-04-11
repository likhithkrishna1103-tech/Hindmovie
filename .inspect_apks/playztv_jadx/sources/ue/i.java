package ue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import n.d3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f12976e;
    public static final i f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f12979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f12980d;

    static {
        h hVar = h.f12972r;
        h hVar2 = h.f12973s;
        h hVar3 = h.f12974t;
        h hVar4 = h.f12966l;
        h hVar5 = h.f12968n;
        h hVar6 = h.f12967m;
        h hVar7 = h.f12969o;
        h hVar8 = h.f12971q;
        h hVar9 = h.f12970p;
        h[] hVarArr = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9};
        h[] hVarArr2 = {hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, h.f12964j, h.f12965k, h.f12963h, h.i, h.f, h.f12962g, h.f12961e};
        d3 d3Var = new d3();
        d3Var.c((h[]) Arrays.copyOf(hVarArr, 9));
        b0 b0Var = b0.f12937v;
        b0 b0Var2 = b0.f12938w;
        d3Var.e(b0Var, b0Var2);
        d3Var.f8374b = true;
        d3Var.a();
        d3 d3Var2 = new d3();
        d3Var2.c((h[]) Arrays.copyOf(hVarArr2, 16));
        d3Var2.e(b0Var, b0Var2);
        d3Var2.f8374b = true;
        f12976e = d3Var2.a();
        d3 d3Var3 = new d3();
        d3Var3.c((h[]) Arrays.copyOf(hVarArr2, 16));
        d3Var3.e(b0Var, b0Var2, b0.f12939x, b0.f12940y);
        d3Var3.f8374b = true;
        d3Var3.a();
        f = new i(false, false, null, null);
    }

    public i(boolean z2, boolean z10, String[] strArr, String[] strArr2) {
        this.f12977a = z2;
        this.f12978b = z10;
        this.f12979c = strArr;
        this.f12980d = strArr2;
    }

    public final List a() {
        String[] strArr = this.f12979c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(h.f12958b.c(str));
        }
        return od.i.h0(arrayList);
    }

    public final boolean b(SSLSocket sSLSocket) {
        if (!this.f12977a) {
            return false;
        }
        String[] strArr = this.f12980d;
        if (strArr != null && !ve.b.h(strArr, sSLSocket.getEnabledProtocols(), qd.a.f11194v)) {
            return false;
        }
        String[] strArr2 = this.f12979c;
        return strArr2 == null || ve.b.h(strArr2, sSLSocket.getEnabledCipherSuites(), h.f12959c);
    }

    public final List c() {
        String[] strArr = this.f12980d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(v.g(str));
        }
        return od.i.h0(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        i iVar = (i) obj;
        boolean z2 = iVar.f12977a;
        boolean z10 = this.f12977a;
        if (z10 != z2) {
            return false;
        }
        if (z10) {
            return Arrays.equals(this.f12979c, iVar.f12979c) && Arrays.equals(this.f12980d, iVar.f12980d) && this.f12978b == iVar.f12978b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.f12977a) {
            return 17;
        }
        String[] strArr = this.f12979c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f12980d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f12978b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f12977a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(a(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f12978b + ')';
    }
}
