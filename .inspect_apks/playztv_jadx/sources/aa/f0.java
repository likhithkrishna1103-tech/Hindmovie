package aa;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends m implements Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f667u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f668v;

    public f0(Object obj, Object obj2) {
        this.f667u = obj;
        this.f668v = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f667u;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f668v;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
