package ta;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o2.p f12370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f12371b;

    public i(o2.p pVar, za.c cVar) {
        this.f12370a = pVar;
        this.f12371b = new h(cVar);
    }

    public final void a(String str) {
        h hVar = this.f12371b;
        synchronized (hVar) {
            if (!Objects.equals(hVar.f12368b, str)) {
                h.a(hVar.f12367a, str, hVar.f12369c);
                hVar.f12368b = str;
            }
        }
    }
}
