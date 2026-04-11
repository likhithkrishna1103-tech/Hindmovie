package o8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements a, t3.d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f9424u;

    public j(int i, List list) {
        switch (i) {
            case 1:
                this.f9424u = list;
                break;
            default:
                this.f9424u = list;
                break;
        }
    }

    @Override // t3.d
    public int a(long j5) {
        return j5 < 0 ? 0 : -1;
    }

    @Override // o8.a
    public /* bridge */ /* synthetic */ Object b(o oVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f9424u);
        return t1.k(arrayList);
    }

    @Override // t3.d
    public long f(int i) {
        s1.d.b(i == 0);
        return 0L;
    }

    @Override // t3.d
    public List i(long j5) {
        return j5 >= 0 ? this.f9424u : Collections.EMPTY_LIST;
    }

    @Override // t3.d
    public int j() {
        return 1;
    }
}
