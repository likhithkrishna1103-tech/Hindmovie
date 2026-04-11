package c2;

import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeSet f2043a = new TreeSet(new r());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2044b;

    public final void a(b bVar, long j4) {
        while (this.f2044b + j4 > 104857600 && !this.f2043a.isEmpty()) {
            i iVar = (i) this.f2043a.first();
            v vVar = (v) bVar;
            synchronized (vVar) {
                vVar.k(iVar);
            }
        }
    }

    public final void b(v vVar, w wVar) {
        this.f2043a.add(wVar);
        this.f2044b += wVar.f2014x;
        a(vVar, 0L);
    }
}
