package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final r f1439u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f1440v;

    public ReflectiveGenericLifecycleObserver(r rVar) {
        this.f1439u = rVar;
        d dVar = d.f1455c;
        Class<?> cls = rVar.getClass();
        b bVar = (b) dVar.f1456a.get(cls);
        this.f1440v = bVar == null ? dVar.a(cls, null) : bVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        HashMap map = this.f1440v.f1445a;
        List list = (List) map.get(mVar);
        r rVar = this.f1439u;
        b.a(list, sVar, mVar, rVar);
        b.a((List) map.get(m.ON_ANY), sVar, mVar, rVar);
    }
}
