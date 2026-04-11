package bf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements ae.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final t f2083u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ p f2084v;

    public k(p pVar, t tVar) {
        this.f2084v = pVar;
        this.f2083u = tVar;
    }

    @Override // ae.a
    public final Object b() {
        p pVar = this.f2084v;
        t tVar = this.f2083u;
        try {
        } catch (IOException e10) {
            pVar.a(2, 2, e10);
        } catch (Throwable th) {
            pVar.a(3, 3, null);
            ve.b.c(tVar);
            throw th;
        }
        if (!tVar.a(true, this)) {
            throw new IOException("Required SETTINGS preface not received");
        }
        while (tVar.a(false, this)) {
        }
        pVar.a(1, 9, null);
        ve.b.c(tVar);
        return nd.k.f8990a;
    }
}
