package p;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashMap f9592y = new HashMap();

    @Override // p.f
    public final c b(Object obj) {
        return (c) this.f9592y.get(obj);
    }

    @Override // p.f
    public final Object d(Object obj) {
        Object objD = super.d(obj);
        this.f9592y.remove(obj);
        return objD;
    }
}
