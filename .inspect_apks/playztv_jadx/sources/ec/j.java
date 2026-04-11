package ec;

import android.content.Context;
import android.os.Bundle;
import cc.i0;
import cc.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f4661c = new h();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b1.c f4662d = i5.a.G(t.f2712b, new rc.b(g.f4656v));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f4664b;

    public j(ga.g gVar, rd.h hVar, rd.h hVar2, ob.d dVar) {
        gVar.a();
        Context context = gVar.f5346a;
        be.h.d(context, "firebaseApp.applicationContext");
        i0 i0Var = i0.f2660a;
        cc.b bVarA = i0.a(gVar);
        a aVar = new a(context);
        a7.b bVar = new a7.b(bVarA, hVar);
        f4661c.getClass();
        e eVar = new e(hVar2, dVar, bVarA, bVar, f4662d.a(context, h.f4657a[0]));
        this.f4663a = aVar;
        this.f4664b = eVar;
    }

    public final double a() {
        Bundle bundle = this.f4663a.f4640a;
        Double dValueOf = bundle.containsKey("firebase_sessions_sampling_rate") ? Double.valueOf(bundle.getDouble("firebase_sessions_sampling_rate")) : null;
        if (dValueOf != null) {
            double dDoubleValue = dValueOf.doubleValue();
            if (0.0d <= dDoubleValue && dDoubleValue <= 1.0d) {
                return dDoubleValue;
            }
        }
        f fVar = this.f4664b.b().f4675b;
        if (fVar == null) {
            be.h.i("sessionConfigs");
            throw null;
        }
        Double d10 = fVar.f4652b;
        if (d10 != null) {
            double dDoubleValue2 = d10.doubleValue();
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                return dDoubleValue2;
            }
        }
        return 1.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(td.c r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ec.i
            if (r0 == 0) goto L13
            r0 = r7
            ec.i r0 = (ec.i) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            ec.i r0 = new ec.i
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f4659y
            int r1 = r0.A
            nd.k r2 = nd.k.f8990a
            r3 = 2
            r4 = 1
            sd.a r5 = sd.a.f11942u
            if (r1 == 0) goto L3a
            if (r1 == r4) goto L34
            if (r1 != r3) goto L2c
            i5.a.Q(r7)
            goto L58
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            ec.j r1 = r0.f4658x
            i5.a.Q(r7)
            goto L4a
        L3a:
            i5.a.Q(r7)
            r0.f4658x = r6
            r0.A = r4
            ec.a r7 = r6.f4663a
            r7.getClass()
            if (r2 != r5) goto L49
            goto L57
        L49:
            r1 = r6
        L4a:
            ec.e r7 = r1.f4664b
            r1 = 0
            r0.f4658x = r1
            r0.A = r3
            java.lang.Object r7 = r7.d(r0)
            if (r7 != r5) goto L58
        L57:
            return r5
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ec.j.b(td.c):java.lang.Object");
    }
}
