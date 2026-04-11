package z1;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends d5.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f15067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f15068e;

    public c(int i, long j4) {
        super(i, 2);
        this.f15066c = j4;
        this.f15067d = new ArrayList();
        this.f15068e = new ArrayList();
    }

    public final c m(int i) {
        ArrayList arrayList = this.f15068e;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar = (c) arrayList.get(i10);
            if (cVar.f3393b == i) {
                return cVar;
            }
        }
        return null;
    }

    public final d n(int i) {
        ArrayList arrayList = this.f15067d;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) arrayList.get(i10);
            if (dVar.f3393b == i) {
                return dVar;
            }
        }
        return null;
    }

    @Override // d5.c
    public final String toString() {
        return d5.c.b(this.f3393b) + " leaves: " + Arrays.toString(this.f15067d.toArray()) + " containers: " + Arrays.toString(this.f15068e.toArray());
    }
}
