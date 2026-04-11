package t1;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f12000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f12001e;

    public c(int i, long j5) {
        super(i, 0);
        this.f11999c = j5;
        this.f12000d = new ArrayList();
        this.f12001e = new ArrayList();
    }

    public final c m(int i) {
        ArrayList arrayList = this.f12001e;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar = (c) arrayList.get(i10);
            if (cVar.f12004b == i) {
                return cVar;
            }
        }
        return null;
    }

    public final d n(int i) {
        ArrayList arrayList = this.f12000d;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) arrayList.get(i10);
            if (dVar.f12004b == i) {
                return dVar;
            }
        }
        return null;
    }

    @Override // t1.e
    public final String toString() {
        return e.b(this.f12004b) + " leaves: " + Arrays.toString(this.f12000d.toArray()) + " containers: " + Arrays.toString(this.f12001e.toArray());
    }
}
