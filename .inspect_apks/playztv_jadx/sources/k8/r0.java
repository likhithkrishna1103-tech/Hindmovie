package k8;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f7391d;

    public r0(p0 p0Var, int i, boolean z2, boolean z10) {
        this.f7391d = p0Var;
        this.f7388a = i;
        this.f7389b = z2;
        this.f7390c = z10;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Serializable, java.lang.String[]] */
    public ue.i a(SSLSocket sSLSocket) throws UnknownServiceException {
        ue.i iVar;
        int i;
        boolean z2;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        int i10 = this.f7388a;
        List list = (List) this.f7391d;
        int size = list.size();
        while (true) {
            if (i10 >= size) {
                iVar = null;
                break;
            }
            iVar = (ue.i) list.get(i10);
            if (iVar.b(sSLSocket)) {
                this.f7388a = i10 + 1;
                break;
            }
            i10++;
        }
        if (iVar == null) {
            StringBuilder sb2 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb2.append(this.f7390c);
            sb2.append(", modes=");
            sb2.append(list);
            sb2.append(", supported protocols=");
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            be.h.b(enabledProtocols2);
            String string = Arrays.toString(enabledProtocols2);
            be.h.d(string, "toString(this)");
            sb2.append(string);
            throw new UnknownServiceException(sb2.toString());
        }
        int i11 = this.f7388a;
        int size2 = list.size();
        while (true) {
            i = 0;
            if (i11 >= size2) {
                z2 = false;
                break;
            }
            if (((ue.i) list.get(i11)).b(sSLSocket)) {
                z2 = true;
                break;
            }
            i11++;
        }
        this.f7389b = z2;
        boolean z10 = this.f7390c;
        ?? r12 = iVar.f12980d;
        String[] strArr = iVar.f12979c;
        if (strArr != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            be.h.d(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            enabledCipherSuites = ve.b.n(enabledCipherSuites2, strArr, ue.h.f12959c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (r12 != 0) {
            String[] enabledProtocols3 = sSLSocket.getEnabledProtocols();
            be.h.d(enabledProtocols3, "sslSocket.enabledProtocols");
            enabledProtocols = ve.b.n(enabledProtocols3, r12, qd.a.f11194v);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        be.h.d(supportedCipherSuites, "supportedCipherSuites");
        ue.g gVar = ue.h.f12959c;
        byte[] bArr = ve.b.f13497a;
        int length = supportedCipherSuites.length;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (gVar.compare(supportedCipherSuites[i], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i++;
        }
        if (z10 && i != -1) {
            be.h.d(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i];
            be.h.d(str, "supportedCipherSuites[indexOfFallbackScsv]");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            be.h.d(objArrCopyOf, "copyOf(this, newSize)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        n.d3 d3Var = new n.d3();
        d3Var.f8373a = iVar.f12977a;
        d3Var.f8375c = strArr;
        d3Var.f8376d = r12;
        d3Var.f8374b = iVar.f12978b;
        be.h.d(enabledCipherSuites, "cipherSuitesIntersection");
        d3Var.b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        be.h.d(enabledProtocols, "tlsVersionsIntersection");
        d3Var.d((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        ue.i iVarA = d3Var.a();
        if (iVarA.c() != null) {
            sSLSocket.setEnabledProtocols(iVarA.f12980d);
        }
        if (iVarA.a() != null) {
            sSLSocket.setEnabledCipherSuites(iVarA.f12979c);
        }
        return iVar;
    }

    public void b(Object obj, Object obj2, String str) {
        ((p0) this.f7391d).w1(this.f7388a, this.f7389b, this.f7390c, str, obj, obj2, null);
    }

    public void c(Object obj, String str) {
        ((p0) this.f7391d).w1(this.f7388a, this.f7389b, this.f7390c, str, obj, null, null);
    }

    public void d(String str) {
        ((p0) this.f7391d).w1(this.f7388a, this.f7389b, this.f7390c, str, null, null, null);
    }

    public void e(String str, Object obj, Object obj2, Object obj3) {
        ((p0) this.f7391d).w1(this.f7388a, this.f7389b, this.f7390c, str, obj, obj2, obj3);
    }

    public r0(List list) {
        be.h.e(list, "connectionSpecs");
        this.f7391d = list;
    }
}
