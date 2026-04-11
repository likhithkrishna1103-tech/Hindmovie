package cc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2702b;

    public /* synthetic */ q0() {
        this.f2701a = 4;
    }

    private final void a(Message message) {
        h4.t tVar;
        h4.r rVar;
        q0 q0Var;
        if (message.what == 1) {
            synchronized (((h4.r) this.f2702b).f5840a) {
                tVar = (h4.t) ((h4.r) this.f2702b).f5843d.get();
                rVar = (h4.r) this.f2702b;
                q0Var = rVar.f5844e;
            }
            if (tVar == null || rVar != tVar.b() || q0Var == null) {
                return;
            }
            tVar.d((h4.b0) message.obj);
            ((h4.r) this.f2702b).a(tVar, q0Var);
            tVar.d(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARN: Type inference failed for: r5v0, types: [rd.c] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleMessage(android.os.Message r14) {
        /*
            Method dump skipped, instruction units count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.q0.handleMessage(android.os.Message):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q0(Object obj, Looper looper, int i) {
        super(looper);
        this.f2701a = i;
        this.f2702b = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(rd.h hVar) {
        super(Looper.getMainLooper());
        this.f2701a = 0;
        this.f2702b = hVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(Looper looper, ub.o oVar) {
        super(looper);
        this.f2701a = 3;
        this.f2702b = oVar;
    }
}
