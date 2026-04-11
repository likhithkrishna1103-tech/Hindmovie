package o1;

import androidx.fragment.app.p0;
import androidx.lifecycle.o0;
import s.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class a extends o0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p0 f9049e = new p0(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f9050d = new j();

    @Override // androidx.lifecycle.o0
    public final void b() {
        j jVar = this.f9050d;
        int i = jVar.f11638w;
        if (i > 0) {
            jVar.f11637v[0].getClass();
            throw new ClassCastException();
        }
        Object[] objArr = jVar.f11637v;
        for (int i10 = 0; i10 < i; i10++) {
            objArr[i10] = null;
        }
        jVar.f11638w = 0;
    }
}
