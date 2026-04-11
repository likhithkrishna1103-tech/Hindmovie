package c7;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements z6.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f2579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f2580c;

    public s(Set set, j jVar, t tVar) {
        this.f2578a = set;
        this.f2579b = jVar;
        this.f2580c = tVar;
    }

    public final zc.c a(String str, z6.c cVar, z6.e eVar) {
        Set set = this.f2578a;
        if (set.contains(cVar)) {
            return new zc.c(this.f2579b, str, cVar, eVar, this.f2580c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", cVar, set));
    }
}
