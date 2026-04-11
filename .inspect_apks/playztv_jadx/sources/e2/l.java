package e2;

import aa.j0;
import android.net.Uri;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends m {
    public final u5.d A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final j f4342z;

    public l(p1.q qVar, j0 j0Var, r rVar, ArrayList arrayList) {
        super(qVar, j0Var, rVar, arrayList);
        Uri.parse(((b) j0Var.get(0)).f4295a);
        long j5 = rVar.f4359e;
        j jVar = j5 <= 0 ? null : new j(rVar.f4358d, j5, null);
        this.f4342z = jVar;
        this.A = jVar == null ? new u5.d(8, new j(0L, -1L, null)) : null;
    }

    @Override // e2.m
    public final String a() {
        return null;
    }

    @Override // e2.m
    public final d2.h e() {
        return this.A;
    }

    @Override // e2.m
    public final j f() {
        return this.f4342z;
    }
}
