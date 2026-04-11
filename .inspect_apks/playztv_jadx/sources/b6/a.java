package b6;

import android.util.Log;
import b2.g;
import com.bumptech.glide.f;
import com.bumptech.glide.load.data.e;
import i6.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import ue.d;
import ue.s;
import ue.x;
import ue.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e, ue.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f1818u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f1819v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public x6.d f1820w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public z f1821x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bumptech.glide.load.data.d f1822y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile ye.h f1823z;

    public a(d dVar, h hVar) {
        this.f1818u = dVar;
        this.f1819v = hVar;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        try {
            x6.d dVar = this.f1820w;
            if (dVar != null) {
                dVar.close();
            }
        } catch (IOException unused) {
        }
        z zVar = this.f1821x;
        if (zVar != null) {
            zVar.close();
        }
        this.f1822y = null;
    }

    @Override // com.bumptech.glide.load.data.e
    public final int c() {
        return 2;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        ye.h hVar = this.f1823z;
        if (hVar != null) {
            hVar.d();
        }
    }

    @Override // ue.e
    public final void d(IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f1822y.l(iOException);
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(f fVar, com.bumptech.glide.load.data.d dVar) {
        zc.c cVar = new zc.c();
        cVar.v(this.f1819v.d());
        for (Map.Entry entry : this.f1819v.f6401b.a().entrySet()) {
            cVar.l((String) entry.getKey(), (String) entry.getValue());
        }
        g gVarM = cVar.m();
        this.f1822y = dVar;
        s sVar = (s) this.f1818u;
        sVar.getClass();
        this.f1823z = new ye.h(sVar, gVarM);
        this.f1823z.e(this);
    }

    @Override // ue.e
    public final void j(x xVar) {
        z zVar = xVar.A;
        this.f1821x = zVar;
        int i = xVar.f13069x;
        if (200 > i || i >= 300) {
            this.f1822y.l(new c6.c(i, null, xVar.f13068w));
            return;
        }
        x6.f.c(zVar, "Argument must not be null");
        x6.d dVar = new x6.d(this.f1821x.v().f0(), zVar.a());
        this.f1820w = dVar;
        this.f1822y.r(dVar);
    }
}
