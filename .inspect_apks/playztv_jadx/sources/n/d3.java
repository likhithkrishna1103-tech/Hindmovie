package n;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8373a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f8375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Serializable f8376d;

    public ue.i a() {
        return new ue.i(this.f8373a, this.f8374b, (String[]) this.f8375c, (String[]) this.f8376d);
    }

    public void b(String... strArr) {
        be.h.e(strArr, "cipherSuites");
        if (!this.f8373a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        }
        this.f8375c = (String[]) strArr.clone();
    }

    public void c(ue.h... hVarArr) {
        be.h.e(hVarArr, "cipherSuites");
        if (!this.f8373a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(hVarArr.length);
        for (ue.h hVar : hVarArr) {
            arrayList.add(hVar.f12975a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        b((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Serializable, java.lang.String[]] */
    public void d(String... strArr) {
        be.h.e(strArr, "tlsVersions");
        if (!this.f8373a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        }
        this.f8376d = (String[]) strArr.clone();
    }

    public void e(ue.b0... b0VarArr) {
        if (!this.f8373a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections");
        }
        ArrayList arrayList = new ArrayList(b0VarArr.length);
        for (ue.b0 b0Var : b0VarArr) {
            arrayList.add(b0Var.f12942u);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        d((String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
