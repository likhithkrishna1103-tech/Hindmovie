package b1;

import ae.l;
import android.content.Context;
import androidx.lifecycle.j0;
import cc.e0;
import java.util.List;
import ke.u;
import z0.a0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rc.b f1714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f1715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f1716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f1717e;
    public volatile u5.d f;

    public c(String str, rc.b bVar, l lVar, u uVar) {
        be.h.e(str, "name");
        this.f1713a = str;
        this.f1714b = bVar;
        this.f1715c = lVar;
        this.f1716d = uVar;
        this.f1717e = new Object();
    }

    public final u5.d a(Object obj, ge.c cVar) {
        u5.d dVar;
        Context context = (Context) obj;
        be.h.e(context, "thisRef");
        be.h.e(cVar, "property");
        u5.d dVar2 = this.f;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (this.f1717e) {
            try {
                if (this.f == null) {
                    Context applicationContext = context.getApplicationContext();
                    rc.b bVar = this.f1714b;
                    l lVar = this.f1715c;
                    be.h.d(applicationContext, "applicationContext");
                    List list = (List) lVar.a(applicationContext);
                    u uVar = this.f1716d;
                    b bVar2 = new b(applicationContext, this);
                    be.h.e(list, "migrations");
                    this.f = new u5.d(5, new a0(new j0(1, bVar2), android.support.v4.media.session.b.G(new e0(list, null, 7)), bVar, uVar));
                }
                dVar = this.f;
                be.h.b(dVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }
}
