package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f1137v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f1138w;

    public ReflectiveGenericLifecycleObserver(r rVar) {
        this.f1137v = rVar;
        d dVar = d.f1152c;
        Class<?> cls = rVar.getClass();
        b bVar = (b) dVar.f1153a.get(cls);
        this.f1138w = bVar == null ? dVar.a(cls, null) : bVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        HashMap map = this.f1138w.f1143a;
        List list = (List) map.get(mVar);
        Object obj = this.f1137v;
        b.a(list, sVar, mVar, obj);
        b.a((List) map.get(m.ON_ANY), sVar, mVar, obj);
    }
}
