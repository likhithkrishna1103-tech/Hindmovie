package h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5310b;

    public /* synthetic */ d() {
        this.f5309a = 0;
    }

    private final void a(Message message) {
        l4.w wVar;
        l4.u uVar;
        d dVar;
        if (message.what == 1) {
            synchronized (((l4.u) this.f5310b).f7758a) {
                wVar = (l4.w) ((l4.u) this.f5310b).f7761d.get();
                uVar = (l4.u) this.f5310b;
                dVar = uVar.f7762e;
            }
            if (wVar == null || uVar != wVar.b() || dVar == null) {
                return;
            }
            wVar.d((l4.e0) message.obj);
            ((l4.u) this.f5310b).a(wVar, dVar);
            wVar.d(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b0  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleMessage(android.os.Message r12) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.d.handleMessage(android.os.Message):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Object obj, Looper looper, int i) {
        super(looper);
        this.f5309a = i;
        this.f5310b = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Looper looper, b6.f fVar) {
        super(looper);
        this.f5309a = 1;
        this.f5310b = fVar;
    }
}
