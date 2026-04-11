package w6;

import android.util.Log;
import c2.o;
import com.bumptech.glide.h;
import com.bumptech.glide.load.data.c;
import com.bumptech.glide.load.data.d;
import d7.j;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import kf.b0;
import kf.e;
import kf.u;
import kf.z;
import of.n;
import s7.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements d, e {
    public volatile n A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final kf.d f14018v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j f14019w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public s7.d f14020x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b0 f14021y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c f14022z;

    public a(kf.d dVar, j jVar) {
        this.f14018v = dVar;
        this.f14019w = jVar;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        try {
            s7.d dVar = this.f14020x;
            if (dVar != null) {
                dVar.close();
            }
        } catch (IOException unused) {
        }
        b0 b0Var = this.f14021y;
        if (b0Var != null) {
            b0Var.close();
        }
        this.f14022z = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        n nVar = this.A;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int e() {
        return 2;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(h hVar, c cVar) {
        dd.c cVar2 = new dd.c();
        cVar2.u(this.f14019w.d());
        for (Map.Entry entry : this.f14019w.f3488b.a().entrySet()) {
            cVar2.l((String) entry.getKey(), (String) entry.getValue());
        }
        o oVar = new o(cVar2);
        this.f14022z = cVar;
        u uVar = (u) this.f14018v;
        uVar.getClass();
        this.A = new n(uVar, oVar);
        this.A.e(this);
    }

    @Override // kf.e
    public final void j(IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f14022z.c(iOException);
    }

    @Override // kf.e
    public final void m(z zVar) {
        b0 b0Var = zVar.B;
        this.f14021y = b0Var;
        if (!zVar.K) {
            this.f14022z.c(new a2.a(zVar.f7597y, null, zVar.f7596x));
        } else {
            f.c(b0Var, "Argument must not be null");
            s7.d dVar = new s7.d(this.f14021y.q().d0(), b0Var.a());
            this.f14020x = dVar;
            this.f14022z.d(dVar);
        }
    }
}
