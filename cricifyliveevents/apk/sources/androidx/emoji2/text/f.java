package androidx.emoji2.text;

import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends com.bumptech.glide.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f850c;

    public f(g gVar) {
        this.f850c = gVar;
    }

    @Override // com.bumptech.glide.c
    public final void A(Throwable th) {
        ((m) this.f850c.f855c).d(th);
    }

    @Override // com.bumptech.glide.c
    public final void B(b6.f fVar) {
        g gVar = this.f850c;
        gVar.f854b = fVar;
        b6.f fVar2 = (b6.f) gVar.f854b;
        m mVar = (m) gVar.f855c;
        gVar.f853a = new v(fVar2, mVar.f869g, mVar.i, Build.VERSION.SDK_INT >= 34 ? r.a() : com.bumptech.glide.d.r());
        m mVar2 = (m) gVar.f855c;
        mVar2.getClass();
        ArrayList arrayList = new ArrayList();
        mVar2.f864a.writeLock().lock();
        try {
            mVar2.f866c = 1;
            arrayList.addAll(mVar2.f865b);
            mVar2.f865b.clear();
            mVar2.f864a.writeLock().unlock();
            mVar2.f867d.post(new k(arrayList, mVar2.f866c, (Throwable) null));
        } catch (Throwable th) {
            mVar2.f864a.writeLock().unlock();
            throw th;
        }
    }
}
