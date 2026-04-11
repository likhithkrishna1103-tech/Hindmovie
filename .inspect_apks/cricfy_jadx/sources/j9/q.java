package j9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements a, x3.g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f6711v;

    public /* synthetic */ q(List list) {
        this.f6711v = list;
    }

    @Override // x3.g
    public int a(long j4) {
        return j4 < 0 ? 0 : -1;
    }

    @Override // j9.a
    public /* bridge */ /* synthetic */ Object c(p pVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f6711v);
        return vf.g.A(arrayList);
    }

    @Override // x3.g
    public long e(int i) {
        y1.d.b(i == 0);
        return 0L;
    }

    @Override // x3.g
    public List i(long j4) {
        return j4 >= 0 ? this.f6711v : Collections.EMPTY_LIST;
    }

    @Override // x3.g
    public int j() {
        return 1;
    }
}
