package kf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f7488e;
    public static final k f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f7491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f7492d;

    static {
        h hVar = h.f7478r;
        h hVar2 = h.f7479s;
        h hVar3 = h.f7480t;
        h hVar4 = h.f7472l;
        h hVar5 = h.f7474n;
        h hVar6 = h.f7473m;
        h hVar7 = h.f7475o;
        h hVar8 = h.f7477q;
        h hVar9 = h.f7476p;
        List listA = sd.i.a(new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9});
        List listA2 = sd.i.a(new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, h.f7470j, h.f7471k, h.f7469h, h.i, h.f, h.f7468g, h.f7467e});
        j jVar = new j();
        h[] hVarArr = (h[]) listA.toArray(new h[0]);
        jVar.c((h[]) Arrays.copyOf(hVarArr, hVarArr.length));
        d0 d0Var = d0.f7456x;
        d0 d0Var2 = d0.f7457y;
        jVar.e(d0Var, d0Var2);
        jVar.f7485b = true;
        jVar.a();
        j jVar2 = new j();
        h[] hVarArr2 = (h[]) listA2.toArray(new h[0]);
        jVar2.c((h[]) Arrays.copyOf(hVarArr2, hVarArr2.length));
        jVar2.e(d0Var, d0Var2);
        jVar2.f7485b = true;
        f7488e = jVar2.a();
        j jVar3 = new j();
        h[] hVarArr3 = (h[]) listA2.toArray(new h[0]);
        jVar3.c((h[]) Arrays.copyOf(hVarArr3, hVarArr3.length));
        jVar3.e(d0Var, d0Var2, d0.f7458z, d0.A);
        jVar3.f7485b = true;
        jVar3.a();
        f = new k(false, false, null, null);
    }

    public k(boolean z10, boolean z11, String[] strArr, String[] strArr2) {
        this.f7489a = z10;
        this.f7490b = z11;
        this.f7491c = strArr;
        this.f7492d = strArr2;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.Serializable, java.lang.String[]] */
    public final void a(SSLSocket sSLSocket, boolean z10) {
        String[] enabledProtocols;
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ge.i.b(enabledCipherSuites);
        String[] strArr = this.f7491c;
        if (strArr != null) {
            enabledCipherSuites = lf.d.i(strArr, enabledCipherSuites, h.f7465c);
        }
        ?? r22 = this.f7492d;
        if (r22 != 0) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            ge.i.d(enabledProtocols2, "getEnabledProtocols(...)");
            enabledProtocols = lf.d.i(enabledProtocols2, r22, ud.a.f12450w);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        ge.i.b(supportedCipherSuites);
        g gVar = h.f7465c;
        byte[] bArr = lf.d.f7960a;
        int length = supportedCipherSuites.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (gVar.compare(supportedCipherSuites[i], "TLS_FALLBACK_SCSV") == 0) {
                break;
            } else {
                i++;
            }
        }
        if (z10 && i != -1) {
            String str = supportedCipherSuites[i];
            ge.i.d(str, "get(...)");
            ge.i.e(enabledCipherSuites, "<this>");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            ge.i.d(objArrCopyOf, "copyOf(...)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        j jVar = new j();
        jVar.f7484a = this.f7489a;
        jVar.f7486c = strArr;
        jVar.f7487d = r22;
        jVar.f7485b = this.f7490b;
        jVar.b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        jVar.d((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        k kVarA = jVar.a();
        if (kVarA.c() != null) {
            sSLSocket.setEnabledProtocols(kVarA.f7492d);
        }
        if (kVarA.b() != null) {
            sSLSocket.setEnabledCipherSuites(kVarA.f7491c);
        }
    }

    public final ArrayList b() {
        String[] strArr = this.f7491c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(h.f7464b.b(str));
        }
        return arrayList;
    }

    public final ArrayList c() {
        String[] strArr = this.f7492d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            d0.f7455w.getClass();
            arrayList.add(b.c(str));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        boolean z10 = kVar.f7489a;
        boolean z11 = this.f7489a;
        if (z11 != z10) {
            return false;
        }
        if (z11) {
            return Arrays.equals(this.f7491c, kVar.f7491c) && Arrays.equals(this.f7492d, kVar.f7492d) && this.f7490b == kVar.f7490b;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.f7489a) {
            return 17;
        }
        String[] strArr = this.f7491c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f7492d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f7490b ? 1 : 0);
    }

    public final String toString() {
        if (!this.f7489a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f7490b + ')';
    }
}
