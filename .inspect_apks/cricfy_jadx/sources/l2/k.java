package l2;

import java.util.concurrent.CopyOnWriteArrayList;
import s2.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f7672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f7673c;

    public k(CopyOnWriteArrayList copyOnWriteArrayList, int i, c0 c0Var) {
        this.f7673c = copyOnWriteArrayList;
        this.f7671a = i;
        this.f7672b = c0Var;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, l2.l] */
    public final void a() {
        for (j jVar : this.f7673c) {
            y1.a0.S(jVar.f7669a, new i(this, jVar.f7670b, 2));
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, l2.l] */
    public final void b() {
        for (j jVar : this.f7673c) {
            y1.a0.S(jVar.f7669a, new i(this, jVar.f7670b, 1));
        }
    }

    public final void c(int i) {
        for (j jVar : this.f7673c) {
            y1.a0.S(jVar.f7669a, new c.k(this, jVar.f7670b, i, 3));
        }
    }

    public final void d(Exception exc) {
        for (j jVar : this.f7673c) {
            y1.a0.S(jVar.f7669a, new androidx.emoji2.text.n(this, jVar.f7670b, exc, 6));
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, l2.l] */
    public final void e() {
        for (j jVar : this.f7673c) {
            y1.a0.S(jVar.f7669a, new i(this, jVar.f7670b, 0));
        }
    }
}
