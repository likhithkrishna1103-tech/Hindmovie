package a2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c2 f181b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa.o0 f182a;

    static {
        u5.c cVar = new u5.c(1, false);
        cVar.f12782v = aa.o0.n(2, 1, 5);
        f181b = new c2(cVar);
    }

    public c2(u5.c cVar) {
        this.f182a = (aa.o0) cVar.f12782v;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c2) && this.f182a.equals(((c2) obj).f182a);
    }

    public final int hashCode() {
        Boolean bool = Boolean.TRUE;
        return Objects.hash(this.f182a, null, null, bool, bool, bool, bool);
    }
}
