package fc;

import android.content.Context;
import android.os.Build;
import hb.n;
import j9.p;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements f, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f4541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f4542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hc.b f4543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f4544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f4545e;

    public d(Context context, String str, Set set, hc.b bVar, Executor executor) {
        this.f4541a = new n(new ab.c(context, str));
        this.f4544d = set;
        this.f4545e = executor;
        this.f4543c = bVar;
        this.f4542b = context;
    }

    public final synchronized int a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        j jVar = (j) this.f4541a.get();
        if (!jVar.i(jCurrentTimeMillis)) {
            return 1;
        }
        jVar.g();
        return 3;
    }

    public final p b() {
        if (Build.VERSION.SDK_INT >= 24 ? p0.d.f(this.f4542b) : true) {
            return vf.g.e(this.f4545e, new c(this, 0));
        }
        return vf.g.A("");
    }

    public final void c() {
        if (this.f4544d.size() <= 0) {
            vf.g.A(null);
            return;
        }
        if (Build.VERSION.SDK_INT >= 24 ? p0.d.f(this.f4542b) : true) {
            vf.g.e(this.f4545e, new c(this, 1));
        } else {
            vf.g.A(null);
        }
    }
}
