package nc;

import androidx.fragment.app.f1;
import g2.d0;
import y2.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9054v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f9055w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f9056x;

    public /* synthetic */ i(int i, Object obj, Object obj2) {
        this.f9054v = i;
        this.f9055w = obj;
        this.f9056x = obj2;
    }

    private final void a() {
        vb.b bVar = (vb.b) this.f9055w;
        g2.f fVar = (g2.f) this.f9056x;
        synchronized (fVar) {
        }
        c0 c0Var = (c0) bVar.f13552x;
        int i = y1.a0.f14551a;
        h2.f fVar2 = ((d0) c0Var).f4651v.O;
        h2.a aVarS = fVar2.S((s2.c0) fVar2.f5497y.f);
        fVar2.W(aVarS, 1020, new f1(aVarS, fVar, 17));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e1  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.i.run():void");
    }

    public /* synthetic */ i(kb.d dVar, boolean z10, y5.c cVar) {
        this.f9054v = 8;
        this.f9055w = dVar;
        this.f9056x = cVar;
    }
}
