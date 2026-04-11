package e4;

import s1.u;
import w2.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4420b;

    public /* synthetic */ f(int i, long j5, boolean z2) {
        this.f4419a = i;
        this.f4420b = j5;
    }

    public static f b(p pVar, u uVar) {
        pVar.w(uVar.f11709a, 0, 8);
        uVar.J(0);
        return new f(uVar.j(), uVar.o(), false);
    }

    public boolean a() {
        int i = this.f4419a;
        return i == 0 || i == 1;
    }

    public f(int i, long j5) {
        s1.d.b(j5 >= 0);
        this.f4419a = i;
        this.f4420b = j5;
    }
}
