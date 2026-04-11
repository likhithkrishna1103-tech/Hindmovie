package w1;

import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeSet f13553a = new TreeSet(new q());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f13554b;

    public final void a(b bVar, long j5) {
        while (this.f13554b + j5 > 104857600 && !this.f13553a.isEmpty()) {
            i iVar = (i) this.f13553a.first();
            u uVar = (u) bVar;
            synchronized (uVar) {
                uVar.k(iVar);
            }
        }
    }

    public final void b(u uVar, v vVar) {
        this.f13553a.add(vVar);
        this.f13554b += vVar.f13529w;
        a(uVar, 0L);
    }
}
