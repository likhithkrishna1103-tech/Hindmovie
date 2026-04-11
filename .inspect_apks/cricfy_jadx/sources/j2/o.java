package j2;

import android.os.Handler;
import android.os.Message;
import java.util.TreeMap;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Handler.Callback {
    public k2.c A;
    public boolean B;
    public boolean C;
    public boolean D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final w2.e f6582v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f f6583w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TreeMap f6586z = new TreeMap();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Handler f6585y = a0.n(this);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k3.b f6584x = new k3.b(1);

    public o(k2.c cVar, f fVar, w2.e eVar) {
        this.A = cVar;
        this.f6583w = fVar;
        this.f6582v = eVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (!this.D) {
            if (message.what != 1) {
                return false;
            }
            m mVar = (m) message.obj;
            long j4 = mVar.f6575a;
            long j7 = mVar.f6576b;
            Long lValueOf = Long.valueOf(j7);
            TreeMap treeMap = this.f6586z;
            Long l10 = (Long) treeMap.get(lValueOf);
            if (l10 == null) {
                treeMap.put(Long.valueOf(j7), Long.valueOf(j4));
                return true;
            }
            if (l10.longValue() > j4) {
                treeMap.put(Long.valueOf(j7), Long.valueOf(j4));
            }
        }
        return true;
    }
}
