package cc;

import android.content.Context;
import com.google.android.gms.internal.measurement.k4;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f2633e = new y();
    public static final b1.c f = i5.a.G(t.f2711a, new rc.b(x.f2724v));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rd.h f2635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f2636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k4 f2637d;

    public f0(Context context, rd.h hVar) {
        be.h.e(context, "context");
        this.f2634a = context;
        this.f2635b = hVar;
        this.f2636c = new AtomicReference();
        f2633e.getClass();
        int i = 29;
        this.f2637d = new k4(new h4.z(((z0.a0) f.a(context, y.f2726a[0]).f12784v).f14746w, i, new a0(3, null)), this);
        ke.x.j(ke.x.a(hVar), null, new w(this, null, 0), 3);
    }
}
