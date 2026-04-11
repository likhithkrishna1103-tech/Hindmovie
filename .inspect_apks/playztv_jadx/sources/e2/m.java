package e2;

import aa.j0;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final p1.q f4343u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j0 f4344v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f4345w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List f4346x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j f4347y;

    public m(p1.q qVar, List list, s sVar, List list2) {
        s1.d.b(!list.isEmpty());
        this.f4343u = qVar;
        this.f4344v = j0.r(list);
        this.f4346x = list2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list2);
        this.f4347y = sVar.a(this);
        long j5 = sVar.f4362c;
        long j8 = sVar.f4361b;
        int i = b0.f11647a;
        this.f4345w = b0.W(j5, 1000000L, j8, RoundingMode.DOWN);
    }

    public abstract String a();

    public abstract d2.h e();

    public abstract j f();
}
