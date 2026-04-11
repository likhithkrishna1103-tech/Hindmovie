package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1193a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f1194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f1195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f1196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1197e;
    public int f;

    public s(v vVar) {
        this.f1194b = vVar;
        this.f1195c = vVar;
    }

    public final void a() {
        this.f1193a = 1;
        this.f1195c = this.f1194b;
        this.f = 0;
    }

    public final boolean b() {
        f1.a aVarB = this.f1195c.f1206b.b();
        int iA = aVarB.a(6);
        return !(iA == 0 || ((ByteBuffer) aVarB.f4694x).get(iA + aVarB.f4691u) == 0) || this.f1197e == 65039;
    }
}
