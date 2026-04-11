package d8;

import androidx.emoji2.text.v;
import k4.k0;
import v1.u0;
import v1.v0;
import y1.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements f8.b, m, k0, y1.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3537v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f3538w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f3539x;

    public /* synthetic */ f(int i, Object obj, Object obj2) {
        this.f3538w = obj;
        this.f3539x = obj2;
        this.f3537v = i;
    }

    @Override // y1.m
    public void a(Object obj) {
        v0 v0Var = (v0) this.f3538w;
        v0 v0Var2 = (v0) this.f3539x;
        u0 u0Var = (u0) obj;
        int i = this.f3537v;
        u0Var.m(i);
        u0Var.B(i, v0Var, v0Var2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    @Override // y1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void accept(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f3538w
            k4.b0 r0 = (k4.b0) r0
            java.lang.Object r1 = r4.f3539x
            k4.s r1 = (k4.s) r1
            ya.w r5 = (ya.w) r5
            java.lang.String r2 = "MediaSessionStub"
            java.lang.Object r5 = r5.get()     // Catch: java.lang.InterruptedException -> L18 java.util.concurrent.ExecutionException -> L1a java.util.concurrent.CancellationException -> L1c
            k4.o1 r5 = (k4.o1) r5     // Catch: java.lang.InterruptedException -> L18 java.util.concurrent.ExecutionException -> L1a java.util.concurrent.CancellationException -> L1c
            java.lang.String r3 = "SessionResult must not be null"
            y1.d.e(r5, r3)     // Catch: java.lang.InterruptedException -> L18 java.util.concurrent.ExecutionException -> L1a java.util.concurrent.CancellationException -> L1c
            goto L40
        L18:
            r5 = move-exception
            goto L1e
        L1a:
            r5 = move-exception
            goto L1e
        L1c:
            r5 = move-exception
            goto L35
        L1e:
            java.lang.String r3 = "Session operation failed"
            y1.b.q(r2, r3, r5)
            k4.o1 r2 = new k4.o1
            java.lang.Throwable r5 = r5.getCause()
            boolean r5 = r5 instanceof java.lang.UnsupportedOperationException
            if (r5 == 0) goto L2f
            r5 = -6
            goto L30
        L2f:
            r5 = -1
        L30:
            r2.<init>(r5)
            r5 = r2
            goto L40
        L35:
            java.lang.String r3 = "Session operation cancelled"
            y1.b.q(r2, r3, r5)
            k4.o1 r5 = new k4.o1
            r2 = 1
            r5.<init>(r2)
        L40:
            int r2 = r4.f3537v
            k4.d1.R(r0, r1, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.f.accept(java.lang.Object):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    @Override // k4.k0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(k4.s r20) {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d8.f.d(k4.s):void");
    }

    @Override // f8.b
    public Object g() {
        j jVar = (j) this.f3538w;
        ((v) jVar.f3554d).C((x7.i) this.f3539x, this.f3537v + 1, false);
        return null;
    }

    public /* synthetic */ f(int i, v0 v0Var, v0 v0Var2) {
        this.f3537v = i;
        this.f3538w = v0Var;
        this.f3539x = v0Var2;
    }
}
