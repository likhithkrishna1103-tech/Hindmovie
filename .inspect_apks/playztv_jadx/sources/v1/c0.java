package v1;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f13126u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f13127v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Uri f13128w;

    public c0(h hVar) {
        hVar.getClass();
        this.f13126u = hVar;
        this.f13128w = Uri.EMPTY;
        Map map = Collections.EMPTY_MAP;
    }

    @Override // v1.h
    public final void close() {
        this.f13126u.close();
    }

    @Override // v1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        this.f13126u.g(e0Var);
    }

    @Override // v1.h
    public final long h(m mVar) {
        h hVar = this.f13126u;
        this.f13128w = mVar.f13157a;
        Map map = Collections.EMPTY_MAP;
        try {
            return hVar.h(mVar);
        } finally {
            Uri uriO = hVar.o();
            if (uriO != null) {
                this.f13128w = uriO;
            }
            hVar.k();
        }
    }

    @Override // v1.h
    public final Map k() {
        return this.f13126u.k();
    }

    @Override // v1.h
    public final Uri o() {
        return this.f13126u.o();
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) {
        int i11 = this.f13126u.read(bArr, i, i10);
        if (i11 != -1) {
            this.f13127v += (long) i11;
        }
        return i11;
    }
}
