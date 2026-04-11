package cc;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends td.g implements ae.q {
    public /* synthetic */ Throwable A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2599y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ ne.c f2600z;

    @Override // ae.q
    public final Object h(Object obj, Object obj2, Object obj3) {
        a0 a0Var = new a0(3, (rd.c) obj3);
        a0Var.f2600z = (ne.c) obj;
        a0Var.A = (Throwable) obj2;
        return a0Var.o(nd.k.f8990a);
    }

    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f2599y;
        if (i == 0) {
            i5.a.Q(obj);
            ne.c cVar = this.f2600z;
            Log.e("FirebaseSessionsRepo", "Error reading stored session data.", this.A);
            c1.b bVar = new c1.b(true);
            this.f2600z = null;
            this.f2599y = 1;
            Object objJ = cVar.j(bVar, this);
            sd.a aVar = sd.a.f11942u;
            if (objJ == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i5.a.Q(obj);
        }
        return nd.k.f8990a;
    }
}
