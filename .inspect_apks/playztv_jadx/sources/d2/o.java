package d2;

import android.os.Handler;
import android.os.Message;
import java.util.TreeMap;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Handler.Callback {
    public boolean A;
    public boolean B;
    public boolean C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s2.e f3761u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final wb.c f3762v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public e2.c f3766z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TreeMap f3765y = new TreeMap();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Handler f3764x = b0.n(this);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final g3.b f3763w = new g3.b(1);

    public o(e2.c cVar, wb.c cVar2, s2.e eVar) {
        this.f3766z = cVar;
        this.f3762v = cVar2;
        this.f3761u = eVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (!this.C) {
            if (message.what != 1) {
                return false;
            }
            m mVar = (m) message.obj;
            long j5 = mVar.f3754a;
            long j8 = mVar.f3755b;
            Long lValueOf = Long.valueOf(j8);
            TreeMap treeMap = this.f3765y;
            Long l10 = (Long) treeMap.get(lValueOf);
            if (l10 == null) {
                treeMap.put(Long.valueOf(j8), Long.valueOf(j5));
                return true;
            }
            if (l10.longValue() > j5) {
                treeMap.put(Long.valueOf(j8), Long.valueOf(j5));
            }
        }
        return true;
    }
}
