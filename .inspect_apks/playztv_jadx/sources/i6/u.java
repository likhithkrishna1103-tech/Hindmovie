package i6;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f6424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rc.b f6425b;

    public u(kc.b bVar) {
        x xVar = new x(bVar);
        this.f6425b = new rc.b(15);
        this.f6424a = xVar;
    }

    public final synchronized ArrayList a(Class cls) {
        return this.f6424a.d(cls);
    }
}
