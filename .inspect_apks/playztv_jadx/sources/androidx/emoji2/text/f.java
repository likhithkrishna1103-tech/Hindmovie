package androidx.emoji2.text;

import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends cf.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f1170d;

    public f(g gVar) {
        this.f1170d = gVar;
    }

    @Override // cf.d
    public final void t(Throwable th) {
        ((m) this.f1170d.f1173c).d(th);
    }

    @Override // cf.d
    public final void u(ub.o oVar) {
        g gVar = this.f1170d;
        gVar.f1172b = oVar;
        ub.o oVar2 = (ub.o) gVar.f1172b;
        m mVar = (m) gVar.f1173c;
        gVar.f1171a = new a7.b(oVar2, mVar.f1187g, mVar.i, Build.VERSION.SDK_INT >= 34 ? p.a() : cf.l.s());
        m mVar2 = (m) gVar.f1173c;
        mVar2.getClass();
        ArrayList arrayList = new ArrayList();
        mVar2.f1182a.writeLock().lock();
        try {
            mVar2.f1184c = 1;
            arrayList.addAll(mVar2.f1183b);
            mVar2.f1183b.clear();
            mVar2.f1182a.writeLock().unlock();
            mVar2.f1185d.post(new k(arrayList, mVar2.f1184c, (Throwable) null));
        } catch (Throwable th) {
            mVar2.f1182a.writeLock().unlock();
            throw th;
        }
    }
}
