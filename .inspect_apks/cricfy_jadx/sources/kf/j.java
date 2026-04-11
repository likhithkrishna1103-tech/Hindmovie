package kf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7484a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f7486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Serializable f7487d;

    public k a() {
        return new k(this.f7484a, this.f7485b, (String[]) this.f7486c, (String[]) this.f7487d);
    }

    public void b(String... strArr) {
        ge.i.e(strArr, "cipherSuites");
        if (!this.f7484a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        }
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
        ge.i.d(objArrCopyOf, "copyOf(...)");
        this.f7486c = (String[]) objArrCopyOf;
    }

    public void c(h... hVarArr) {
        ge.i.e(hVarArr, "cipherSuites");
        if (!this.f7484a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(hVarArr.length);
        for (h hVar : hVarArr) {
            arrayList.add(hVar.f7481a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        b((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Serializable, java.lang.String[]] */
    public void d(String... strArr) {
        ge.i.e(strArr, "tlsVersions");
        if (!this.f7484a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        }
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
        ge.i.d(objArrCopyOf, "copyOf(...)");
        this.f7487d = (String[]) objArrCopyOf;
    }

    public void e(d0... d0VarArr) {
        if (!this.f7484a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(d0VarArr.length);
        for (d0 d0Var : d0VarArr) {
            arrayList.add(d0Var.f7459v);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        d((String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
