package q;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends e implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f10314v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10315w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ f f10316x;

    public d(f fVar) {
        this.f10316x = fVar;
    }

    @Override // q.e
    public final void a(c cVar) {
        c cVar2 = this.f10314v;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f10313y;
            this.f10314v = cVar3;
            this.f10315w = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f10315w) {
            return this.f10316x.f10317v != null;
        }
        c cVar = this.f10314v;
        return (cVar == null || cVar.f10312x == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f10315w) {
            this.f10315w = false;
            this.f10314v = this.f10316x.f10317v;
        } else {
            c cVar = this.f10314v;
            this.f10314v = cVar != null ? cVar.f10312x : null;
        }
        return this.f10314v;
    }
}
