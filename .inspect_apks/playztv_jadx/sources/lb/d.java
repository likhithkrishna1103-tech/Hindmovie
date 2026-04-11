package lb;

import android.content.Context;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.Executor;
import o8.o;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements f, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ga.c f8076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f8077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nb.b f8078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f8079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f8080e;

    public d(Context context, String str, Set set, nb.b bVar, Executor executor) {
        this.f8076a = new ga.c(context, str);
        this.f8079d = set;
        this.f8080e = executor;
        this.f8078c = bVar;
        this.f8077b = context;
    }

    public final synchronized int a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        u5.d dVar = (u5.d) this.f8076a.get();
        if (!dVar.T(jCurrentTimeMillis)) {
            return 1;
        }
        dVar.R();
        return 3;
    }

    public final o b() {
        if (Build.VERSION.SDK_INT >= 24 ? m0.d.e(this.f8077b) : true) {
            return t1.f(this.f8080e, new c(this, 0));
        }
        return t1.k("");
    }

    public final void c() {
        if (this.f8079d.size() <= 0) {
            t1.k(null);
            return;
        }
        if (Build.VERSION.SDK_INT >= 24 ? m0.d.e(this.f8077b) : true) {
            t1.f(this.f8080e, new c(this, 1));
        } else {
            t1.k(null);
        }
    }
}
